package com.wisea.cultivar.common.vo.tp.trade;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className SelfMentionAddressListVo
 * @date 2019/4/19 10:09
 * @Description
 */
public class SelfMentionAddressListVo {
    @ApiModelProperty("自提地址Id")
    private Long id;
    @ApiModelProperty("自提地址名称")
    private String selfMentionAddressName;
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
    @ApiModelProperty("联系人")
    private String contactsName;
    @ApiModelProperty("联系电话")
    private String tel;
    @ApiModelProperty("营业时间")
    private String businessHours;
    @ApiModelProperty("备注")
    private String remarks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSelfMentionAddressName() {
        return selfMentionAddressName;
    }

    public void setSelfMentionAddressName(String selfMentionAddressName) {
        this.selfMentionAddressName = selfMentionAddressName;
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

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(String businessHours) {
        this.businessHours = businessHours;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
