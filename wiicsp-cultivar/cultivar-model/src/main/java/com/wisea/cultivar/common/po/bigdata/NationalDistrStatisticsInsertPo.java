package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * NationalDistrStatisticsInsertPo
 * 2020/09/02 15:16:31
 */
public class NationalDistrStatisticsInsertPo {
    /**
     * 城市名称
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "城市名称", allowableValues = "mixLength:(,255]")
    private String cityName;

    /**
     * 配送件数
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "配送件数", allowableValues = "length:(,10]")
    private Integer num;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 获取城市名称
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * 设置城市名称
     */
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    /**
     * 获取配送件数
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置配送件数
     */
    public void setNum(Integer num) {
        this.num = num;
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
