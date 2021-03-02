package com.wisea.cultivar.plant.entity.oritrapla;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * 品牌信息
 */
public class BrandInfo extends DataLongEntity<BrandInfo> {
    private Long membId; //会员id
    private String brandName; //品牌名称
    private String brandIntr; //品牌介绍

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandIntr() {
        return brandIntr;
    }

    public void setBrandIntr(String brandIntr) {
        this.brandIntr = brandIntr;
    }
}
