package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className MonitrLiveStatisticsPo
 * @date 2019/2/28 11:03
 * @Description 设备周、月、年统计Po
 */
@ApiModel("设备周、月、年统计Po")
public class MonitrLiveStatisticsPo {
    @ApiModelProperty("设备ID")
    @Check(test = "required")
    private Long equId;
    @ApiModelProperty("统计维度标签0 周、 1 最近30天、 2 最近一年、3 当天")
    @Check(test = {"required", "liveable"}, liveable = {"0", "1", "2","3"})
    private String statisticsFlag;

    @ApiModelProperty(value = "查询开始时间", hidden = true)
    private OffsetDateTime startDate;
    @ApiModelProperty(value = "查询结束时间", hidden = true)
    private OffsetDateTime endDate;


    public Long getEquId() {
        return equId;
    }

    public void setEquId(Long equId) {
        this.equId = equId;
    }

    public String getStatisticsFlag() {
        return statisticsFlag;
    }

    public void setStatisticsFlag(String statisticsFlag) {
        this.statisticsFlag = statisticsFlag;
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
