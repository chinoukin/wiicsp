package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class InvoInfo extends DataLongEntity<InvoInfo> {
    /**
     * 会员id（一级会员）
     */
    private Long membId;

    /**
     * 发票类型
     */
    private String invoType;

    /**
     * 发票类别
     */
    private String invoCatgType;

    /**
     * 发票抬头
     */
    private String invoTitle;

    /**
     * 纳税人识别号
     */
    private String taxIdentNum;

    /**
     * 发票内容类型
     */
    private String invoContentType;

    /**
     * 注册地址
     */
    private String registAddress;

    /**
     * 注册电话
     */
    private String registTel;

    /**
     * 开户银行
     */
    private String bankName;

    /**
     * 银行账户
     */
    private String bankAccNum;

    /**
     * 是否默认
     */
    private String defaultFlag;

    private String invoRemarks;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getInvoType() {
        return invoType;
    }

    public void setInvoType(String invoType) {
        this.invoType = invoType;
    }

    public String getInvoCatgType() {
        return invoCatgType;
    }

    public void setInvoCatgType(String invoCatgType) {
        this.invoCatgType = invoCatgType;
    }

    public String getInvoTitle() {
        return invoTitle;
    }

    public void setInvoTitle(String invoTitle) {
        this.invoTitle = invoTitle;
    }

    public String getTaxIdentNum() {
        return taxIdentNum;
    }

    public void setTaxIdentNum(String taxIdentNum) {
        this.taxIdentNum = taxIdentNum;
    }

    public String getInvoContentType() {
        return invoContentType;
    }

    public void setInvoContentType(String invoContentType) {
        this.invoContentType = invoContentType;
    }

    public String getRegistAddress() {
        return registAddress;
    }

    public void setRegistAddress(String registAddress) {
        this.registAddress = registAddress;
    }

    public String getRegistTel() {
        return registTel;
    }

    public void setRegistTel(String registTel) {
        this.registTel = registTel;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccNum() {
        return bankAccNum;
    }

    public void setBankAccNum(String bankAccNum) {
        this.bankAccNum = bankAccNum;
    }

    public String getDefaultFlag() {
        return defaultFlag;
    }

    public void setDefaultFlag(String defaultFlag) {
        this.defaultFlag = defaultFlag;
    }

    public String getInvoRemarks() {
        return invoRemarks;
    }

    public void setInvoRemarks(String invoRemarks) {
        this.invoRemarks = invoRemarks;
    }
}
