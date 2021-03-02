package com.wisea.transac.common.po.memb;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 根据旧密码修改用户密码
 *
 * @author wangh(wisea)
 *
 * @date 2018年9月26日
 * @version 1.0
 */
@ApiModel("修改用户密码参数PO")
public class MembPwdUpdatePo {

	@ApiModelProperty(value="旧密码(必填)",required=true)
	@Check(test="required")
	private String oldPwd;
	@ApiModelProperty(value="新密码(必填)",required=true)
	@Check(test="required")
	private String newPwd;
	@ApiModelProperty(value="确认新密码(必填)",required=true)
	@Check(test="required")
	private String conNewPwd;
	/**
	 * @return the oldPwd
	 */
	public String getOldPwd() {
		return oldPwd;
	}
	/**
	 * @param oldPwd the oldPwd to set
	 */
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	/**
	 * @return the newPwd
	 */
	public String getNewPwd() {
		return newPwd;
	}
	/**
	 * @param newPwd the newPwd to set
	 */
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	/**
	 * @return the conNewPwd
	 */
	public String getConNewPwd() {
		return conNewPwd;
	}
	/**
	 * @param conNewPwd the conNewPwd to set
	 */
	public void setConNewPwd(String conNewPwd) {
		this.conNewPwd = conNewPwd;
	}
}
