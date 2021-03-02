package com.wisea.transac.common.vo.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className ApPayMageCountVo
 * @date 2020/5/12 14:46
 * @Description
 */
@ApiModel("结算单角标Vo")
public class SettleBillCountVo {
    @ApiModelProperty("待对账角标")
    private Integer recoCount;
    @ApiModelProperty("冻结角标")
    private Integer invoicCount;
    @ApiModelProperty("待结算角标")
    private Integer settledCount;
    @ApiModelProperty("逾期角标")
    private Integer overdue;

    public Integer getRecoCount() {
        return recoCount;
    }

    public void setRecoCount(Integer recoCount) {
        this.recoCount = recoCount;
    }

    public Integer getInvoicCount() {
        return invoicCount;
    }

    public void setInvoicCount(Integer invoicCount) {
        this.invoicCount = invoicCount;
    }

    public Integer getSettledCount() {
        return settledCount;
    }

    public void setSettledCount(Integer settledCount) {
        this.settledCount = settledCount;
    }

    public Integer getOverdue() {
        return overdue;
    }

    public void setOverdue(Integer overdue) {
        this.overdue = overdue;
    }
}
