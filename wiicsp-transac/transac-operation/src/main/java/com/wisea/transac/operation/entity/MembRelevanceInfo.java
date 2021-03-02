package com.wisea.transac.operation.entity;

import com.wisea.cloud.common.entity.DataLongEntity;
/**
 * 会员第三方登录关联信息
 *
 * @author wangh(wisea)
 *
 * @date 2019年12月31日
 * @version 1.0
 */
public class MembRelevanceInfo extends DataLongEntity<MembRelevanceInfo> {

	private static final long serialVersionUID = -9100896748444913245L;

	private Long releId;// 关联ID 会员ID或者子账户ID
	private String type;// 开发接口类型 0 ：微信小程序
	private String openId;// 第三方开放的ID
	private String openType;// 开发ID类型(用于区分一个OpenId有多个端使用)
	private String unionId;
	/** 查询用 **/
	private String userName;// 用户名
	private String registTel;// 注册手机号

	public Long getReleId() {
		return releId;
	}
	public void setReleId(Long releId) {
		this.releId = releId;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUnionId() {
		return unionId;
	}
	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}
	public String getRegistTel() {
		return registTel;
	}
	public void setRegistTel(String registTel) {
		this.registTel = registTel;
	}

}
