package com.wisea.transac.common.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("新增或修改Po")
public class SettleBillPo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="卖方id")
    private Long sellerId;

    @ApiModelProperty(value="买方id")
    private Long buyerId;

    @ApiModelProperty(value="结算单号")
    private String settleBillNumb;

    @ApiModelProperty(value="结算周期开始时间")
    private OffsetDateTime settleCycleStartDate;

    @ApiModelProperty(value="结算周期结束时间")
    private OffsetDateTime settleCycleEndDate;

    @ApiModelProperty(value="订单数")
    private Integer ordCount;

    @ApiModelProperty(value="账期类型")
    private String settleCycleType;

    @ApiModelProperty(value="账单生成日类型")
    private String billDateType;

    @ApiModelProperty(value="应结总额")
    private Double totalMoney;

    @ApiModelProperty(value="商家名称")
    private String entpName;

    @ApiModelProperty(value="最晚付款日期")
    private OffsetDateTime lastPayDate;

    @ApiModelProperty(value="结算单状态")
    private String settleBillStatueType;

    @ApiModelProperty(value="滞纳金")
    private Double lateFee;

    @ApiModelProperty(value="滞纳金比例")
    private Double lateFeeBl;

    @ApiModelProperty(value="是否逾期")
    private String sfYqFlag;

    @ApiModelProperty(value="商品金额")
    private Double commAmount;

    @ApiModelProperty(value="账期服务费金额")
    private Double zqSerCost;

    @ApiModelProperty(value="平台服务费")
    private Double platfCost;

    @ApiModelProperty(value="对账日")
    private OffsetDateTime recoDate;

    @ApiModelProperty(value="第一次付款金额")
    private Double firstPayAmount;

    @ApiModelProperty(value="第一次付款时间")
    private OffsetDateTime firstPayDate;

    @ApiModelProperty(value="第二次付款金额")
    private Double secondPayAmount;

    @ApiModelProperty(value="第二次付款时间")
    private OffsetDateTime secondPayDate;

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

    public Double getFirstPayAmount() {
        return firstPayAmount;
    }

    public void setFirstPayAmount(Double firstPayAmount) {
        this.firstPayAmount = firstPayAmount;
    }

    public OffsetDateTime getFirstPayDate() {
        return firstPayDate;
    }

    public void setFirstPayDate(OffsetDateTime firstPayDate) {
        this.firstPayDate = firstPayDate;
    }

    public Double getSecondPayAmount() {
        return secondPayAmount;
    }

    public void setSecondPayAmount(Double secondPayAmount) {
        this.secondPayAmount = secondPayAmount;
    }

    public OffsetDateTime getSecondPayDate() {
        return secondPayDate;
    }

    public void setSecondPayDate(OffsetDateTime secondPayDate) {
        this.secondPayDate = secondPayDate;
    }
}
