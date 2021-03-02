package com.wisea.cultivar.common.po.tp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className CommMageTreePo
 * @date 2019/1/14 14:04
 * @Description 查询商品分类树PO
 */
@ApiModel("查询商品分类树PO")
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
