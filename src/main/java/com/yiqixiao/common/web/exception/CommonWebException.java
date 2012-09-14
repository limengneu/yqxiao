/**
 * @文件名称：SchoolWebException.java
 * @类路径：com.school.common.web.exception
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Aug 15, 20122:49:56 PM
 */
package com.yiqixiao.common.web.exception;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Aug 15, 20122:49:56 PM
 */
public class CommonWebException  extends RuntimeException{
	/**
	 * @FieldsserialVersionUID:TODO
	 */
	private static final long serialVersionUID = -8310554541770582275L;

	public CommonWebException() {
		super();
	}

	public CommonWebException(String message) {
		super(message);
	}

	public CommonWebException(String message, Throwable cause) {
		super(message, cause);
	}

	public CommonWebException(Throwable e) {
		this(e.getMessage(), e);
	}
}
