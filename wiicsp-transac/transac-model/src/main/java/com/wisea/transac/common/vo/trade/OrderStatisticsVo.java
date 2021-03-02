package com.wisea.transac.common.vo.trade;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className OrderStatisticsVo
 * @date 2020/5/26 9:38
 * @Description
 */
public class OrderStatisticsVo {
    @ApiModelProperty("待确认")
    private Integer confirmedCount;
    @ApiModelProperty("待付款")
    private Integer paymentCount;
    @ApiModelProperty("待自提")
    private Integer mentionedCount;
    @ApiModelProperty("退款申请")
    private Integer refundAppCount;

    public Integer getConfirmedCount() {
        return confirmedCount;
    }

    public void setConfirmedCount(Integer confirmedCount) {
        this.confirmedCount = confirmedCount;
    }

    public Integer getPaymentCount() {
        return paymentCount;
    }

    public void setPaymentCount(Integer paymentCount) {
        this.paymentCount = paymentCount;
    }

    public Integer getMentionedCount() {
        return mentionedCount;
    }

    public void setMentionedCount(Integer mentionedCount) {
        this.mentionedCount = mentionedCount;
    }

    public Integer getRefundAppCount() {
        return refundAppCount;
    }

    public void setRefundAppCount(Integer refundAppCount) {
        this.refundAppCount = refundAppCount;
    }
}
