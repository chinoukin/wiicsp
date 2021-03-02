package com.wisea.transac.common.vo.system;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author wangjiahao
 * @since 2020/5/11 10:22 上午
 */
@ApiModel("批发市场排名Vo")
public class MarketRankVo {

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty("市场ID")
    private Long id;

    @ApiModelProperty("市场名称")
    private String name;

    @ApiModelProperty("成交量")
    private Long orderCount;

    @ApiModelProperty("成交金额")
    private String totalAmount;

    @ApiModelProperty("入驻商铺数量")
    private Long shopCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Long orderCount) {
        this.orderCount = orderCount;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getShopCount() {
        return shopCount;
    }

    public void setShopCount(Long shopCount) {
        this.shopCount = shopCount;
    }
}
