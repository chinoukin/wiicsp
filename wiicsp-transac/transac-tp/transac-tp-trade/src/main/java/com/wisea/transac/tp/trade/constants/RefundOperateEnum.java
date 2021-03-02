package com.wisea.transac.tp.trade.constants;

/**
 * @author jirg
 * @version 1.0
 * @className OrdOperateEnum
 * @date 2020/5/6 16:57
 * @Description 退款操作记录节点
 */
public enum RefundOperateEnum {
    SUBMIT("submit", "提交退款申请"),
    CANCEL("CANCEL", "买家取消申请"),
    ASSENT("assent", "卖家同意退款申请"),
    REJECT("reject", "卖家拒绝退款申请"),
    DELIVERY("delivery", "卖家提货产生退款");

    private String operate;
    private String description;

    RefundOperateEnum(String operate, String description) {
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
