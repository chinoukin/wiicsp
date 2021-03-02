package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * dead_line_mage 表实体
 * 期限类型：买家提交订单后，付款期限商家发货后，买家确认收货期限
 * 2018/09/18 14:36:47
 */
public class DeadLineMage extends DataLongEntity<DeadLineMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 期限类型
     */
    private String deadLineType;

    /**
     * 天数限制
     */
    private Integer limitDays;

    /**
     * 获取期限类型
     */
    public String getDeadLineType() {
        return deadLineType;
    }

    /**
     * 设置期限类型
     */
    public void setDeadLineType(String deadLineType) {
        this.deadLineType = deadLineType == null ? null : deadLineType.trim();
    }

    /**
     * 获取天数限制
     */
    public Integer getLimitDays() {
        return limitDays;
    }

    /**
     * 设置天数限制
     */
    public void setLimitDays(Integer limitDays) {
        this.limitDays = limitDays;
    }
}
