package com.wisea.transac.common.po.product;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @author: wangs
 * @date :2020/7/21
 */
@ApiModel("计算净价传入参数")
public class CommPubNetPrice {

    @ApiModelProperty("净重")
    @Check(test = "required", requiredMsg = "净重不能为空")
    private Double netWeight;
    @Check(test = "required", requiredMsg = "价格不能为空")
    @ApiModelProperty("价格")
    private Double price;
    @ApiModelProperty("多少钱/斤")
    private Double netPrice;

    public Double getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(Double netWeight) {
        this.netWeight = netWeight;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(Double netPrice) {
        this.netPrice = netPrice;
    }
}
