package com.wisea.cultivar.common.vo.bigdata;

import java.util.List;

/**
 * @author wangjiahao
 * @version 1.0
 * @since 2019/8/28 9:47 上午
 */
public class MassifAndMonitrListVo {

    private Long membId;
    private String orgName;
    private String crop;
    private String massifName;
    private String massifAcre;
    private Long archId;
    private String equNum;
    private Long equId;
    private String equName;
    private String temperature;
    private String atmPress;
    private String co2;
    private String lastDate;
    private String flFx;
    private String fx;
    private String humidity;
    private String intenIllum;
    private String ll;
    private String rainfall;
    private String soilMois;
    private String soilTemper;
    private String trPh;
    private String bfUrl;
    private Double jd;
    private Double wd;

    private List<ArchBasicInfo> archs;

    public List<ArchBasicInfo> getArchs() {
        return archs;
    }

    public void setArchs(List<ArchBasicInfo> archs) {
        this.archs = archs;
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

    public Long getEquId() {
        return equId;
    }

    public void setEquId(Long equId) {
        this.equId = equId;
    }

    public Long getArchId() {
        return archId;
    }

    public void setArchId(Long archId) {
        this.archId = archId;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getMassifName() {
        return massifName;
    }

    public void setMassifName(String massifName) {
        this.massifName = massifName;
    }

    public String getMassifAcre() {
        return massifAcre;
    }

    public void setMassifAcre(String massifAcre) {
        this.massifAcre = massifAcre;
    }

    public String getEquNum() {
        return equNum;
    }

    public void setEquNum(String equNum) {
        this.equNum = equNum;
    }

    public String getEquName() {
        return equName;
    }

    public void setEquName(String equName) {
        this.equName = equName;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getAtmPress() {
        return atmPress;
    }

    public void setAtmPress(String atmPress) {
        this.atmPress = atmPress;
    }

    public String getCo2() {
        return co2;
    }

    public void setCo2(String co2) {
        this.co2 = co2;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    public String getFlFx() {
        return flFx;
    }

    public void setFlFx(String flFx) {
        this.flFx = flFx;
    }

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        this.fx = fx;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getIntenIllum() {
        return intenIllum;
    }

    public void setIntenIllum(String intenIllum) {
        this.intenIllum = intenIllum;
    }

    public String getLl() {
        return ll;
    }

    public void setLl(String ll) {
        this.ll = ll;
    }

    public String getRainfall() {
        return rainfall;
    }

    public void setRainfall(String rainfall) {
        this.rainfall = rainfall;
    }

    public String getSoilMois() {
        return soilMois;
    }

    public void setSoilMois(String soilMois) {
        this.soilMois = soilMois;
    }

    public String getSoilTemper() {
        return soilTemper;
    }

    public void setSoilTemper(String soilTemper) {
        this.soilTemper = soilTemper;
    }

    public String getTrPh() {
        return trPh;
    }

    public void setTrPh(String trPh) {
        this.trPh = trPh;
    }

    public String getBfUrl() {
        return bfUrl;
    }

    public void setBfUrl(String bfUrl) {
        this.bfUrl = bfUrl;
    }
}
