package com.wisea.cultivar.plant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("SproutEntp详细信息Vo")
public class SproutEntpInfoVo {
    @ApiModelProperty(value="种苗目录管理id")
    private Long sproutCatalogMageId;

    @ApiModelProperty(value="服务商id")
    private Long membId;

    public Long getSproutCatalogMageId() {
        return sproutCatalogMageId;
    }

    public void setSproutCatalogMageId(Long sproutCatalogMageId) {
        this.sproutCatalogMageId = sproutCatalogMageId;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }
}
