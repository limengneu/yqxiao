/**
 * @文件名称：SchoolCommonException.java
 * @类路径：com.school.common.exception
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Aug 15, 20127:46:27 PM
 */
package com.yiqixiao.common.exception;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Aug 15, 20127:46:27 PM
 */
public class YiQiXiaoCommonException extends RuntimeException {

	/**
	 * @FieldsserialVersionUID:TODO
	 */
	private static final long serialVersionUID = 8967339445981380759L;

	public YiQiXiaoCommonException() {
		super();
	}

	public YiQiXiaoCommonException(String message) {
		super(message);
	}

	public YiQiXiaoCommonException(String message, Throwable cause) {
		super(message, cause);
	}

	public YiQiXiaoCommonException(Throwable e) {
		this(e.getMessage(), e);
	}

}
