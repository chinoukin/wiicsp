package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * shop_info_mage 表实体
 * 店铺基本设置
 * 2019/12/12 09:12:09
 */
public class ShopInfoMage extends DataLongEntity<ShopInfoMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 会员id
     */
    private Long membId;

    /**
     * 店铺名称
     */
    private String shopName;

    /**
     * 店铺宣传栏
     */
    private String shopXclUrl;

    /**
     * 获取会员id
     */
    public Long getMembId() {
        return membId;
    }

    /**
     * 设置会员id
     */
    public void setMembId(Long membId) {
        this.membId = membId;
    }

    /**
     * 获取店铺名称
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * 设置店铺名称
     */
    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    /**
     * 获取店铺宣传栏
     */
    public String getShopXclUrl() {
        return shopXclUrl;
    }

    /**
     * 设置店铺宣传栏
     */
    public void setShopXclUrl(String shopXclUrl) {
        this.shopXclUrl = shopXclUrl == null ? null : shopXclUrl.trim();
    }
}
