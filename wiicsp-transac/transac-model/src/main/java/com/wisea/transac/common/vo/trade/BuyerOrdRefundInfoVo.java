package com.wisea.transac.common.vo.trade;

import com.wisea.transac.common.vo.OrderInfoInfoVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 订单、退款信息
 */
@ApiModel("订单、退款信息")
public class BuyerOrdRefundInfoVo extends OrderInfoInfoVo{

    @ApiModelProperty(value="退款金额")
    private Double refundAmount;
    @ApiModelProperty(value="应退服务费金额")
    private Double refundSerFee;
    @ApiModelProperty(value="应退账期服务费金额")
    private Double refundZqSerCost;

    public Double getRefundAmount() {
        return refundAmount;
    }
    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }
    public Double getRefundSerFee() {
        return refundSerFee;
    }
    public void setRefundSerFee(Double refundSerFee) {
        this.refundSerFee = refundSerFee;
    }
    public Double getRefundZqSerCost() {
        return refundZqSerCost;
    }
    public void setRefundZqSerCost(Double refundZqSerCost) {
        this.refundZqSerCost = refundZqSerCost;
    }
}

