package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * CommAttriMageGetPo
 * 2018/09/18 14:36:47
 */
public class CommAttriMageGetPo {
    /**
     * 属性ID
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="属性ID")
    @Check(test = "required")
    private Long id;

    /**
     * 获取属性ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置属性ID
     */
    public void setId(Long id) {
        this.id = id;
    }
}
