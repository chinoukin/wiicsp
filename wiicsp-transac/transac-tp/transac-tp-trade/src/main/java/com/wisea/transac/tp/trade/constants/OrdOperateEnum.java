package com.wisea.transac.tp.trade.constants;

/**
 * @author jirg
 * @version 1.0
 * @className OrdOperateEnum
 * @date 2020/5/6 16:57
 * @Description 订单操作记录节点
 */
public enum OrdOperateEnum {
    SUBMIT("submit", "买家提交订单"),
    CONFIRMORD("confirmOrd", "卖家确认订单"),
    PAY("pay", "买家支付订单"),
    DELIVE("delive", "卖家订单发货"),
    DELIVERY("delivery", "买家提货"),
    PROPOSECANCEL("proposeCancel", "买家提出取消订单申请"),
    CANCEL("cancel", "买家取消订单"),
    REJECTCANCEL("rejectCancel", "卖家拒绝取消申请"),
    ASSENTCANCEL("assentCancel", "卖家同意取消申请"),
    TIMEOUTDELIVERY("timeoutDelivery", "订单自提超时"),
    TIMEOUTCONFIRM("timeoutConfirm", "订单待确认超时"),
    TIMEOUTPAY("timeoutPay", "订单代付款超时"),
    INVOICING("invoicing", "卖家开票"),
    RENEWINVOICING("renewInvoicing", "卖家重新开票"),
    DISPUTEHANDLE("disputeHandle", "处理争议订单");

    private String operate;
    private String description;

    OrdOperateEnum(String operate, String description) {
        this.operate = operate;
        this.description = description;
    }

    public String operate() {
        return operate;
    }

    public String description() {
        return description;
    }
}
