package com.wisea.cultivar.common.vo.tp.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 提交订单返回订单信息
 */
@ApiModel("提交订单返回订单信息")
public class BuyerOrderInfoVo {

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "订单id")
    private Long id;

    @ApiModelProperty(value = "订单编号")
    private String ordNum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrdNum() {
		return ordNum;
	}

	public void setOrdNum(String ordNum) {
		this.ordNum = ordNum;
	}
}

