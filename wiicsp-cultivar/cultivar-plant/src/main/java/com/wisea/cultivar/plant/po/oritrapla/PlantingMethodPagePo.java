package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.vo.oritrapla.PlantingMethodListVo;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * PlantingMethodPagePo
 * 2019/05/27 13:59:47
 */
public class PlantingMethodPagePo extends PagePo<PlantingMethodListVo> {
    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "分类ID")
    private Long commId;

    @ApiModelProperty(value = "标准类型")
    private String plantType;

    @ApiModelProperty(value = "地块类型")
    private String massifType;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "标准规范id")
    private Long standardSpecificationId;

    @ApiModelProperty(value = "sourceType")
    private String sourceType;

    @ApiModelProperty(value = "remarks")
    private String remarks;

    @ApiModelProperty(value = "delFlag")
    private String delFlag;

    @ApiModelProperty(value = "开始时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime startTime;

    @ApiModelProperty(value = "结束时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime endTime;

    public OffsetDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
    }

    public OffsetDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(OffsetDateTime endTime) {
        this.endTime = endTime;
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
