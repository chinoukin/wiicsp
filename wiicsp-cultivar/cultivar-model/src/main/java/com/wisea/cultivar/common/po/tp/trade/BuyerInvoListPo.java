package com.wisea.cultivar.common.po.tp.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 买家发票列表PO
 */
@ApiModel("买家发票列表PO")
public class BuyerInvoListPo {

    @ApiModelProperty(value="买家ID", hidden = true)
    private Long membId;
    @ApiModelProperty("卖家允许开票类型，多个用逗号分隔")
    private String invoType;

	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}
	public String getInvoType() {
		return invoType;
	}
	public void setInvoType(String invoType) {
		this.invoType = invoType;
	}
}
