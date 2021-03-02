package com.wisea.transac.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("通用信息详细信息Vo")
public class CommCurrencyInfoInfoVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="内容")
    private String commCurrencyContent;

    public String getCommCurrencyContent() {
        return commCurrencyContent;
    }

    public void setCommCurrencyContent(String commCurrencyContent) {
        this.commCurrencyContent = commCurrencyContent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
