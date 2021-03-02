package com.wisea.cultivar.common.po.tp.system;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * SellerSpeSerCostMageInsertPo
 * 2019/01/14 13:49:31
 */
public class SellerSpeSerCostMageInsertPo {
    /**
     * 卖家id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "卖家id,以企业信息中的sellerID为准")
    private Long sellerId;

    /**
     * 买家id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "买家id")
    private Long buyerId;

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
     * 获取买家id
     */
    public Long getBuyerId() {
        return buyerId;
    }

    /**
     * 设置买家id
     */
    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
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
