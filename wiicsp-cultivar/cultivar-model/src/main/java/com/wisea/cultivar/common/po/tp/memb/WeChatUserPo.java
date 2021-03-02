package com.wisea.cultivar.common.po.tp.memb;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

/**
 * 微信账号信息完善的处理
 *
 * @author wangh(wisea)
 *
 * @date 2018年11月12日
 * @version 1.0
 */
@Api("微信账号信息完善的处理PO")
public class WeChatUserPo {

	@ApiModelProperty(value="unionId(必填)")
	@Check(test = { "required" })
	private String unionId;
	@ApiModelProperty(value="手机号(必填)")
	@Check(test = { "required" })
	private String mobile;
	@ApiModelProperty(value="手机验证码(必填)")
	@Check(test = { "required" })
	private String vliCode;
	@ApiModelProperty(value="密码(必填)")
	@Check(test = { "required" })
	private String password;
	@ApiModelProperty(value="头像地址")
	private String url;

	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getVliCode() {
		return vliCode;
	}
	public void setVliCode(String vliCode) {
		this.vliCode = vliCode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUnionId() {
		return unionId;
	}
	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}
}
