package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * video_mage 表实体
 * 视频中心列表管理
 * 2019/08/29 17:45:19
 */
public class VideoMage extends DataLongEntity<VideoMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 标题
     */
    private String title;

    /**
     * 视频来源类型
     */
    private String videoLyType;

    /**
     * 视频url
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
    public String getVideoLyType() {
        return videoLyType;
    }

    /**
     * 设置视频来源类型
     */
    public void setVideoLyType(String videoLyType) {
        this.videoLyType = videoLyType == null ? null : videoLyType.trim();
    }

    /**
     * 获取视频url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置视频url
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
}
