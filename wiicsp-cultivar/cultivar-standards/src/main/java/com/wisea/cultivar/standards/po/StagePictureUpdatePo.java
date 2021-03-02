package com.wisea.cultivar.standards.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * StagePictureUpdatePo
 * 2020/07/24 11:21:45
 */
public class StagePictureUpdatePo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id", required = true)
    private Long id;

    /**
     * 农事阶段
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "农事阶段", allowableValues = "length:(,19]")
    private Long farmingStageId;

    /**
     * url
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "url", allowableValues = "mixLength:(,255]")
    private String url;

    /**
     * 排序
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "排序", allowableValues = "length:(,10]")
    private Integer sortIndex;

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
     * 获取农事阶段
     */
    public Long getFarmingStageId() {
        return farmingStageId;
    }

    /**
     * 设置农事阶段
     */
    public void setFarmingStageId(Long farmingStageId) {
        this.farmingStageId = farmingStageId;
    }

    /**
     * 获取url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取排序
     */
    public Integer getSortIndex() {
        return sortIndex;
    }

    /**
     * 设置排序
     */
    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
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
