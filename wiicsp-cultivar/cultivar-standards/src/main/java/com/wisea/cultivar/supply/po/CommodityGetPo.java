package com.wisea.cultivar.supply.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * 商品列表
 * @author chengq
 * @date 2020/8/12 17:53
 */
public class CommodityGetPo {

    /**
     * 商品id
     */
    @ApiModelProperty(value = "商品id", required = true)
    @Check(test = {"required" }, requiredMsg = "商品id不能为空")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
