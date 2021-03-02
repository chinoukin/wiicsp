package com.wisea.cultivar.common.vo.tp.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 订单收货地址VO
 */
@ApiModel("订单收货地址VO")
public class OrderReceAddress {
    @ApiModelProperty("收货人姓名")
    private String receName;
    @ApiModelProperty("手机号码")
    private String tel;
    @ApiModelProperty("邮政编码")
    private String zipCode;
    @ApiModelProperty("收货地址省份编码")
    private String receAddressProvCode;
    @ApiModelProperty("收货地址市编码")
    private String receAddressCityCode;
    @ApiModelProperty("收货地址区县编码")
    private String receAddressCouCode;
    @ApiModelProperty("收货地址省份")
    private String receAddressProv;
    @ApiModelProperty("收货地址市")
    private String receAddressCity;
    @ApiModelProperty("收货地址区县")
    private String receAddressCou;
    @ApiModelProperty("收货地址街道")
    private String receAddressStreet;
    @ApiModelProperty("详细地址")
    private String receAddressDetail;

    public String getReceName() {
        return receName;
    }

    public void setReceName(String receName) {
        this.receName = receName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getReceAddressProvCode() {
        return receAddressProvCode;
    }

    public void setReceAddressProvCode(String receAddressProvCode) {
        this.receAddressProvCode = receAddressProvCode;
    }

    public String getReceAddressCityCode() {
        return receAddressCityCode;
    }

    public void setReceAddressCityCode(String receAddressCityCode) {
        this.receAddressCityCode = receAddressCityCode;
    }

    public String getReceAddressCouCode() {
        return receAddressCouCode;
    }

    public void setReceAddressCouCode(String receAddressCouCode) {
        this.receAddressCouCode = receAddressCouCode;
    }

    public String getReceAddressProv() {
        return receAddressProv;
    }

    public void setReceAddressProv(String receAddressProv) {
        this.receAddressProv = receAddressProv;
    }

    public String getReceAddressCity() {
        return receAddressCity;
    }

    public void setReceAddressCity(String receAddressCity) {
        this.receAddressCity = receAddressCity;
    }

    public String getReceAddressCou() {
        return receAddressCou;
    }

    public void setReceAddressCou(String receAddressCou) {
        this.receAddressCou = receAddressCou;
    }

    public String getReceAddressStreet() {
        return receAddressStreet;
    }

    public void setReceAddressStreet(String receAddressStreet) {
        this.receAddressStreet = receAddressStreet;
    }

    public String getReceAddressDetail() {
        return receAddressDetail;
    }

    public void setReceAddressDetail(String receAddressDetail) {
        this.receAddressDetail = receAddressDetail;
    }
}
