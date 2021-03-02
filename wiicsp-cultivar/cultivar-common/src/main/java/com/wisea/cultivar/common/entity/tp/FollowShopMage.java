package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * follow_shop_mage 表实体
 * 关注店铺管理
 * 2019/12/24 11:10:18
 */
public class FollowShopMage extends DataLongEntity<FollowShopMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 店铺id
     */
    private Long shopInfoMageId;

    /**
     * 会员id
     */
    private Long membId;

    /**
     * 获取店铺id
     */
    public Long getShopInfoMageId() {
        return shopInfoMageId;
    }

    /**
     * 设置店铺id
     */
    public void setShopInfoMageId(Long shopInfoMageId) {
        this.shopInfoMageId = shopInfoMageId;
    }

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
}
