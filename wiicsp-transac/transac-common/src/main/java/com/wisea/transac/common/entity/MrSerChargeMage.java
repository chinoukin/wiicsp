package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class MrSerChargeMage extends DataLongEntity<MrSerChargeMage> {
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

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public String getColleMethType() {
        return colleMethType;
    }

    public void setColleMethType(String colleMethType) {
        this.colleMethType = colleMethType;
    }

    public Double getSqVal() {
        return sqVal;
    }

    public void setSqVal(Double sqVal) {
        this.sqVal = sqVal;
    }

    public Double getOneceMin() {
        return oneceMin;
    }

    public void setOneceMin(Double oneceMin) {
        this.oneceMin = oneceMin;
    }

    public Double getOneceMax() {
        return oneceMax;
    }

    public void setOneceMax(Double oneceMax) {
        this.oneceMax = oneceMax;
    }
}
