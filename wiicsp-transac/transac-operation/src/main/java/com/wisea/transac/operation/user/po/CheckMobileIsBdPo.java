package com.wisea.transac.operation.user.po;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 验证手机号是否绑定其他微信PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年8月21日
 * @version 1.0
 */
@ApiModel("验证手机号是否绑定其他微信PO")
public class CheckMobileIsBdPo {

	@ApiModelProperty(value = "手机号")
	@Check(test = "required",requiredMsg="手机号不能为空")
	private String mobile;
	@ApiModelProperty(value = "开放接口类型(0:微信小程序1:微信登录APP)",hidden=true)
	private String relType;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRelType() {
		return relType;
	}

	public void setRelType(String relType) {
		this.relType = relType;
	}
}
