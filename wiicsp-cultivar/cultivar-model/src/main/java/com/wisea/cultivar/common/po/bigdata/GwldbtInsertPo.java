package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * GwldbtInsertPo
 * 2019/12/02 11:02:14
 */
public class GwldbtInsertPo {
    /**
     * 物流名称
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "物流名称", allowableValues = "mixLength:(,255]")
    private String wlname;

    /**
     * 物流流通件数
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "物流流通件数", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double wlltjs;

    /**
     * 排序
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "排序", allowableValues = "length:(,10]")
    private Integer sort;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 获取物流名称
     */
    public String getWlname() {
        return wlname;
    }

    /**
     * 设置物流名称
     */
    public void setWlname(String wlname) {
        this.wlname = wlname == null ? null : wlname.trim();
    }

    /**
     * 获取物流流通件数
     */
    public Double getWlltjs() {
        return wlltjs;
    }

    /**
     * 设置物流流通件数
     */
    public void setWlltjs(Double wlltjs) {
        this.wlltjs = wlltjs;
    }

    /**
     * 获取排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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
