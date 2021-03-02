package com.wisea.cultivar.common.vo.memb;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 设置用户名密码判断返回值VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年7月24日
 * @version 1.0
 */
@ApiModel("设置用户名密码判断返回值VO")
public class SetPwdOrNameInitVo {

	@ApiModelProperty("会员ID")
	private Long id;
	@ApiModelProperty("用户名是否设定(0:设定过1：未审定过)")
	private String loginNameSetFlag;
	@ApiModelProperty("密码是否设定(0:设定过1：未审定过)")
	private String passwordSetFlag;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLoginNameSetFlag() {
		return loginNameSetFlag;
	}
	public void setLoginNameSetFlag(String loginNameSetFlag) {
		this.loginNameSetFlag = loginNameSetFlag;
	}
	public String getPasswordSetFlag() {
		return passwordSetFlag;
	}
	public void setPasswordSetFlag(String passwordSetFlag) {
		this.passwordSetFlag = passwordSetFlag;
	}
}
