package com.wisea.cultivar.common.po.tp.lta;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @author: wangs
 * @date :2019/5/7
 */
@ApiModel("商品编辑id")
public class LtaCommRelaGetPo {

    @ApiModelProperty("商品编辑传递id")
    @Check(test = "required", requiredMsg = "商品id不能为空")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
