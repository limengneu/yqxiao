package com.yiqixiao.biz.thrid.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthFactoryService {

	@Autowired
	private AuthLoginService qqAuthLoginService;
	@Autowired
	private AuthLoginService weiboAuthLoginService;


	public AuthLoginService getAuthService(String state) {

		if (OAuth2ClientParams.QQ_STATE.equals(state)) {

			return qqAuthLoginService;
		} 
		return weiboAuthLoginService;
	}


}
