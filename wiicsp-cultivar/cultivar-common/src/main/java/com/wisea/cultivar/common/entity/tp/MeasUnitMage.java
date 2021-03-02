package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * meas_unit_mage 表实体
 * 计量单位管理
 * 2018/09/18 14:36:47
 */
public class MeasUnitMage extends DataLongEntity<MeasUnitMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 计量单位名称
     */
    private String measUnitName;

    /**
     * 计量单位序号
     */
    private String unitNum;

    /**
     * 排序
     */
    private String sort;

    /**
     * 计量单位状态（有效、无效）
     */
    private String effeInvalState;

    /**
     * 获取计量单位名称
     */
    public String getMeasUnitName() {
        return measUnitName;
    }

    /**
     * 设置计量单位名称
     */
    public void setMeasUnitName(String measUnitName) {
        this.measUnitName = measUnitName == null ? null : measUnitName.trim();
    }

    /**
     * 获取排序
     */
    public String getSort() {
        return sort;
    }

    /**
     * 设置排序
     */
    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    /**
     * 获取计量单位状态（有效、无效）
     */
    public String getEffeInvalState() {
        return effeInvalState;
    }

    /**
     * 设置计量单位状态（有效、无效）
     */
    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState == null ? null : effeInvalState.trim();
    }

    public String getUnitNum() {
        return unitNum;
    }

    public void setUnitNum(String unitNum) {
        this.unitNum = unitNum;
    }
}
