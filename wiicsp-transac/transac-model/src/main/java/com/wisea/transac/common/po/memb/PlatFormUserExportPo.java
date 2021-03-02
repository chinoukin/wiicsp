package com.wisea.transac.common.po.memb;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class PlatFormUserExportPo{


	@ApiModelProperty(value = "用户名/姓名")
    private String key;

	@ApiModelProperty(value = "系统角色ID")
	private String roleType;

	@ApiModelProperty(value = "启用禁用标识(effe_inval_state0:启用1:停用)")
	private String effeInvalState;

	@ApiModelProperty(value = "批发市场ID(如果是运营平台则为空)")
	private String marketId;

	@ApiModelProperty(value="会员id列表(如果为空则按照条件,如果不是空则按照id列表查询)")
	private List<String> idList;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getEffeInvalState() {
		return effeInvalState;
	}

	public void setEffeInvalState(String effeInvalState) {
		this.effeInvalState = effeInvalState;
	}

	public String getMarketId() {
		return marketId;
	}

	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}

	public List<String> getIdList() {
		return idList;
	}

	public void setIdList(List<String> idList) {
		this.idList = idList;
	}
}
