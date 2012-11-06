package com.yiqixiao.biz.thrid.login;

import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.lang.StringUtils;

import com.yiqixiao.biz.thrid.exception.YqxiaoThridException;
import com.yiqixiao.common.url.utils.UrlBroker;

public class OAuth2HttpsClient {


	private HttpClient httpClient;

	
	public void init() {

		Protocol httpsProtocol = new Protocol("https", new SSLSocketFactory(),
				443);
		Protocol.registerProtocol("https", httpsProtocol);
	}

	public String get(String token, String url) throws Exception {

		return get(token, url, null);

	}

	public String get(String token, String baseUrl, Map<String, Object> params)
			throws Exception {

		String url = new UrlBroker(baseUrl, params).render();

		GetMethod getMethod = new GetMethod(url);

		InetAddress ipaddr = InetAddress.getLocalHost();
		if (StringUtils.isNotBlank(token)) {
			// List<Header> headers = new ArrayList<Header>();
			// headers.add(new Header("Authorization", "OAuth2 " + token));
			// headers.add(new Header("API-RemoteIP", ipaddr.getHostAddress()));
			// httpClient.getHostConfiguration().getParams()
			// .setParameter("http.default-headers", headers);

			getMethod.addRequestHeader("Authorization", "OAuth2 " + token);
			getMethod.addRequestHeader("API-RemoteIP", ipaddr.getHostAddress());
		}

		return doRequest(getMethod);
	}

	public String post(String url, Map<String, String> params) {

		PostMethod postMethod = new PostMethod(url);
		for (Entry<String, String> param : params.entrySet()) {
			postMethod.addParameter(param.getKey(), param.getValue());
		}

		return doRequest(postMethod);
	}

	private String doRequest(HttpMethod method) {

		try {

			method.getParams().setContentCharset("UTF-8");

			httpClient.executeMethod(method);

			int responseCode = method.getStatusCode();
			if (responseCode != HttpURLConnection.HTTP_OK) {
				throw new YqxiaoThridException(
						"http client error the responseCode is :"
								+ responseCode);
			}
			return method.getResponseBodyAsString();
		} catch (Exception e) {
			throw new YqxiaoThridException(e);
		} finally {
			method.releaseConnection();
		}

	}

	/**
	 * @param httpClient the httpClient to set
	 */
	public void setHttpClient(HttpClient httpClient) {
		this.httpClient = httpClient;
	}
	
	

}
