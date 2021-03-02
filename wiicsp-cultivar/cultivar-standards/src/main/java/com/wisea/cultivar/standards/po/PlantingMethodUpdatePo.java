package com.wisea.cultivar.standards.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * PlantingMethodUpdatePo
 * 2020/07/24 11:21:45
 */
public class PlantingMethodUpdatePo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id", required = true)
    private Long id;

    /**
     * 种植标准管理id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "种植标准管理id", allowableValues = "length:(,19]")
    private Long plantStandardMageId;

    /**
     * 分类
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "分类", allowableValues = "length:(,19]")
    private Long commId;

    /**
     * 种植标准类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "种植标准类型", allowableValues = "mixLength:(,5]")
    private String plantType;

    /**
     * 种植设施类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "种植设施类型", allowableValues = "mixLength:(,5]")
    private String massifType;

    /**
     * source_type
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "source_type", allowableValues = "mixLength:(,5]")
    private String sourceType;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 删除标记
     */
    @Check(test = { "maxLength" }, mixLength = 1)
    @ApiModelProperty(value = "删除标记", allowableValues = "mixLength:(,1]")
    private String delFlag;

    @ApiModelProperty(value = "新增农事周期")
    private List<FarmingCycleInsertPo> farmingCycleInsertPo;

    public List<FarmingCycleInsertPo> getFarmingCycleInsertPo() {
        return farmingCycleInsertPo;
    }

    public void setFarmingCycleInsertPo(List<FarmingCycleInsertPo> farmingCycleInsertPo) {
        this.farmingCycleInsertPo = farmingCycleInsertPo;
    }

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
