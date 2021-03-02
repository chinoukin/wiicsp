package com.wisea.cultivar.common.vo.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel("交易交收方式分析Vo")
public class OrderSettlement {
    @ApiModelProperty("数量")
    private Integer orderCount;

    @ApiModelProperty("金额")
    @JsonSerialize(using = IdSerializer.class)
    private Long orderAmoun;


    @ApiModelProperty("状态")
    private String type;



    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Long getOrderAmoun() {
        return orderAmoun;
    }

    public void setOrderAmoun(Long orderAmoun) {
        this.orderAmoun = orderAmoun;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
