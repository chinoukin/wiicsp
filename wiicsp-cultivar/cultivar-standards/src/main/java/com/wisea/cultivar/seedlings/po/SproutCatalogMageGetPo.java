package com.wisea.cultivar.seedlings.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.seedlings.vo.SproutCatalogMageGetVo;
import io.swagger.annotations.ApiModelProperty;

/**
 * SproutCatalogMageGetPo
 * 2020/08/06 14:19:24
 */
public class SproutCatalogMageGetPo extends PagePo<SproutCatalogMageGetVo> {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value="id")
    private Long id;

    /**
     * 年份
     */
    @ApiModelProperty(value = "年份")
    private Integer sproutYear;

    /**
     * 种苗目录状态类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "种苗目录状态类型", allowableValues = "mixLength:(,5]")
    private String sproutCatalogStateType;

    public Integer getSproutYear() {
        return sproutYear;
    }

    public void setSproutYear(Integer sproutYear) {
        this.sproutYear = sproutYear;
    }

    public String getSproutCatalogStateType() {
        return sproutCatalogStateType;
    }

    public void setSproutCatalogStateType(String sproutCatalogStateType) {
        this.sproutCatalogStateType = sproutCatalogStateType;
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
