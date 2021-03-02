package com.wisea.cultivar.explorer.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * proce_entp_video 表实体
 * 加工企业视频
 * 2020/08/27 13:47:43
 */
public class ProceEntpVideo extends DataLongEntity<ProceEntpVideo> {
    private static final long serialVersionUID = 1L;

    /**
     * 种植主体id
     */
    private Long entpInfoMageId;

    /**
     * 视频名称
     */
    private String videoName;

    /**
     * 视频链接地址
     */
    private String url;

    /**
     * 排序
     */
    private Integer sort;

    /**
     *
     * @mbg.generated
     */
    public ProceEntpVideo() {
        super();
    }

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

    /**
     * 获取视频链接地址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置视频链接地址
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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
}
