package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * FarmingStageGetPo
 * 2019/05/27 13:59:47
 */
public class FarmingStageGetPo {
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="id")
    @Check(test = "required")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
