package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModelProperty;

/**
 * 子账户修改密码操作
 *
 * @author wangh(wisea)
 *
 * @date 2018年10月10日
 * @version 1.0
 */
public class MembSubUpdPwdPo {

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="子账户ID")
    @Check(test = "required")
	private Long membSubId;
	@ApiModelProperty(value="新密码")
    @Check(test = "required")
	private String password;
	@ApiModelProperty(value="确认密码")
    @Check(test = "required")
	private String conPwd;

	public Long getMembSubId() {
		return membSubId;
	}
	public void setMembSubId(Long membSubId) {
		this.membSubId = membSubId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConPwd() {
		return conPwd;
	}
	public void setConPwd(String conPwd) {
		this.conPwd = conPwd;
	}
}
