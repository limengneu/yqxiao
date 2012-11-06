/**
 * @文件名称：SchoolThridException.java
 * @类路径：com.school.biz.thrid.exception
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Aug 15, 20127:35:27 PM
 */
package com.yiqixiao.biz.thrid.exception;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Aug 15, 20127:35:27 PM
 */
public class YqxiaoThridException extends RuntimeException {

	/**
	 * @FieldsserialVersionUID:TODO
	 */
	private static final long serialVersionUID = -2467355981870522825L;
	
	public YqxiaoThridException() {
		super();
	}

	public YqxiaoThridException(String message) {
		super(message);
	}

	public YqxiaoThridException(String message, Throwable cause) {
		super(message, cause);
	}

	public YqxiaoThridException(Throwable e) {
		this(e.getMessage(), e);
	}

}
