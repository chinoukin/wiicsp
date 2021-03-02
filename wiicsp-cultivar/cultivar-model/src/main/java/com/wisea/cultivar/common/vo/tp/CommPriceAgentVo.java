package com.wisea.cultivar.common.vo.tp;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 代理价格信息
 * @author: wangs
 * @date :2018/9/30
 */
public class CommPriceAgentVo {

    /**
     * 价格
     */
    @ApiModelProperty("价格")
    private String price;
    /**
     * 起订量
     */
    @ApiModelProperty("价格")
    private String orderStartCount;

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
}
