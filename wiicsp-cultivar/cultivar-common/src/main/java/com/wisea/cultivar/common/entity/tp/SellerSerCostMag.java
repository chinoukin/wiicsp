package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

public class SellerSerCostMag extends DataLongEntity<SellerSerCostMag> {
    private Long sellerId; //卖家id
    private Double serCost; //服务费

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Double getSerCost() {
        return serCost;
    }

    public void setSerCost(Double serCost) {
        this.serCost = serCost;
    }
}
