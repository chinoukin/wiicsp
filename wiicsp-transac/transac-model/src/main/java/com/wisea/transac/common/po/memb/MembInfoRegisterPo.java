package com.wisea.transac.common.po.memb;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 商家注册会员信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年4月28日
 * @version 1.0
 */
@ApiModel("商家注册会员信息PO")
public class MembInfoRegisterPo {

    /**
     * 用户名
     */
    @Check(test = { "maxLength","required"}, mixLength = 255)
    @ApiModelProperty(value = "用户名")
    private String loginName;
    /**
     * 注册手机号
     */
    @Check(test = { "maxLength","required"}, mixLength = 32)
    @ApiModelProperty(value = "注册手机号")
    private String registTel;
	/**
	 * 手机验证码
	 */
    @Check(test = {"required"})
    @ApiModelProperty(value = "手机验证码")
    private String mobileCode;
    /**
	 * 密码
	 */
    @Check(test = {"required"})
    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "是否产地会员类型(0:是产地会员1不是产地会员(空也是非产地会员))",hidden=true)
    private String localityMembType;

	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getRegistTel() {
		return registTel;
	}
	public void setRegistTel(String registTel) {
		this.registTel = registTel;
	}
	public String getMobileCode() {
		return mobileCode;
	}
	public void setMobileCode(String mobileCode) {
		this.mobileCode = mobileCode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLocalityMembType() {
		return localityMembType;
	}
	public void setLocalityMembType(String localityMembType) {
		this.localityMembType = localityMembType;
	}

}
