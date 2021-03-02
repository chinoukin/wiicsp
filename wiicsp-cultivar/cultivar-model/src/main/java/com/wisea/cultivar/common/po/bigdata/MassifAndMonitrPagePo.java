package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.bigdata.MassifAndMonitrListVo;

/**
 * @author wangjiahao
 * @version 1.0
 * @since 2019/8/28 9:45 上午
 */
public class MassifAndMonitrPagePo extends PagePo<MassifAndMonitrListVo> {
    private String membId;
    private String massifName;
    private String massifAcre;
    private String equNum;
    private String equName;
    private String equType;
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

    public String getEquType() {
        return equType;
    }

    public void setEquType(String equType) {
        this.equType = equType;
    }

    public String getMembId() {
        return membId;
    }

    public void setMembId(String membId) {
        this.membId = membId;
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
