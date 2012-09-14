/**
 * @文件名称：ThridVedioServiceImpl.java
 * @类路径：com.school.biz.thrid.impl
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Aug 15, 20126:57:02 PM
 */
package com.yiqixiao.biz.thrid.impl;

import java.net.URLEncoder;

import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yiqixiao.biz.thrid.ThridVedioService;
import com.yiqixiao.biz.thrid.util.VedioUploadConstans;


/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Aug 15, 20126:57:02 PM
 */
public class ThridVedioServiceImpl implements ThridVedioService {
	
	private static final Logger logger=LoggerFactory.getLogger(ThridVedioServiceImpl.class);

	private String appkey;

	private String secret;

	private String css;
	
	private String ourl;
	
	private String rurl;

	private String vedioPublic;
	
	private String uploadUrl;
	


	/*
	 * (non-Javadoc)
	 * 
	 * @see com.school.biz.thrid.ThridVedioService#uploadVedio()
	 */
	public String uploadVedio(String user) {
		
		String urlParam=null;
		try {
			urlParam = buildUrlPrama(user);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		
		return uploadUrl+"?"+urlParam;
	}


	/**
	 * @方法功能说明：
	 * @修改者名字: limeng
	 * @修改时间：Aug 15, 20128:48:46 PM
	 * @参数：@param sid
	 * @return:void
	 * @throws Exception 
	 */
	private String buildUrlPrama(String sid) throws Exception {
		String ts=getTsString();
	
		StringBuilder param=new StringBuilder();
		param.append(VedioUploadConstans.VEDIO_APPKEY);param.append("=");param.append(URLEncoder.encode(appkey, "UTF-8"));
		param.append("&");
//		param.append(VedioUploadConstans.VEDIO_SECRET);param.append("=");param.append(URLEncoder.encode(secret, "UTF-8"));
//		param.append("&");
		param.append(VedioUploadConstans.VEDIO_TS);param.append("=");param.append(URLEncoder.encode(ts, "UTF-8"));
		param.append("&");
		StringBuilder sortparam=new StringBuilder();
		sortparam.append(VedioUploadConstans.VEDIO_CSS);sortparam.append("=");sortparam.append(URLEncoder.encode(css, "UTF-8"));
		sortparam.append("&");
		sortparam.append(VedioUploadConstans.VEDIO_OURL);sortparam.append("=");sortparam.append(URLEncoder.encode(ourl, "UTF-8"));
		sortparam.append("&");
		sortparam.append(VedioUploadConstans.VEDIO_PUBLIC);sortparam.append("=");sortparam.append(URLEncoder.encode(vedioPublic, "UTF-8"));
		sortparam.append("&");
		sortparam.append(VedioUploadConstans.VEDIO_RURL);sortparam.append("=");sortparam.append(URLEncoder.encode(rurl, "UTF-8"));
		sortparam.append("&");
		sortparam.append(VedioUploadConstans.VEDIO_SID);sortparam.append("=");sortparam.append(URLEncoder.encode(sid, "UTF-8"));
		String sign=buildSign(sortparam.toString(),ts);
		param.append(sortparam);
		param.append("&");
		param.append(VedioUploadConstans.VEDIO_SIGN);param.append("=");param.append(URLEncoder.encode(sign, "UTF-8"));
		
		return param.toString();
	}

	private String buildSign(String orderparam,String ts) {

		String req = DigestUtils.md5Hex(orderparam);

		String secendDigest = req + "#" + appkey + "#" + secret + "#" + ts;

		return DigestUtils.md5Hex(secendDigest);

	}

	private String getTsString() {
		DateTime time = DateTime.now();
		String ts = time.getMillis() + "";
		return ts.substring(0, 10);
	}

	/**
	 * @param appkey
	 *            the appkey to set
	 */
	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}

	/**
	 * @param secret
	 *            the secret to set
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}

	/**
	 * @param css
	 *            the css to set
	 */
	public void setCss(String css) {
		this.css = css;
	}

	/**
	 * @param ourl
	 *            the ourl to set
	 */
	public void setOurl(String ourl) {
		this.ourl = ourl;
	}

	/**
	 * @param rurl
	 *            the rurl to set
	 */
	public void setRurl(String rurl) {
		this.rurl = rurl;
	}

	/**
	 * @param vedioPublic
	 *            the vedioPublic to set
	 */
	public void setVedioPublic(String vedioPublic) {
		this.vedioPublic = vedioPublic;
	}

	/**
	 * @param uploadUrl the uploadUrl to set
	 */
	public void setUploadUrl(String uploadUrl) {
		this.uploadUrl = uploadUrl;
	}

	

}
