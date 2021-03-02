package com.wisea.transac.common.vo.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @author: wangs
 * @date :2020/5/28
 */
@ApiModel("商品类目销售top10")
public class CommdityCategoriesVo {

    @ApiModelProperty(value = "分类名称")
    private String commSetName;
    @ApiModelProperty(value = "销售数量")
    private Double saleCount;
    @ApiModelProperty(value = "数量比例")
    private Integer salesScale;
    @ApiModelProperty(value = "销售金额")
    private Double saleNum;
    @ApiModelProperty(value = "金额比例")
    private Integer amountScale;

    public String getCommSetName() {
        return commSetName;
    }

    public void setCommSetName(String commSetName) {
        this.commSetName = commSetName;
    }

    public Double getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Double saleCount) {
        this.saleCount = saleCount;
    }

    public Integer getSalesScale() {
        return salesScale;
    }

    public void setSalesScale(Integer salesScale) {
        this.salesScale = salesScale;
    }

    public Double getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Double saleNum) {
        this.saleNum = saleNum;
    }

    public Integer getAmountScale() {
        return amountScale;
    }

    public void setAmountScale(Integer amountScale) {
        this.amountScale = amountScale;
    }
}
