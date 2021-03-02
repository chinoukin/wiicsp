package com.wisea.cultivar.common.po.tp.memb;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 忘记密码操作的PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年9月25日
 * @version 1.0
 */
@ApiModel("忘记密码操作的PO")
public class MembForgotPwdPo {

	/**
     * 用户名
     */
    @ApiModelProperty(value="用户名称(必填)")
    @Check(test = "required")
    private String  mobile;
    /**
     * 手机验证码
     */
    @ApiModelProperty(value="手机验证码(必填)")
    @Check(test = "required")
    private String  mobileCode;
    /**
     * 修改后的密码
     */
    @ApiModelProperty(value="修改后的密码(必填)")
    @Check(test = "required")
    private String newPwd;
    /**
     * keyCode(必填)
     */
    @ApiModelProperty(value="keyCode(必填)",required=true)
	@Check(test="required")
	private String keyCode;

	public String getMobileCode() {
		return mobileCode;
	}
	public void setMobileCode(String mobileCode) {
		this.mobileCode = mobileCode;
	}
	public String getNewPwd() {
		return newPwd;
	}
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getKeyCode() {
		return keyCode;
	}
	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
