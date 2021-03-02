package com.wisea.transac.common.vo.memb;

import com.wisea.cloud.common.util.excel.annotation.ExcelField;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 平台或者市场人员信息导出VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月6日
 * @version 1.0
 */
@ApiModel("平台或者市场人员信息导出VO")
public class PlatFormUserInfoExportVo {

	@ApiModelProperty(value = "市场账号管理表ID")
	private Long id;

	@ApiModelProperty(value = "批发市场id(总运营平台为空，市场下的用户有值)")
	private Long marketId;

	@ExcelField(title = "用户名", sort = 10)
	private String loginName;


	@ExcelField(title = "姓名", sort = 30)
	private String name;

	@ExcelField(title = "联系电话", sort = 40)
	private String tel;

	@ApiModelProperty(value = "角色ID")
	private String roleType;

	@ExcelField(title = "角色", sort = 20)
	private String roleName;

	@ApiModelProperty(value = "启用禁用标识(effe_inval_state0:启用1:停用)")
	@ExcelField(title = "当前状态", sort = 50)
	private String effeInvalState;

	@ApiModelProperty(value = "是否设置成为管理员(sf_admin_flag0:是1:否)")
	@ExcelField(title = "是否是管理员", sort = 60)
	private String sfAdminFlag;

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
	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}

}
