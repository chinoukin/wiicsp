package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

public class RefundCommAddressMage extends DataLongEntity<RefundCommAddressMage> {
    @ApiModelProperty(value = "会员id", hidden = true)
    private Long membId;
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
    @ApiModelProperty("邮编")
    private String zipCode;
    @ApiModelProperty("收货人姓名")
    @Check(test = "required")
    private String recerName;
    @ApiModelProperty("联系电话")
    @Check(test = "required")
    private String tel;
    @ApiModelProperty("是否默认")
    private String defaultFlag;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
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
