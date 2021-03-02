package com.wisea.cultivar.portal.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * zhfw_industry_video_list 表实体
 * 种植服务产业视频列表
 * 2020/08/24 20:28:13
 */
public class ZhfwIndustryVideoList extends DataLongEntity<ZhfwIndustryVideoList> {
    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
    private String title;

    /**
     * 视频来源类型
     */
    private String videoSourceType;

    /**
     * 链接地址
     */
    private String url;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     * 是否显示
     */
    private String ifRequ;

    /**
     * 发布时间
     */
    private OffsetDateTime pubDate;

    /**
     *
     * @mbg.generated
     */
    public ZhfwIndustryVideoList() {
        super();
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
}
