package com.wisea.cultivar.common.po.tp.statistics;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 统计入参PO
 */
public class StatisticsPo {
    @ApiModelProperty("近几天（7天就传7，30天就传30，90天同上）注意：该字段和开始/结束时间互斥")
    @Check(test = "logic", logic = "(#isNotEmpty(#startDate) || #isNotEmpty(#endDate))?#isEmpty(#recentDays):true", logicMsg = "开始时间和结束时间不为空，近几天需要为空")
    private Integer recentDays;
    @ApiModelProperty(value = "开始时间")
    @Check(test = "logic", logic = "#isNotEmpty(#recentDays) ? #isEmpty(#startDate) : true", logicMsg = "近几天不为空，开始时间和结束时间需要为空")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime startDate;
    @ApiModelProperty(value = "结束时间")
    @Check(test = "logic", logic = "#isNotEmpty(#recentDays) ? #isEmpty(#endDate) : true", logicMsg = "近几天不为空，开始时间和结束时间需要为空")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime endDate;

    @ApiModelProperty(value = "卖家ID", hidden = true)
    private Long sellerId;

    public Integer getRecentDays() {
        return recentDays;
    }

    public void setRecentDays(Integer recentDays) {
        this.recentDays = recentDays;
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

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
}
