package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * monthly_distr_trend 表实体
 * 月配送单量趋势
 * 2020/09/02 15:33:51
 */
public class MonthlyDistrTrend extends DataLongEntity<MonthlyDistrTrend> {
    private static final long serialVersionUID = 1L;

    /**
     * 月份
     */
    private String month;

    /**
     * 单量
     */
    private Integer num;

    /**
     *
     * @mbg.generated
     */
    public MonthlyDistrTrend() {
        super();
    }

    /**
     * 获取月份
     */
    public String getMonth() {
        return month;
    }

    /**
     * 设置月份
     */
    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    /**
     * 获取单量
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置单量
     */
    public void setNum(Integer num) {
        this.num = num;
    }
}
