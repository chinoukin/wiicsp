package com.wisea.transac.common.vo.trade;

import java.time.OffsetDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("结算单去支付详细信息Vo")
public class ToPaySettleInfoVo {

    @ApiModelProperty("卖方id")
    private Long sellerId;
    @ApiModelProperty("买方id")
    private Long buyerId;
    @ApiModelProperty("结算单号")
    private String settleBillNumb;
    @ApiModelProperty("结算周期开始时间")
    private OffsetDateTime settleCycleStartDate;
    @ApiModelProperty("结算周期结束时间")
    private OffsetDateTime settleCycleEndDate;
    @ApiModelProperty("订单数")
    private Integer ordCount;
    @ApiModelProperty("账期类型")
    private String settleCycleType;
    @ApiModelProperty("账单生成日类型")
    private String billDateType;
    @ApiModelProperty("应结总额")
    private Double totalMoney;
    @ApiModelProperty("商家名称")
    private String entpName;
    @ApiModelProperty("最晚付款日期")
    private OffsetDateTime lastPayDate;
    @ApiModelProperty("结算单状态")
    private String settleBillStatueType;
    @ApiModelProperty("滞纳金")
    private Double lateFee;
    @ApiModelProperty("滞纳金比例")
    private Double lateFeeBl;
    @ApiModelProperty("是否逾期")
    private String sfYqFlag;
    @ApiModelProperty("商品金额")
    private Double commAmount;
    @ApiModelProperty("账期服务费金额")
    private Double zqSerCost;
    @ApiModelProperty("平台服务费")
    private Double platfCost;
    @ApiModelProperty("对账日")
    private OffsetDateTime recoDate;
    @ApiModelProperty("已支付总金额")
    private Double paymentAmount;
    @ApiModelProperty("已支付结算金额")
    private Double paymentSettleAmount;
    @ApiModelProperty(" 已支付滞纳金金额")
    private Double paymentLateFeeAmount;
    @ApiModelProperty("对账状态")
    private String reconStateType;
    @ApiModelProperty("结算单生成类型")
    private String settleBillPrdutType;
    @ApiModelProperty("对账截止日")
    private OffsetDateTime reconDeadline;
    @ApiModelProperty("开票截止日")
    private OffsetDateTime openBillDeadline;
    @ApiModelProperty("验票截止日")
    private OffsetDateTime examBillDeadline;
    @ApiModelProperty("最晚付款期限（对账完成后）")
    private Integer payDeadDate;
    @ApiModelProperty("未支付本金金额")
    private Double notPaymentAmount;
    @ApiModelProperty("已支付滞纳金金额")
    private Double paymentLateFeAmount;
    @ApiModelProperty("当前剩余滞纳金金额")
    private Double lateFeAmount;
    @ApiModelProperty("本次最小支付金额")
    private Double smartAmount;
    @ApiModelProperty("本次剩余支付金额")
    private Double nowPayAmount;
    @ApiModelProperty("较上次支付逾期天数")
    private Integer lateDay;
    @ApiModelProperty("上次支付日期")
    private OffsetDateTime prevPayDate;

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getSettleBillNumb() {
        return settleBillNumb;
    }

    public void setSettleBillNumb(String settleBillNumb) {
        this.settleBillNumb = settleBillNumb;
    }

    public OffsetDateTime getSettleCycleStartDate() {
        return settleCycleStartDate;
    }

    public void setSettleCycleStartDate(OffsetDateTime settleCycleStartDate) {
        this.settleCycleStartDate = settleCycleStartDate;
    }

    public OffsetDateTime getSettleCycleEndDate() {
        return settleCycleEndDate;
    }

    public void setSettleCycleEndDate(OffsetDateTime settleCycleEndDate) {
        this.settleCycleEndDate = settleCycleEndDate;
    }

    public OffsetDateTime getPrevPayDate() {
        return prevPayDate;
    }

    public void setPrevPayDate(OffsetDateTime prevPayDate) {
        this.prevPayDate = prevPayDate;
    }

    public Integer getOrdCount() {
        return ordCount;
    }

    public void setOrdCount(Integer ordCount) {
        this.ordCount = ordCount;
    }

    public String getSettleCycleType() {
        return settleCycleType;
    }

    public void setSettleCycleType(String settleCycleType) {
        this.settleCycleType = settleCycleType;
    }

    public String getBillDateType() {
        return billDateType;
    }

    public void setBillDateType(String billDateType) {
        this.billDateType = billDateType;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public OffsetDateTime getLastPayDate() {
        return lastPayDate;
    }

    public void setLastPayDate(OffsetDateTime lastPayDate) {
        this.lastPayDate = lastPayDate;
    }

    public String getSettleBillStatueType() {
        return settleBillStatueType;
    }

    public void setSettleBillStatueType(String settleBillStatueType) {
        this.settleBillStatueType = settleBillStatueType;
    }

    public Double getLateFee() {
        return lateFee;
    }

    public void setLateFee(Double lateFee) {
        this.lateFee = lateFee;
    }

    public Double getLateFeeBl() {
        return lateFeeBl;
    }

    public void setLateFeeBl(Double lateFeeBl) {
        this.lateFeeBl = lateFeeBl;
    }

    public String getSfYqFlag() {
        return sfYqFlag;
    }

    public void setSfYqFlag(String sfYqFlag) {
        this.sfYqFlag = sfYqFlag;
    }

    public Double getCommAmount() {
        return commAmount;
    }

    public void setCommAmount(Double commAmount) {
        this.commAmount = commAmount;
    }

    public Double getZqSerCost() {
        return zqSerCost;
    }

    public void setZqSerCost(Double zqSerCost) {
        this.zqSerCost = zqSerCost;
    }

    public Double getPlatfCost() {
        return platfCost;
    }

    public void setPlatfCost(Double platfCost) {
        this.platfCost = platfCost;
    }

    public OffsetDateTime getRecoDate() {
        return recoDate;
    }

    public void setRecoDate(OffsetDateTime recoDate) {
        this.recoDate = recoDate;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Double getPaymentSettleAmount() {
        return paymentSettleAmount;
    }

    public void setPaymentSettleAmount(Double paymentSettleAmount) {
        this.paymentSettleAmount = paymentSettleAmount;
    }

    public Double getPaymentLateFeeAmount() {
        return paymentLateFeeAmount;
    }

    public void setPaymentLateFeeAmount(Double paymentLateFeeAmount) {
        this.paymentLateFeeAmount = paymentLateFeeAmount;
    }

    public String getReconStateType() {
        return reconStateType;
    }

    public void setReconStateType(String reconStateType) {
        this.reconStateType = reconStateType;
    }

    public String getSettleBillPrdutType() {
        return settleBillPrdutType;
    }

    public void setSettleBillPrdutType(String settleBillPrdutType) {
        this.settleBillPrdutType = settleBillPrdutType;
    }

    public OffsetDateTime getReconDeadline() {
        return reconDeadline;
    }

    public void setReconDeadline(OffsetDateTime reconDeadline) {
        this.reconDeadline = reconDeadline;
    }

    public OffsetDateTime getOpenBillDeadline() {
        return openBillDeadline;
    }

    public void setOpenBillDeadline(OffsetDateTime openBillDeadline) {
        this.openBillDeadline = openBillDeadline;
    }

    public OffsetDateTime getExamBillDeadline() {
        return examBillDeadline;
    }

    public void setExamBillDeadline(OffsetDateTime examBillDeadline) {
        this.examBillDeadline = examBillDeadline;
    }

    public Integer getPayDeadDate() {
        return payDeadDate;
    }

    public void setPayDeadDate(Integer payDeadDate) {
        this.payDeadDate = payDeadDate;
    }

    public Double getNotPaymentAmount() {
        return notPaymentAmount;
    }

    public void setNotPaymentAmount(Double notPaymentAmount) {
        this.notPaymentAmount = notPaymentAmount;
    }

    public Double getPaymentLateFeAmount() {
        return paymentLateFeAmount;
    }

    public void setPaymentLateFeAmount(Double paymentLateFeAmount) {
        this.paymentLateFeAmount = paymentLateFeAmount;
    }

    public Double getLateFeAmount() {
        return lateFeAmount;
    }

    public void setLateFeAmount(Double lateFeAmount) {
        this.lateFeAmount = lateFeAmount;
    }

    public Double getSmartAmount() {
        return smartAmount;
    }

    public void setSmartAmount(Double smartAmount) {
        this.smartAmount = smartAmount;
    }

    public Double getNowPayAmount() {
        return nowPayAmount;
    }

    public void setNowPayAmount(Double nowPayAmount) {
        this.nowPayAmount = nowPayAmount;
    }

    public Integer getLateDay() {
        return lateDay;
    }

    public void setLateDay(Integer lateDay) {
        this.lateDay = lateDay;
    }
}
