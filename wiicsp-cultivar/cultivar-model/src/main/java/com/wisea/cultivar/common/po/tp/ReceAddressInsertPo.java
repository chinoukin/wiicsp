package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * ReceAddressInsertPo
 * 2018/09/18 14:36:47
 */
public class ReceAddressInsertPo {
    /**
     * 订单id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "订单id")
    private Long ordId;

    /**
     * 收货人姓名
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "收货人姓名")
    private String receName;

    /**
     * 手机号码
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "手机号码")
    private String tel;

    /**
     * 收货地址省
     */
    @Check(test = { "maxLength" }, mixLength = 10)
    @ApiModelProperty(value = "收货地址省")
    private String receAddressProv;

    /**
     * 收货地址市
     */
    @Check(test = { "maxLength" }, mixLength = 10)
    @ApiModelProperty(value = "收货地址市")
    private String receAddressCity;

    /**
     * 收货地址区县
     */
    @Check(test = { "maxLength" }, mixLength = 10)
    @ApiModelProperty(value = "收货地址区县")
    private String receAddressCou;

    /**
     * 收货地址街道
     */
    @Check(test = { "maxLength" }, mixLength = 10)
    @ApiModelProperty(value = "收货地址街道")
    private String receAddressStreet;

    /**
     * 详细地址
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "详细地址")
    private String receAddressDetail;

    /**
     * 邮政编码
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "邮政编码")
    private String zipCode;

    /**
     * 固定电话
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "固定电话")
    private String fixedTel;

    /**
     * 是否默认
     */
    @Check(test = { "maxLength" }, mixLength = 1)
    @ApiModelProperty(value = "是否默认")
    private String defaultFlag;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 获取订单id
     */
    public Long getOrdId() {
        return ordId;
    }

    /**
     * 设置订单id
     */
    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }

    /**
     * 获取收货人姓名
     */
    public String getReceName() {
        return receName;
    }

    /**
     * 设置收货人姓名
     */
    public void setReceName(String receName) {
        this.receName = receName == null ? null : receName.trim();
    }

    /**
     * 获取手机号码
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置手机号码
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * 获取收货地址省
     */
    public String getReceAddressProv() {
        return receAddressProv;
    }

    /**
     * 设置收货地址省
     */
    public void setReceAddressProv(String receAddressProv) {
        this.receAddressProv = receAddressProv == null ? null : receAddressProv.trim();
    }

    /**
     * 获取收货地址市
     */
    public String getReceAddressCity() {
        return receAddressCity;
    }

    /**
     * 设置收货地址市
     */
    public void setReceAddressCity(String receAddressCity) {
        this.receAddressCity = receAddressCity == null ? null : receAddressCity.trim();
    }

    /**
     * 获取收货地址区县
     */
    public String getReceAddressCou() {
        return receAddressCou;
    }

    /**
     * 设置收货地址区县
     */
    public void setReceAddressCou(String receAddressCou) {
        this.receAddressCou = receAddressCou == null ? null : receAddressCou.trim();
    }

    /**
     * 获取收货地址街道
     */
    public String getReceAddressStreet() {
        return receAddressStreet;
    }

    /**
     * 设置收货地址街道
     */
    public void setReceAddressStreet(String receAddressStreet) {
        this.receAddressStreet = receAddressStreet == null ? null : receAddressStreet.trim();
    }

    /**
     * 获取详细地址
     */
    public String getReceAddressDetail() {
        return receAddressDetail;
    }

    /**
     * 设置详细地址
     */
    public void setReceAddressDetail(String receAddressDetail) {
        this.receAddressDetail = receAddressDetail == null ? null : receAddressDetail.trim();
    }

    /**
     * 获取邮政编码
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 设置邮政编码
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    /**
     * 获取固定电话
     */
    public String getFixedTel() {
        return fixedTel;
    }

    /**
     * 设置固定电话
     */
    public void setFixedTel(String fixedTel) {
        this.fixedTel = fixedTel == null ? null : fixedTel.trim();
    }

    /**
     * 获取是否默认
     */
    public String getDefaultFlag() {
        return defaultFlag;
    }

    /**
     * 设置是否默认
     */
    public void setDefaultFlag(String defaultFlag) {
        this.defaultFlag = defaultFlag == null ? null : defaultFlag.trim();
    }

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}
