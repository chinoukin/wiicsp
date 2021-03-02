package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

/**
 * @author wangjh
 * @version 1.0
 * @className SettleInvoOperatInfo
 * @since 2018/11/14 14:46
 */
public class SettleInvoOperatInfo {
    @JsonSerialize(using = IdSerializer.class)
    private Long settleId;
    private String amount;
    private String settleNum;

    public Long getSettleId() {
        return settleId;
    }

    public void setSettleId(Long settleId) {
        this.settleId = settleId;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSettleNum() {
        return settleNum;
    }

    public void setSettleNum(String settleNum) {
        this.settleNum = settleNum;
    }
}
