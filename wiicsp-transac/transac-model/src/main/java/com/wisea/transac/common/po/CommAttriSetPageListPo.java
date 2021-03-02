package com.wisea.transac.common.po;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.CommAttriSetPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询Po")
public class CommAttriSetPageListPo extends PagePo<CommAttriSetPageListVo> {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="商品id")
    private Long commId;

    @ApiModelProperty(value="属性ID")
    private Long attriId;

    @ApiModelProperty(value="是否必填")
    private String ifRequ;

    @ApiModelProperty(value="搜索条件")
    private String ifSearch;

    @ApiModelProperty(value="显示顺序")
    private Integer sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public Long getAttriId() {
        return attriId;
    }

    public void setAttriId(Long attriId) {
        this.attriId = attriId;
    }

    public String getIfRequ() {
        return ifRequ;
    }

    public void setIfRequ(String ifRequ) {
        this.ifRequ = ifRequ;
    }

    public String getIfSearch() {
        return ifSearch;
    }

    public void setIfSearch(String ifSearch) {
        this.ifSearch = ifSearch;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
