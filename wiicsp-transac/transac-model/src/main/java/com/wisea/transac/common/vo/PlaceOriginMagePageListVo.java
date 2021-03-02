package com.wisea.transac.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("国外产地分页查询Vo")
public class PlaceOriginMagePageListVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="产地名称")
    private String placeOriginName;

    @ApiModelProperty(value="排序")
    private Integer sort;

    @ApiModelProperty(value="数量")
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

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
