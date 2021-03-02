package com.wisea.transac.common.po.memb;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 查询市场或者运营平台总菜单列表PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年6月18日
 * @version 1.0
 */
@ApiModel("查询市场或者运营平台总菜单列表PO")
public class MarketOrPlatIdPo {

	@ApiModelProperty(value="市场ID(如果获取运营平台的则为空)")
	private Long marketId;

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}
}
