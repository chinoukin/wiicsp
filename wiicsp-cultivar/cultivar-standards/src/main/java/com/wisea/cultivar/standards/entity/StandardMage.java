package com.wisea.cultivar.standards.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * standard_mage 表实体
 * 标准管理
 * 2020/07/24 11:21:45
 */
public class StandardMage extends DataLongEntity<StandardMage> {
    private static final long serialVersionUID = 1L;

    private Long standardSpecificationId;

    /**
     * 种植采收加工标准类型
     */
    private String plantRecoProcessType;

    /**
     * 标准名称
     */
    private String plantStandardName;

    /**
     * 产品图片
     */
    private String prudtUrl;

    /**
     * 种植标准类型
     */
    private String plantType;

    /**
     * 摘要
     */
    private String outline;

    public Long getStandardSpecificationId() {
        return standardSpecificationId;
    }

    public void setStandardSpecificationId(Long standardSpecificationId) {
        this.standardSpecificationId = standardSpecificationId;
    }

    /**
     * 获取种植采收加工标准类型
     */
    public String getPlantRecoProcessType() {
        return plantRecoProcessType;
    }

    /**
     * 设置种植采收加工标准类型
     */
    public void setPlantRecoProcessType(String plantRecoProcessType) {
        this.plantRecoProcessType = plantRecoProcessType == null ? null : plantRecoProcessType.trim();
    }

    /**
     * 获取标准名称
     */
    public String getPlantStandardName() {
        return plantStandardName;
    }

    /**
     * 设置标准名称
     */
    public void setPlantStandardName(String plantStandardName) {
        this.plantStandardName = plantStandardName == null ? null : plantStandardName.trim();
    }

    /**
     * 获取产品图片
     */
    public String getPrudtUrl() {
        return prudtUrl;
    }

    /**
     * 设置产品图片
     */
    public void setPrudtUrl(String prudtUrl) {
        this.prudtUrl = prudtUrl == null ? null : prudtUrl.trim();
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
     * 获取摘要
     */
    public String getOutline() {
        return outline;
    }

    /**
     * 设置摘要
     */
    public void setOutline(String outline) {
        this.outline = outline == null ? null : outline.trim();
    }
}
