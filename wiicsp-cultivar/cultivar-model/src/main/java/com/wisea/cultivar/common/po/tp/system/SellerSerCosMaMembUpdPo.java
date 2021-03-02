package com.wisea.cultivar.common.po.tp.system;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModelProperty;

/**
 *  商家认证时添加修改商家服务费信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年1月21日
 * @version 1.0
 */
public class SellerSerCosMaMembUpdPo {

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="买家ID")
    @Check(test = "required")
	private Long buyerId;
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "服务费")
    private Double serCost;

	public Long getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}
	public Double getSerCost() {
		return serCost;
	}
	public void setSerCost(Double serCost) {
		this.serCost = serCost;
	}
}
