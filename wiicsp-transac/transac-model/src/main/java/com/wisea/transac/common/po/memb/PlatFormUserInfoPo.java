package com.wisea.transac.common.po.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 平台或者市场用户保存PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月6日
 * @version 1.0
 */
@ApiModel("平台或者市场用户保存PO")
public class PlatFormUserInfoPo {

	@ApiModelProperty(value = "市场账号管理表ID(市场或者运营平台人员ID)")
	@JsonSerialize(using = IdSerializer.class)
	private Long id;
	@ApiModelProperty(value = "批发市场id(总运营平台为空)")
	private Long marketId;
	@Check(test = { "maxLength","required"}, mixLength = 255)
	@ApiModelProperty(value = "用户名")
	private String loginName;
	@ApiModelProperty(value = "密码(修改的情况,如果没有没有修改则为空)")
	private String password;
	@Check(test = { "maxLength","required"}, mixLength = 30)
	@ApiModelProperty(value = "姓名")
	private String name;
	@ApiModelProperty(value = "手机号")
	private String tel;
	@Check(test = {"required"})
	@ApiModelProperty(value = "角色ID")
	private String roleType;
	@Check(test = {"required"})
	@ApiModelProperty(value = "启用禁用标识(effe_inval_state0:启用1:停用)")
	private String effeInvalState;
	@ApiModelProperty(value = "是否设置成为管理员(sf_admin_flag0:是1:否)",hidden=true)
	private String sfAdminFlag;

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
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSfAdminFlag() {
		return sfAdminFlag;
	}
	public void setSfAdminFlag(String sfAdminFlag) {
		this.sfAdminFlag = sfAdminFlag;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	public Long getMarketId() {
		return marketId;
	}
	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

}
