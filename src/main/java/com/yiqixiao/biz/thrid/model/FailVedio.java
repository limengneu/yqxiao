/**
 * @文件名称：FailVedio.java
 * @类路径：com.school.biz.thrid.model
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Aug 16, 20124:23:57 PM
 */
package com.yiqixiao.biz.thrid.model;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Aug 16, 20124:23:57 PM
 */
public class FailVedio {

	public String vid;// vid=0
	public String msg;// 请不要重复上传相同视频
	public String subject;// 1

	/**
	 * @return the vid
	 */
	public String getVid() {
		return vid;
	}

	/**
	 * @param vid
	 *            the vid to set
	 */
	public void setVid(String vid) {
		this.vid = vid;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject
	 *            the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

}
