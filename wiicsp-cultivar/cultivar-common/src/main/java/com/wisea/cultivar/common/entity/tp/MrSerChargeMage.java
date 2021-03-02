package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * mr_ser_charge_mage 表实体
 * 默认服务费管理
 * 2019/05/15 15:14:16
 */
public class MrSerChargeMage extends DataLongEntity<MrSerChargeMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 交易模式
     */
    private String transModeType;

    /**
     * 商品id
     */
    private Long commId;

    /**
     * 收取方式
     */
    private String colleMethType;

    /**
     * 收取数值
     */
    private Double sqVal;

    /**
     * 单笔最小数值
     */
    private Double oneceMin;

    /**
     * 单笔最大数值
     */
    private Double oneceMax;

    /**
     * 获取交易模式
     */
    public String getTransModeType() {
        return transModeType;
    }

    /**
     * 设置交易模式
     */
    public void setTransModeType(String transModeType) {
        this.transModeType = transModeType == null ? null : transModeType.trim();
    }

    /**
     * 获取商品id
     */
    public Long getCommId() {
        return commId;
    }

    /**
     * 设置商品id
     */
    public void setCommId(Long commId) {
        this.commId = commId;
    }

    /**
     * 获取收取方式
     */
    public String getColleMethType() {
        return colleMethType;
    }

    /**
     * 设置收取方式
     */
    public void setColleMethType(String colleMethType) {
        this.colleMethType = colleMethType == null ? null : colleMethType.trim();
    }

    /**
     * 获取收取数值
     */
    public Double getSqVal() {
        return sqVal;
    }

    /**
     * 设置收取数值
     */
    public void setSqVal(Double sqVal) {
        this.sqVal = sqVal;
    }

    /**
     * 获取单笔最小数值
     */
    public Double getOneceMin() {
        return oneceMin;
    }

    /**
     * 设置单笔最小数值
     */
    public void setOneceMin(Double oneceMin) {
        this.oneceMin = oneceMin;
    }

    /**
     * 获取单笔最大数值
     */
    public Double getOneceMax() {
        return oneceMax;
    }

    /**
     * 设置单笔最大数值
     */
    public void setOneceMax(Double oneceMax) {
        this.oneceMax = oneceMax;
    }
}
