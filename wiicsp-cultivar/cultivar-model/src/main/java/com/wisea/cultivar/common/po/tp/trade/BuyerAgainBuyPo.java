package com.wisea.cultivar.common.po.tp.trade;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BuyerAgainBuyPo
 * 2018/09/18 17:40:35
 */
@ApiModel("再次购买po")
public class BuyerAgainBuyPo{

	@ApiModelProperty(value = "订单的ID")
	@Check(test = "required")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
