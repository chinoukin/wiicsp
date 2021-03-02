package com.wisea.transac.common.vo.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className DeliveryAmountDetailsVo
 * @date 2020/6/18 9:39
 * @Description
 */
@ApiModel("提货金额明细VO")
public class DeliveryAmountDetailsVo {
    @ApiModelProperty("支付方式（在线支付、账期支付）")
    private String payMethodType;
    @ApiModelProperty("订单金额")
    private Double payableAmount;
    @ApiModelProperty("订单账期服务费")
    private Double zqSerCost;
    @ApiModelProperty("提货金额")
    private Double deliveryAmount;
    @ApiModelProperty("提货账期服务费")
    private Double deliveryZqSerCost;
    @ApiModelProperty("退款金额")
    private Double refundAmount;
    @ApiModelProperty("退款账期服务费")
    private Double refundZqSerCost;

    public String getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(String payMethodType) {
        this.payMethodType = payMethodType;
    }

    public Double getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(Double payableAmount) {
        this.payableAmount = payableAmount;
    }

    public Double getZqSerCost() {
        return zqSerCost;
    }

    public void setZqSerCost(Double zqSerCost) {
        this.zqSerCost = zqSerCost;
    }

    public Double getDeliveryAmount() {
        return deliveryAmount;
    }

    public void setDeliveryAmount(Double deliveryAmount) {
        this.deliveryAmount = deliveryAmount;
    }

    public Double getDeliveryZqSerCost() {
        return deliveryZqSerCost;
    }

    public void setDeliveryZqSerCost(Double deliveryZqSerCost) {
        this.deliveryZqSerCost = deliveryZqSerCost;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Double getRefundZqSerCost() {
        return refundZqSerCost;
    }

    public void setRefundZqSerCost(Double refundZqSerCost) {
        this.refundZqSerCost = refundZqSerCost;
    }
}
