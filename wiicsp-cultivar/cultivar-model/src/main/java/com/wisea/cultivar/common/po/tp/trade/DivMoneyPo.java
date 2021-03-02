package com.wisea.cultivar.common.po.tp.trade;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 申请退货计算金额PO
 *
 * @author yangtao
 *
 */
@ApiModel("申请退货计算金额PO")
public class DivMoneyPo {

    @ApiModelProperty("订单商品id")
    @Check(test = "required")
    private Long id;

    @ApiModelProperty("退货数量")
    private int count;

    @ApiModelProperty(value = "应退商品金额")
    private Double commTotalAmount;

    @ApiModelProperty(value = "应退运费金额")
    private Double shouldYfAmount;

    @ApiModelProperty(value = "应退金额")
    private Double shouldRefundAmount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getShouldRefundAmount() {
		return shouldRefundAmount;
	}

	public void setShouldRefundAmount(Double shouldRefundAmount) {
		this.shouldRefundAmount = shouldRefundAmount;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Double getCommTotalAmount() {
		return commTotalAmount;
	}

	public void setCommTotalAmount(Double commTotalAmount) {
		this.commTotalAmount = commTotalAmount;
	}

	public Double getShouldYfAmount() {
		return shouldYfAmount;
	}

	public void setShouldYfAmount(Double shouldYfAmount) {
		this.shouldYfAmount = shouldYfAmount;
	}
}
