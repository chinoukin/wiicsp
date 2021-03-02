package com.wisea.cultivar.plant.vo.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.annotation.LongSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.OffsetDateTime;

/**
 * @author wangjiahao
 * @version 1.0
 * @since 2019/8/23 9:18 上午
 */
public class HealthCheckVo implements Serializable {

    @ApiModelProperty("设备ID")
    @JsonSerialize(using= LongSerializer.class)
    private Long equId;

    @ApiModelProperty("病虫害ID")
    @JsonSerialize(using= LongSerializer.class)
    private Long padId;

    @ApiModelProperty("当前持续时间，单位分钟")
    private Long duration;
    @ApiModelProperty("爆发时间，时间限制，单位分钟")
    private Long bfTime;

    @ApiModelProperty("创建时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime createDate;

    @ApiModelProperty("更新时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime updateDate;

    public Long getPadId() {
        return padId;
    }

    public void setPadId(Long padId) {
        this.padId = padId;
    }

    public Long getEquId() {
        return equId;
    }

    public void setEquId(Long equId) {
        this.equId = equId;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getBfTime() {
        return bfTime;
    }

    public void setBfTime(Long bfTime) {
        this.bfTime = bfTime;
    }

    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
    }

    public OffsetDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(OffsetDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
