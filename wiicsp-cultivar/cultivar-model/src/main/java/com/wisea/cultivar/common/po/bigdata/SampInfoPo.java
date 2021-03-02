package com.wisea.cultivar.common.po.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @ClassNameSampInfoPo
 * @Description
 * @Author zhangbo
 * @Date2020/9/3 16:15
 **/
public class SampInfoPo {

    @ApiModelProperty(value = "0:最近一年，1：最近一个月")
    private String status;

    @ApiModelProperty(value = "选择时间范围内 时间起")
    @JsonSerialize(
            using = OffsetDateTimeSerializer.class
    )
    @JsonDeserialize(
            using = OffsetDateTimeDeserializer.class
    )
    private OffsetDateTime startTime;

    @ApiModelProperty(value = "选择时间范围内 时间止")
    @JsonSerialize(
            using = OffsetDateTimeSerializer.class
    )
    @JsonDeserialize(
            using = OffsetDateTimeDeserializer.class
    )
    private OffsetDateTime endTime;

    private String cityName;

    private String parentId;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public OffsetDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
    }

    public OffsetDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(OffsetDateTime endTime) {
        this.endTime = endTime;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
