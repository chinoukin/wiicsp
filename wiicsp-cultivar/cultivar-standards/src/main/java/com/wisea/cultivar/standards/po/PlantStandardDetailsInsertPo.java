package com.wisea.cultivar.standards.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * PlantStandardDetailsInsertPo
 * 2020/07/24 11:21:45
 */
public class PlantStandardDetailsInsertPo  extends DataLongEntity<PlantStandardDetailsInsertPo> {
    /**
     * 种植标准管理id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "种植标准管理id", allowableValues = "length:(,19]")
    private Long plantStandardMageId;

    /**
     * 标题名称
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "标题名称", allowableValues = "mixLength:(,30]")
    private String titleName;

    /**
     * 显示顺序
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "显示顺序", allowableValues = "length:(,10]")
    private Integer sort;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 内容介绍
     */
    @Check(test = { "maxLength" }, mixLength = 16777215)
    @ApiModelProperty(value = "内容介绍", allowableValues = "mixLength:(,16777215]")
    private String content;

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
     * 获取标题名称
     */
    public String getTitleName() {
        return titleName;
    }

    /**
     * 设置标题名称
     */
    public void setTitleName(String titleName) {
        this.titleName = titleName == null ? null : titleName.trim();
    }

    /**
     * 获取显示顺序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置显示顺序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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
     * 获取内容介绍
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置内容介绍
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
