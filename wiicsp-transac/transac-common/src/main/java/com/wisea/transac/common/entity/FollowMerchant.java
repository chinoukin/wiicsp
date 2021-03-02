package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class FollowMerchant extends DataLongEntity<FollowMerchant> {
    /**
     * 会员id
     */
    private Long membId;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 基地id
     */
    private Long baseId;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }
}
