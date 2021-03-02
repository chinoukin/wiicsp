package com.wisea.transac.common.po.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModelProperty;

/**
 * 微信端初期设置密码的接口
 *
 * @author wangh(wisea)
 *
 * @date 2019年12月10日
 * @version 1.0
 */
public class MembWechatPwdPo {


	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="id(不填写为当前用户)")
    private Long id;
	@ApiModelProperty(value="新密码(必填)",required=true)
	@Check(test="required")
	private String newPwd;
	@ApiModelProperty(value="确认新密码(必填)",required=true)
	@Check(test="required")
	private String conNewPwd;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getConNewPwd() {
		return conNewPwd;
	}
	public void setConNewPwd(String conNewPwd) {
		this.conNewPwd = conNewPwd;
	}
}
