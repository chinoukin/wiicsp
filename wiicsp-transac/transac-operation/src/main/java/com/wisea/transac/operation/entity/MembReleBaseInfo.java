package com.wisea.transac.operation.entity;

import java.io.Serializable;

/**
 * 会员第三方登录关联基本信息
 *
 * @author wangh(wisea)
 *
 * @date 2019年12月31日
 * @version 1.0
 */
public class MembReleBaseInfo implements Serializable{

	private static final long serialVersionUID = 4038981185065545939L;
	/**
	 * 关联表的ID
	 */
	private Long id;//关联表的ID
	/**
	 * 关联ID 会员ID或者子账户ID
	 */
	private Long releId;
	/**
	 * 会员ID(如果是会员用户则是本身,如果是子账户则是子账户会员的ID)
	 */
	private Long membId;
	/**
	 * 开发接口类型 0 ：微信小程序
	 */
	private String type;// 开发接口类型 0 ：微信小程序
	/**
	 * 第三方开放的ID
	 */
	private String openId;// 第三方开放的ID
	/**
	 * 开发ID类型(用于区分一个OpenId有多个端使用)
	 */
	private String openType;// 开发ID类型(用于区分一个OpenId有多个端使用)
	/**
	 * 账户类型（0：会员账户1：子账户）
	 */
	private String membFlag;
	/**
	 * unionid
	 */
	private String unionid;
	/**
	 * 注册手机号
	 */
	private String registTel;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getReleId() {
		return releId;
	}
	public void setReleId(Long releId) {
		this.releId = releId;
	}
	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getOpenType() {
		return openType;
	}
	public void setOpenType(String openType) {
		this.openType = openType;
	}
	public String getMembFlag() {
		return membFlag;
	}
	public void setMembFlag(String membFlag) {
		this.membFlag = membFlag;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	public String getRegistTel() {
		return registTel;
	}
	public void setRegistTel(String registTel) {
		this.registTel = registTel;
	}
}
