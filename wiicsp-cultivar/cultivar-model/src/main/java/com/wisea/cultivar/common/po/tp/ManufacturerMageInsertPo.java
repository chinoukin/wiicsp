package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * ManufacturerMageInsertPo
 * 2018/09/18 14:36:47
 */
public class ManufacturerMageInsertPo {
    /**
     * 生产厂家名称
     */
    @Check(test = { "maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "生产厂家名称")
    private String manufacturerName;

    /**
     * 所在地区省
     */
    @Check(test = { "maxLength" }, mixLength = 10)
    @ApiModelProperty(value = "所在地区省")
    private String addressProv;

    /**
     * 所在地区市
     */
    @Check(test = { "maxLength" }, mixLength = 10)
    @ApiModelProperty(value = "所在地区市")
    private String addressCity;

    /**
     * 所在地区区县
     */
    @Check(test = { "maxLength" }, mixLength = 10)
    @ApiModelProperty(value = "所在地区区县")
    private String addressCou;

    /**
     * 详细地址
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "详细地址")
    private String addressDetail;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 获取生产厂家名称
     */
    public String getManufacturerName() {
        return manufacturerName;
    }

    /**
     * 设置生产厂家名称
     */
    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName == null ? null : manufacturerName.trim();
    }

    /**
     * 获取所在地区省
     */
    public String getAddressProv() {
        return addressProv;
    }

    /**
     * 设置所在地区省
     */
    public void setAddressProv(String addressProv) {
        this.addressProv = addressProv == null ? null : addressProv.trim();
    }

    /**
     * 获取所在地区市
     */
    public String getAddressCity() {
        return addressCity;
    }

    /**
     * 设置所在地区市
     */
    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity == null ? null : addressCity.trim();
    }

    /**
     * 获取所在地区区县
     */
    public String getAddressCou() {
        return addressCou;
    }

    /**
     * 设置所在地区区县
     */
    public void setAddressCou(String addressCou) {
        this.addressCou = addressCou == null ? null : addressCou.trim();
    }

    /**
     * 获取详细地址
     */
    public String getAddressDetail() {
        return addressDetail;
    }

    /**
     * 设置详细地址
     */
    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail == null ? null : addressDetail.trim();
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
