package com.wisea.cultivar.common.po.tp.trade;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className ComputeAvailableCreditPo
 * @date 2019/6/5 17:50
 * @Description
 */
@ApiModel("计算可用额度Po")
public class ComputeAvailableCreditPo {
    @ApiModelProperty("原始账期授信额度")
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double oldAcctCreditLine;
    @ApiModelProperty("新账期授信额度")
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double acctCreditLine;
    @ApiModelProperty("原始可用额度")
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double availableCredit;

    public Double getOldAcctCreditLine() {
        return oldAcctCreditLine;
    }

    public void setOldAcctCreditLine(Double oldAcctCreditLine) {
        this.oldAcctCreditLine = oldAcctCreditLine;
    }

    public Double getAcctCreditLine() {
        return acctCreditLine;
    }

    public void setAcctCreditLine(Double acctCreditLine) {
        this.acctCreditLine = acctCreditLine;
    }

    public Double getAvailableCredit() {
        return availableCredit;
    }

    public void setAvailableCredit(Double availableCredit) {
        this.availableCredit = availableCredit;
    }
}
