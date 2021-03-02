package com.wisea.cultivar.plant.vo.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * PlantingMethodListVo
 * 2019/05/27 13:59:47
 */
public class PlantingMethodListVo {
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "commId")
    private Long commId;

    @ApiModelProperty(value = "品类名称")
    private String commCatgName;

    @ApiModelProperty(value = "种植标准键")
    private String plantType;

    @ApiModelProperty(value = "种植标准值")
    private String plantTypeValue;

    @ApiModelProperty(value = "种植设施")
    private String massifType;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "standardSpecificationId")
    private Long standardSpecificationId;

    @ApiModelProperty(value = "来源类型")
    private String sourceType;

    @ApiModelProperty(value = "remarks")
    private String remarks;

    @ApiModelProperty(value = "delFlag")
    private String delFlag;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @ApiModelProperty(value = "创建时间")
    private OffsetDateTime createDate;

    @ApiModelProperty(value = "种植方法")
    private String plantingMethod;

    public String getPlantTypeValue() {
        return plantTypeValue;
    }

    public void setPlantTypeValue(String plantTypeValue) {
        this.plantTypeValue = plantTypeValue;
    }

    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
    }

    public String getPlantingMethod() {
        return plantingMethod;
    }

    public void setPlantingMethod(String plantingMethod) {
        this.plantingMethod = plantingMethod;
    }

    public String getCommCatgName() {
        return commCatgName;
    }

    public void setCommCatgName(String commCatgName) {
        this.commCatgName = commCatgName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public String getPlantType() {
        return plantType;
    }

    public void setPlantType(String plantType) {
        this.plantType = plantType == null ? null : plantType.trim();
    }

    public String getMassifType() {
        return massifType;
    }

    public void setMassifType(String massifType) {
        this.massifType = massifType == null ? null : massifType.trim();
    }

    public Long getStandardSpecificationId() {
        return standardSpecificationId;
    }

    public void setStandardSpecificationId(Long standardSpecificationId) {
        this.standardSpecificationId = standardSpecificationId;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}
