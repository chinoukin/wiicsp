package com.wisea.cultivar.common.vo.bigdata;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cultivar.common.vo.product.CommVarietMageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("交易销售量、金额、品种热卖Vo")
public class HeadNumAndSearchVo {

    @ApiModelProperty("总订单数量")
    private Integer orderCounts;

    @ApiModelProperty("总订单金额")
    @JsonSerialize(using = IdSerializer.class)
    private Long orderAmouns;

    @ApiModelProperty("各个平台数据")
    private List<OrderNumVo> orderNumVos;


    @ApiModelProperty("热卖品种")
    private List<String> commVarietMageListVos;

    public Integer getOrderCounts() {
        return orderCounts;
    }

    public void setOrderCounts(Integer orderCounts) {
        this.orderCounts = orderCounts;
    }

    public Long getOrderAmouns() {
        return orderAmouns;
    }

    public void setOrderAmouns(Long orderAmouns) {
        this.orderAmouns = orderAmouns;
    }

    public List<OrderNumVo> getOrderNumVos() {
        return orderNumVos;
    }

    public void setOrderNumVos(List<OrderNumVo> orderNumVos) {
        this.orderNumVos = orderNumVos;
    }

    public List<String> getCommVarietMageListVos() {
        return commVarietMageListVos;
    }

    public void setCommVarietMageListVos(List<String> commVarietMageListVos) {
        this.commVarietMageListVos = commVarietMageListVos;
    }
}
