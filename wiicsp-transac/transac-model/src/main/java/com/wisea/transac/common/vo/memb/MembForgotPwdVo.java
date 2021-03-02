package com.wisea.transac.common.vo.memb;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 忘记密码返回手机号和keyCodeVo
 *
 * @author wangh(wisea)
 *
 * @date 2018年9月29日
 * @version 1.0
 */
@ApiModel("忘记密码返回手机号和keyCodeVo")
public class MembForgotPwdVo {

	@ApiModelProperty(value = "keyCode")
	private String keyCode;
	@ApiModelProperty(value = "手机号")
	private String mobile;


	public String getKeyCode() {
		return keyCode;
	}
	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
