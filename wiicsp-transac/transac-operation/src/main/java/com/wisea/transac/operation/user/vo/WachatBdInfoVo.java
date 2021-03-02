package com.wisea.transac.operation.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 微信用户绑定信息Vo
 *
 * @author wangh(wisea)
 *
 * @date 2020年2月27日
 * @version 1.0
 */
@ApiModel("微信用户绑定信息Vo")
public class WachatBdInfoVo {

	@ApiModelProperty("OPenId")
	private String openId;
	@ApiModelProperty("UnionId")
	private String unionId;

	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getUnionId() {
		return unionId;
	}
	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}
}
