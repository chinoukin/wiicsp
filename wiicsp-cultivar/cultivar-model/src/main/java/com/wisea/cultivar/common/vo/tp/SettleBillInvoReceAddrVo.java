package com.wisea.cultivar.common.vo.tp;

import io.swagger.annotations.ApiModelProperty;

/**
 * SettleBillInvoReceAddrVo
 * 2018/10/12 11:10:09
 */
public class SettleBillInvoReceAddrVo {

    /**
     * 收件人
     */
    @ApiModelProperty(value = "收件人")
    private String receName;

    /**
     * 所在地区省
     */
    @ApiModelProperty(value = "所在地区省")
    private String addressProv;

    /**
     * 所在地区市
     */
    @ApiModelProperty(value = "所在地区市")
    private String addressCity;

    /**
     * 所在地区区县
     */
    @ApiModelProperty(value = "所在地区区县")
    private String addressCou;

    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String addressDetail;

    /**
     * 邮编
     */
    @ApiModelProperty(value = "邮编")
    private String zipCode;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    private String tel;

    public String getReceName() {
        return receName;
    }

    public void setReceName(String receName) {
        this.receName = receName;
    }

    public String getAddressProv() {
        return addressProv;
    }

    public void setAddressProv(String addressProv) {
        this.addressProv = addressProv;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressCou() {
        return addressCou;
    }

    public void setAddressCou(String addressCou) {
        this.addressCou = addressCou;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
