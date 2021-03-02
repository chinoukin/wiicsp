package com.wisea.cultivar.common.po.tp.product;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 修改技术服务费信息
 * @author: wangs
 * @date :2019/5/17
 */
@ApiModel("修改技术服务费传入参数")
public class UpdateJsSerCostMagePo {

    @ApiModelProperty("技术服务id修改时传递")
    private Long id;

    @ApiModelProperty("技术服务费信息比例")
    @Check(test = "required", requiredMsg = "技术服务费比例不能为空")
    private Double serCost;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSerCost() {
        return serCost;
    }

    public void setSerCost(Double serCost) {
        this.serCost = serCost;
    }
}
