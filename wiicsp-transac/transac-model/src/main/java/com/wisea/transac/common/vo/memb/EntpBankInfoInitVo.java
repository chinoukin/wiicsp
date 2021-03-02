package com.wisea.transac.common.vo.memb;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 企业银行卡初期化信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月12日
 * @version 1.0
 */
@ApiModel("企业银行卡初期化信息VO")
public class EntpBankInfoInitVo implements Serializable{

	private static final long serialVersionUID = 8873834261278947453L;

	@ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="商家认证id")
    private Long merchantAuthId;

    @ApiModelProperty(value="账户类型")
    private String bankAcctType;

    @ApiModelProperty(value="开户行名称")
    private String openBank;

    @ApiModelProperty(value="结算银行卡号")
    private String entpBankNum;

    @ApiModelProperty(value="银行预留手机号")
    private String bankReservedTel;

    @ApiModelProperty(value="开户名")
    private String khName;

    @ApiModelProperty(value="开户行省")
    private String khProv;

    @ApiModelProperty(value="开户行市")
    private String khCity;

    @ApiModelProperty(value="开户支行")
    private String acctOpenSubBank;

    @ApiModelProperty(value="结算银行卡正面url")
    private String bankCardZmUrl;

    @ApiModelProperty(value="结算银行卡反面url")
    private String bankCardFmUrl;

    @ApiModelProperty(value="开户许可证url")
    private String khxkzUrl;

    @ApiModelProperty(value="客户协议书")
    private String registAgreementFile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchantAuthId() {
        return merchantAuthId;
    }

    public void setMerchantAuthId(Long merchantAuthId) {
        this.merchantAuthId = merchantAuthId;
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
