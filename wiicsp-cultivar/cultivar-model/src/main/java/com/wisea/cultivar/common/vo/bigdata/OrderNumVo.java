package com.wisea.cultivar.common.vo.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel("交易销售量、金额Vo")
public class OrderNumVo {
    @ApiModelProperty("订单数量")
    private Integer orderCount;

    @ApiModelProperty("订单金额")
    @JsonSerialize(using = IdSerializer.class)
    private Long orderAmoun;


    @ApiModelProperty("订单来源")
    private String source;

    public OrderNumVo() {
    }

    public OrderNumVo(Integer orderCount, Long orderAmoun, String source) {
        this.orderCount = orderCount;
        this.orderAmoun = orderAmoun;
        this.source = source;
    }

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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
