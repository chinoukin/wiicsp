package com.wisea.cultivar.plant.po.oritrapla;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className HealthCheckPo
 * @date 2020/8/11 17:30
 * @Description
 */
public class HealthCheckPo {
    @ApiModelProperty("品类ID")
    private Long commId;
    @ApiModelProperty("空气温度")
    private Double temperature;
    @ApiModelProperty("空气湿度")
    private Double humidity;

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
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
}
