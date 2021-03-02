package com.wisea.transac.tp.trade.constants;

/**
 * @author jirg
 * @version 1.0
 * @className OrdOperateEnum
 * @date 2020/5/6 16:57
 * @Description 退款操作记录节点
 */
public enum SettleBillOperateEnum {
    SYSTEM_GENERATE("system_generate", "系统生成结算单"),
    BUYER_GENERATE("BUYER_GENERATE", "买家提前生成结算单"),
    BUYER_RECON("BUYER_RECON", "买家对账完成"),
    SELLER_RECON("BUYER_RECON", "卖家家对账完成"),
    INVOICING("INVOICING", "供应商开票"),
    RENEW_INVOICING("RENEW_INVOICING", "供应重新商开票"),
    BUYER_PAY("BUYER_PAY", "采购商支付"),
    INVO_PASS("INVO_PASS", "验票通过"),
    INVO_DISSENT("INVO_DISSENT", "验票异议"),
    OUTTIME_RECON("OUTTIME_RECON", "对账超时"),
    OUTTIME_INVO_DISSENT("OUTTIME_INVO_DISSENT", "超时未验票"),
    REMIND_PAYMENT("REMIND_PAYMENT", "提醒采购商支付");

    private String operate;
    private String description;

    SettleBillOperateEnum(String operate, String description) {
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
