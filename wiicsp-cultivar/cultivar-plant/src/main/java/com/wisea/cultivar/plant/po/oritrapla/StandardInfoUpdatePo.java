package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * StandardInfoUpdatePo
 * 2019/05/27 13:59:47
 */
public class StandardInfoUpdatePo {
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id")
    private Long id;

    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "standardSpecificationId")
    private Long standardSpecificationId;

    @Check(test = { "maxLength" }, mixLength = 200)
    @ApiModelProperty(value = "titleName")
    private String titleName;

    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "remarks")
    private String remarks;

    @Check(test = { "maxLength" }, mixLength = 1)
    @ApiModelProperty(value = "delFlag")
    private String delFlag;

    @Check(test = { "maxLength" }, mixLength = 65535)
    @ApiModelProperty(value = "standardContent")
    private String standardContent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStandardSpecificationId() {
        return standardSpecificationId;
    }

    public void setStandardSpecificationId(Long standardSpecificationId) {
        this.standardSpecificationId = standardSpecificationId;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName == null ? null : titleName.trim();
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

    public String getStandardContent() {
        return standardContent;
    }

    public void setStandardContent(String standardContent) {
        this.standardContent = standardContent == null ? null : standardContent.trim();
    }
}
