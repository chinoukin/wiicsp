package com.wisea.cultivar.common.entity.tp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @author: wangs
 * @date :2018/11/1
 */
@ApiModel("计算商家实付")
public class CommPubCostBuyer {

    @ApiModelProperty("商家输入原价")
    private Double oriPrice;

    public Double getOriPrice() {
        return oriPrice;
    }

    public void setOriPrice(Double oriPrice) {
        this.oriPrice = oriPrice;
    }
}
