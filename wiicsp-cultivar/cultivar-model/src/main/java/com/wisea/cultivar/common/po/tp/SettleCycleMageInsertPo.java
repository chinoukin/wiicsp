package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * SettleCycleMageInsertPo
 * 2018/10/18 17:17:58
 */
public class SettleCycleMageInsertPo {
    /**
     * 结算周期类型
     */
    @Check(test = { "maxLength","required" }, mixLength = 5)
    @ApiModelProperty(value = "结算周期类型，0周结，1月结，2双月结")
    private String settleCycleType;

    /**
     * 最晚付款日期
     */
    @Check(test = { "maxLength","required" }, length = 10)
    @ApiModelProperty(value = "最晚付款日期")
    private Integer theLatestPayDate;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 获取结算周期类型
     */
    public String getSettleCycleType() {
        return settleCycleType;
    }

    /**
     * 设置结算周期类型
     */
    public void setSettleCycleType(String settleCycleType) {
        this.settleCycleType = settleCycleType == null ? null : settleCycleType.trim();
    }

    /**
     * 获取最晚付款日期
     */
    public Integer getTheLatestPayDate() {
        return theLatestPayDate;
    }

    /**
     * 设置最晚付款日期
     */
    public void setTheLatestPayDate(Integer theLatestPayDate) {
        this.theLatestPayDate = theLatestPayDate;
    }

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}
