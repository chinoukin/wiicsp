package com.wisea.cultivar.seedlings.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * sprout_catalog_mage 表实体
 * 种苗目录管理
 * 2020/08/06 14:19:24
 */
public class SproutCatalogMage extends DataLongEntity<SproutCatalogMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Long id;
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

    /**
     * 选育方式
     */
    private String breedEntp;
    /**
     * 备注
     */
    private String remarks;

    @Override
    public String getRemarks() {
        return remarks;
    }

    @Override
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getBreedEntp() {
        return breedEntp;
    }

    public void setBreedEntp(String breedEntp) {
        this.breedEntp = breedEntp;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

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
