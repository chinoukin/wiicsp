package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 注册会员的基本信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月5日
 * @version 1.0
 */
@ApiModel("注册会员的基本信息PO")
public class RegisterBaseInfoPo {
	@ApiModelProperty(value="用户名(必填)",required=true)
	@Check(test="required,minLength,maxLength",lengthRange={6,16},lengthMsg="用户名的长度为6-16")
	private String loginName;
	@ApiModelProperty(value="密码(必填)",required=true)
	@Check(test="required")
	private String password;
	@ApiModelProperty(value="手机号码(必填)",required=true)
	@Check(test="required,minLength,maxLength",lengthRange={11,11},lengthMsg="手机号的长度为11")
	private String registTel;
	@ApiModelProperty(value="手机验证码(必填)",required=true)
	@Check(test="required")
	private String viliCode;
	@ApiModelProperty(value="会员类型,服务商APP注册时填固定值0")
	private String membType;


	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegistTel() {
		return registTel;
	}

	public void setRegistTel(String registTel) {
		this.registTel = registTel;
	}

	public String getViliCode() {
		return viliCode;
	}

	public void setViliCode(String viliCode) {
		this.viliCode = viliCode;
	}

	public String getMembType() {
		return membType;
	}

	public void setMembType(String membType) {
		this.membType = membType;
	}
}
