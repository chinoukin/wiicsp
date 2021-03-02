package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * category_mage 表实体
 * 品类管理
 * 2019/12/03 14:35:19
 */
public class CategoryMage extends DataLongEntity<CategoryMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 品类名称
     */
    private String categoryName;

    /**
     * 品类图标
     */
    private String categoryUrl;

    /**
     * 关联物料数量
     */
    private Integer glwlSl;

    /**
     * 获取品类名称
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * 设置品类名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    /**
     * 获取品类图标
     */
    public String getCategoryUrl() {
        return categoryUrl;
    }

    /**
     * 设置品类图标
     */
    public void setCategoryUrl(String categoryUrl) {
        this.categoryUrl = categoryUrl == null ? null : categoryUrl.trim();
    }

    /**
     * 获取关联物料数量
     */
    public Integer getGlwlSl() {
        return glwlSl;
    }

    /**
     * 设置关联物料数量
     */
    public void setGlwlSl(Integer glwlSl) {
        this.glwlSl = glwlSl;
    }
}
