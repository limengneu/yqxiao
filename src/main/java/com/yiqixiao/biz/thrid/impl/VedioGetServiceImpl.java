/**
 * @文件名称：VedioGetServiceImpl.java
 * @类路径：com.yiqixiao.biz.thrid.impl
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Sep 18, 20129:38:57 AM
 */
package com.yiqixiao.biz.thrid.impl;


import java.net.URLEncoder;
import java.util.List;

import com.yiqixiao.biz.thrid.VedioGetService;
import com.yiqixiao.biz.thrid.model.VedioInfo;
import com.yiqixiao.biz.thrid.util.BuildSignUtils;
import com.yiqixiao.biz.thrid.util.JsonUtils;
import com.yiqixiao.biz.thrid.util.VedioGetConstans;
import com.yiqixiao.biz.thrid.util.VedioUploadConstans;
import com.yiqixiao.common.service.NetworkGrabService;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Sep 18, 20129:38:57 AM
 */
public class VedioGetServiceImpl implements VedioGetService{

	private String appkey;

	private String secret;
	
	private String channelUrl;
	
	private String vedioInfoUrl;
	
	private NetworkGrabService networkGrabService;
	
	/* (non-Javadoc)
	 * @see com.yiqixiao.biz.thrid.VedioGetService#getThirdVedio()
	 */
	@Override
	public String getThirdVedioFromChannel(String cid,Integer num,Integer page) throws Exception {
		String urlParam=buildChannelUrlParam(cid, num, page);
		String sourceUrl=channelUrl+"?"+urlParam;
	    String result=	networkGrabService.grabAsString(sourceUrl, "utf-8");
	    
		return JsonUtils.getVedioIdsFormChannel(result);
	}
	
	/* (non-Javadoc)
	 * @see com.yiqixiao.biz.thrid.VedioGetService#getThirdVedioFromVId(java.lang.String)
	 */
	@Override
	public List<VedioInfo> getThirdVedioFromVId(String vids) throws Exception {
		String urlParam=buildVidsUrlParam(vids);
		String sourceUrl=vedioInfoUrl+"?"+urlParam;
	    String result=	networkGrabService.grabAsString(sourceUrl, "utf-8");
	    List<VedioInfo> vedios=JsonUtils.thansforStringToVedioInfo(result);
		return vedios;
	}
	

	/**
	 * @方法功能说明：
	 * @修改者名字: limeng
	 * @修改时间：Sep 18, 20122:23:15 PM
	 * @参数：@param vids
	 * @参数：@return
	 * @return:String
	 * @throws Exception 
	 */
	private String buildVidsUrlParam(String vids) throws Exception {
		String ts=BuildSignUtils.getTimeAsString();
		StringBuilder param=new StringBuilder();
		param.append(VedioUploadConstans.VEDIO_APPKEY);param.append("=");param.append(URLEncoder.encode(appkey, "UTF-8"));
		param.append("&");
		param.append(VedioUploadConstans.VEDIO_TS);param.append("=");param.append(URLEncoder.encode(ts, "UTF-8"));
		param.append("&");
		StringBuilder sortparam=new StringBuilder();
		sortparam.append(VedioGetConstans.VEDIO_VID);sortparam.append("=");sortparam.append(URLEncoder.encode(vids, "UTF-8"));
		String sign=BuildSignUtils.buildSign(sortparam.toString(),ts, appkey, secret);
		param.append(sortparam);
		param.append("&");
		param.append(VedioUploadConstans.VEDIO_SIGN);param.append("=");param.append(URLEncoder.encode(sign, "UTF-8"));
		return param.toString();
	}

	/**
	 * @方法功能说明：
	 * @修改者名字: limeng
	 * @修改时间：Sep 18, 201210:19:55 AM
	 * @参数：@param cid
	 * @参数：@param num
	 * @参数：@param page
	 * @参数：@throws UnsupportedEncodingException
	 * @return:void
	 */
	private String buildChannelUrlParam(String cid, Integer num, Integer page)
			throws Exception {
		String ts=BuildSignUtils.getTimeAsString();
		StringBuilder param=new StringBuilder();
		param.append(VedioUploadConstans.VEDIO_APPKEY);param.append("=");param.append(URLEncoder.encode(appkey, "UTF-8"));
		param.append("&");
		param.append(VedioUploadConstans.VEDIO_TS);param.append("=");param.append(URLEncoder.encode(ts, "UTF-8"));
		param.append("&");
		
		StringBuilder sortparam=new StringBuilder();

		sortparam.append(VedioGetConstans.VEDIO_CID);sortparam.append("=");sortparam.append(URLEncoder.encode(cid, "UTF-8"));
		sortparam.append("&");
		sortparam.append(VedioGetConstans.VEDIO_NUM);sortparam.append("=");sortparam.append(num);
		sortparam.append("&");
		sortparam.append(VedioGetConstans.VEDIO_PAGE);sortparam.append("=");sortparam.append(page);
		
		String sign=BuildSignUtils.buildSign(sortparam.toString(),ts, appkey, secret);
		param.append(sortparam);
		param.append("&");
		param.append(VedioUploadConstans.VEDIO_SIGN);param.append("=");param.append(URLEncoder.encode(sign, "UTF-8"));
		

		
		return param.toString();
	}

	/**
	 * @param appkey the appkey to set
	 */
	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	/**
	 * @param secret the secret to set
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}


	

	/**
	 * @param channelUrl the channelUrl to set
	 */
	public void setChannelUrl(String channelUrl) {
		this.channelUrl = channelUrl;
	}

	/**
	 * @param networkGrabService the networkGrabService to set
	 */
	public void setNetworkGrabService(NetworkGrabService networkGrabService) {
		this.networkGrabService = networkGrabService;
	}

	/**
	 * @param vedioInfoUrl the vedioInfoUrl to set
	 */
	public void setVedioInfoUrl(String vedioInfoUrl) {
		this.vedioInfoUrl = vedioInfoUrl;
	}

	
	

}
