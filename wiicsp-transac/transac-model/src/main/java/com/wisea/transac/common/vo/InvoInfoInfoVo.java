package com.wisea.transac.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("发票管理详细信息Vo")
public class InvoInfoInfoVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="会员id（一级会员）")
    private Long membId;

    @ApiModelProperty(value="发票类型")
    private String invoType;

    @ApiModelProperty(value="发票类别")
    private String invoCatgType;

    @ApiModelProperty(value="发票抬头")
    private String invoTitle;

    @ApiModelProperty(value="纳税人识别号")
    private String taxIdentNum;

    @ApiModelProperty(value="发票内容类型")
    private String invoContentType;

    @ApiModelProperty(value="注册地址")
    private String registAddress;

    @ApiModelProperty(value="注册电话")
    private String registTel;

    @ApiModelProperty(value="开户银行")
    private String bankName;

    @ApiModelProperty(value="银行账户")
    private String bankAccNum;

    @ApiModelProperty(value="是否默认")
    private String defaultFlag;

    @ApiModelProperty(value="发票备注")
    private String invoRemarks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
