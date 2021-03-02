package com.wisea.cultivar.plant.entity.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.model.annotation.OffsetDateTime2LongStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 消费者查询记录表
 */
@ApiModel("消费者查询记录表")
public class ConsumerQueryRecd extends DataLongEntity<ConsumerQueryRecd> {
    @ApiModelProperty("追溯码")
    private String rtspCode;
    @ApiModelProperty("查询方式（web查询）")
    private String queryMethType;
    @ApiModelProperty("查询ip")
    private String queryIp;
    @ApiModelProperty("查询时间")
    @JsonSerialize(using = OffsetDateTime2LongStrSerializer.class)
    private OffsetDateTime queryDate;
    @ApiModelProperty("批次编号")
    private String batchNum;
    @ApiModelProperty("档案编号")
    private String archNum;

    public String getRtspCode() {
        return rtspCode;
    }

    public void setRtspCode(String rtspCode) {
        this.rtspCode = rtspCode;
    }

    public String getQueryMethType() {
        return queryMethType;
    }

    public void setQueryMethType(String queryMethType) {
        this.queryMethType = queryMethType;
    }

    public String getQueryIp() {
        return queryIp;
    }

    public void setQueryIp(String queryIp) {
        this.queryIp = queryIp;
    }

    public OffsetDateTime getQueryDate() {
        return queryDate;
    }

    public void setQueryDate(OffsetDateTime queryDate) {
        this.queryDate = queryDate;
    }

    public String getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum;
    }

    public String getArchNum() {
        return archNum;
    }

    public void setArchNum(String archNum) {
        this.archNum = archNum;
    }
}
