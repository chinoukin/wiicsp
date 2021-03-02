package com.wisea.transac.common.po.memb;

import io.swagger.annotations.ApiModel;

/**
 * 验证角色是否存在PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月20日
 * @version 1.0
 */
@ApiModel("验证角色是否存在PO")
public class RoleExtendsCheckPo {

	// 角色ID
	private String id;
	// 市场或者是总运营平台的ID
	private String marketId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMarketId() {
		return marketId;
	}
	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}
}
