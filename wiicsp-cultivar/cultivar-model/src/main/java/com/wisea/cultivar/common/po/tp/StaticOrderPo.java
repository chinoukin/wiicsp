package com.wisea.cultivar.common.po.tp;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("订单统计PO")
public class StaticOrderPo {

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
    @ApiModelProperty(value = "日期格式", hidden = true)
    private String plat;
    @ApiModelProperty(value = "后台/商家，0商家，1后台")
    private String membFlag;

    public Long getStallsId() {
        return stallsId;
    }
    public void setStallsId(Long stallsId) {
        this.stallsId = stallsId;
    }
    public String getPlat() {
        return plat;
    }
    public void setPlat(String plat) {
        this.plat = plat;
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
