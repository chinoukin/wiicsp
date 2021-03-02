package com.wisea.transac.common.po.trade;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.po.LongIdPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className HandleSissentPo
 * @date 2020/5/18 15:21
 * @Description
 */
@ApiModel("处理对账异议PO")
public class HandleSissentPo extends LongIdPo {
    @ApiModelProperty("订单ID列表")
    @Check(test = "logic", logic = "#isNotEmpty(#ordIds)", logicMsg = "订单不能为空")
    private List<Long> ordIds;

    public List<Long> getOrdIds() {
        return ordIds;
    }

    public void setOrdIds(List<Long> ordIds) {
        this.ordIds = ordIds;
    }
}
