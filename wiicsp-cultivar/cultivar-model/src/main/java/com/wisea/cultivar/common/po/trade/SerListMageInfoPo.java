package com.wisea.cultivar.common.po.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName: SerListMageInfoPo
 * @Author: tgz
 * @Date: 2020/8/5 8:56
 */


@ApiModel("服务单查询详情PO")
public class SerListMageInfoPo {

    /***** 服务单信息 *****/
    @ApiModelProperty("服务单ID")
    private Long id;

    @ApiModelProperty("订单状态")
    private String serListStateType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerListStateType() {
        return serListStateType;
    }

    public void setSerListStateType(String serListStateType) {
        this.serListStateType = serListStateType;
    }
}
