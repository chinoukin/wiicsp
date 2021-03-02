package com.wisea.cultivar.common.po.tp.memb;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 保存新手机号的PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年9月25日
 * @version 1.0
 */
@ApiModel("保存新手机号的PO")
public class MembSaveNewMobilePo {

	/**
     * 新手机号码(必填)
     */
    @ApiModelProperty(value="新手机号码(必填)",required=true)
	@Check(test="required")
	private String newMobile;
    /**
     * 手机验证码
     */
    @ApiModelProperty(value="手机验证码(必填)")
    @Check(test = "required")
    private String  mobileCode;
    /**
     * keyCode(必填)
     */
    @ApiModelProperty(value="keyCode(必填)",required=true)
	@Check(test="required")
	private String keyCode;

	public String getNewMobile() {
		return newMobile;
	}
	public void setNewMobile(String newMobile) {
		this.newMobile = newMobile;
	}
	public String getMobileCode() {
		return mobileCode;
	}
	public void setMobileCode(String mobileCode) {
		this.mobileCode = mobileCode;
	}
	public String getKeyCode() {
		return keyCode;
	}
	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}
}
