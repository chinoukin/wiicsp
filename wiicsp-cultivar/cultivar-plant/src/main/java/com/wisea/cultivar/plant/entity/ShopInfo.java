package com.wisea.cultivar.plant.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class ShopInfo extends DataLongEntity<ShopInfo> {
    /**
     * 服务商id
     */
    private Long membId;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 店铺背景图
     */
    private String backGroundUrl;

    /**
     * 店铺介绍
     */
    private String shopSignature;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getBackGroundUrl() {
        return backGroundUrl;
    }

    public void setBackGroundUrl(String backGroundUrl) {
        this.backGroundUrl = backGroundUrl;
    }

    public String getShopSignature() {
        return shopSignature;
    }

    public void setShopSignature(String shopSignature) {
        this.shopSignature = shopSignature;
    }
}
