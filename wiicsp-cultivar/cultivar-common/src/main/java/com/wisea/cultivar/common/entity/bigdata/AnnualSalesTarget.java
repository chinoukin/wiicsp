package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;

public class AnnualSalesTarget extends DataLongEntity<AnnualSalesTarget> {
    /**
     * 年份
     */
    private String year;

    /**
     * 目标销售额（亿）
     */
    private Double salesTarget;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Double getSalesTarget() {
        return salesTarget;
    }

    public void setSalesTarget(Double salesTarget) {
        this.salesTarget = salesTarget;
    }
}
