package com.wisea.cultivar.standards.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * stage_picture 表实体
 * 阶段参考图片
 * 2020/07/24 11:21:45
 */
public class StagePicture extends DataLongEntity<StagePicture> {
    private static final long serialVersionUID = 1L;

    /**
     * 农事阶段
     */
    private Long farmingStageId;

    /**
     * url
     */
    private String url;

    /**
     * 排序
     */
    private Integer sortIndex;

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
}
