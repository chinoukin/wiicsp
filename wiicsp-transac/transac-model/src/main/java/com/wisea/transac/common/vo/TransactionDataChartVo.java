package com.wisea.transac.common.vo;

import io.swagger.annotations.ApiModelProperty;

public class TransactionDataChartVo {
    @ApiModelProperty("X轴坐标点")
    private String xPoint;
    @ApiModelProperty("付款金额Y轴值")
    private Double totalPayAmount;
    @ApiModelProperty("付款人数Y轴值")
    private Integer payBuyerCount;
    @ApiModelProperty("付款件数Y轴值")
    private Integer payOrdCommRelaCount;
    @ApiModelProperty("退款金额Y轴值")
    private Double totalRefund;

    public String getxPoint() {
        return xPoint;
    }

    public void setxPoint(String xPoint) {
        this.xPoint = xPoint;
    }

    public Double getTotalPayAmount() {
        return totalPayAmount;
    }

    public void setTotalPayAmount(Double totalPayAmount) {
        this.totalPayAmount = totalPayAmount;
    }

    public Integer getPayBuyerCount() {
        return payBuyerCount;
    }

    public void setPayBuyerCount(Integer payBuyerCount) {
        this.payBuyerCount = payBuyerCount;
    }

    public Integer getPayOrdCommRelaCount() {
        return payOrdCommRelaCount;
    }

    public void setPayOrdCommRelaCount(Integer payOrdCommRelaCount) {
        this.payOrdCommRelaCount = payOrdCommRelaCount;
    }

    public Double getTotalRefund() {
        return totalRefund;
    }

    public void setTotalRefund(Double totalRefund) {
        this.totalRefund = totalRefund;
    }
}
