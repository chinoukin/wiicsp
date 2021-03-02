package com.wisea.transac.operation.user.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * APP第三方登录解绑的处理PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年8月24日
 * @version 1.0
 */
@ApiModel("APP第三方登录解绑的处理PO")
public class MembThirdUnBindPo {

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="会员ID(如果为空表示当前登录的会员)")
	private Long membId;
	@ApiModelProperty(value="开放接口类型(0:微信)默认是0")
	private String type = "0";
	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
