package com.wisea.cultivar.common.po.tp;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * SettleBillOpreateInfoInsertPo
 * 2018/10/13 17:14:52
 */
public class SettleBillSendInvoInsertPo {

    /**
     * 结算单和发票相关信息
     */
    @ApiModelProperty(value = "结算单和发票相关信息")
    private List<SettleInvoOperatInfo> info;

    @ApiModelProperty(value = "企业银行账户")
    private String entpBankNum;

    @ApiModelProperty(value = "开户行")
    private String openBank;

    public String getEntpBankNum() {
        return entpBankNum;
    }

    public void setEntpBankNum(String entpBankNum) {
        this.entpBankNum = entpBankNum;
    }

    public String getOpenBank() {
        return openBank;
    }

    public void setOpenBank(String openBank) {
        this.openBank = openBank;
    }

    public List<SettleInvoOperatInfo> getInfo() {
        return info;
    }

    public void setInfo(List<SettleInvoOperatInfo> info) {
        this.info = info;
    }
}
