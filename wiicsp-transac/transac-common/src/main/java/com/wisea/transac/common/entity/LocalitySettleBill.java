package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class LocalitySettleBill extends DataLongEntity<LocalitySettleBill> {
    /**
     * 卖方id
     */
    private Long sellerId;

    /**
     * 买方id
     */
    private Long buyerId;

    /**
     * 结算单号
     */
    private String settleBillNumb;

    /**
     * 结算周期开始时间
     */
    private OffsetDateTime settleCycleStartDate;

    /**
     * 结算周期结束时间
     */
    private OffsetDateTime settleCycleEndDate;

    /**
     * 订单数
     */
    private Integer ordCount;

    /**
     * 账期类型
     */
    private String settleCycleType;

    /**
     * 账单生成日类型
     */
    private String billDateType;

    /**
     * 应结总额
     */
    private Double totalMoney;

    /**
     * 商家名称
     */
    private String entpName;

    /**
     * 最晚付款日期
     */
    private OffsetDateTime lastPayDate;

    /**
     * 结算单状态
     */
    private String settleBillStatueType;

    /**
     * 滞纳金
     */
    private Double lateFee;

    /**
     * 滞纳金比例
     */
    private Double lateFeeBl;

    /**
     * 是否逾期
     */
    private String sfYqFlag;

    /**
     * 商品金额
     */
    private Double commAmount;

    /**
     * 账期服务费金额
     */
    private Double zqSerCost;

    /**
     * 平台服务费
     */
    private Double platfCost;

    /**
     * 对账日
     */
    private OffsetDateTime recoDate;

    /**
     * 已支付总金额
     */
    private Double paymentAmount;

    /**
     * 已支付结算金额
     */
    private Double paymentSettleAmount;

    /**
     * 已支付滞纳金金额
     */
    private Double paymentLateFeeAmount;

    /**
     * 对账状态
     */
    private String reconStateType;

    /**
     * 结算单生成类型
     */
    private String settleBillPrdutType;

    /**
     * 对账截止日
     */
    private OffsetDateTime reconDeadline;

    /**
     * 开票截止日
     */
    private OffsetDateTime openBillDeadline;

    /**
     * 验票截止日
     */
    private OffsetDateTime examBillDeadline;

    /**
     * 最晚付款日
     */
    private Integer payDeadDate;

    /**
     * 上次付款日期
     */
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

    public OffsetDateTime getPrevPayDate() {
        return prevPayDate;
    }

    public void setPrevPayDate(OffsetDateTime prevPayDate) {
        this.prevPayDate = prevPayDate;
    }
}
