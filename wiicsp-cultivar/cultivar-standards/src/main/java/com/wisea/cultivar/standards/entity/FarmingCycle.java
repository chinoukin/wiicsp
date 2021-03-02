package com.wisea.cultivar.standards.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * farming_cycle 表实体
 * 农事周期
 * 2020/07/24 11:21:45
 */
public class FarmingCycle extends DataLongEntity<FarmingCycle> {
    private static final long serialVersionUID = 1L;

    /**
     * 种植方法id
     */
    private Long plantingMethodId;

    /**
     * 周期名称
     */
    private String cycleName;

    /**
     * 开始天
     */
    private Integer startDays;

    /**
     * 结束天
     */
    private Integer endDays;

    /**
     * 获取种植方法id
     */
    public Long getPlantingMethodId() {
        return plantingMethodId;
    }

    /**
     * 设置种植方法id
     */
    public void setPlantingMethodId(Long plantingMethodId) {
        this.plantingMethodId = plantingMethodId;
    }

    /**
     * 获取周期名称
     */
    public String getCycleName() {
        return cycleName;
    }

    /**
     * 设置周期名称
     */
    public void setCycleName(String cycleName) {
        this.cycleName = cycleName == null ? null : cycleName.trim();
    }

    /**
     * 获取开始天
     */
    public Integer getStartDays() {
        return startDays;
    }

    /**
     * 设置开始天
     */
    public void setStartDays(Integer startDays) {
        this.startDays = startDays;
    }

    /**
     * 获取结束天
     */
    public Integer getEndDays() {
        return endDays;
    }

    /**
     * 设置结束天
     */
    public void setEndDays(Integer endDays) {
        this.endDays = endDays;
    }
}
