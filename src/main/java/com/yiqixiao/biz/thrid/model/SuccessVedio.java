/**
 * @文件名称：SuccessVedio.java
 * @类路径：com.school.biz.thrid.model
 * @版权:Copyright (c)2012
 * @公司名称：杭州商友全球网信息技术有限公司
 * @作者：limeng
 * @时间：Aug 16, 20124:20:32 PM
 */
package com.yiqixiao.biz.thrid.model;

/**
 * @描述：
 * @部门：研发部
 * @作者：limeng
 * @创建时间：Aug 16, 20124:20:32 PM
 */
public class SuccessVedio {
	private String vid;// 视频ID
	private String subject;// 视频标题
	private String result;// 上传成功-1，上传失败-0
	private String player;// 视频播放地址，区分大小写
	private String cover;// 封面图
	private String chk;// y-通过审核，n-待审 ，一般情况下新上传视频都是待审状态
	private String coop_public;// 是否共享(y-共享，n-私有),这里是指当前视频是否会被分享给56其他用户播放。
	private String forbid;// y-被屏蔽了，n-正常--这个必须要的，因为会有继承屏蔽的情况，比如版权原因，不确定时间解开
	private String coopid;// coop_+(appid) ,例如 coop_1000008
	private String sid;// 第三方用户标识，与请求参数的说明一样。
	private String attach;// 附加信息
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
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
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
	 * @return the player
	 */
	public String getPlayer() {
		return player;
	}
	/**
	 * @param player the player to set
	 */
	public void setPlayer(String player) {
		this.player = player;
	}
	/**
	 * @return the cover
	 */
	public String getCover() {
		return cover;
	}
	/**
	 * @param cover the cover to set
	 */
	public void setCover(String cover) {
		this.cover = cover;
	}
	/**
	 * @return the chk
	 */
	public String getChk() {
		return chk;
	}
	/**
	 * @param chk the chk to set
	 */
	public void setChk(String chk) {
		this.chk = chk;
	}
	/**
	 * @return the coop_public
	 */
	public String getCoop_public() {
		return coop_public;
	}
	/**
	 * @param coop_public the coop_public to set
	 */
	public void setCoop_public(String coop_public) {
		this.coop_public = coop_public;
	}
	/**
	 * @return the forbid
	 */
	public String getForbid() {
		return forbid;
	}
	/**
	 * @param forbid the forbid to set
	 */
	public void setForbid(String forbid) {
		this.forbid = forbid;
	}
	/**
	 * @return the coopid
	 */
	public String getCoopid() {
		return coopid;
	}
	/**
	 * @param coopid the coopid to set
	 */
	public void setCoopid(String coopid) {
		this.coopid = coopid;
	}
	/**
	 * @return the sid
	 */
	public String getSid() {
		return sid;
	}
	/**
	 * @param sid the sid to set
	 */
	public void setSid(String sid) {
		this.sid = sid;
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
	

}
