package com.wisea.transac.operation.user.po;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 验证第三方帐号是否存在PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年8月20日
 * @version 1.0
 */
@ApiModel("验证第三方帐号是否存在PO")
public class ValiUnionExistPo {

	@Check(test = { "required"})
	@ApiModelProperty(value = "unionId")
	private String unionId;

	@ApiModelProperty(value = "登录类型(web:采购端city_bus:同城商家端loc_bus:产地商家端)")
	@Check(test = { "required", "liveable" }, liveable = { "web", "city_bus","loc_bus" },liveableMsg = "登录类型不正确")
	private String loginType;
	@ApiModelProperty(value = "开放接口类型(0:微信小程序1:微信登录APP)",hidden=true)
	private String relType;

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getRelType() {
		return relType;
	}

	public void setRelType(String relType) {
		this.relType = relType;
	}
}
