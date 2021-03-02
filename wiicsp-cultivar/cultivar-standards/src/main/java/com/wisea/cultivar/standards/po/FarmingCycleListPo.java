package com.wisea.cultivar.standards.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * FarmingCycleListPo
 * 2020/07/24 11:21:45
 */
public class FarmingCycleListPo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 种植方法id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "种植方法id")
    private Long plantingMethodId;

    /**
     * 周期名称
     */
    @ApiModelProperty(value = "周期名称")
    private String cycleName;

    /**
     * 开始天
     */
    @ApiModelProperty(value = "开始天")
    private Integer startDays;

    /**
     * 结束天
     */
    @ApiModelProperty(value = "结束天")
    private Integer endDays;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

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

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}
