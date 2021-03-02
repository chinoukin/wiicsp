package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class SellerSpeSerCostMage extends DataLongEntity<SellerSpeSerCostMage> {
    /**
     * 卖家id
     */
    private Long sellerId;

    /**
     * 买家id
     */
    private Long buyerId;

    /**
     * 服务费
     */
    private Double serCost;

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Double getSerCost() {
        return serCost;
    }

    public void setSerCost(Double serCost) {
        this.serCost = serCost;
    }
}
