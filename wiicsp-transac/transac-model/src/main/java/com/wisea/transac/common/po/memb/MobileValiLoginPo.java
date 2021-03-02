package com.wisea.transac.common.po.memb;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 手机号验证码登录的PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月11日
 * @version 1.0
 */
@ApiModel("手机号验证码登录的PO")
public class MobileValiLoginPo {

	@ApiModelProperty(value = "手机号")
	@Check(test = "required",requiredMsg="手机号不能为空")
	private String mobile;
	@ApiModelProperty(value = "手机验证码")
	@Check(test = "required",requiredMsg="验证码不能为空")
	private String valCode;

	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getValCode() {
		return valCode;
	}
	public void setValCode(String valCode) {
		this.valCode = valCode;
	}
}
