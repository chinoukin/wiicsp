package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * sub_entp_video_info_mage 表实体
 * 分公司视频信息维护
 * 2019/12/02 11:02:15
 */
public class SubEntpVideoInfoMage extends DataLongEntity<SubEntpVideoInfoMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 分公司id
     */
    private Long subEntpId;

    /**
     * 视频名称
     */
    private String videoName;

    /**
     * 视频地址
     */
    private String videoUrl;

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
}
