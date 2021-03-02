package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class ApPayMage extends DataLongEntity<ApPayMage> {
    /**
     * 会员id
     */
    private Long membId;

    /**
     * 商家id
     */
    private Long sellerId;

    /**
     * 账期授信额度
     */
    private Double acctCreditLine;

    /**
     * 可用额度
     */
    private Double availableCredit;

    /**
     * 账期类型
     */
    private String settleCycleType;

    /**
     * 账单生成日类型
     */
    private String billDateType;

    /**
     * 最晚付款日
     */
    private Integer payDeadDate;

    /**
     * 服务费比例
     */
    private Double serCostBl;

    /**
     * 是否收取滞纳金标志
     */
    private String sfLateFeeFlag;

    /**
     * 逾期滞纳金比例
     */
    private Double overdueLateFeeProp;

    /**
     * 授信状态
     */
    private String creditType;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Double getAcctCreditLine() {
        return acctCreditLine;
    }

    public void setAcctCreditLine(Double acctCreditLine) {
        this.acctCreditLine = acctCreditLine;
    }

    public Double getAvailableCredit() {
        return availableCredit;
    }

    public void setAvailableCredit(Double availableCredit) {
        this.availableCredit = availableCredit;
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

    public Integer getPayDeadDate() {
        return payDeadDate;
    }

    public void setPayDeadDate(Integer payDeadDate) {
        this.payDeadDate = payDeadDate;
    }

    public Double getSerCostBl() {
        return serCostBl;
    }

    public void setSerCostBl(Double serCostBl) {
        this.serCostBl = serCostBl;
    }

    public String getSfLateFeeFlag() {
        return sfLateFeeFlag;
    }

    public void setSfLateFeeFlag(String sfLateFeeFlag) {
        this.sfLateFeeFlag = sfLateFeeFlag;
    }

    public Double getOverdueLateFeeProp() {
        return overdueLateFeeProp;
    }

    public void setOverdueLateFeeProp(Double overdueLateFeeProp) {
        this.overdueLateFeeProp = overdueLateFeeProp;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }
}
