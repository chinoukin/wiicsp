package com.wisea.cultivar.common.po.tp.memb;

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

	@ApiModelProperty(value="unionId(必填)")
	@Check(test = { "required" })
	private String unionId;
	@ApiModelProperty(value="用户名(必填)")
	@Check(test = { "required" })
	private String loginName;
	@ApiModelProperty(value="密码(必填)")
	@Check(test = { "required" })
	private String password;

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
	public String getUnionId() {
		return unionId;
	}
	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

}
