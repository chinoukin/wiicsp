package com.wisea.cultivar.common.vo.tp.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 */
@ApiModel("结算单详情Vo")
public class SettleBillOrdInfoVo {

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "订单id")
    private Long ordId;
	@ApiModelProperty(value = "订单类型")
	private String ordSourceType;
	@ApiModelProperty(value = "买家名称")
	private String buyerName;
	@ApiModelProperty(value = "卖家名称")
	private String sellerName;

	public Long getOrdId() {
		return ordId;
	}
	public void setOrdId(Long ordId) {
		this.ordId = ordId;
	}

	public String getOrdSourceType() {
		return ordSourceType;
	}

	public void setOrdSourceType(String ordSourceType) {
		this.ordSourceType = ordSourceType;
	}

	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
}
