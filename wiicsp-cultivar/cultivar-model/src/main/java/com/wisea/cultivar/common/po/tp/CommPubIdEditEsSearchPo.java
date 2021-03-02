package com.wisea.cultivar.common.po.tp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @author: wangs
 * @date :2019/11/6
 */
@ApiModel("查询全部已上架的商品参数")
public class CommPubIdEditEsSearchPo {

    @ApiModelProperty("状态")
    private String commState;

    public String getCommState() {
        return commState;
    }

    public void setCommState(String commState) {
        this.commState = commState;
    }
}
