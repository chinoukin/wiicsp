package com.wisea.transac.operation.user.po;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModelProperty;

/**
 * 微信小程序验证是否登录成功PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年12月26日
 * @version 1.0
 */
public class WechatVilLoginPo {

	@ApiModelProperty(value="登录时获取的code(必填)",required=true)
	@Check(test="required")
	private String code;
	@ApiModelProperty(value="小程序标识(如果只有一个小程序可以不填写),填写的必须与配置的appID相对应")
	private Integer wechatType = 0;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getWechatType() {
		return wechatType;
	}
	public void setWechatType(Integer wechatType) {
		this.wechatType = wechatType;
	}
}
