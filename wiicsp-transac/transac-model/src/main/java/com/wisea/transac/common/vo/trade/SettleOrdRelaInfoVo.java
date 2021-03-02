package com.wisea.transac.common.vo.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className SettleOrdRelaInfoVo
 * @date 2020/5/15 9:23
 * @Description 账期订单信息
 */
@ApiModel("账期订单Vo")
public class SettleOrdRelaInfoVo{
    @ApiModelProperty("订单id")
    private Long ordId;
    @ApiModelProperty("结算金额")
    private Double amount;
    @ApiModelProperty("订单编号")
    private String ordNum;
    @ApiModelProperty("订单金额")
    private Double ordAmount;
    @ApiModelProperty("退款金额")
    private Double refundAmount;
    @ApiModelProperty("退款id")
    private Long refundId;
    @ApiModelProperty("卖家id")
    private Long sellerId;

    public Long getOrdId() {
        return ordId;
    }

    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getRefundId() {
        return refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public Double getOrdAmount() {
        return ordAmount;
    }

    public void setOrdAmount(Double ordAmount) {
        this.ordAmount = ordAmount;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }
}
