package com.wisea.cultivar.common.po.tp.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * OrderInfoListPo
 * @author yangtao
 */
@ApiModel("买家端申请延期收货po")
public class BuyerOrdDelayRecePo {

    @ApiModelProperty(value = "延期收货原因")
    @Check(test = "required")
    private String delayReason;

    @ApiModelProperty(value = "延期收货期限")
    @Check(test = "required")
    private String delayDate;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "订单ID")
    @Check(test = "required")
    private Long ordId;

	public String getDelayReason() {
		return delayReason;
	}

	public void setDelayReason(String delayReason) {
		this.delayReason = delayReason;
	}

	public String getDelayDate() {
		return delayDate;
	}

	public void setDelayDate(String delayDate) {
		this.delayDate = delayDate;
	}

	public Long getOrdId() {
		return ordId;
	}

	public void setOrdId(Long ordId) {
		this.ordId = ordId;
	}

}
