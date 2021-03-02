package com.wisea.transac.common.po.trade;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className OutstandingBillInfoPo
 * @date 2020/5/19 16:08
 * @Description 未出账单详细信息PO
 */
@ApiModel("未出账单详细信息PO")
public class OutstandingBillInfoPo {
    @ApiModelProperty("卖家ID")
    @Check(test = "required")
    private Long sellerId;
    @ApiModelProperty("买家ID")
    @Check(test = "required")
    private Long buyerId;

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }
}
