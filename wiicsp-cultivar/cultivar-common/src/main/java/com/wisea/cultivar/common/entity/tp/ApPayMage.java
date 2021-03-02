package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

public class ApPayMage extends DataLongEntity<ApPayMage> {
    /**
     * 会员id
     */
    private Long membId;

    /**
     * 买家id
     */
    private Long buyerId;

    /**
     * 采购商账号
     */
    private String purchaserAcct;

    /**
     * 采购商名称
     */
    private String purchaserAcctName;

    /**
     * 账期类型（周结、月结、双月结、季结）
     */
    private String settleCycleType;

    /**
     * 账单生成日类型（周一、周二。。。周日）
     */
    private String billDateType;

    /**
     * 账期授信额度
     */
    private Double acctCreditLine;

    /**
     * 可用额度
     */
    private Double availableCredit;

    /**
     * 最晚付款日
     */
    private Integer payDeadDate;

    /**
     * 授信状态（正常、冻结）
     */
    private String creditType;

    /**
     * 是否收取滞纳金
     */
    private String sfLateFeeFlag;

    /**
     * 服务费比例
     */
    private Double serCostBl;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getPurchaserAcct() {
        return purchaserAcct;
    }

    public void setPurchaserAcct(String purchaserAcct) {
        this.purchaserAcct = purchaserAcct;
    }

    public String getPurchaserAcctName() {
        return purchaserAcctName;
    }

    public void setPurchaserAcctName(String purchaserAcctName) {
        this.purchaserAcctName = purchaserAcctName;
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

    public Integer getPayDeadDate() {
        return payDeadDate;
    }

    public void setPayDeadDate(Integer payDeadDate) {
        this.payDeadDate = payDeadDate;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public String getSfLateFeeFlag() {
        return sfLateFeeFlag;
    }

    public void setSfLateFeeFlag(String sfLateFeeFlag) {
        this.sfLateFeeFlag = sfLateFeeFlag;
    }

    public Double getSerCostBl() {
        return serCostBl;
    }

    public void setSerCostBl(Double serCostBl) {
        this.serCostBl = serCostBl;
    }
}
