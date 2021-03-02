package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * JyOrdMageGetPo
 * 2019/12/02 11:02:14
 */
public class JyOrdMageGetPo {
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
