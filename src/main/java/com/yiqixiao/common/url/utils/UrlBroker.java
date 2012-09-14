package com.yiqixiao.common.url.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;

import com.yiqixiao.common.exception.YiQiXiaoCommonException;

public class UrlBroker {

	private static final String DEFAULT_ENCODING = "UTF-8";
	private String base;
	private Map<String, Object> parameterMap;

	public UrlBroker(String base) {
		this(base, null);
	}

	public UrlBroker(String base, Map<String, Object> parameterMap) {

		this.base = base;
		this.parameterMap = parameterMap != null ? parameterMap
				: new LinkedHashMap<String, Object>();
	}

	public void setParameter(String key, Object value) {

		if (value == null) {
			return;
		}
		parameterMap.put(key, value);
	}

	public String toString() {
		return render();
	}

	/**
	 * not encode parameter key and non-string parameters
	 */
	public String render() {

		if (parameterMap.isEmpty()) {
			return base;
		}

		StringBuilder buffer = new StringBuilder(base);

		boolean firstParam = true;
		for (Entry<String, Object> entry : parameterMap.entrySet()) {

			Object value = entry.getValue();

			if (value == null) {

				continue;
			}

			if (value instanceof String) {
				String strValue = (String) value;
				if (StringUtils.isBlank(strValue)) {
					continue;
				}

				char separator = firstParam ? '?' : '&';
				buffer.append(separator);
				buffer.append(entry.getKey());
				buffer.append('=');
				buffer.append(encode(strValue));

				firstParam = false;
				continue;
			}

			char separator = firstParam ? '?' : '&';
			buffer.append(separator);
			buffer.append(entry.getKey());
			buffer.append('=');
			buffer.append(value);

			firstParam = false;
		}

		return buffer.toString();
	}

	private static String encode(String str) {
		try {
			return URLEncoder.encode(str, DEFAULT_ENCODING);
		} catch (UnsupportedEncodingException e) {
			throw new YiQiXiaoCommonException(e);
		}
	}

	public static String stripParameters(String pattern) {

		int separatorIndex = pattern.indexOf('?');
		if (separatorIndex < 0) {
			return pattern;
		}

		return pattern.substring(0, separatorIndex);
	}

}
