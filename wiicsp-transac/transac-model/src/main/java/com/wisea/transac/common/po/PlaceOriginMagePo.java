package com.wisea.transac.common.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("新增或修改Po")
public class PlaceOriginMagePo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="产地名称")
    private String placeOriginName;

    @ApiModelProperty(value="排序")
    private Integer sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaceOriginName() {
        return placeOriginName;
    }

    public void setPlaceOriginName(String placeOriginName) {
        this.placeOriginName = placeOriginName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
