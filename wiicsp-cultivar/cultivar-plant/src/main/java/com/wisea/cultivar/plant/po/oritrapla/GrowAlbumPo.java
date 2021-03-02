package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className GrowAlbumPo
 * @date 2019/2/25 19:37
 * @Description
 */
@ApiModel("生长相册PO")
public class GrowAlbumPo {
    @ApiModelProperty("设备ID")
    @Check(test = "required")
    private Long equId;
    @ApiModelProperty("开始时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime startDate;
    @ApiModelProperty("结束时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime endDate;

    public Long getEquId() {
        return equId;
    }

    public void setEquId(Long equId) {
        this.equId = equId;
    }

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
    }
}
