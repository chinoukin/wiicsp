package com.wisea.cultivar.common.vo.tp.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className RefundCommAddressListVo
 * @date 2019/4/18 17:47
 * @Description 退货地址列表Vo
 */
@ApiModel("退货地址列表Vo")
public class RefundCommAddressListVo {
    @ApiModelProperty("退货地址Id")
    private Long id;
    @ApiModelProperty("所在地省")
    private String addressProv;
    @ApiModelProperty("所在地市")
    private String addressCity;
    @ApiModelProperty("所在地区县")
    private String addressCou;
    @ApiModelProperty("所在地省-中文")
    private String addressProvName;
    @ApiModelProperty("所在地市-中文")
    private String addressCityName;
    @ApiModelProperty("所在地区县-中文")
    private String addressCouName;
    @ApiModelProperty("详细地址")
    private String address;
    @ApiModelProperty("邮编")
    private String zipCode;
    @ApiModelProperty("收货人姓名")
    private String recerName;
    @ApiModelProperty("联系电话")
    private String tel;
    @ApiModelProperty("是否默认")
    private String defaultFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAddressProvName() {
        return addressProvName;
    }

    public void setAddressProvName(String addressProvName) {
        this.addressProvName = addressProvName;
    }

    public String getAddressCityName() {
        return addressCityName;
    }

    public void setAddressCityName(String addressCityName) {
        this.addressCityName = addressCityName;
    }

    public String getAddressCouName() {
        return addressCouName;
    }

    public void setAddressCouName(String addressCouName) {
        this.addressCouName = addressCouName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getRecerName() {
        return recerName;
    }

    public void setRecerName(String recerName) {
        this.recerName = recerName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDefaultFlag() {
        return defaultFlag;
    }

    public void setDefaultFlag(String defaultFlag) {
        this.defaultFlag = defaultFlag;
    }
}
