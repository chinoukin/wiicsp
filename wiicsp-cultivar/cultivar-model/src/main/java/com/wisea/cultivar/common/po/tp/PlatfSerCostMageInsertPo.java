package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * PlatfSerCostMageInsertPo
 * 2018/09/18 14:36:47
 */
public class PlatfSerCostMageInsertPo {
    /**
     * 服务费类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "服务费类型，0表示平台服务费，1表示平台代理服务费")
    private String serCostType;

    /**
     * 服务费
     */
    @Check(test = { "regex","required" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "服务费")
    private Double serCost;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 获取服务费类型
     */
    public String getSerCostType() {
        return serCostType;
    }

    /**
     * 设置服务费类型
     */
    public void setSerCostType(String serCostType) {
        this.serCostType = serCostType == null ? null : serCostType.trim();
    }

    /**
     * 获取服务费
     */
    public Double getSerCost() {
        return serCost;
    }

    /**
     * 设置服务费
     */
    public void setSerCost(Double serCost) {
        this.serCost = serCost;
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
