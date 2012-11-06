/**
 * @文件名称：Comment.java
 * @类路径：com.yiqixiao.biz.model
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Sep 14, 20124:45:18 PM
 */
package com.yiqixiao.biz.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Sep 14, 20124:45:18 PM
 */
@Entity
public class Comment  extends BaseModel{
	
	@Column
	private String userName;
	@Column
	private String userType;
	@Column
	private String message;
	@Column
	private Integer vedioId;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the vedioId
	 */
	public Integer getVedioId() {
		return vedioId;
	}
	/**
	 * @param vedioId the vedioId to set
	 */
	public void setVedioId(Integer vedioId) {
		this.vedioId = vedioId;
	}
	
	

}
