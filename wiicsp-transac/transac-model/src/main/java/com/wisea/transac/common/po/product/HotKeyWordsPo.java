package com.wisea.transac.common.po.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("搜索的关键词")
public class HotKeyWordsPo {

    @ApiModelProperty("id值")
    private Long id;

    @ApiModelProperty("搜搜框的内容")
    private String searchInput;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSearchInput() {
        return searchInput;
    }

    public void setSearchInput(String searchInput) {
        this.searchInput = searchInput;
    }
}
