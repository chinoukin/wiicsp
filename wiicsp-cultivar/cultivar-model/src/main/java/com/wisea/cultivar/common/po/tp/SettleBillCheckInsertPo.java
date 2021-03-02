package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 结算单审核通过，平台使用
 * SettleBillCheckInsertPo
 * 2018/10/13 17:14:52
 */
public class SettleBillCheckInsertPo {

    /**
     * 结算单id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = {"maxLength", "required"}, length = 19)
    @ApiModelProperty(value = "结算单id")
    private Long settleId;

    @ApiModelProperty(value = "收货人姓名")
    @Check(test = "required")
    private String receName;
    @Check(test = "required")
    @ApiModelProperty(value = "省份code码")
    private String addressProv;
    @Check(test = "required")
    @ApiModelProperty(value = "城市code码")
    private String addressCity;
    @Check(test = "required")
    @ApiModelProperty(value = "区县code码")
    private String addressCou;
    @Check(test = "required")
    @ApiModelProperty(value = "收货详细地址")
    private String addressDetail;
    @Check(test = "required")
    @ApiModelProperty(value = "收货人电话号码")
    private String tel;
    @ApiModelProperty(value = "邮编")
    private String zipCode;
    /**
     * 备注
     */
    @Check(test = {"maxLength"}, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 获取结算单id
     */
    public Long getSettleId() {
        return settleId;
    }

    /**
     * 设置结算单id
     */
    public void setSettleId(Long settleId) {
        this.settleId = settleId;
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
}
