/**
 * @文件名称：CoursesController.java
 * @类路径：com.school.teacher.controller
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Aug 20, 20121:34:00 PM
 */
package com.yiqixiao.teacher.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Aug 20, 20121:34:00 PM
 */
@Controller
public class CoursesController {
	/**
	 * 
	 * @方法功能说明：
	 * @修改者名字: limeng
	 * @修改时间：Aug 20, 20121:36:14 PM
	 * @参数：
	 * @return:void
	 */
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public void save() {
	}

	/**
	 * 
	 * @方法功能说明：
	 * @修改者名字: limeng
	 * @修改时间：Aug 20, 20121:40:44 PM
	 * @参数：
	 * @return:void
	 */
	@RequestMapping(value = "/courses/create", method = RequestMethod.GET)
	public ModelAndView create(HttpServletRequest request, ModelAndView mav) {
		mav.setViewName("/courses/create");
		return mav;
	}

}
