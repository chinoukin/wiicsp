package com.wisea.transac.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("分页查询结算单Vo")
public class SettleBillPageListVo {
    @ApiModelProperty(value="id")
    private Long id;
    @ApiModelProperty(value="卖方id")
    private Long sellerId;
    @ApiModelProperty("卖方名称")
    private String sellerName;
    @ApiModelProperty(value="买方id")
    private Long buyerId;
    @ApiModelProperty("买方账号")
    private String buyerAccount;
    @ApiModelProperty("买方名称")
    private String buyerName;
    @ApiModelProperty(value="结算单号")
    private String settleBillNumb;
    @ApiModelProperty(value="账期类型")
    private String settleCycleType;
    @ApiModelProperty("结算单生成类型")
    private String settleBillPrdutType;
    @ApiModelProperty(value="对账日")
    private OffsetDateTime recoDate;
    @ApiModelProperty(value="最晚付款日期")
    private OffsetDateTime lastPayDate;
    @ApiModelProperty(value="应结总额")
    private Double totalMoney;
    @ApiModelProperty(value="滞纳金")
    private Double lateFee;
    @ApiModelProperty(value="订单数")
    private Integer ordCount;
    @ApiModelProperty(value="结算单状态")
    private String settleBillStatueType;
    @ApiModelProperty("对账状态")
    private String reconStateType;
    @ApiModelProperty("对账截止日")
    private OffsetDateTime reconDeadline;
    @ApiModelProperty("开票截止日")
    private OffsetDateTime openBillDeadline;
    @ApiModelProperty("验票截止日")
    private OffsetDateTime examBillDeadline;
    @ApiModelProperty("是否逾期")
    private String sfYqFlag;
    @ApiModelProperty("滞纳金比例")
    private Double lateFeeBl;
    @ApiModelProperty("当前时间")
    private OffsetDateTime nowDate;
    @ApiModelProperty("已支付总金额")
    private Double paymentAmount;

    @ApiModelProperty(value="结算单发票Id")
    private Long settleBillInvoId;
    @ApiModelProperty(value="结算单发票状态")
    private String settleBillInvoState;
    @ApiModelProperty("验票异议状态")
    private String examInvoDissType;

    @ApiModelProperty("查询类型：0 待对账、 1 待开票、 2 待结算、 3 逾期、 4 全部")
    private String queryFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerAccount() {
        return buyerAccount;
    }

    public void setBuyerAccount(String buyerAccount) {
        this.buyerAccount = buyerAccount;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getSettleBillNumb() {
        return settleBillNumb;
    }

    public void setSettleBillNumb(String settleBillNumb) {
        this.settleBillNumb = settleBillNumb;
    }

    public String getSettleCycleType() {
        return settleCycleType;
    }

    public void setSettleCycleType(String settleCycleType) {
        this.settleCycleType = settleCycleType;
    }

    public String getSettleBillPrdutType() {
        return settleBillPrdutType;
    }

    public void setSettleBillPrdutType(String settleBillPrdutType) {
        this.settleBillPrdutType = settleBillPrdutType;
    }

    public OffsetDateTime getRecoDate() {
        return recoDate;
    }

    public void setRecoDate(OffsetDateTime recoDate) {
        this.recoDate = recoDate;
    }

    public OffsetDateTime getLastPayDate() {
        return lastPayDate;
    }

    public void setLastPayDate(OffsetDateTime lastPayDate) {
        this.lastPayDate = lastPayDate;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Double getLateFee() {
        return lateFee;
    }

    public void setLateFee(Double lateFee) {
        this.lateFee = lateFee;
    }

    public Integer getOrdCount() {
        return ordCount;
    }

    public void setOrdCount(Integer ordCount) {
        this.ordCount = ordCount;
    }

    public String getSettleBillStatueType() {
        return settleBillStatueType;
    }

    public void setSettleBillStatueType(String settleBillStatueType) {
        this.settleBillStatueType = settleBillStatueType;
    }

    public String getReconStateType() {
        return reconStateType;
    }

    public void setReconStateType(String reconStateType) {
        this.reconStateType = reconStateType;
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

    public String getSfYqFlag() {
        return sfYqFlag;
    }

    public void setSfYqFlag(String sfYqFlag) {
        this.sfYqFlag = sfYqFlag;
    }

    public Double getLateFeeBl() {
        return lateFeeBl;
    }

    public void setLateFeeBl(Double lateFeeBl) {
        this.lateFeeBl = lateFeeBl;
    }

    public OffsetDateTime getNowDate() {
        return OffsetDateTime.now();
    }

    public void setNowDate(OffsetDateTime nowDate) {
        this.nowDate = nowDate;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Long getSettleBillInvoId() {
        return settleBillInvoId;
    }

    public void setSettleBillInvoId(Long settleBillInvoId) {
        this.settleBillInvoId = settleBillInvoId;
    }

    public String getSettleBillInvoState() {
        return settleBillInvoState;
    }

    public void setSettleBillInvoState(String settleBillInvoState) {
        this.settleBillInvoState = settleBillInvoState;
    }

    public String getExamInvoDissType() {
        return examInvoDissType;
    }

    public void setExamInvoDissType(String examInvoDissType) {
        this.examInvoDissType = examInvoDissType;
    }

    public String getQueryFlag() {
        return queryFlag;
    }

    public void setQueryFlag(String queryFlag) {
        this.queryFlag = queryFlag;
    }
}
