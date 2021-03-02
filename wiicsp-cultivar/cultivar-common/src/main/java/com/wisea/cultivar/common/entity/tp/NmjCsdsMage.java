package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * nmj_csds_mage 表实体
 * 糯米蕉成熟吨数管理
 * 2019/08/29 17:45:19
 */
public class NmjCsdsMage extends DataLongEntity<NmjCsdsMage> {
    private static final long serialVersionUID = 1L;
    private String date;
    /**
     * 年份
     */
    private Integer partYear;

    /**
     * 月份
     */
    private Integer month;

    /**
     * 成熟吨数
     */
    private Double csDs;

    /**
     * 获取年份
     */
    public Integer getPartYear() {
        return partYear;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 设置年份
     */
    public void setPartYear(Integer partYear) {
        this.partYear = partYear;
    }

    /**
     * 获取月份
     */
    public Integer getMonth() {
        return month;
    }

    /**
     * 设置月份
     */
    public void setMonth(Integer month) {
        this.month = month;
    }

    /**
     * 获取成熟吨数
     */
    public Double getCsDs() {
        return csDs;
    }

    /**
     * 设置成熟吨数
     */
    public void setCsDs(Double csDs) {
        this.csDs = csDs;
    }
}
