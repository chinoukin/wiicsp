package com.wisea.transac.common.po.product;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 国外产地新增和编辑信息
 * @author: wangs
 * @date :2019/4/25
 */
public class AbroadMageInsertPo {

    @ApiModelProperty("国外产地ID-修改时使用")
    private Long id;
    @ApiModelProperty("名称")
    @Check(test = "required",requiredMsg = "名称不能为空")
    private String placeOriginName;
    @ApiModelProperty("排序")
    @Check(test = "required",requiredMsg = "排序字段不能为空")
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
