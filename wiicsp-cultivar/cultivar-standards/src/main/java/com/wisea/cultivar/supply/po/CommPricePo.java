package com.wisea.cultivar.supply.po;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 商品价格
 * @author chengq
 * @date 2020/8/13 15:25
 */
public class CommPricePo {

    /**
     * 数量
     */
    @ApiModelProperty("数量")
    @NotNull(message = "数量不能为空")
    private Integer num;

    /**
     * 金额
     */
    @ApiModelProperty("金额")
    @NotNull(message = "金额不能为空")
    private Double price;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
