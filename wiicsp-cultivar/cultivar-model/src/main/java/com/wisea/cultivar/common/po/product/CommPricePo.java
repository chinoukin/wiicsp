package com.wisea.cultivar.common.po.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.javers.core.metamodel.annotation.DiffInclude;

/**
 * @Description: 商品等级对应的区间价格
 * @author: wangs
 * @date :2020/5/7
 */
@ApiModel("商品等级对应的区间价格")
public class CommPricePo {

    @DiffInclude
    @ApiModelProperty(value = "起批量")
    private String orderStartCount;
    @ApiModelProperty(value = "对应的价格")
    private String price;
    @ApiModelProperty
    private int sort;
    @ApiModelProperty(value = "元/斤")
    private Double netPrice;
    @ApiModelProperty(value = "对应等级规格的id")
    private Long levelSpecQuotetId;

    public Long getLevelSpecQuotetId() {
        return levelSpecQuotetId;
    }

    public void setLevelSpecQuotetId(Long levelSpecQuotetId) {
        this.levelSpecQuotetId = levelSpecQuotetId;
    }

    public Double getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(Double netPrice) {
        this.netPrice = netPrice;
    }

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

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
