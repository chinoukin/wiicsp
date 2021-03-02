package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * PlantingMethodInsertPo
 * 2019/05/27 13:59:47
 */
public class PlantingMethodInsertPo {
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = {"maxLength"}, length = 19)
    @ApiModelProperty(value = "commId")
    private Long commId;

    @Check(test = {"maxLength"}, mixLength = 5)
    @ApiModelProperty(value = "plantType")
    private String plantType;

    @Check(test = {"maxLength"}, mixLength = 5)
    @ApiModelProperty(value = "massifType")
    private String massifType;

    @JsonSerialize(using = IdSerializer.class)
    @Check(test = {"maxLength"}, length = 19)
    @ApiModelProperty(value = "standardSpecificationId")
    private Long standardSpecificationId;

    @Check(test = {"maxLength"}, mixLength = 5)
    @ApiModelProperty(value = "sourceType")
    private String sourceType;

    @Check(test = {"maxLength"}, mixLength = 255)
    @ApiModelProperty(value = "remarks")
    private String remarks;

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
}
