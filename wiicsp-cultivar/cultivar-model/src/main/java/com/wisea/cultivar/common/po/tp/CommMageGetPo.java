package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * CommMageGetPo
 * 2018/09/18 14:36:47
 */
public class CommMageGetPo {
    /**
     * 商品id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="商品id")
    @Check(test = "required")
    private Long id;

    /**
     * 获取商品id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置商品id
     */
    public void setId(Long id) {
        this.id = id;
    }
}
