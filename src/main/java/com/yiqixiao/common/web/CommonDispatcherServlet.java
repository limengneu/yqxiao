/**
 * @文件名称：SchoolDispatcherServlet.java
 * @类路径：com.school.common.web
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Aug 15, 20121:28:41 PM
 */
package com.yiqixiao.common.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Aug 15, 20121:28:41 PM
 */
public class CommonDispatcherServlet extends DispatcherServlet {

	/**
	 * @FieldsserialVersionUID:TODO
	 */
	private static final long serialVersionUID = 541137914548149001L;

	private static final Logger logger = LoggerFactory
			.getLogger(CommonDispatcherServlet.class);

	@Override
	protected void doService(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		try {
			super.doService(request, response);
		} catch (Exception e) {

			Throwable t = e.getCause();
			if (t == null) {

				logger.error(e.getMessage(), t);
				// trigger 500 code and error page
				throw e;
			}

			while (t.getCause() != null) {

				t = t.getCause();
			}
			logger.error(t.getMessage(), t);

			logger.error(e.getMessage(), t);

			// trigger 500 code and error page
			throw e;
		}
	}

}
