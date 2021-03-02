package com.wisea.transac.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("详细信息Vo")
public class IndBusiBankInfoInfoVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="个体户认证id")
    private Long indBusiAuthId;

    @ApiModelProperty(value="开户行")
    private String openBank;

    @ApiModelProperty(value="账户类型")
    private String bankAcctType;

    @ApiModelProperty(value="银行预留手机号")
    private String bankReservedTel;

    @ApiModelProperty(value="开户许可证url")
    private String khxkzUrl;

    @ApiModelProperty(value="结算银行卡号")
    private String entpBankNum;

    @ApiModelProperty(value="开户支行")
    private String acctOpenSubBank;

    @ApiModelProperty(value="结算银行卡正面url")
    private String bankCardZmUrl;

    @ApiModelProperty(value="结算银行卡反面url")
    private String bankCardFmUrl;

    @ApiModelProperty(value="开户名")
    private String khName;

    @ApiModelProperty(value="客户协议书")
    private String registAgreementFile;

    @ApiModelProperty(value="开户行省")
    private String khProv;

    @ApiModelProperty(value="开户行市")
    private String khCity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
