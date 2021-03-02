package com.wisea.cultivar.common.vo.tp.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 包含品种返回值
 * @author: wangs
 * @date :2019/5/29
 */
@ApiModel("品种返回参数")
public class AvailableQuantityVo {

    @ApiModelProperty("品种数量")
    private Integer quantityCount;

    public Integer getQuantityCount() {
        return quantityCount;
    }

    public void setQuantityCount(Integer quantityCount) {
        this.quantityCount = quantityCount;
    }
}
