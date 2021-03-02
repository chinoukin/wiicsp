package com.wisea.transac.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("详细信息Vo")
public class TradAreaPictureMageInfoVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="交易区id")
    private Long tradAreaId;

    @ApiModelProperty(value="图片url")
    private String url;

    @ApiModelProperty(value="显示顺序")
    private Integer sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTradAreaId() {
        return tradAreaId;
    }

    public void setTradAreaId(Long tradAreaId) {
        this.tradAreaId = tradAreaId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
