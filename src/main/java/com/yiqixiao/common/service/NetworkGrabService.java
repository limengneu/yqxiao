/**
 * @文件名称：NetworkGrabService.java
 * @类路径：com.yiqixiao.common.service
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Sep 18, 201210:30:26 AM
 */
package com.yiqixiao.common.service;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import com.yiqixiao.common.exception.YiQiXiaoCommonException;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Sep 18, 201210:30:26 AM
 */
@Component
public class NetworkGrabService {
	
	private HttpClient httpClient;
	
	public interface GetMethodProcessor<T> {

		T process(GetMethod getMethod) throws Exception;
	}

	public <T> T grabAsStream(String sourceUrl, GetMethodProcessor<T> processor) {

		return grabAsStream(sourceUrl, processor, null);
	}

	public <T> T grabAsStream(String sourceUrl,
			GetMethodProcessor<T> processor, Map<String, String> customHeaders) {

		GetMethod method = new GetMethod(sourceUrl);

		URL url;
		try {
			url = new URL(sourceUrl);
		} catch (MalformedURLException e) {
			throw new YiQiXiaoCommonException(e);
		}

		method.setRequestHeader(
				"User-Agent",
				"Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.102 Safari/535.2");
		method.setRequestHeader("Location", url.getPath());
		method.setRequestHeader("Referer",
				url.getProtocol() + "://" + url.getHost());
		method.setRequestHeader("Accept-Charset", "utf-8,GBK;q=0.7,*;q=0.3");
		method.setRequestHeader("Accept-Language", "zh-CN,zh;q=0.8");

		// could not use deflation
		// method.setRequestHeader("Accept-Encoding", "gzip,deflate");

		if (customHeaders != null && !customHeaders.isEmpty()) {
			for (Entry<String, String> entry : customHeaders.entrySet()) {

				method.setRequestHeader(entry.getKey(), entry.getValue());
			}
		}

		try {
			int statusCode = httpClient.executeMethod(method);
			if (statusCode != HttpStatus.SC_OK) {

				throw new YiQiXiaoCommonException("Method failed: "
						+ method.getStatusLine());
			}
			return processor.process(method);
		} catch (Exception e) {
			throw new YiQiXiaoCommonException(e);
		} finally {
			method.releaseConnection();
		}

	}

	public String grabAsString(String sourceUrl, final String encoding,
			Map<String, String> customHeaders) {
		return grabAsStream(sourceUrl, new GetMethodProcessor<String>() {

			public String process(GetMethod getMethod) throws Exception {

				InputStream input = getMethod.getResponseBodyAsStream();
				return IOUtils.toString(input, encoding);
			}

		}, customHeaders);

	}

	public String grabAsString(String sourceUrl, final String encoding) {

		return grabAsString(sourceUrl, encoding, null);
	}
	
	
   public void setHttpClient(HttpClient httpClient) {
		this.httpClient = httpClient;
	}
}
