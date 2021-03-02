package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.entity.oritrapla.ConsumerQueryRecd;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * Auth： jirg
 * CreateDate:  2018/6/25
 * projectName:  oritrapla
 * remark:  消费者查询记录列表PO
 */
public class ConsumerQueryRecdPo extends PagePo<ConsumerQueryRecd> {
    @ApiModelProperty(value="【查询key】(0追溯码1:批次编号2:档案编号)")
    private String queryKey;
    @ApiModelProperty("查询条件值")
    private String queryValue;
    @ApiModelProperty("查询开始时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime queryDateStart;
    @ApiModelProperty("查询结束时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime queryDateEnd;
    @ApiModelProperty("查询方式")
    private String queryMethType;

    public String getQueryKey() {
        return queryKey;
    }

    public void setQueryKey(String queryKey) {
        this.queryKey = queryKey;
    }

    public String getQueryValue() {
        return queryValue;
    }

    public void setQueryValue(String queryValue) {
        this.queryValue = queryValue;
    }

    public OffsetDateTime getQueryDateStart() {
        return queryDateStart;
    }

    public void setQueryDateStart(OffsetDateTime queryDateStart) {
        this.queryDateStart = queryDateStart;
    }

    public OffsetDateTime getQueryDateEnd() {
        return queryDateEnd;
    }

    public void setQueryDateEnd(OffsetDateTime queryDateEnd) {
        this.queryDateEnd = queryDateEnd;
    }

    public String getQueryMethType() {
        return queryMethType;
    }

    public void setQueryMethType(String queryMethType) {
        this.queryMethType = queryMethType;
    }
}
