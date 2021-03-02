package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

public class SellerSpeSerCostMage extends DataLongEntity<SellerSpeSerCostMage> {

    private Long sellerId; //卖家id
    private Long buyerId; //买家id
    private Double serCost; //服务费

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
