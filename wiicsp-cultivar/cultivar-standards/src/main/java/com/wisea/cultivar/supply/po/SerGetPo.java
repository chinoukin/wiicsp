package com.wisea.cultivar.supply.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author chengq
 * @date 2020/8/15 18:45
 */
public class SerGetPo {

    @ApiModelProperty("服务单id")
    @Check(test = {"required" }, requiredMsg = "服务单id不能为空")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
