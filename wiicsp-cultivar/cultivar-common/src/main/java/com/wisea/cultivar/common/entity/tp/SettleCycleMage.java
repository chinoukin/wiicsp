package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * settle_cycle_mage 表实体
 * 结算周期管理
 * 2018/10/18 17:17:58
 */
public class SettleCycleMage extends DataLongEntity<SettleCycleMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 结算周期类型
     */
    private String settleCycleType;

    /**
     * 最晚付款日期
     */
    private Integer theLatestPayDate;

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
}
