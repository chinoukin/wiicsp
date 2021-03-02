package com.wisea.cultivar.common.po.memb;

/**
 * 登录名或者手机号PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年6月18日
 * @version 1.0
 */
public class LoginNameOrMobilePo {

	/**
	 * 登录用户名
	 */
	private String loginName;
	/**
	 * 注册手机号
	 */
	private String mobile;

	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
