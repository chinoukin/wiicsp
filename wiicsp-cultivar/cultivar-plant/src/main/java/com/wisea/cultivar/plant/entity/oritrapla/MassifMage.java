package com.wisea.cultivar.plant.entity.oritrapla;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * 地块管理
 */
public class MassifMage extends DataLongEntity<MassifMage> {
    private Long membId; //会员id
    private String massifName; //地块名称
    private String massifType; //地块类型
    private Double massifAcre; //地块面积
    private Double jd; //地块纬度
    private Double wd; //地块纬度
    private String location; //所在位置

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getMassifName() {
        return massifName;
    }

    public void setMassifName(String massifName) {
        this.massifName = massifName;
    }

    public String getMassifType() {
        return massifType;
    }

    public void setMassifType(String massifType) {
        this.massifType = massifType;
    }

    public Double getMassifAcre() {
        return massifAcre;
    }

    public void setMassifAcre(Double massifAcre) {
        this.massifAcre = massifAcre;
    }

    public Double getJd() {
        return jd;
    }

    public void setJd(Double jd) {
        this.jd = jd;
    }

    public Double getWd() {
        return wd;
    }

    public void setWd(Double wd) {
        this.wd = wd;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
