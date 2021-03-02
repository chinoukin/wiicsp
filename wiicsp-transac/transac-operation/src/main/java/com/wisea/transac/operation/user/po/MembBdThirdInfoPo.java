package com.wisea.transac.operation.user.po;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 根据第三方绑定会员信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年8月20日
 * @version 1.0
 */
@ApiModel("根据第三方绑定会员信息PO")
public class MembBdThirdInfoPo {

	@ApiModelProperty(value = "如果绑定当前用户可以为空")
	private Long membId;
	@Check(test = { "required"},requiredMsg="unionId不能为空")
	@ApiModelProperty(value = "unionId")
	private String unionId;
	@Check(test = { "required"},requiredMsg="openId不能为空")
	@ApiModelProperty(value = "openId")
	private String openId;
	@Check(test = { "required"},requiredMsg="昵称不能为空")
	@ApiModelProperty(value = "昵称")
	private String petName;
	@ApiModelProperty(value = "登录类型(web:采购端city_bus:同城商家端loc_bus:产地商家端)")
	@Check(test = { "required", "liveable" }, liveable = { "web", "city_bus","loc_bus" },liveableMsg = "登录类型不正确")
	private String loginType;
	@ApiModelProperty(value = "开放接口类型(0:微信)",hidden=true)
	private String relType;
	public String getUnionId() {
		return unionId;
	}
	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
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
	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}
}
