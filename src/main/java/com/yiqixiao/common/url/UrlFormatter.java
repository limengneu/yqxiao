/**
 * @文件名称：UrLFormatter.java
 * @类路径：com.school.common.url
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Aug 17, 20124:04:01 PM
 */
package com.yiqixiao.common.url;

import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang.ArrayUtils;

import com.yiqixiao.common.url.utils.StringFormatter;
import com.yiqixiao.common.url.utils.UrlBroker;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Aug 17, 20124:04:01 PM
 */
public class UrlFormatter {
	private static final Pattern OPTIONAL_PARAM_PATTERN = Pattern
			.compile("\\|");

	public static String format(String rawPattern,
			Map<String, Object> parameterMap) {

		String[] tokens = OPTIONAL_PARAM_PATTERN.split(rawPattern);

		String[] optionalParams = new String[0];
		String pattern = rawPattern;
		if (tokens.length > 1) {

			pattern = tokens[0];
			optionalParams = (String[]) ArrayUtils.subarray(tokens, 1,
					tokens.length);
		}
		String base = StringFormatter.format(pattern, parameterMap);

		if (parameterMap == null || parameterMap.isEmpty()
				|| optionalParams.length == 0) {
			return base;
		}

		UrlBroker urlBroker = new UrlBroker(base, parameterMap);

		return urlBroker.render();

	}

}
