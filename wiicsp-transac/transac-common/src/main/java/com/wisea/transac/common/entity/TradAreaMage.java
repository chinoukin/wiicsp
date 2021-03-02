package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * trad_area_mage 表实体
 * 交易区管理
 * 2020/05/07 10:34:56
 */
public class TradAreaMage extends DataLongEntity<TradAreaMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 批发市场id
     */
    private Long wholeSaleMarketId;

    /**
     * 父分类名称
     */
    private String pCatgName;

    /**
     * 分类名称
     */
    private String catgName;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     * 是否显示
     */
    private String ifDisplayType;

    /**
     * 获取批发市场id
     */
    public Long getWholeSaleMarketId() {
        return wholeSaleMarketId;
    }

    /**
     * 设置批发市场id
     */
    public void setWholeSaleMarketId(Long wholeSaleMarketId) {
        this.wholeSaleMarketId = wholeSaleMarketId;
    }

    /**
     * 获取父分类名称
     */
    public String getpCatgName() {
        return pCatgName;
    }

    /**
     * 设置父分类名称
     */
    public void setpCatgName(String pCatgName) {
        this.pCatgName = pCatgName == null ? null : pCatgName.trim();
    }

    /**
     * 获取分类名称
     */
    public String getCatgName() {
        return catgName;
    }

    /**
     * 设置分类名称
     */
    public void setCatgName(String catgName) {
        this.catgName = catgName == null ? null : catgName.trim();
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

    /**
     * 获取是否显示
     */
    public String getIfDisplayType() {
        return ifDisplayType;
    }

    /**
     * 设置是否显示
     */
    public void setIfDisplayType(String ifDisplayType) {
        this.ifDisplayType = ifDisplayType == null ? null : ifDisplayType.trim();
    }
}
