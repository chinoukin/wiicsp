package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

public class SelfMentionAddressMage extends DataLongEntity<SelfMentionAddressMage> {
    @ApiModelProperty(value = "会员id", hidden = true)
    private Long membId;
    @ApiModelProperty("自提地址名称")
    private String selfMentionAddressName;
    @ApiModelProperty("所在地省")
    @Check(test = "required")
    private String addressProv;
    @ApiModelProperty("所在地市")
    @Check(test = "required")
    private String addressCity;
    @ApiModelProperty("所在地区县")
    @Check(test = "required")
    private String addressCou;
    @ApiModelProperty("详细地址")
    @Check(test = "required")
    private String address;
    @ApiModelProperty("联系人")
    @Check(test = "required")
    private String contactsName;
    @ApiModelProperty("联系电话")
    @Check(test = "required")
    private String tel;
    @ApiModelProperty("营业时间")
    @Check(test = "required")
    private String businessHours;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
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
}
