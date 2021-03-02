package com.wisea.transac.common.po;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.AgentSerListPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("商家服务分页查询Po")
public class AgentSerListPageListPo extends PagePo<AgentSerListPageListVo> {
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
