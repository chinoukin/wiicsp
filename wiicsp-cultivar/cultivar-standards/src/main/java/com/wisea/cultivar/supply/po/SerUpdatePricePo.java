package com.wisea.cultivar.supply.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * 修改价格
 * @author chengq
 * @date 2020/8/15 18:45
 */
public class SerUpdatePricePo {

    @ApiModelProperty("服务单id")
    @Check(test = {"required" }, requiredMsg = "服务单id不能为空")
    private Long id;

    @ApiModelProperty("价格")
    @Check(test = {"required" }, requiredMsg = "价格不能为空")
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
