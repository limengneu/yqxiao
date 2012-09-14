/**
 * @文件名称：StringCollectionUtils.java
 * @类路径：com.school.common.utils
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Aug 16, 20123:53:56 PM
 */
package com.yiqixiao.common.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Aug 16, 20123:53:56 PM
 */
public class StringCollectionUtils {
	private static final String[] EMPTY_STRING_ARRAY = new String[] {};
	public static final char SEPARATOR = '\01';
	public static final char COMMA_SEPARATOR = ',';

	public static List<String> deserialize(String composition) {

		return new ArrayList<String>(
				Arrays.asList(deserializeToArray(composition)));
	}

	public static String[] deserializeToArray(String composition) {

		if (composition == null) {

			return EMPTY_STRING_ARRAY;
		}

		return StringUtils.split(composition, SEPARATOR);
	}

	public static String serialize(List<?> list) {
		if (list == null || list.isEmpty()) {

			return null;
		}

		return StringUtils.join(list, SEPARATOR);
	}

	public static String serialize(String[] list) {

		if (list == null || list.length == 0) {

			return null;
		}

		return StringUtils.join(list, SEPARATOR);
	}

	public static List<String> deserializeWithComma(String composition) {

		if (composition == null || composition.length() <= 2) {

			return new ArrayList<String>();
		}
		composition = composition.substring(0, composition.length() - 1);
		return new ArrayList<String>(Arrays.asList(StringUtils.split(
				composition, COMMA_SEPARATOR)));
	}

	public static String serializeWithComma(List<?> list) {

		if (list == null || list.isEmpty()) {

			return null;
		}

		return COMMA_SEPARATOR + StringUtils.join(list, COMMA_SEPARATOR)
				+ COMMA_SEPARATOR;
	}


}
