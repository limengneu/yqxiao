/**
 * @文件名称：DigestUtils.java
 * @类路径：com.school.common.utils
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Aug 15, 20127:43:50 PM
 */
package com.yiqixiao.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.yiqixiao.biz.thrid.exception.SchoolThridException;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Aug 15, 20127:43:50 PM
 */
public class DigestUtils {

	public static String Md5Encrypt(String src) {
		try {
			
			MessageDigest sha1 = MessageDigest.getInstance("MD5");
			byte[] srcBytes = EncodingUtils.toBytes(src);
			byte[] digestedBytes = sha1.digest(srcBytes);
			return EncodingUtils.toString(digestedBytes);

		} catch (NoSuchAlgorithmException e) {

			throw new SchoolThridException(e);
		}
	}

}
