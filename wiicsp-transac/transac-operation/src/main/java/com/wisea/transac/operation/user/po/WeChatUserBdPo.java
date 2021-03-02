package com.wisea.transac.operation.user.po;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * 微信账号绑定的PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年11月12日
 * @version 1.0
 */
@Api("微信账号绑定的PO")
public class WeChatUserBdPo {

	@ApiModelProperty(value="pendid(必填)")
	@Check(test = { "required" })
	private String openid;
	@ApiModelProperty(value="用户名(必填)")
	@Check(test = { "required" })
	private String loginName;
	@ApiModelProperty(value="密码(必填)")
	@Check(test = { "required" })
	private String password;
	@ApiModelProperty(value="小程序标识(如果只有一个小程序可以不填写),填写的必须与配置的appID相对应")
	private Integer wechatType = 0;

	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public Integer getWechatType() {
		return wechatType;
	}
	public void setWechatType(Integer wechatType) {
		this.wechatType = wechatType;
	}

}
