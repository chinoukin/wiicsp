package com.wisea.cultivar.common.po.product;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Author wangs
 * CommPubInfoGetPo
 * 2018/09/18 14:36:47
 */
public class CommPubInfoGetPo {

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    @Check(test = "required")
    private Long id;


    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }
}
