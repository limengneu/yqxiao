/**
 * @文件名称：Home.java
 * @类路径：com.school.teacher.controller
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Aug 15, 20123:59:41 PM
 */
package com.yiqixiao.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yiqixiao.biz.query.VedioQuery;
import com.yiqixiao.biz.service.VedioService;
import com.yiqixiao.common.paginator.Paginator;
import com.yiqixiao.common.paginator.PaginatorConstants;
import com.yiqixiao.utils.UrlPatternConsts;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Aug 15, 20123:59:41 PM
 */
@Controller
public class HomeController {
	

	@Autowired
	private VedioService vedioService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request, ModelAndView mav){
		mav.setViewName("home");
		VedioQuery vedioQuery=vedioService.findListByPage("status","s",1, PaginatorConstants.DEFAULT_PAGE_SIZE);
		
		Paginator paginator=new Paginator(UrlPatternConsts.VEDIO_List,1,PaginatorConstants.DEFAULT_PAGE_SIZE,vedioQuery.getSize());
		
		mav.addObject("paginator", paginator);
		mav.addObject("vedios", vedioQuery.getVedios());
	
		return mav;
	}

	@RequestMapping(value = UrlPatternConsts.VEDIO_List, method = RequestMethod.GET)
	public ModelAndView vedioList(HttpServletRequest request, ModelAndView mav,@PathVariable Integer page){
		mav.setViewName("home");
		VedioQuery vedioQuery=vedioService.findListByPage("status","s",page, PaginatorConstants.DEFAULT_PAGE_SIZE);
	
		Paginator paginator=new Paginator(UrlPatternConsts.VEDIO_List,page,PaginatorConstants.DEFAULT_PAGE_SIZE,vedioQuery.getSize());
		
		mav.addObject("paginator", paginator);
		mav.addObject("vedios", vedioQuery.getVedios());
		return mav;
	}

}
