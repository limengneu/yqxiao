/**
 * @文件名称：BuildSignUtils.java
 * @类路径：com.yiqixiao.biz.thrid.util
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Sep 18, 20129:43:55 AM
 */
package com.yiqixiao.biz.thrid.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.joda.time.DateTime;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Sep 18, 20129:43:55 AM
 */
public class BuildSignUtils {

	/**
	 * 
	 * @方法功能说明：
	 * @修改者名字: limeng
	 * @修改时间：Sep 18, 20129:45:48 AM
	 * @参数：@param orderparam
	 * @参数：@param ts
	 * @参数：@param appkey
	 * @参数：@param secret
	 * @参数：@return
	 * @return:String
	 */
	public static String buildSign(String orderparam,String ts,String appkey,String secret) {

		String req = DigestUtils.md5Hex(orderparam);

		String secendDigest = req + "#" + appkey + "#" + secret + "#" + ts;

		return DigestUtils.md5Hex(secendDigest);

	}
	
	/**
	 * 
	 * @方法功能说明：
	 * @修改者名字: limeng
	 * @修改时间：Sep 18, 20129:46:36 AM
	 * @参数：@return
	 * @return:String
	 */
	public static String getTimeAsString() {

		DateTime time = DateTime.now();
		String ts = time.getMillis() + "";
		return ts.substring(0, 10);

	}
	
}
