/**
 * @文件名称：PullToolsPreparationInterceptor.java
 * @类路径：com.school.common.web.Interceptor
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Aug 17, 201210:42:48 AM
 */
package com.yiqixiao.common.web.Interceptor;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Aug 17, 201210:42:48 AM
 */
public class PullToolsPreparationInterceptor extends HandlerInterceptorAdapter {
	private Map<String, Object> tools;


	
	// before the actual handler will be executed
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		for (Entry<String, Object> entry : tools.entrySet()) {
			request.setAttribute(entry.getKey(), entry.getValue());			
		}

		return true;
	}
	
	
	public void setTools(Map<String, Object> tools) {
		this.tools = tools;
	}
}
