package com.wisea.cultivar.explorer.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * ProceEntpVideoInsertPo
 * 2020/08/27 13:47:43
 */
public class ProceEntpVideoInsertPo {
    /**
     * 种植主体id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required", "maxLength" }, length = 19)
    @ApiModelProperty(value = "种植主体id", allowableValues = "length:(,19]")
    private Long entpInfoMageId;

    /**
     * 视频名称
     */
    @Check(test = { "required", "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "视频名称", allowableValues = "mixLength:(,255]")
    private String videoName;

    /**
     * 视频链接地址
     */
    @Check(test = { "required", "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "视频链接地址", allowableValues = "mixLength:(,255]")
    private String videoUrl;

    /**
     * 排序
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "排序", allowableValues = "length:(,10]")
    private Integer sort;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 获取种植主体id
     */
    public Long getEntpInfoMageId() {
        return entpInfoMageId;
    }

    /**
     * 设置种植主体id
     */
    public void setEntpInfoMageId(Long entpInfoMageId) {
        this.entpInfoMageId = entpInfoMageId;
    }

    /**
     * 获取视频名称
     */
    public String getVideoName() {
        return videoName;
    }

    /**
     * 设置视频名称
     */
    public void setVideoName(String videoName) {
        this.videoName = videoName == null ? null : videoName.trim();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    /**
     * 获取排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
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
}
