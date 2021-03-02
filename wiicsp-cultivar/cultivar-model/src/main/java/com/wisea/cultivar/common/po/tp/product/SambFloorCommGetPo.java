package com.wisea.cultivar.common.po.tp.product;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @author: wangs
 * @date :2019/5/29
 */
@ApiModel("楼层中编辑传递id")
public class SambFloorCommGetPo {

    @ApiModelProperty("楼层中编辑传递id")
    @Check(test = "required", requiredMsg = "商品id不能为空")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
