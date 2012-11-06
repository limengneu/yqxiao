/**
 * @文件名称：VedioServiceHelper.java
 * @类路径：com.yiqixiao.biz.service.helper
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Sep 18, 20127:33:20 PM
 */
package com.yiqixiao.biz.service.helper;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yiqixiao.biz.model.Vedio;
import com.yiqixiao.biz.service.VedioService;
import com.yiqixiao.biz.thrid.VedioGetService;
import com.yiqixiao.biz.thrid.model.VedioInfo;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Sep 18, 20127:33:20 PM
 */
@Component
public class VedioServiceHelper {

	@Autowired
	private VedioGetService vedioGetService;

	@Autowired
	private VedioService vedioService;

	private List<String> cids = new ArrayList<String>();

	private Integer defaultNumber = 5;

	private Integer defaultPage = 1;

	@PostConstruct
	public void init() {
		cids.add("36");
		cids.add("37");
		cids.add("38");
	}

	public void buildLastesetVedio() throws Exception {
		String vids= buildVediosFromChannel();
		List<VedioInfo> vedioInfos= vedioGetService.getThirdVedioFromVId(vids);
		
		for(VedioInfo vedioInfo:vedioInfos){
			Vedio vedio=new Vedio();
			vedio.setImage(vedioInfo.getImg());
			vedio.setMimage(vedioInfo.getMimg());
			vedio.setBimage(vedioInfo.getBimg());
			
			vedio.setSource("56.com");
			vedio.setSummary(vedioInfo.getDesc());
			vedio.setTitle(vedioInfo.getTitle());
			vedio.setTags(vedioInfo.getTag());
			vedio.setRealPath(vedioInfo.getSwf());
			vedio.setStatus("s");
			vedioService.saveVedio(vedio);
		}
		
		

	}

	/**
	 * @方法功能说明：
	 * @修改者名字: limeng
	 * @修改时间：Sep 18, 20127:52:42 PM
	 * @参数：@throws Exception
	 * @return:void
	 */
	private String buildVediosFromChannel() throws Exception {
		StringBuilder vedioIds = new StringBuilder();
		if (!cids.isEmpty()) {
			int index = 1;
			for (String cid : cids) {
				String vid = vedioGetService.getThirdVedioFromChannel(cid,
						defaultNumber, defaultPage);
				vedioIds.append(vid);
				if (index < cids.size()) {
					vedioIds.append(",");
				}
				index++;
			}
		}
		return vedioIds.toString();
	}

}
