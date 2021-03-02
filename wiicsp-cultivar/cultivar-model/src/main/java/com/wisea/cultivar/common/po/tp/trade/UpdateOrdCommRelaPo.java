package com.wisea.cultivar.common.po.tp.trade;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className UpdateOrdCommRelaPo
 * @date 2019/1/16 9:50
 * @Description 修改订单商品Po
 */
@ApiModel("修改订单商品Po")
public class UpdateOrdCommRelaPo {
    @Check(test = "required")
    @ApiModelProperty("订单商品ID")
    private Long id;
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty("商品单价")
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
