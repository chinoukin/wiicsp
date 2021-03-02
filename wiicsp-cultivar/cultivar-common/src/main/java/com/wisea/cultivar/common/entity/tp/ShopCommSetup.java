package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * shop_comm_setup 表实体
 * 店内商品设置
 * 2019/12/12 09:12:09
 */
public class ShopCommSetup extends DataLongEntity<ShopCommSetup> {
    private static final long serialVersionUID = 1L;

    /**
     * 商品分类id
     */
    private Long commId;

    /**
     * 商品发布id
     */
    private Long commPubId;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     * 获取商品分类id
     */
    public Long getCommId() {
        return commId;
    }

    /**
     * 设置商品分类id
     */
    public void setCommId(Long commId) {
        this.commId = commId;
    }

    /**
     * 获取商品发布id
     */
    public Long getCommPubId() {
        return commPubId;
    }

    /**
     * 设置商品发布id
     */
    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    /**
     * 获取显示顺序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置显示顺序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
