package com.wisea.cultivar.plant.vo.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * StandardSpecificationListVo
 * 2019/05/27 13:59:47
 */
public class StandardSpecificationListVo {
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "标准名称")
    private String standardName;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "品种第三级ID")
    private Long commId;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "品种第二级ID")
    private Long commLevel2Id;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "品种第一级ID")
    private Long commLevel1Id;

    @ApiModelProperty(value = "品种名称")
    private String commName;

    @ApiModelProperty(value = "标准类型，0：无公害，1：有机，2：绿色，3：其它")
    private String plantType;

    @ApiModelProperty(value = "摘要")
    private String summary;

    @ApiModelProperty(value = "图片URL")
    private String imgUrl;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "删除标志")
    private String delFlag;

    @ApiModelProperty("创建时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime createDate;

    @ApiModelProperty(value = "标准详情列表")
    private List<StandardInfoListVo> details;

    public Long getCommLevel2Id() {
        return commLevel2Id;
    }

    public void setCommLevel2Id(Long commLevel2Id) {
        this.commLevel2Id = commLevel2Id;
    }

    public Long getCommLevel1Id() {
        return commLevel1Id;
    }

    public void setCommLevel1Id(Long commLevel1Id) {
        this.commLevel1Id = commLevel1Id;
    }

    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public void setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
    }

    public List<StandardInfoListVo> getDetails() {
        return details;
    }

    public void setDetails(List<StandardInfoListVo> details) {
        this.details = details;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStandardName() {
        return standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName == null ? null : standardName.trim();
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

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
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
