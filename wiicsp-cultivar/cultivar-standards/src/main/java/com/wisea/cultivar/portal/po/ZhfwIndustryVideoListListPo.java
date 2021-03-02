package com.wisea.cultivar.portal.po;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * ZhfwIndustryVideoListListPo
 * 2020/08/24 20:28:13
 */
public class ZhfwIndustryVideoListListPo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 视频来源类型
     */
    @ApiModelProperty(value = "视频来源类型")
    private String videoSourceType;

    /**
     * 链接地址
     */
    @ApiModelProperty(value = "链接地址")
    private String url;

    /**
     * 显示顺序
     */
    @ApiModelProperty(value = "显示顺序")
    private Integer sort;

    /**
     * 是否显示
     */
    @ApiModelProperty(value = "是否显示")
    private String ifRequ;

    /**
     * 发布时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "发布时间")
    private OffsetDateTime pubDate;

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
     * 获取标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取视频来源类型
     */
    public String getVideoSourceType() {
        return videoSourceType;
    }

    /**
     * 设置视频来源类型
     */
    public void setVideoSourceType(String videoSourceType) {
        this.videoSourceType = videoSourceType == null ? null : videoSourceType.trim();
    }

    /**
     * 获取链接地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置链接地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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
     * 获取是否显示
     */
    public String getIfRequ() {
        return ifRequ;
    }

    /**
     * 设置是否显示
     */
    public void setIfRequ(String ifRequ) {
        this.ifRequ = ifRequ == null ? null : ifRequ.trim();
    }

    /**
     * 获取发布时间
     */
    public OffsetDateTime getPubDate() {
        return pubDate;
    }

    /**
     * 设置发布时间
     */
    public void setPubDate(OffsetDateTime pubDate) {
        this.pubDate = pubDate;
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
