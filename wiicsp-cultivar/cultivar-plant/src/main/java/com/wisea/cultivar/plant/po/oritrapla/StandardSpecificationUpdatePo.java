package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * StandardSpecificationUpdatePo
 * 2019/05/27 13:59:47
 */
public class StandardSpecificationUpdatePo {
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id")
    private Long id;

    @Check(test = { "maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "标准名称")
    private String standardName;

    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "商品ID")
    private Long commId;

    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "标准类型，0：无公害，1：有机，2：绿色，3：其它")
    private String plantType;

    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "摘要")
    private String summary;

    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "图片URL")
    private String imgUrl;

    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    @Check(test = { "maxLength" }, mixLength = 1)
    @ApiModelProperty(value = "删除标志")
    private String delFlag;

    @ApiModelProperty("标准详情")
    private List<StandardInfoInsertPo> standardDetails;

    public List<StandardInfoInsertPo> getStandardDetails() {
        return standardDetails;
    }

    public void setStandardDetails(List<StandardInfoInsertPo> standardDetails) {
        this.standardDetails = standardDetails;
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
