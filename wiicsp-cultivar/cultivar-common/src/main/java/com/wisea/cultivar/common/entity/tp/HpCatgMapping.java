package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * hp_catg_mapping 表实体
 * 首页分类映射
 * 2019/05/28 16:20:20
 */
public class HpCatgMapping extends DataLongEntity<HpCatgMapping> {
    private static final long serialVersionUID = 1L;

    /**
     * 首页分类id
     */
    private Long hpCatgId;

    /**
     * 映射类型（品类、品种、搜索）
     */
    private String mappingType;

    /**
     * 商品分类
     */
    private Long commId;

    /**
     * 商品品种
     */
    private Long commVarietId;

    /**
     * 搜索内容
     */
    private String searchKey;

    /**
     * 获取首页分类id
     */
    public Long getHpCatgId() {
        return hpCatgId;
    }

    /**
     * 设置首页分类id
     */
    public void setHpCatgId(Long hpCatgId) {
        this.hpCatgId = hpCatgId;
    }

    /**
     * 获取映射类型（品类、品种、搜索）
     */
    public String getMappingType() {
        return mappingType;
    }

    /**
     * 设置映射类型（品类、品种、搜索）
     */
    public void setMappingType(String mappingType) {
        this.mappingType = mappingType == null ? null : mappingType.trim();
    }

    /**
     * 获取商品分类
     */
    public Long getCommId() {
        return commId;
    }

    /**
     * 设置商品分类
     */
    public void setCommId(Long commId) {
        this.commId = commId;
    }

    /**
     * 获取商品品种
     */
    public Long getCommVarietId() {
        return commVarietId;
    }

    /**
     * 设置商品品种
     */
    public void setCommVarietId(Long commVarietId) {
        this.commVarietId = commVarietId;
    }

    /**
     * 获取搜索内容
     */
    public String getSearchKey() {
        return searchKey;
    }

    /**
     * 设置搜索内容
     */
    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey == null ? null : searchKey.trim();
    }
}
