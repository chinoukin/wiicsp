package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * MonthlyDistrTrendInsertPo
 * 2020/09/02 15:33:51
 */
public class MonthlyDistrTrendInsertPo {
    /**
     * 月份
     */
    @Check(test = { "maxLength" }, mixLength = 10)
    @ApiModelProperty(value = "月份", allowableValues = "mixLength:(,10]")
    private String month;

    /**
     * 单量
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "单量", allowableValues = "length:(,10]")
    private Integer num;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 获取月份
     */
    public String getMonth() {
        return month;
    }

    /**
     * 设置月份
     */
    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    /**
     * 获取单量
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置单量
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
