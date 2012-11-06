/**
 * @文件名称：CommentService.java
 * @类路径：com.yiqixiao.biz.service
 * @版权:Copyright (c)2012
 * @作者：limeng
 * @时间：Sep 20, 201210:55:59 AM
 */
package com.yiqixiao.biz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yiqixiao.biz.dao.CommentDao;
import com.yiqixiao.biz.model.Comment;
import com.yiqixiao.biz.query.CommentQuery;

/**
 * @描述：
 * @作者：limeng
 * @创建时间：Sep 20, 201210:55:59 AM
 */
@Component
public class CommentService {

	@Autowired
	private CommentDao commentDao;
	
	public Comment saveComment(Comment comment){
		return commentDao.save(comment);
	}
	
	public Comment updateComment(Comment comment){
		return commentDao.save(comment);
	}
	
	public Comment findComment(String column,String value){
		return  commentDao.findByValue(column, value);
	}
	
	
	public Comment findCommentById(Integer commentId){
		return  commentDao.find(commentId);
	}
	
	public CommentQuery findCommentPageByVedioId(String column,String value,Integer page,Integer pageSize){
		
		List<Comment>  comments=commentDao.findListByPage(column, value,page,pageSize);
		Long size=commentDao.countByPage(column, value);
		CommentQuery commentQuery=new CommentQuery(comments,size.intValue());
		 return commentQuery;
	}
	
	
	public List<Comment> findComments(String column,String value){
		return  commentDao.findListByValue(column, value);
	}
}
