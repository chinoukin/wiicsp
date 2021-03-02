package com.wisea.cultivar.plant.entity.oritrapla;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * stage_picture 表实体
 * 阶段参考图片
 * 2019/05/27 13:59:47
 */
public class StagePicture extends DataLongEntity<StagePicture> {
    private static final long serialVersionUID = 1L;

    private Long farmingStageId;

    private String url;

    private Integer sortIndex;

    public Long getFarmingStageId() {
        return farmingStageId;
    }

    public void setFarmingStageId(Long farmingStageId) {
        this.farmingStageId = farmingStageId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }
}
