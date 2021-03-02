package com.wisea.cultivar.common.po.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * SubEntpVideoInfoMageInsertPo
 * 2019/12/02 11:02:15
 */
public class SubEntpVideoInfoMageInsertPo {
    /**
     * 分公司id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "分公司id", allowableValues = "length:(,19]")
    private Long subEntpId;

    /**
     * 视频名称
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "视频名称", allowableValues = "mixLength:(,255]")
    private String videoName;

    /**
     * 视频地址
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "视频地址", allowableValues = "mixLength:(,255]")
    private String videoUrl;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 获取分公司id
     */
    public Long getSubEntpId() {
        return subEntpId;
    }

    /**
     * 设置分公司id
     */
    public void setSubEntpId(Long subEntpId) {
        this.subEntpId = subEntpId;
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

    /**
     * 获取视频地址
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * 设置视频地址
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
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
