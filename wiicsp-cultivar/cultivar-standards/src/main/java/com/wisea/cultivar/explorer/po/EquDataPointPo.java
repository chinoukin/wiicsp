package com.wisea.cultivar.explorer.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className EquDataPointPo
 * @date 2020/7/9 14:12
 * @Description 查询数据点PO
 */
@ApiModel("查询数据点PO")
public class EquDataPointPo {
    @ApiModelProperty("设备厂商")
    @Check(test = { "required" })
    private Long equEntpId;
    @ApiModelProperty("设备编号")
    @Check(test = { "required" })
    private String equNum;
    @ApiModelProperty("查询开始时间")
    private OffsetDateTime startDate;
    @ApiModelProperty("查询开始时间")
    private OffsetDateTime endDate;

    @ApiModelProperty("统计维度标签0 当天、 1 近7天、 2 近30天")
    private String statisticsFlag;

    public Long getEquEntpId() {
        return equEntpId;
    }

    public void setEquEntpId(Long equEntpId) {
        this.equEntpId = equEntpId;
    }

    public String getEquNum() {
        return equNum;
    }

    public void setEquNum(String equNum) {
        this.equNum = equNum;
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
