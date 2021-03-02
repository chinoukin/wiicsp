package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class SettleBill extends DataLongEntity<SettleBill> {
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
     * 账期类型
     */
    private String settleCycleType;

    /**
     * 账单生成日类型
     */
    private String billDateType;

    /**
     * 订单数
     */
    private Integer ordCount;

    /**
     * 结算单状态
     */
    private String settleBillStatueType;

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
     * 滞纳金比例
     */
    private Double lateFeeBl;

    /**
     * 滞纳金
     */
    private Double lateFee;

    /**
     * 是否逾期
     */
    private String sfYqFlag;

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

    public Double getLateFeeBl() {
        return lateFeeBl;
    }

    public void setLateFeeBl(Double lateFeeBl) {
        this.lateFeeBl = lateFeeBl;
    }

    public Double getLateFee() {
        return lateFee;
    }

    public void setLateFee(Double lateFee) {
        this.lateFee = lateFee;
    }

    public String getSfYqFlag() {
        return sfYqFlag;
    }

    public void setSfYqFlag(String sfYqFlag) {
        this.sfYqFlag = sfYqFlag;
    }
}
