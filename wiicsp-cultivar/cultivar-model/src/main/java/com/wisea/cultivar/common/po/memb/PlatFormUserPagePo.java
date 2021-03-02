package com.wisea.cultivar.common.po.memb;

import com.wisea.cloud.model.po.PagePo;

import com.wisea.cultivar.common.vo.memb.PlatFormUserInfoVo;
import io.swagger.annotations.ApiModelProperty;

public class PlatFormUserPagePo extends PagePo<PlatFormUserInfoVo>{

	private static final long serialVersionUID = 1463121028673373037L;

	@ApiModelProperty(value = "用户名/姓名")
    private String key;

	@ApiModelProperty(value = "系统角色ID")
	private String roleType;

	@ApiModelProperty(value = "启用禁用标识(effe_inval_state0:启用1:停用)")
	private String effeInvalState;

	@ApiModelProperty(value = "批发市场ID(如果是运营平台则为空)")
	private String marketId;

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
}
