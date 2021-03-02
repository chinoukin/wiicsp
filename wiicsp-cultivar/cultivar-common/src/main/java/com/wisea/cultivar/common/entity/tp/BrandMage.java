package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * brand_mage 表实体
 * 品牌管理
 * 2018/09/18 14:36:47
 */
public class BrandMage extends DataLongEntity<BrandMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    private String serialNum;

    /**
     * 品牌logo
     */
    private String brandLogo;

    /**
     * 品牌故事
     */
    private String brandStory;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 排序
     */
    private Integer sort;

    public String getBrandStory() {
        return brandStory;
    }

    public void setBrandStory(String brandStory) {
        this.brandStory = brandStory;
    }

    /**
     * 获取序号
     */
    public String getSerialNum() {
        return serialNum;
    }

    /**
     * 设置序号
     */
    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum == null ? null : serialNum.trim();
    }

    /**
     * 获取品牌logo
     */
    public String getBrandLogo() {
        return brandLogo;
    }

    /**
     * 设置品牌logo
     */
    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo == null ? null : brandLogo.trim();
    }

    /**
     * 获取品牌名称
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * 设置品牌名称
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    /**
     * 获取排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
