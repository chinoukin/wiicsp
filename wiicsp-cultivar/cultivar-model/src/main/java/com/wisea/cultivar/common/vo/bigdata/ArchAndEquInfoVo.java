package com.wisea.cultivar.common.vo.bigdata;

import java.io.Serializable;

/**
 * @author wangjiahao
 * @version 1.0
 * @since 2019/9/5 4:11 下午
 */
public class ArchAndEquInfoVo implements Serializable {

    private Long massifId;
    private Long archId;
    private Long equId;
    private String archName;
    private String massifName;
    private String bfUrl;
    private String crop;
    private Double plantAcre;
    private Double massifAcre;

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public Long getMassifId() {
        return massifId;
    }

    public void setMassifId(Long massifId) {
        this.massifId = massifId;
    }

    public Long getArchId() {
        return archId;
    }

    public void setArchId(Long archId) {
        this.archId = archId;
    }

    public Long getEquId() {
        return equId;
    }

    public void setEquId(Long equId) {
        this.equId = equId;
    }

    public String getArchName() {
        return archName;
    }

    public void setArchName(String archName) {
        this.archName = archName;
    }

    public String getMassifName() {
        return massifName;
    }

    public void setMassifName(String massifName) {
        this.massifName = massifName;
    }

    public String getBfUrl() {
        return bfUrl;
    }

    public void setBfUrl(String bfUrl) {
        this.bfUrl = bfUrl;
    }

    public Double getPlantAcre() {
        return plantAcre;
    }

    public void setPlantAcre(Double plantAcre) {
        this.plantAcre = plantAcre;
    }

    public Double getMassifAcre() {
        return massifAcre;
    }

    public void setMassifAcre(Double massifAcre) {
        this.massifAcre = massifAcre;
    }
}
