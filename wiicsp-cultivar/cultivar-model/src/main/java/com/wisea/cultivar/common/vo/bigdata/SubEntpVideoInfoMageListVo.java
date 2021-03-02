package com.wisea.cultivar.common.vo.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * SubEntpVideoInfoMageListVo
 * 2019/12/02 11:02:15
 */
public class SubEntpVideoInfoMageListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 分公司id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "分公司id")
    private Long subEntpId;

    /**
     * 视频名称
     */
    @ApiModelProperty(value = "视频名称")
    private String videoName;

    /**
     * 视频地址
     */
    @ApiModelProperty(value = "视频地址")
    private String videoUrl;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
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
