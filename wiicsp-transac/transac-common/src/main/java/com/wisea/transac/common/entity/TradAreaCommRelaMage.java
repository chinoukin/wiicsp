package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * trad_area_comm_rela_mage 表实体
 * 交易区商品管理
 * 2020/05/07 10:34:47
 */
public class TradAreaCommRelaMage extends DataLongEntity<TradAreaCommRelaMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 交易区id
     */
    private Long tradAreaId;

    /**
     * 销售分类配置id
     */
    private Long commSaleSetId;

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
     * 获取交易区id
     */
    public Long getTradAreaId() {
        return tradAreaId;
    }

    /**
     * 设置交易区id
     */
    public void setTradAreaId(Long tradAreaId) {
        this.tradAreaId = tradAreaId;
    }

    /**
     * 获取销售分类配置id
     */
    public Long getCommSaleSetId() {
        return commSaleSetId;
    }

    /**
     * 设置销售分类配置id
     */
    public void setCommSaleSetId(Long commSaleSetId) {
        this.commSaleSetId = commSaleSetId;
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
