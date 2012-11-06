package com.yiqixiao.biz.thrid.login;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yiqixiao.biz.thrid.exception.YqxiaoThridException;

public class AuthLoginService {

	private Logger logger = LoggerFactory.getLogger(AuthLoginService.class);

	private OAuth2HttpsClient OAuth2HttpsClient;

	private String authTokenUrl;

	private String userAccountUrl;

	private String authorizeURL;

	private String clientId;

	private String clientSecret;

	private String grantType;

	private String redirectUri;

	private String responseType;

	private String state;

	public String getAuthToken(String code) {
		Map<String, String> params = new HashMap<String, String>();
		params.put(OAuth2ClientParams.CLIENT_ID, clientId);
		params.put(OAuth2ClientParams.CLIENT_SECRET, clientSecret);
		params.put(OAuth2ClientParams.GRANT_TYPE, grantType);
		params.put(OAuth2ClientParams.REDIRECT_URI, redirectUri);
		params.put(OAuth2ClientParams.CODE, code);
		params.put(OAuth2ClientParams.STATE, state);

		return OAuth2HttpsClient.post(authTokenUrl, params);
	}

	public String getAuthorizeURL() {
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append(authorizeURL);
		sbuilder.append("?");
		sbuilder.append(buildParam(OAuth2ClientParams.CLIENT_ID, clientId));
		sbuilder.append("&");
		sbuilder.append(buildParam(OAuth2ClientParams.REDIRECT_URI, redirectUri));
		sbuilder.append("&");
		sbuilder.append(buildParam(OAuth2ClientParams.RESPONSE_TYPE_KEY,
				responseType));
		sbuilder.append("&");
		sbuilder.append(buildParam(OAuth2ClientParams.STATE, state));
		return sbuilder.toString();
	}

	private String buildParam(String key, String value) {
		StringBuilder sbuilder = new StringBuilder();
		sbuilder.append(key);
		sbuilder.append("=");
		sbuilder.append(value);
		return sbuilder.toString();
	}

	public String getOpenId(String token) {
		// autu2HttpClient.setToken(token);
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("access_token", token);

			String userId = OAuth2HttpsClient
					.get(token, userAccountUrl, params);
			return userId;
		} catch (Exception e) {
			throw new YqxiaoThridException(e);
		}
	}

	public String getUid(String token) {
		// autu2HttpClient.setToken(token);
		try {

			String userId = OAuth2HttpsClient.get(token, userAccountUrl);
			return userId;
		} catch (Exception e) {
			throw new YqxiaoThridException(e);
		}
	}

	public void setOAuth2HttpsClient(OAuth2HttpsClient oAuth2HttpsClient) {
		this.OAuth2HttpsClient = oAuth2HttpsClient;
	}

	public void setAuthTokenUrl(String authTokenUrl) {
		this.authTokenUrl = authTokenUrl;
	}

	public void setUserAccountUrl(String userAccountUrl) {
		this.userAccountUrl = userAccountUrl;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}

	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}

	public void setAuthorizeURL(String authorizeURL) {
		this.authorizeURL = authorizeURL;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	public void setState(String state) {
		this.state = state;
	}

}
