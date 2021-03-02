package com.wisea.cultivar.standards.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * planting_method 表实体
 * 种植方法
 * 2020/07/24 11:21:45
 */
public class PlantingMethod extends DataLongEntity<PlantingMethod> {
    private static final long serialVersionUID = 1L;

    /**
     * 种植标准管理id
     */
    private Long plantStandardMageId;

    /**
     * 分类
     */
    private Long commId;

    /**
     * 种植标准类型
     */
    private String plantType;

    /**
     * 种植设施类型
     */
    private String massifType;

    /**
     * source_type
     */
    private String sourceType;

    /**
     * 获取种植标准管理id
     */
    public Long getPlantStandardMageId() {
        return plantStandardMageId;
    }

    /**
     * 设置种植标准管理id
     */
    public void setPlantStandardMageId(Long plantStandardMageId) {
        this.plantStandardMageId = plantStandardMageId;
    }

    /**
     * 获取分类
     */
    public Long getCommId() {
        return commId;
    }

    /**
     * 设置分类
     */
    public void setCommId(Long commId) {
        this.commId = commId;
    }

    /**
     * 获取种植标准类型
     */
    public String getPlantType() {
        return plantType;
    }

    /**
     * 设置种植标准类型
     */
    public void setPlantType(String plantType) {
        this.plantType = plantType == null ? null : plantType.trim();
    }

    /**
     * 获取种植设施类型
     */
    public String getMassifType() {
        return massifType;
    }

    /**
     * 设置种植设施类型
     */
    public void setMassifType(String massifType) {
        this.massifType = massifType == null ? null : massifType.trim();
    }

    /**
     * 获取source_type
     */
    public String getSourceType() {
        return sourceType;
    }

    /**
     * 设置source_type
     */
    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }
}
