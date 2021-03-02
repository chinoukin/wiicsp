package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * jydz_mage 表实体
 * 交易递增配置
 * 2019/12/02 14:39:38
 */
public class JydzMage extends DataLongEntity<JydzMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 是否开启
     */
    private String sfkqFlag;

    /**
     * 自动更新时间
     */
    private Integer zddzDate;

    /**
     * 自动递增小
     */
    private Integer zddzMin;

    /**
     * 自动递增大
     */
    private Integer zddzMax;

    /**
     * 已递增金额
     */
    private Double ydiJe;

    /**
     * 国外是否开启
     */
    private String gwSfkqFlag;

    /**
     * 国外自动更新时间
     */
    private Integer gwZddzDate;

    /**
     * 国外自动递增小
     */
    private Integer gwZddzMin;

    /**
     * 国外自动递增大
     */
    private Integer gwZddzMax;

    /**
     * 国外已递增金额
     */
    private Double gwYdiJe;

    /**
     * 获取是否开启
     */
    public String getSfkqFlag() {
        return sfkqFlag;
    }

    /**
     * 设置是否开启
     */
    public void setSfkqFlag(String sfkqFlag) {
        this.sfkqFlag = sfkqFlag == null ? null : sfkqFlag.trim();
    }

    /**
     * 获取自动更新时间
     */
    public Integer getZddzDate() {
        return zddzDate;
    }

    /**
     * 设置自动更新时间
     */
    public void setZddzDate(Integer zddzDate) {
        this.zddzDate = zddzDate;
    }

    /**
     * 获取自动递增小
     */
    public Integer getZddzMin() {
        return zddzMin;
    }

    /**
     * 设置自动递增小
     */
    public void setZddzMin(Integer zddzMin) {
        this.zddzMin = zddzMin;
    }

    /**
     * 获取自动递增大
     */
    public Integer getZddzMax() {
        return zddzMax;
    }

    /**
     * 设置自动递增大
     */
    public void setZddzMax(Integer zddzMax) {
        this.zddzMax = zddzMax;
    }

    /**
     * 获取已递增金额
     */
    public Double getYdiJe() {
        return ydiJe;
    }

    /**
     * 设置已递增金额
     */
    public void setYdiJe(Double ydiJe) {
        this.ydiJe = ydiJe;
    }

    /**
     * 获取国外是否开启
     */
    public String getGwSfkqFlag() {
        return gwSfkqFlag;
    }

    /**
     * 设置国外是否开启
     */
    public void setGwSfkqFlag(String gwSfkqFlag) {
        this.gwSfkqFlag = gwSfkqFlag == null ? null : gwSfkqFlag.trim();
    }

    /**
     * 获取国外自动更新时间
     */
    public Integer getGwZddzDate() {
        return gwZddzDate;
    }

    /**
     * 设置国外自动更新时间
     */
    public void setGwZddzDate(Integer gwZddzDate) {
        this.gwZddzDate = gwZddzDate;
    }

    /**
     * 获取国外自动递增小
     */
    public Integer getGwZddzMin() {
        return gwZddzMin;
    }

    /**
     * 设置国外自动递增小
     */
    public void setGwZddzMin(Integer gwZddzMin) {
        this.gwZddzMin = gwZddzMin;
    }

    /**
     * 获取国外自动递增大
     */
    public Integer getGwZddzMax() {
        return gwZddzMax;
    }

    /**
     * 设置国外自动递增大
     */
    public void setGwZddzMax(Integer gwZddzMax) {
        this.gwZddzMax = gwZddzMax;
    }

    /**
     * 获取国外已递增金额
     */
    public Double getGwYdiJe() {
        return gwYdiJe;
    }

    /**
     * 设置国外已递增金额
     */
    public void setGwYdiJe(Double gwYdiJe) {
        this.gwYdiJe = gwYdiJe;
    }
}
