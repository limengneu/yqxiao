/**
 * @文件名称：Vedio.java
 * @类路径：com.school.biz.model
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Aug 16, 201211:05:47 AM
 */
package com.yiqixiao.biz.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PostLoad;
import javax.persistence.Transient;

import com.yiqixiao.common.utils.StringCollectionUtils;



/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Aug 16, 201211:05:47 AM
 */
@Entity
public class Vedio extends BaseModel {

	@Column
	private String author;
	@Column
	private String title;
	@Column
	private String result;
	@Column
	private String tags;
	@Column
	private String summary;
	@Column
	private String path;
	@Column
	private String realPath;
	@Column
	private String image;
	@Column
	private String mimage;
	@Column
	private String bimage;
	@Column
	private String status;
	@Column
	private String vid;
	@Column
	private String vpublic;
	
	@Column
	private String  attach;

	@Column
	private String source; //来源
	
	@Column
	private String style;//分类
	
	@Column
	private Integer playerSum; //播放总数
	
	@Column
	private Integer commentSum;//评论总数
	
	@Transient
	private List<String> tagsList;
	
	
	public Vedio() {
		tagsList = new ArrayList<String>();
	}
	

	
	
	@PostLoad
	void postLoad() {
		tagsList = StringCollectionUtils.deserialize(tags);
	}

	public void prePersist() {
		super.prePersist();
		tags = StringCollectionUtils.serialize(tagsList);

		
	}

	public void preUpdate() {
		super.preUpdate();
		tags = StringCollectionUtils.serialize(tagsList);

	}
	


	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}




	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}




	/**
	 * @return the tags
	 */
	public String getTags() {
		return tags;
	}

	/**
	 * @param tags
	 *            the tags to set
	 */
	public void setTags(String tags) {
		this.tags = tags;
	}

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary
	 *            the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path
	 *            the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the image
	 */
	public String getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * @return the vid
	 */
	public String getVid() {
		return vid;
	}

	/**
	 * @param vid the vid to set
	 */
	public void setVid(String vid) {
		this.vid = vid;
	}

	/**
	 * @return the vpublic
	 */
	public String getVpublic() {
		return vpublic;
	}

	/**
	 * @param vpublic the vpublic to set
	 */
	public void setVpublic(String vpublic) {
		this.vpublic = vpublic;
	}




	/**
	 * @return the realPath
	 */
	public String getRealPath() {
		return realPath;
	}




	/**
	 * @param realPath the realPath to set
	 */
	public void setRealPath(String realPath) {
		this.realPath = realPath;
	}




	/**
	 * @return the attach
	 */
	public String getAttach() {
		return attach;
	}




	/**
	 * @param attach the attach to set
	 */
	public void setAttach(String attach) {
		this.attach = attach;
	}




	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}




	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}




	/**
	 * @return the style
	 */
	public String getStyle() {
		return style;
	}




	/**
	 * @param style the style to set
	 */
	public void setStyle(String style) {
		this.style = style;
	}




	/**
	 * @return the playerSum
	 */
	public Integer getPlayerSum() {
		return playerSum;
	}



	/**
	 * @param playerSum the playerSum to set
	 */
	public void setPlayerSum(Integer playerSum) {
		this.playerSum = playerSum;
	}

	/**
	 * @return the commentSum
	 */
	public Integer getCommentSum() {
		return commentSum;
	}

	/**
	 * @param commentSum the commentSum to set
	 */
	public void setCommentSum(Integer commentSum) {
		this.commentSum = commentSum;
	}




	/**
	 * @return the mimage
	 */
	public String getMimage() {
		return mimage;
	}




	/**
	 * @param mimage the mimage to set
	 */
	public void setMimage(String mimage) {
		this.mimage = mimage;
	}




	/**
	 * @return the bimage
	 */
	public String getBimage() {
		return bimage;
	}




	/**
	 * @param bimage the bimage to set
	 */
	public void setBimage(String bimage) {
		this.bimage = bimage;
	}


}
