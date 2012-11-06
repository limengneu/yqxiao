/**
 * @文件名称：VedioQuery.java
 * @类路径：com.school.biz.query
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Aug 17, 20125:40:39 PM
 */
package com.yiqixiao.biz.query;

import java.util.List;

import com.yiqixiao.biz.model.Comment;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Aug 17, 20125:40:39 PM
 */
public class CommentQuery {
	
	private Integer size;
	
	private List<Comment> comments;

	public CommentQuery(List<Comment> comments,Integer size ){
	  this.comments=comments;
	  this.size=size;
	}
	
	/**
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Integer size) {
		this.size = size;
	}

	/**
	 * @return the comments
	 */
	public List<Comment> getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
