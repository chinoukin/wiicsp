package com.wisea.transac.common.po.system;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 删除默认服务费的传递参数
 * @author: wangs
 * @date :2019/5/15
 */
public class MrSerChargeStatePo {

    /**
     * 删除记录的id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    @Check(test = "required")
    private Long id;

    /**
     * 状态标识
     */
    @ApiModelProperty("状态标识,预留不用传递")
    private String stateType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStateType() {
        return stateType;
    }

    public void setStateType(String stateType) {
        this.stateType = stateType;
    }
}
