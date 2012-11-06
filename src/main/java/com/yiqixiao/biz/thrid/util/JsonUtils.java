/**
 * @文件名称：JsonUtils.java
 * @类路径：com.yiqixiao.biz.thrid.util
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Sep 18, 20125:05:53 PM
 */
package com.yiqixiao.biz.thrid.util;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;

import com.yiqixiao.biz.thrid.model.VedioInfo;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Sep 18, 20125:05:53 PM
 */
public class JsonUtils {

	/**
	 * 
	 * @方法功能说明：
	 * @修改者名字: limeng
	 * @修改时间：Sep 18, 20125:48:43 PM
	 * @参数：@param str
	 * @参数：@return
	 * @return:List<VedioInfo>
	 */
	public static List<VedioInfo> thansforStringToVedioInfo(String str) {
		JSONObject jb = JSONObject.fromObject(str);
		List<VedioInfo> vedioInfos = new ArrayList<VedioInfo>();
		int index = 0;
		String vedioInfoString = jb.getString(index + "");
		while (StringUtils.isNotEmpty(vedioInfoString)) {
			VedioInfo vedioInfo = new VedioInfo();
			JSONObject jbVedioInfo = JSONObject.fromObject(vedioInfoString);
			vedioInfo.setBimg(jbVedioInfo.getString("bimg"));
			vedioInfo.setChk_yn(jbVedioInfo.getString("chk_yn"));
			vedioInfo.setDesc(jbVedioInfo.getString("desc"));
			vedioInfo.setImg(jbVedioInfo.getString("img"));
			vedioInfo.setSwf(jbVedioInfo.getString("swf"));
			vedioInfo.setTag(jbVedioInfo.getString("tag"));
			vedioInfo.setTotaltime(jbVedioInfo.getString("totaltime"));
			vedioInfo.setTitle(jbVedioInfo.getString("title"));
			vedioInfo.setMimg(jbVedioInfo.getString("mimg"));
			vedioInfo.setBimg(jbVedioInfo.getString("bimg"));
			vedioInfo.setVid(jbVedioInfo.getString("vid"));

			vedioInfos.add(vedioInfo);
			index++;
			try {
				vedioInfoString = jb.getString(index + "");
			} catch (Exception e) {
				break;
			}
		}
		return vedioInfos;
	}

	public static String getVedioIdsFormChannel(String string) {
		JSONObject jb = JSONObject.fromObject(string);
		JSONArray jsons = jb.getJSONArray("data");
		StringBuilder stringBuilder=new StringBuilder();
		int jsonLength = jsons.size();
		for (int i = 0; i < jsonLength; i++) {
			JSONObject tempJson = JSONObject.fromObject(jsons.get(i));
			stringBuilder.append(tempJson.getString("flvid"));
			int m=i+1;
			if(m<jsonLength){
				stringBuilder.append(",");
			}
			
		}
		return stringBuilder.toString();
	}

}
