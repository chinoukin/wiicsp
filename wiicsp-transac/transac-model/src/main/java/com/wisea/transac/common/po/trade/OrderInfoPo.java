package com.wisea.transac.common.po.trade;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.po.LongIdPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 查询订单详细信息PO
 */
@ApiModel("查询订单详细信息PO")
public class OrderInfoPo extends LongIdPo {
    @ApiModelProperty("当前登录用户类型（0 商家/ 1 买家/ 2 后台/）")
    @Check(test = {"required", "liveable"} , liveable = {"0", "1", "2"}, liveableMsg = "用户类型只能是1、2、3")
    private String queryUserFlag;

    public String getQueryUserFlag() {
        return queryUserFlag;
    }

    public void setQueryUserFlag(String queryUserFlag) {
        this.queryUserFlag = queryUserFlag;
    }
}
