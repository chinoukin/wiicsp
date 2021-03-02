package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class IndBusiBankInfo extends DataLongEntity<IndBusiBankInfo> {
    /**
     * 个体户认证id
     */
    private Long indBusiAuthId;

    /**
     * 开户行
     */
    private String openBank;

    /**
     * 账户类型
     */
    private String bankAcctType;

    /**
     * 银行预留手机号
     */
    private String bankReservedTel;

    /**
     * 开户许可证url
     */
    private String khxkzUrl;

    /**
     * 结算银行卡号
     */
    private String entpBankNum;

    /**
     * 开户支行
     */
    private String acctOpenSubBank;

    /**
     * 结算银行卡正面url
     */
    private String bankCardZmUrl;

    /**
     * 结算银行卡反面url
     */
    private String bankCardFmUrl;

    /**
     * 开户名
     */
    private String khName;

    /**
     * 客户协议书
     */
    private String registAgreementFile;

    /**
     * 开户行省
     */
    private String khProv;

    /**
     * 开户行市
     */
    private String khCity;

    public Long getIndBusiAuthId() {
        return indBusiAuthId;
    }

    public void setIndBusiAuthId(Long indBusiAuthId) {
        this.indBusiAuthId = indBusiAuthId;
    }

    public String getOpenBank() {
        return openBank;
    }

    public void setOpenBank(String openBank) {
        this.openBank = openBank;
    }

    public String getBankAcctType() {
        return bankAcctType;
    }

    public void setBankAcctType(String bankAcctType) {
        this.bankAcctType = bankAcctType;
    }

    public String getBankReservedTel() {
        return bankReservedTel;
    }

    public void setBankReservedTel(String bankReservedTel) {
        this.bankReservedTel = bankReservedTel;
    }

    public String getKhxkzUrl() {
        return khxkzUrl;
    }

    public void setKhxkzUrl(String khxkzUrl) {
        this.khxkzUrl = khxkzUrl;
    }

    public String getEntpBankNum() {
        return entpBankNum;
    }

    public void setEntpBankNum(String entpBankNum) {
        this.entpBankNum = entpBankNum;
    }

    public String getAcctOpenSubBank() {
        return acctOpenSubBank;
    }

    public void setAcctOpenSubBank(String acctOpenSubBank) {
        this.acctOpenSubBank = acctOpenSubBank;
    }

    public String getBankCardZmUrl() {
        return bankCardZmUrl;
    }

    public void setBankCardZmUrl(String bankCardZmUrl) {
        this.bankCardZmUrl = bankCardZmUrl;
    }

    public String getBankCardFmUrl() {
        return bankCardFmUrl;
    }

    public void setBankCardFmUrl(String bankCardFmUrl) {
        this.bankCardFmUrl = bankCardFmUrl;
    }

    public String getKhName() {
        return khName;
    }

    public void setKhName(String khName) {
        this.khName = khName;
    }

    public String getRegistAgreementFile() {
        return registAgreementFile;
    }

    public void setRegistAgreementFile(String registAgreementFile) {
        this.registAgreementFile = registAgreementFile;
    }

    public String getKhProv() {
        return khProv;
    }

    public void setKhProv(String khProv) {
        this.khProv = khProv;
    }

    public String getKhCity() {
        return khCity;
    }

    public void setKhCity(String khCity) {
        this.khCity = khCity;
    }
}
