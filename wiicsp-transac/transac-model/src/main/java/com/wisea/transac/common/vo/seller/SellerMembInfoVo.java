package com.wisea.transac.common.vo.seller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 会员基础信息
 *
 * @author wangh(wisea)
 *
 * @date 2018年10月10日
 * @version 1.0
 */
public class SellerMembInfoVo implements Serializable{


	@ApiModelProperty(value="用户ID")
    @JsonSerialize(using = IdSerializer.class)
	private Long id;

	@ApiModelProperty(value="注册手机号")
    private String registTel;

	@ApiModelProperty(value="会员昵称")
	private String petName;

	@ApiModelProperty(value="姓名")
	private String contName;

	@ApiModelProperty(value="LOGO")
	private String logoUrl;

	@ApiModelProperty(value="企业名称-企业信息")
	private String entpName;

	@ApiModelProperty(value="绑定微信")
	private String bindWechat;

	@ApiModelProperty(value="企业认证状态（有值就是已认证）")
	private String entpAuth;

	@ApiModelProperty(value="会员职位")
	private String membClass;

	@ApiModelProperty(value="介绍信息")
	private String signature;

	@ApiModelProperty(value="实人认证状态（有值就是已认证）")
	private String realPersonAuth;

	@ApiModelProperty(value="采购主体是0  采购员是1")
	private String roleFlag;

	@ApiModelProperty(value="是否设置成为管理员")
	private String sfAdminFlag;

	public String getSfAdminFlag() {
		return sfAdminFlag;
	}

	public void setSfAdminFlag(String sfAdminFlag) {
		this.sfAdminFlag = sfAdminFlag;
	}

	public String getRoleFlag() {
		return roleFlag;
	}

	public void setRoleFlag(String roleFlag) {
		this.roleFlag = roleFlag;
	}

	public String getRealPersonAuth() {
		return realPersonAuth;
	}

	public void setRealPersonAuth(String realPersonAuth) {
		this.realPersonAuth = realPersonAuth;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegistTel() {
		return registTel;
	}

	public void setRegistTel(String registTel) {
		this.registTel = registTel;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}


	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getEntpName() {
		return entpName;
	}

	public void setEntpName(String entpName) {
		this.entpName = entpName;
	}

	public String getBindWechat() {
		return bindWechat;
	}

	public void setBindWechat(String bindWechat) {
		this.bindWechat = bindWechat;
	}

	public String getEntpAuth() {
		return entpAuth;
	}

	public void setEntpAuth(String entpAuth) {
		this.entpAuth = entpAuth;
	}

	public String getContName() {
		return contName;
	}

	public void setContName(String contName) {
		this.contName = contName;
	}

	public String getMembClass() {
		return membClass;
	}

	public void setMembClass(String membClass) {
		this.membClass = membClass;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
}
