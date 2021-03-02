package com.wisea.cultivar.common.po.tp.system;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * SellerSerCostMageInsertPo
 * 2019/01/14 13:49:31
 */
public class SellerSerCostMageInsertPo {
    /**
     * 卖家id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "卖家id")
    private Long sellerId;

    /**
     * 服务费
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "服务费")
    private Double serCost;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 获取卖家id
     */
    public Long getSellerId() {
        return sellerId;
    }

    /**
     * 设置卖家id
     */
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
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
