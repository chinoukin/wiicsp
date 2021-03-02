package com.wisea.cultivar.plant.entity.oritrapla;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.util.List;

/**
 * farming_stage 表实体
 * 农事阶段
 * 2019/05/27 13:59:47
 */
public class FarmingStage extends DataLongEntity<FarmingStage> {
    private static final long serialVersionUID = 1L;

    private Long farmingCycleId;

    private Integer startDays;

    private Integer endDays;

    private Long farmWorkTypeId;

    private String farmingRequire;

    private String videoUrl;

    private String usAgriculturalMaterials;

    private String cycleInterval;

    private List<StagePicture> stagePicture;

    /**
     * 多级的农事类型分类
     */
    private Long[] farmWorkTypeIds;

    private String farmWorkTypeName;

    public String getFarmWorkTypeName() {
        return farmWorkTypeName;
    }

    public void setFarmWorkTypeName(String farmWorkTypeName) {
        this.farmWorkTypeName = farmWorkTypeName;
    }

    public Long[] getFarmWorkTypeIds() {
        return farmWorkTypeIds;
    }

    public void setFarmWorkTypeIds(Long[] farmWorkTypeIds) {
        this.farmWorkTypeIds = farmWorkTypeIds;
    }

    public List<StagePicture> getStagePicture() {
        return stagePicture;
    }

    public void setStagePicture(List<StagePicture> stagePicture) {
        this.stagePicture = stagePicture;
    }

    public Long getFarmingCycleId() {
        return farmingCycleId;
    }

    public void setFarmingCycleId(Long farmingCycleId) {
        this.farmingCycleId = farmingCycleId;
    }

    public Integer getStartDays() {
        return startDays;
    }

    public void setStartDays(Integer startDays) {
        this.startDays = startDays;
    }

    public Integer getEndDays() {
        return endDays;
    }

    public void setEndDays(Integer endDays) {
        this.endDays = endDays;
    }

    public Long getFarmWorkTypeId() {
        return farmWorkTypeId;
    }

    public void setFarmWorkTypeId(Long farmWorkTypeId) {
        this.farmWorkTypeId = farmWorkTypeId;
    }

    public String getFarmingRequire() {
        return farmingRequire;
    }

    public void setFarmingRequire(String farmingRequire) {
        this.farmingRequire = farmingRequire == null ? null : farmingRequire.trim();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public String getUsAgriculturalMaterials() {
        return usAgriculturalMaterials;
    }

    public void setUsAgriculturalMaterials(String usAgriculturalMaterials) {
        this.usAgriculturalMaterials = usAgriculturalMaterials == null ? null : usAgriculturalMaterials.trim();
    }

    public String getCycleInterval() {
        return cycleInterval;
    }

    public void setCycleInterval(String cycleInterval) {
        this.cycleInterval = cycleInterval == null ? null : cycleInterval.trim();
    }
}
