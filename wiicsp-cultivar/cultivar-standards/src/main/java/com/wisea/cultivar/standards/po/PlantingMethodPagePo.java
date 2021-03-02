package com.wisea.cultivar.standards.po;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.standards.vo.PlantingMethodListVo;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.Date;

/**
 * PlantingMethodPagePo
 * 2020/07/24 11:21:45
 */
public class PlantingMethodPagePo extends PagePo<PlantingMethodListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 种植标准管理id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "种植标准管理id")
    private Long plantStandardMageId;

    /**
     * 分类
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "分类")
    private Long commId;

    /**
     * 种植标准类型
     */
    @ApiModelProperty(value = "种植标准类型")
    private String plantType;

    /**
     * 种植设施类型
     */
    @ApiModelProperty(value = "种植设施类型")
    private String massifType;

    /**
     * source_type
     */
    @ApiModelProperty(value = "source_type")
    private String sourceType;

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

    @ApiModelProperty(value = "结束时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime endTime;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime startTime;

    public OffsetDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(OffsetDateTime endTime) {
        this.endTime = endTime;
    }

    public OffsetDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
    }

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "更新时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private Date updateDate;

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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
