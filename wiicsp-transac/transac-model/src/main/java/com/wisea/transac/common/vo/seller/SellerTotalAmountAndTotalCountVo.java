package com.wisea.transac.common.vo.seller;

import io.swagger.annotations.ApiModel;

/**
 * @author wangjiahao
 * @since 2020/4/28 10:41 上午
 */
@ApiModel("卖家总销售额和总订单统计vo")
public class SellerTotalAmountAndTotalCountVo {

    private Double totalAmount;
    private Long totalCount;

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}
