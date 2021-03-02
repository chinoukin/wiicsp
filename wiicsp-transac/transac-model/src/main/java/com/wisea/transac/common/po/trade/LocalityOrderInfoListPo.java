package com.wisea.transac.common.po.trade;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.trade.MerchantOrderInfoListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className LocalityOrderInfoListPo
 * @date 2020/7/3 16:00
 * @Description
 */
@ApiModel("数字基地订单列表PO")
public class LocalityOrderInfoListPo extends PagePo<MerchantOrderInfoListVo> {
    @ApiModelProperty(value = "卖家ID", hidden = true)
    private Long sellerId;
    @ApiModelProperty("订单状态")
    private String orderStateType;
    @ApiModelProperty("查询框内容")
    String query;

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getOrderStateType() {
        return orderStateType;
    }

    public void setOrderStateType(String orderStateType) {
        this.orderStateType = orderStateType;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
