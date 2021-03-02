package com.wisea.cultivar.supply.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author chengq
 * @date 2020/8/16 8:21
 */
public class CommUnitVo {

    /**
     * 单位id
     */
    @ApiModelProperty("单位id")
    @JsonSerialize(using = IdSerializer.class)
    private Long unitId;


    /**
     * 单位名称
     */
    @ApiModelProperty("单位名称")
    private String unitName;

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public CommUnitVo() {
    }

    public CommUnitVo(Long unitId, String unitName) {
        this.unitId = unitId;
        this.unitName = unitName;
    }
}
