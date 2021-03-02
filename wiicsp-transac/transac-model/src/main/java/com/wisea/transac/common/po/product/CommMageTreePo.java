package com.wisea.transac.common.po.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 品类传入参数
 */
@ApiModel("查询品类树PO")
public class CommMageTreePo {
    @ApiModelProperty("查询框内容")
    private String query;
    @ApiModelProperty("有效状态")
    private String effeInvalState;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getEffeInvalState() {
        return effeInvalState;
    }

    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState;
    }
}
