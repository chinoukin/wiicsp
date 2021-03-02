package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class BrandMage extends DataLongEntity<BrandMage> {
    /**
     * 序号
     */
    private String serialNum;

    /**
     * 品牌logo
     */
    private String brandLogo;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 品牌故事
     */
    private String brandStory;

    /**
     * 排序
     */
    private Integer sort;

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandStory() {
        return brandStory;
    }

    public void setBrandStory(String brandStory) {
        this.brandStory = brandStory;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
