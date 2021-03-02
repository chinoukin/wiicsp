package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 修改忘记密码的参数PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月5日
 * @version 1.0
 */
@ApiModel("修改忘记密码的参数PO")
public class SaveForgetPwdPo {
	@ApiModelProperty(value="用户名(如果手机号为空，用户名必填)")
	@Check(test = "logic", logic = "#isEmpty(#registTel)?#isNotEmpty(#loginName):true", logicMsg = "手机号为空，用户名必填")
	private String loginName;
	@ApiModelProperty(value="手机号(如果用户名为空，手机号必填)")
	@Check(test = "logic", logic = "#isEmpty(#loginName)?#isNotEmpty(#registTel):true", logicMsg = "用户名为空，手机号必填")
	private String registTel;
	@ApiModelProperty(value="手机验证码(必填)",required=true)
	@Check(test="required")
	private String viliCode;
	@ApiModelProperty(value="新密码(必填)",required=true)
	@Check(test="required")
	private String newPwd;

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

	public String getViliCode() {
		return viliCode;
	}

	public void setViliCode(String viliCode) {
		this.viliCode = viliCode;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
}
