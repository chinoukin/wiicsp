package com.wisea.transac.common.po.trade;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.trade.CgsOrderVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("订单统计PO")
public class StaticOrderPo extends PagePo<CgsOrderVo>{

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "档口ID")
    private Long stallsId;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商家ID", hidden = true)
    private Long sellerId;
    @ApiModelProperty(value = "开始日期")
    private OffsetDateTime startDate;
    @ApiModelProperty(value = "结束日期")
    private OffsetDateTime endDate;
    @ApiModelProperty(value = "订单状态串", hidden = true)
    private String states;
    @ApiModelProperty(value = "后台/商家，0商家，1后台")
    private String membFlag;

    public Long getStallsId() {
        return stallsId;
    }
    public void setStallsId(Long stallsId) {
        this.stallsId = stallsId;
    }
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
    public String getStates() {
        return states;
    }
    public void setStates(String states) {
        this.states = states;
    }
    public String getMembFlag() {
        return membFlag;
    }
    public void setMembFlag(String membFlag) {
        this.membFlag = membFlag;
    }
}
