package com.wisea.transac.common.po.trade;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.trade.IncomeListVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("订单统计PO")
public class IncomeListPo extends PagePo<IncomeListVo>{

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商家ID", hidden = true)
    private Long sellerId;
    @ApiModelProperty(value = "开始日期")
    private OffsetDateTime startDate;
    @ApiModelProperty(value = "结束日期")
    private OffsetDateTime endDate;
    @ApiModelProperty(value = "查询条件")
    private String searchKey;

    public Long getSellerId() {
        return sellerId;
    }
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
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
    public String getSearchKey() {
        return searchKey;
    }
    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }
}
