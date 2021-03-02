package com.wisea.transac.operation.user.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 第三方登录绑定解绑传参PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年12月31日
 * @version 1.0
 */
@ApiModel("第三方登录绑定解绑传参PO")
public class MembReleUnBdPo {

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="id")
    @Check(test = "required")
    private Long id;
	@ApiModelProperty(value="小程序标识(如果只有一个小程序可以不填写),填写的必须与配置的appID相对应")
	private Integer wechatType = 0;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getWechatType() {
		return wechatType;
	}
	public void setWechatType(Integer wechatType) {
		this.wechatType = wechatType;
	}
}
