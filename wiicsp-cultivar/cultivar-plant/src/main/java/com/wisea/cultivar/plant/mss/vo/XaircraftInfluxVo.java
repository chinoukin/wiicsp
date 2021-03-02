package com.wisea.cultivar.plant.mss.vo;

import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className EquDataPointVo
 * @date 2020/7/13 17:47
 * @Description
 */
public class XaircraftInfluxVo {
    @ApiModelProperty("数据点ID")
    private Long id;
    @ApiModelProperty("设备厂商ID")
    private Long equEntpId;
    @ApiModelProperty("设备型号ID")
    private Long equModelId;
    @ApiModelProperty("设备编号")
    private String equNum;
    @ApiModelProperty("设备id")
    private Long equId;
    @ApiModelProperty("设备数据类型")
    private String equDateType;
    @ApiModelProperty("数据时间")
    protected OffsetDateTime time;

    //极飞数据点字段（FM1）
    @ApiModelProperty("空气温度")
    private Double temperature;
    @ApiModelProperty("空气湿度")
    private Double humidity;
    @ApiModelProperty("大气压力")
    private Double pressure;
    @ApiModelProperty("光照强度")
    private Double illumination;
    @ApiModelProperty("电量")
    private Integer battery;
    //以下为极飞图片数据字段
    @ApiModelProperty("图片URL")
    private String image;
    @ApiModelProperty("图片高度")
    private Integer height;
    @ApiModelProperty("图片宽度")
    private Integer width;

    /************Vo字段************/
    @ApiModelProperty("VO字段，X轴显示（仅近七天、近30天有效）")
    private String xaxis;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEquEntpId() {
        return equEntpId;
    }

    public void setEquEntpId(Long equEntpId) {
        this.equEntpId = equEntpId;
    }

    public Long getEquModelId() {
        return equModelId;
    }

    public void setEquModelId(Long equModelId) {
        this.equModelId = equModelId;
    }

    public String getEquNum() {
        return equNum;
    }

    public void setEquNum(String equNum) {
        this.equNum = equNum;
    }

    public Long getEquId() {
        return equId;
    }

    public void setEquId(Long equId) {
        this.equId = equId;
    }

    public String getEquDateType() {
        return equDateType;
    }

    public void setEquDateType(String equDateType) {
        this.equDateType = equDateType;
    }

    public OffsetDateTime getTime() {
        return time;
    }

    public void setTime(OffsetDateTime time) {
        this.time = time;
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

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getIllumination() {
        return illumination;
    }

    public void setIllumination(Double illumination) {
        this.illumination = illumination;
    }

    public Integer getBattery() {
        return battery;
    }

    public void setBattery(Integer battery) {
        this.battery = battery;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getXaxis() {
        return xaxis;
    }

    public void setXaxis(String xaxis) {
        this.xaxis = xaxis;
    }
}
