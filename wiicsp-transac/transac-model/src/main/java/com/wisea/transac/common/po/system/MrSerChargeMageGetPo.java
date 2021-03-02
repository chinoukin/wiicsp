package com.wisea.transac.common.po.system;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @author: wangs
 * @date :2019/5/15
 */
@ApiModel("编辑id")
public class MrSerChargeMageGetPo {

    @ApiModelProperty("编辑传递id")
    @Check(test = "required", requiredMsg = "默认服务费不能为空")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
