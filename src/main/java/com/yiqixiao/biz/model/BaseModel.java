/**
 * @文件名称：BaseModel.java
 * @类路径：com.school.biz.model
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Aug 16, 201211:10:21 AM
 */
package com.yiqixiao.biz.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.joda.time.DateTime;



/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Aug 16, 201211:10:21 AM
 */
@MappedSuperclass
public class BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private Date createAt;
	@Column
	private Date modifyAt;

	public void prePersist() {
		DateTime now = DateTime.now();
		createAt = now.toDate();
		modifyAt = now.toDate();
	}
	
	public void preUpdate() {
		modifyAt = new Date();
	}


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the createAt
	 */
	public Date getCreateAt() {
		return createAt;
	}

	/**
	 * @param createAt
	 *            the createAt to set
	 */
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	/**
	 * @return the modifyAt
	 */
	public Date getModifyAt() {
		return modifyAt;
	}

	/**
	 * @param modifyAt
	 *            the modifyAt to set
	 */
	public void setModifyAt(Date modifyAt) {
		this.modifyAt = modifyAt;
	}
	
	@Override
	public boolean equals(Object another) {

		if (another == null) {
			return false;
		}

		if (this == another) {
			return true;
		}

		if (!(another instanceof BaseModel)) {
			return false;
		}

		BaseModel anotherModel = (BaseModel) another;

		return new EqualsBuilder().append(getId(), anotherModel.getId())
				.isEquals();
	}

	@Override
	public int hashCode() {

		return new HashCodeBuilder().append(getId()).toHashCode();
	}

	@Override
	public String toString() {

		return ToStringBuilder.reflectionToString(this);
	}

}
