package com.wisea.cultivar.common.po.tp.memb;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * 采样人员添加的PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年11月6日
 * @version 1.0
 */
@Api("采样人员保存的PO")
public class SampUserSavePo {

	@ApiModelProperty(value="用户名")
	@Check(test = { "required" })
	private String loginName;
	@ApiModelProperty(value="采样人姓名")
	@Check(test = { "required" })
	private String sampName;
	@ApiModelProperty(value="密码")
	@Check(test = { "required" })
	private String password;
	@ApiModelProperty(value="手机号")
	@Check(test = { "required" })
	private String mobile;
	@ApiModelProperty(value="邮箱")
	private String email;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSampName() {
		return sampName;
	}
	public void setSampName(String sampName) {
		this.sampName = sampName;
	}
}
