package com.wisea.cultivar.standards.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * StandardMageGetPo
 * 2020/07/24 11:21:45
 */
public class StandardMageGetPo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="id")
    @Check(test = "required")
    private Long id;

    /**
     * 种植采收加工标准类型
     */
    @ApiModelProperty(value = "种植采收加工标准类型")
    @Check(test = "required")
    private String plantRecoProcessType;

    public String getPlantRecoProcessType() {
        return plantRecoProcessType;
    }

    public void setPlantRecoProcessType(String plantRecoProcessType) {
        this.plantRecoProcessType = plantRecoProcessType;
    }

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
