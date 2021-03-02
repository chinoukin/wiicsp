package com.wisea.cultivar.standards.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

public class StandardMageOneDeletePo {

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id", required = true)
    private Long id;

    /**
     * 种植采收加工标准类型
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "种植采收加工标准类型")
    @Check(test = "required")
    private String plantRecoProcessType;

    public String getPlantRecoProcessType() {
        return plantRecoProcessType;
    }

    public void setPlantRecoProcessType(String plantRecoProcessType) {
        this.plantRecoProcessType = plantRecoProcessType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
