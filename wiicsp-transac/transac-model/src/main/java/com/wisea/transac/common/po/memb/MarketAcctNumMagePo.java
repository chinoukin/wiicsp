package com.wisea.transac.common.po.memb;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 总运营平台用户基本信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月6日
 * @version 1.0
 */
@ApiModel("总运营平台用户基本信息PO")
public class MarketAcctNumMagePo {

	@Check(test = {"required"})
    @ApiModelProperty(value="用户名")
    private String loginName;

    @Check(test = {"required"})
    @ApiModelProperty(value="姓名")
    private String name;

    @ApiModelProperty(value="联系电话")
    private String tel;

    @Check(test = {"required"})
	@ApiModelProperty(value = "角色ID")
	private String roleType;

    @Check(test = {"required"})
	@ApiModelProperty(value = "启用禁用标识(effe_inval_state0:启用1:停用)")
	private String effeInvalState;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEffeInvalState() {
		return effeInvalState;
	}

	public void setEffeInvalState(String effeInvalState) {
		this.effeInvalState = effeInvalState;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}


}
