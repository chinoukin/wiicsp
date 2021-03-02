package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * StandardSpecificationOptionPo
 * 2019/05/27 13:59:47
 */
public class StandardSpecificationOptionPo{

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品ID")
    @Check(test = "required")
    private Long commId;

    @ApiModelProperty(value = "标准类型，0：无公害，1：有机，2：绿色，3：其它")
    @Check(test = "required")
    private String plantType;

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public String getPlantType() {
        return plantType;
    }

    public void setPlantType(String plantType) {
        this.plantType = plantType;
    }
}
