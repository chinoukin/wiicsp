package com.wisea.cultivar.common.vo.memb;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 平台或者市场人员信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月6日
 * @version 1.0
 */
@ApiModel("平台或者市场人员信息VO")
public class PlatFormUserInfoVo {

	@ApiModelProperty(value = "市场账号管理表ID")
	private Long id;

	@ApiModelProperty(value = "批发市场id(总运营平台为空，市场下的用户有值)")
	private Long marketId;

	@ApiModelProperty(value = "用户名")
	private String loginName;

	@ApiModelProperty(value = "姓名")
	private String name;

	@ApiModelProperty(value = "手机号")
	private String tel;

	@ApiModelProperty(value = "角色ID")
	private String roleType;

	@ApiModelProperty(value = "角色名称")
	private String roleName;

	@ApiModelProperty(value = "启用禁用标识(effe_inval_state0:启用1:停用)")
	private String effeInvalState;

	@ApiModelProperty(value = "是否设置成为管理员(sf_admin_flag0:是1:否)")
	private String sfAdminFlag;

	@ApiModelProperty(value = "密码")
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getEffeInvalState() {
		return effeInvalState;
	}

	public void setEffeInvalState(String effeInvalState) {
		this.effeInvalState = effeInvalState;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

}
