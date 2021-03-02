package com.wisea.cultivar.plant.entity.oritrapla;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * planting_method 表实体
 * 种植方法
 * 2019/05/27 13:59:47
 */
public class PlantingMethod extends DataLongEntity<PlantingMethod> {
    private static final long serialVersionUID = 1L;

    private Long commId;

    private String plantType;

    private String massifType;

    private Long plantStandardMageId;

    private String sourceType;

    private String farmingCycleId;

    private Long commLevel1Id;

    private Long commLevel2Id;

    public Long getCommLevel1Id() {
        return commLevel1Id;
    }

    public void setCommLevel1Id(Long commLevel1Id) {
        this.commLevel1Id = commLevel1Id;
    }

    public Long getCommLevel2Id() {
        return commLevel2Id;
    }

    public void setCommLevel2Id(Long commLevel2Id) {
        this.commLevel2Id = commLevel2Id;
    }

    public String getFarmingCycleId() {
        return farmingCycleId;
    }

    public void setFarmingCycleId(String farmingCycleId) {
        this.farmingCycleId = farmingCycleId;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public String getPlantType() {
        return plantType;
    }

    public void setPlantType(String plantType) {
        this.plantType = plantType == null ? null : plantType.trim();
    }

    public String getMassifType() {
        return massifType;
    }

    public void setMassifType(String massifType) {
        this.massifType = massifType == null ? null : massifType.trim();
    }

    public Long getPlantStandardMageId() {
        return plantStandardMageId;
    }

    public void setPlantStandardMageId(Long plantStandardMageId) {
        this.plantStandardMageId = plantStandardMageId;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType == null ? null : sourceType.trim();
    }
}
