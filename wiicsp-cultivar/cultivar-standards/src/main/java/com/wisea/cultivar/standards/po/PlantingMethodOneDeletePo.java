package com.wisea.cultivar.standards.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.standards.vo.PlantingMethodListVo;
import io.swagger.annotations.ApiModelProperty;

/**
 * PlantingMethodPagePo
 * 2020/07/24 11:21:45
 */
public class PlantingMethodOneDeletePo extends PagePo<PlantingMethodListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
