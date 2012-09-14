/**
 * @文件名称：EncodingUtils.java
 * @类路径：com.school.common.utils
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Aug 15, 20127:45:16 PM
 */
package com.yiqixiao.common.utils;

import java.io.UnsupportedEncodingException;

import com.yiqixiao.common.exception.YiQiXiaoCommonException;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Aug 15, 20127:45:16 PM
 */
public class EncodingUtils {
	private static final String DEFAULT_ENCODING = "UTF-8";

	public static String toHexString(byte[] bytes) {
		StringBuilder buf = new StringBuilder(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			int halfbyte = (bytes[i] >>> 4) & 0x0F;
			int two_halfs = 0;
			do {
				if ((0 <= halfbyte) && (halfbyte <= 9))
					buf.append((char) ('0' + halfbyte));
				else
					buf.append((char) ('a' + (halfbyte - 10)));
				halfbyte = bytes[i] & 0x0F;
			} while (two_halfs++ < 1);
		}
		return buf.toString();
	}

	public static String toString(byte[] bytes) {

		try {
			return new String(bytes, DEFAULT_ENCODING);
		} catch (UnsupportedEncodingException e) {
			throw new YiQiXiaoCommonException(e);
		}
	}

	public static byte[] toBytes(String string) {

		try {
			return string.getBytes(DEFAULT_ENCODING);
		} catch (UnsupportedEncodingException e) {
			throw new YiQiXiaoCommonException(e);
		}
	}
}
