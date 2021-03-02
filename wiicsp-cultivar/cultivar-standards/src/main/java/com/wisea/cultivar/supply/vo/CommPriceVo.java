package com.wisea.cultivar.supply.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 商品价格
 * @author chengq
 * @date 2020/8/13 15:25
 */
public class CommPriceVo {

    /**
     * 数量
     */
    @ApiModelProperty("数量")
    private String num;

    /**
     * 金额
     */
    @ApiModelProperty("金额")
    private String price;

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
