/**
 * @文件名称：ThridLoginController.java
 * @类路径：com.yiqixiao.controller
 * @版权:Copyright (c)2012
 * @作者：limeng
 * @时间：Sep 20, 20123:03:43 PM
 */
package com.yiqixiao.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yiqixiao.biz.thrid.login.AuthFactoryService;
import com.yiqixiao.biz.thrid.login.AuthLoginService;
import com.yiqixiao.utils.UrlPatternConsts;

/**
 * @描述：
 * @作者：limeng
 * @创建时间：Sep 20, 20123:03:43 PM
 */
@Controller
public class ThridLoginController {
	@Autowired
	private AuthFactoryService authFactoryService;
	
	@RequestMapping(method = RequestMethod.GET, value = UrlPatternConsts.THRID_LOGIN)
	public String login(HttpServletRequest request, @PathVariable String state) {

		AuthLoginService authLoginService = authFactoryService
				.getAuthService(state);
		String url = authLoginService.getAuthorizeURL();
		return "redirect:" + url;
	}
}
