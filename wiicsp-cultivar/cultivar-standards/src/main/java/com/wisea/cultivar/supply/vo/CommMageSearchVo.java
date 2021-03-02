package com.wisea.cultivar.supply.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author chengq
 * @date 2020/8/15 18:26
 */
public class CommMageSearchVo {

    @ApiModelProperty("分类id")
    @JsonSerialize(using = IdSerializer.class)
    private Long id;

    @ApiModelProperty("名称")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommMageSearchVo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CommMageSearchVo() {
    }
}
