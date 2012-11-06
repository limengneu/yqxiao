/**
 * @文件名称：VedioGetService.java
 * @类路径：com.yiqixiao.biz.thrid
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Sep 18, 20129:36:48 AM
 */
package com.yiqixiao.biz.thrid;

import java.util.List;

import com.yiqixiao.biz.thrid.model.VedioInfo;


/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Sep 18, 20129:36:48 AM
 */
public interface VedioGetService {
	/**
	 * 
	 * @方法功能说明：
	 * @修改者名字: limeng
	 * @修改时间：Sep 18, 20129:38:43 AM
	 * @参数：@return
	 * @return:List<String>
	 */
	String getThirdVedioFromChannel(String cid,Integer num,Integer page)throws Exception;
	
	/**
	 * 
	 * @方法功能说明：多个Id用,隔开
	 * @修改者名字: limeng
	 * @修改时间：Sep 18, 20122:21:27 PM
	 * @参数：@param vid
	 * @参数：@return
	 * @参数：@throws Exception
	 * @return:String
	 */
	List<VedioInfo> getThirdVedioFromVId(String vids)throws Exception;
}
