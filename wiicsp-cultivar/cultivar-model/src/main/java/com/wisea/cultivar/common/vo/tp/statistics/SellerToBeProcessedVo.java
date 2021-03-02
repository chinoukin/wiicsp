package com.wisea.cultivar.common.vo.tp.statistics;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 卖家待处理事项Vo
 */
@ApiModel("卖家待处理事项Vo")
public class SellerToBeProcessedVo {
    /*******普通订单*******/
    @ApiModelProperty("【普通订单】待确认订单")
    private Integer pendingConfirmOrderCount;
    @ApiModelProperty("【普通订单】待发货订单")
    private Integer pendingShipmentOrderCount;
    @ApiModelProperty("【普通订单】待处理退款申请")
    private Integer refundApplCount;
    @ApiModelProperty("【普通订单】待处理退货申请")
    private Integer refundCommApplCount;
    @ApiModelProperty("【普通订单】待处开票数量")
    private Integer ordInvoCount;

    /*******长期合同*******/
    @ApiModelProperty("【长期合同】待确认合同")
    private Integer pendingConfirmLtaContCount;
    @ApiModelProperty("【长期合同】终止合同申请")
    private Integer pendingTerminationLtaContCount;
    @ApiModelProperty("【长期合同】待确认订单")
    private Integer pendingConfirmLtaOrderCount;
    @ApiModelProperty("【长期合同】待发货订单")
    private Integer pendingShipmentLtaOrderCount;
    @ApiModelProperty("【长期合同】待处理退款申请")
    private Integer ltaRefundApplCount;
    @ApiModelProperty("【长期合同】待处理退货申请")
    private Integer ltaRefundCommApplCount;
    @ApiModelProperty("【长期合同】待处开票数量")
    private Integer ltaOrdInvoCount;

    /*******长期合同*******/
    @ApiModelProperty("【其它事务】逾期账单数量")
    private Integer overdueSettleBillCount;
    @ApiModelProperty("【其它事务】账期待开票数量")
    private Integer settleBillInvoCount;


    public Integer getPendingConfirmOrderCount() {
        return pendingConfirmOrderCount;
    }

    public void setPendingConfirmOrderCount(Integer pendingConfirmOrderCount) {
        this.pendingConfirmOrderCount = pendingConfirmOrderCount;
    }

    public Integer getPendingShipmentOrderCount() {
        return pendingShipmentOrderCount;
    }

    public void setPendingShipmentOrderCount(Integer pendingShipmentOrderCount) {
        this.pendingShipmentOrderCount = pendingShipmentOrderCount;
    }

    public Integer getRefundApplCount() {
        return refundApplCount;
    }

    public void setRefundApplCount(Integer refundApplCount) {
        this.refundApplCount = refundApplCount;
    }

    public Integer getRefundCommApplCount() {
        return refundCommApplCount;
    }

    public void setRefundCommApplCount(Integer refundCommApplCount) {
        this.refundCommApplCount = refundCommApplCount;
    }

    public Integer getOrdInvoCount() {
        return ordInvoCount;
    }

    public void setOrdInvoCount(Integer ordInvoCount) {
        this.ordInvoCount = ordInvoCount;
    }

    public Integer getPendingConfirmLtaContCount() {
        return pendingConfirmLtaContCount;
    }

    public void setPendingConfirmLtaContCount(Integer pendingConfirmLtaContCount) {
        this.pendingConfirmLtaContCount = pendingConfirmLtaContCount;
    }

    public Integer getPendingTerminationLtaContCount() {
        return pendingTerminationLtaContCount;
    }

    public void setPendingTerminationLtaContCount(Integer pendingTerminationLtaContCount) {
        this.pendingTerminationLtaContCount = pendingTerminationLtaContCount;
    }

    public Integer getPendingConfirmLtaOrderCount() {
        return pendingConfirmLtaOrderCount;
    }

    public void setPendingConfirmLtaOrderCount(Integer pendingConfirmLtaOrderCount) {
        this.pendingConfirmLtaOrderCount = pendingConfirmLtaOrderCount;
    }

    public Integer getPendingShipmentLtaOrderCount() {
        return pendingShipmentLtaOrderCount;
    }

    public void setPendingShipmentLtaOrderCount(Integer pendingShipmentLtaOrderCount) {
        this.pendingShipmentLtaOrderCount = pendingShipmentLtaOrderCount;
    }

    public Integer getLtaRefundApplCount() {
        return ltaRefundApplCount;
    }

    public void setLtaRefundApplCount(Integer ltaRefundApplCount) {
        this.ltaRefundApplCount = ltaRefundApplCount;
    }

    public Integer getLtaRefundCommApplCount() {
        return ltaRefundCommApplCount;
    }

    public void setLtaRefundCommApplCount(Integer ltaRefundCommApplCount) {
        this.ltaRefundCommApplCount = ltaRefundCommApplCount;
    }

    public Integer getLtaOrdInvoCount() {
        return ltaOrdInvoCount;
    }

    public void setLtaOrdInvoCount(Integer ltaOrdInvoCount) {
        this.ltaOrdInvoCount = ltaOrdInvoCount;
    }

    public Integer getOverdueSettleBillCount() {
        return overdueSettleBillCount;
    }

    public void setOverdueSettleBillCount(Integer overdueSettleBillCount) {
        this.overdueSettleBillCount = overdueSettleBillCount;
    }

    public Integer getSettleBillInvoCount() {
        return settleBillInvoCount;
    }

    public void setSettleBillInvoCount(Integer settleBillInvoCount) {
        this.settleBillInvoCount = settleBillInvoCount;
    }
}
