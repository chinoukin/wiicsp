package com.wisea.transac.common.vo.trade;

import java.util.List;

import com.wisea.transac.common.vo.TransactionDataChartVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("交易数据统计Vo")
public class StatisTradeVo {

    @ApiModelProperty(value="订单数")
    private Integer ordCount;
    @ApiModelProperty(value="订单总额")
    private Double ordAmount;
    @ApiModelProperty(value="下单人数")
    private Integer ordMembCount;
    @ApiModelProperty(value="下单数量")
    private Integer ordCommCount;
    @ApiModelProperty(value="有效订单数")
    private Integer effOrdCount;
    @ApiModelProperty(value="有效订单总额")
    private Double effOrdAmount;
    @ApiModelProperty(value="付款订单数")
    private Integer payOrdCount;
    @ApiModelProperty(value="付款订单总额")
    private Double payOrdAmount;
    @ApiModelProperty(value="付款下单人数")
    private Integer payOrdMembCount;
    @ApiModelProperty(value="付款下单数量")
    private Integer payOrdCommCount;
    @ApiModelProperty(value="退款订单总额")
    private Double refundOrdAmount;
    @ApiModelProperty(value="客单价")
    private Double overPrice;
    @ApiModelProperty("图表列表")
    private List<TransactionDataChartVo> chartVos;

    public Integer getOrdCount() {
        return ordCount;
    }
    public void setOrdCount(Integer ordCount) {
        this.ordCount = ordCount;
    }
    public List<TransactionDataChartVo> getChartVos() {
        return chartVos;
    }
    public void setChartVos(List<TransactionDataChartVo> chartVos) {
        this.chartVos = chartVos;
    }
    public Double getOrdAmount() {
        return ordAmount;
    }
    public void setOrdAmount(Double ordAmount) {
        this.ordAmount = ordAmount;
    }
    public Integer getOrdMembCount() {
        return ordMembCount;
    }
    public void setOrdMembCount(Integer ordMembCount) {
        this.ordMembCount = ordMembCount;
    }
    public Integer getOrdCommCount() {
        return ordCommCount;
    }
    public void setOrdCommCount(Integer ordCommCount) {
        this.ordCommCount = ordCommCount;
    }
    public Integer getEffOrdCount() {
        return effOrdCount;
    }
    public void setEffOrdCount(Integer effOrdCount) {
        this.effOrdCount = effOrdCount;
    }
    public Double getEffOrdAmount() {
        return effOrdAmount;
    }
    public void setEffOrdAmount(Double effOrdAmount) {
        this.effOrdAmount = effOrdAmount;
    }
    public Integer getPayOrdCount() {
        return payOrdCount;
    }
    public void setPayOrdCount(Integer payOrdCount) {
        this.payOrdCount = payOrdCount;
    }
    public Double getPayOrdAmount() {
        return payOrdAmount;
    }
    public void setPayOrdAmount(Double payOrdAmount) {
        this.payOrdAmount = payOrdAmount;
    }
    public Integer getPayOrdMembCount() {
        return payOrdMembCount;
    }
    public void setPayOrdMembCount(Integer payOrdMembCount) {
        this.payOrdMembCount = payOrdMembCount;
    }
    public Integer getPayOrdCommCount() {
        return payOrdCommCount;
    }
    public void setPayOrdCommCount(Integer payOrdCommCount) {
        this.payOrdCommCount = payOrdCommCount;
    }
    public Double getRefundOrdAmount() {
        return refundOrdAmount;
    }
    public void setRefundOrdAmount(Double refundOrdAmount) {
        this.refundOrdAmount = refundOrdAmount;
    }
    public Double getOverPrice() {
        return overPrice;
    }
    public void setOverPrice(Double overPrice) {
        this.overPrice = overPrice;
    }
}
