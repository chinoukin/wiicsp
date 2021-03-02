package com.wisea.cultivar.common.vo.tp.statistics;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

public class TransactionDataVo {
    @ApiModelProperty("下单人数")
    private Integer buyerCount;
    @ApiModelProperty("订单数")
    private Integer orderCount;
    @ApiModelProperty("下单件数")
    private Integer ordCommRelaCount;
    @ApiModelProperty("下单金额")
    private Double totalOrderAmount;
    @ApiModelProperty("有效订单数")
    private Integer effectiveOrderCount;
    @ApiModelProperty("有效订单金额")
    private Double totalEffectiveOrderAmount;
    @ApiModelProperty("退款金额")
    private Double totalRefund;
    @ApiModelProperty("付款人数")
    private Integer payBuyerCount;
    @ApiModelProperty("付款订单数")
    private Integer payOrderCount;
    @ApiModelProperty("付款件数")
    private Integer payOrdCommRelaCount;
    @ApiModelProperty("付款金额")
    private Double payTotalOrderAmount;
    @ApiModelProperty("客单价")
    private Double customerPrice;
    @ApiModelProperty("图表列表")
    private List<TransactionDataChartVo> chartVos;


    public Integer getBuyerCount() {
        return buyerCount;
    }

    public void setBuyerCount(Integer buyerCount) {
        this.buyerCount = buyerCount;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Integer getOrdCommRelaCount() {
        return ordCommRelaCount;
    }

    public void setOrdCommRelaCount(Integer ordCommRelaCount) {
        this.ordCommRelaCount = ordCommRelaCount;
    }

    public Double getTotalOrderAmount() {
        return totalOrderAmount;
    }

    public void setTotalOrderAmount(Double totalOrderAmount) {
        this.totalOrderAmount = totalOrderAmount;
    }

    public Integer getEffectiveOrderCount() {
        return effectiveOrderCount;
    }

    public void setEffectiveOrderCount(Integer effectiveOrderCount) {
        this.effectiveOrderCount = effectiveOrderCount;
    }

    public Double getTotalEffectiveOrderAmount() {
        return totalEffectiveOrderAmount;
    }

    public void setTotalEffectiveOrderAmount(Double totalEffectiveOrderAmount) {
        this.totalEffectiveOrderAmount = totalEffectiveOrderAmount;
    }

    public Double getTotalRefund() {
        return totalRefund;
    }

    public void setTotalRefund(Double totalRefund) {
        this.totalRefund = totalRefund;
    }

    public Integer getPayBuyerCount() {
        return payBuyerCount;
    }

    public void setPayBuyerCount(Integer payBuyerCount) {
        this.payBuyerCount = payBuyerCount;
    }

    public Integer getPayOrderCount() {
        return payOrderCount;
    }

    public void setPayOrderCount(Integer payOrderCount) {
        this.payOrderCount = payOrderCount;
    }

    public Integer getPayOrdCommRelaCount() {
        return payOrdCommRelaCount;
    }

    public void setPayOrdCommRelaCount(Integer payOrdCommRelaCount) {
        this.payOrdCommRelaCount = payOrdCommRelaCount;
    }

    public Double getPayTotalOrderAmount() {
        return payTotalOrderAmount;
    }

    public void setPayTotalOrderAmount(Double payTotalOrderAmount) {
        this.payTotalOrderAmount = payTotalOrderAmount;
    }

    public Double getCustomerPrice() {
        return customerPrice;
    }

    public void setCustomerPrice(Double customerPrice) {
        this.customerPrice = customerPrice;
    }

    public List<TransactionDataChartVo> getChartVos() {
        return chartVos;
    }

    public void setChartVos(List<TransactionDataChartVo> chartVos) {
        this.chartVos = chartVos;
    }
}
