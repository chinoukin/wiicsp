package com.wisea.transac.common.po.system;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @author: wangs
 * @date :2019/5/17
 */
@ApiModel("编辑优惠信息传递参数")
public class YhSerChargeMageGetPo {

    @ApiModelProperty("编辑传递id")
    @Check(test = "required", requiredMsg = "优惠服务费id不能为空")
    @JsonSerialize(using = IdSerializer.class)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
