package com.wisea.cultivar.common.po.trade;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.trade.SerListMageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("服务单查询列表PO")
public class SerListMageListPo extends PagePo<SerListMageListVo> {
    @ApiModelProperty("状态")
    private String serListStateType;
    @ApiModelProperty("输入搜索内容")
    private String query;
    @ApiModelProperty("预约下单开始时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime startDate;
    @ApiModelProperty("预约结束时间")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime endDate;

    public String getSerListStateType() {
        return serListStateType;
    }

    public void setSerListStateType(String serListStateType) {
        this.serListStateType = serListStateType;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
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
