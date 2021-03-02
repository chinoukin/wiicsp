package com.wisea.cultivar.explorer.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * oil_tea_brand_mage 表实体
 * 茶油品牌信息维护
 * 2020/07/24 11:21:45
 */
public class OilTeaBrandMage extends DataLongEntity<OilTeaBrandMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 品牌编号
     */
    private String brandNo;

    /**
     * 品牌图标
     */
    private String brandUrl;

    /**
     * 品牌介绍
     */
    private String brandIntroduce;

    /**
     * 申请时间
     */
    private OffsetDateTime applDate;

    /**
     * 联系人
     */
    private String conter;

    /**
     * 联系方式
     */
    private String contTel;

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
     * 获取品牌编号
     */
    public String getBrandNo() {
        return brandNo;
    }

    /**
     * 设置品牌编号
     */
    public void setBrandNo(String brandNo) {
        this.brandNo = brandNo == null ? null : brandNo.trim();
    }

    /**
     * 获取品牌图标
     */
    public String getBrandUrl() {
        return brandUrl;
    }

    /**
     * 设置品牌图标
     */
    public void setBrandUrl(String brandUrl) {
        this.brandUrl = brandUrl == null ? null : brandUrl.trim();
    }

    /**
     * 获取品牌介绍
     */
    public String getBrandIntroduce() {
        return brandIntroduce;
    }

    /**
     * 设置品牌介绍
     */
    public void setBrandIntroduce(String brandIntroduce) {
        this.brandIntroduce = brandIntroduce == null ? null : brandIntroduce.trim();
    }

    /**
     * 获取申请时间
     */
    public OffsetDateTime getApplDate() {
        return applDate;
    }

    /**
     * 设置申请时间
     */
    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
    }

    /**
     * 获取联系人
     */
    public String getConter() {
        return conter;
    }

    /**
     * 设置联系人
     */
    public void setConter(String conter) {
        this.conter = conter == null ? null : conter.trim();
    }

    /**
     * 获取联系方式
     */
    public String getContTel() {
        return contTel;
    }

    /**
     * 设置联系方式
     */
    public void setContTel(String contTel) {
        this.contTel = contTel == null ? null : contTel.trim();
    }
}
