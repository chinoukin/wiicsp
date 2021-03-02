package com.wisea.cultivar.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("商家服务详细信息Vo")
public class AgentSerListInfoVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="图标")
    private String pictureUrl;

    @ApiModelProperty(value="服务简称")
    private String serName;

    @ApiModelProperty(value="服务说明")
    private String serContent;

    @ApiModelProperty(value="显示顺序")
    private Integer sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getSerName() {
        return serName;
    }

    public void setSerName(String serName) {
        this.serName = serName;
    }

    public String getSerContent() {
        return serContent;
    }

    public void setSerContent(String serContent) {
        this.serContent = serContent;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
