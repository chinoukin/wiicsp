package com.wisea.cultivar.common.vo.tp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 商品价格信息
 * @author: wangs
 * @date :2018/9/21
 */
@ApiModel("商品价格信息")
public class CommPrice {

    /**
     * 起订量
     */
    @ApiModelProperty("起订量")
    private String orderStartCount;

    /**
     * 价格
     */
    @ApiModelProperty("价格")
    private String price;

    @ApiModelProperty("原始价格")
    private String oriPrice;

    public String getOrderStartCount() {
        return orderStartCount;
    }

    public void setOrderStartCount(String orderStartCount) {
        this.orderStartCount = orderStartCount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOriPrice() {
        return oriPrice;
    }

    public void setOriPrice(String oriPrice) {
        this.oriPrice = oriPrice;
    }
}
