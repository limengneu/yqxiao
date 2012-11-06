/**
 * @文件名称：CoursesController.java
 * @类路径：com.school.teacher.controller
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Aug 20, 20121:34:00 PM
 */
package com.yiqixiao.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.yiqixiao.biz.model.Comment;
import com.yiqixiao.biz.query.CommentQuery;
import com.yiqixiao.biz.service.CommentService;
import com.yiqixiao.common.paginator.PaginatorConstants;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Aug 20, 20121:34:00 PM
 */
@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;

  
	@RequestMapping(value = "/vedio/comment", method = RequestMethod.GET)
	public ModelAndView doComment(HttpServletRequest request, ModelAndView mav,Integer vedioId,String content){
		Comment comment=new Comment();
		comment.setUserName("一起笑");
		comment.setUserType("sina");
		comment.setVedioId(vedioId);
		comment.setMessage(content);
		commentService.saveComment(comment);
		return mav;
	}

	@RequestMapping(value = "/vedio/comment", method = RequestMethod.GET)
	public ModelAndView commentList(HttpServletRequest request, ModelAndView mav,Integer vedioId,Integer page){
		CommentQuery commentQuery = commentService.findCommentPageByVedioId("vedioId", vedioId.toString(), page, PaginatorConstants.DEFAULT_COMMENT_PAGE_SIZE);
		mav.addObject("commentQuery",commentQuery);
		return mav;
	}
	
}
