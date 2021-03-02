package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 保存会员标签的PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年10月12日
 * @version 1.0
 */
@ApiModel("保存会员标签的PO")
public class MembLabelListInsertPo {

    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "labelCatgType")
    private String labelCatgType;

    @Check(test = { "maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "labelName")
    private String labelName;

    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "alredyActUrl")
    private String alredyActUrl;

    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "notActUrl")
    private String notActUrl;

    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "labelDesc")
    private String labelDesc;

    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "sort")
    private Integer sort;

    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "remarks")
    private String remarks;

    public String getLabelCatgType() {
        return labelCatgType;
    }

    public void setLabelCatgType(String labelCatgType) {
        this.labelCatgType = labelCatgType == null ? null : labelCatgType.trim();
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName == null ? null : labelName.trim();
    }

    public String getAlredyActUrl() {
        return alredyActUrl;
    }

    public void setAlredyActUrl(String alredyActUrl) {
        this.alredyActUrl = alredyActUrl == null ? null : alredyActUrl.trim();
    }

    public String getNotActUrl() {
        return notActUrl;
    }

    public void setNotActUrl(String notActUrl) {
        this.notActUrl = notActUrl == null ? null : notActUrl.trim();
    }

    public String getLabelDesc() {
        return labelDesc;
    }

    public void setLabelDesc(String labelDesc) {
        this.labelDesc = labelDesc == null ? null : labelDesc.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}
