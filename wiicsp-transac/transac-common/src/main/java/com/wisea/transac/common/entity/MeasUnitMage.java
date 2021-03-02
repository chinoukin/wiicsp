package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class MeasUnitMage extends DataLongEntity<MeasUnitMage> {
    /**
     * 编号
     */
    private String unitNum;

    /**
     * 计量单位名称
     */
    private String measUnitName;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 计量单位状态（有效、无效）
     */
    private String effeInvalState;

    /**
     * 所属量纲类型
     */
    private String dimensionsType;

    /**
     * 转换系数
     */
    private Double transXs;

    public Double getTransXs() {
        return transXs;
    }

    public void setTransXs(Double transXs) {
        this.transXs = transXs;
    }

    public String getUnitNum() {
        return unitNum;
    }

    public void setUnitNum(String unitNum) {
        this.unitNum = unitNum;
    }

    public String getMeasUnitName() {
        return measUnitName;
    }

    public void setMeasUnitName(String measUnitName) {
        this.measUnitName = measUnitName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getEffeInvalState() {
        return effeInvalState;
    }

    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState;
    }

    public String getDimensionsType() {
        return dimensionsType;
    }

    public void setDimensionsType(String dimensionsType) {
        this.dimensionsType = dimensionsType;
    }
}
