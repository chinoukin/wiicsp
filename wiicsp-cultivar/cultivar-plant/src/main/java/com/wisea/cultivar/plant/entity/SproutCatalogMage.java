package com.wisea.cultivar.plant.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class SproutCatalogMage extends DataLongEntity<SproutCatalogMage> {
    /**
     * 种苗目录名称
     */
    private String sproutCatalogName;

    /**
     * 年份
     */
    private Integer sproutYear;

    /**
     * 种苗目录状态类型
     */
    private String sproutCatalogStateType;

    /**
     * 主推品种数
     */
    private Integer mainThrustNum;

    public String getSproutCatalogName() {
        return sproutCatalogName;
    }

    public void setSproutCatalogName(String sproutCatalogName) {
        this.sproutCatalogName = sproutCatalogName;
    }

    public Integer getSproutYear() {
        return sproutYear;
    }

    public void setSproutYear(Integer sproutYear) {
        this.sproutYear = sproutYear;
    }

    public String getSproutCatalogStateType() {
        return sproutCatalogStateType;
    }

    public void setSproutCatalogStateType(String sproutCatalogStateType) {
        this.sproutCatalogStateType = sproutCatalogStateType;
    }

    public Integer getMainThrustNum() {
        return mainThrustNum;
    }

    public void setMainThrustNum(Integer mainThrustNum) {
        this.mainThrustNum = mainThrustNum;
    }
}
