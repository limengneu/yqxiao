/**
 * @文件名称：Link.java
 * @类路径：com.school.biz.paginator
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Aug 17, 20123:49:26 PM
 */
package com.yiqixiao.common.paginator;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Aug 17, 20123:49:26 PM
 */
public class Link {

	private String name;

	private String href;

	private boolean isCurrentPage;

	private Object extra;

	public Link(String name, String href, boolean isCurrentPage) {

		this(name, href, isCurrentPage, null);
	}

	public Link(String name, String href, boolean isCurrentPage, Object extra) {

		this.name = name;
		this.href = href;
		this.isCurrentPage = isCurrentPage;
		this.extra = extra;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the href
	 */
	public String getHref() {
		return href;
	}

	/**
	 * @param href
	 *            the href to set
	 */
	public void setHref(String href) {
		this.href = href;
	}

	/**
	 * @return the isCurrentPage
	 */
	public boolean isCurrentPage() {
		return isCurrentPage;
	}

	/**
	 * @param isCurrentPage
	 *            the isCurrentPage to set
	 */
	public void setCurrentPage(boolean isCurrentPage) {
		this.isCurrentPage = isCurrentPage;
	}

	/**
	 * @return the extra
	 */
	public Object getExtra() {
		return extra;
	}

	/**
	 * @param extra
	 *            the extra to set
	 */
	public void setExtra(Object extra) {
		this.extra = extra;
	}

}
