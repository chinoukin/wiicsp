package com.wisea.cultivar.common.vo.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("监控实况")
public class MonitrLive extends DataLongEntity<MonitrLive> {

    @ApiModelProperty("设备id")
    private Long equId;
    @ApiModelProperty("空气温度")
    private Double temperature;
    @ApiModelProperty("空气湿度")
    private Double humidity;
    @ApiModelProperty("大气压力")
    private Double atmPress;
    @ApiModelProperty("光照强度")
    private Double intenIllum;
    @ApiModelProperty("土壤温度")
    private Double soilTemper;
    @ApiModelProperty("土壤湿度")
    private Double soilMois;
    @ApiModelProperty("风力/风向")
    private Double flFx;
    @ApiModelProperty("降雨量")
    private Double rainfall;

    @ApiModelProperty("二氧化碳")
    private Double co2;
    @ApiModelProperty("土壤PH值")
    private Double trPh;
    @ApiModelProperty("流量")
    private Double ll;
    @ApiModelProperty("风向")
    private String fx;



    /************Vo字段************/
    @ApiModelProperty("VO字段，X轴显示（仅近七天、近30天、近一年有效）")
    private String xaxis;

    public Double getCo2() {
        return co2;
    }

    public void setCo2(Double co2) {
        this.co2 = co2;
    }

    public Double getTrPh() {
        return trPh;
    }

    public void setTrPh(Double trPh) {
        this.trPh = trPh;
    }

    public Double getLl() {
        return ll;
    }

    public void setLl(Double ll) {
        this.ll = ll;
    }

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        this.fx = fx;
    }

    public Long getEquId() {
        return equId;
    }

    public void setEquId(Long equId) {
        this.equId = equId;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getAtmPress() {
        return atmPress;
    }

    public void setAtmPress(Double atmPress) {
        this.atmPress = atmPress;
    }

    public Double getIntenIllum() {
        return intenIllum;
    }

    public void setIntenIllum(Double intenIllum) {
        this.intenIllum = intenIllum;
    }

    public Double getSoilTemper() {
        return soilTemper;
    }

    public void setSoilTemper(Double soilTemper) {
        this.soilTemper = soilTemper;
    }

    public Double getSoilMois() {
        return soilMois;
    }

    public void setSoilMois(Double soilMois) {
        this.soilMois = soilMois;
    }

    public Double getFlFx() {
        return flFx;
    }

    public void setFlFx(Double flFx) {
        this.flFx = flFx;
    }

    public Double getRainfall() {
        return rainfall;
    }

    public void setRainfall(Double rainfall) {
        this.rainfall = rainfall;
    }

    public String getXaxis() {
        return xaxis;
    }

    public void setXaxis(String xaxis) {
        this.xaxis = xaxis;
    }
}
