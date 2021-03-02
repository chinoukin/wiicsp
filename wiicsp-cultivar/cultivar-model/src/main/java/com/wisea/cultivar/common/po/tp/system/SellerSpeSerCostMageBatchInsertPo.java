package com.wisea.cultivar.common.po.tp.system;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * SellerSpeSerCostMageBatchInsertPo
 * 2019/01/14 13:49:31
 */
public class SellerSpeSerCostMageBatchInsertPo {

    @ApiModelProperty("特殊服务费插入列表")
    private List<SellerSpeSerCostMageInsertPo> list;

    public List<SellerSpeSerCostMageInsertPo> getList() {
        return list;
    }

    public void setList(List<SellerSpeSerCostMageInsertPo> list) {
        this.list = list;
    }
}
