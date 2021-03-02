package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * JtgjdyfxInsertPo
 * 2019/12/02 11:02:14
 */
public class JtgjdyfxInsertPo {
    /**
     * 交通工具名称
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "交通工具名称", allowableValues = "mixLength:(,255]")
    private String jtgjmc;

    /**
     * 流通数量
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "流通数量", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double ltsl;

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
     * 获取交通工具名称
     */
    public String getJtgjmc() {
        return jtgjmc;
    }

    /**
     * 设置交通工具名称
     */
    public void setJtgjmc(String jtgjmc) {
        this.jtgjmc = jtgjmc == null ? null : jtgjmc.trim();
    }

    /**
     * 获取流通数量
     */
    public Double getLtsl() {
        return ltsl;
    }

    /**
     * 设置流通数量
     */
    public void setLtsl(Double ltsl) {
        this.ltsl = ltsl;
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
