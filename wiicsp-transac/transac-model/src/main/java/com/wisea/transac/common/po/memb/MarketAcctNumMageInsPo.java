package com.wisea.transac.common.po.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 市场平台用户新增PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月6日
 * @version 1.0
 */
@ApiModel("市场平台用户新增PO")
public class MarketAcctNumMageInsPo extends MarketAcctNumMagePo{

	@Check(test = {"required"})
	@ApiModelProperty(value = "批发市场id")
	@JsonSerialize(using = IdSerializer.class)
	private Long marketId;

	@Check(test = {"required"})
	@ApiModelProperty(value = "密码")
	private String password;

	@ApiModelProperty(value = "是否设置成为管理员(sf_admin_flag0:是1:否)",hidden=true)
	private String sfAdminFlag;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSfAdminFlag() {
		return sfAdminFlag;
	}

	public void setSfAdminFlag(String sfAdminFlag) {
		this.sfAdminFlag = sfAdminFlag;
	}

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}
}
