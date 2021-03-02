package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * nmj_ggmj_mage 表实体
 * 糯米蕉挂果面积管理
 * 2019/08/29 17:45:19
 */
public class NmjGgmjMage extends DataLongEntity<NmjGgmjMage> {
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
     * 挂果面积
     */
    private Double ggMj;

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
     * 获取挂果面积
     */
    public Double getGgMj() {
        return ggMj;
    }

    /**
     * 设置挂果面积
     */
    public void setGgMj(Double ggMj) {
        this.ggMj = ggMj;
    }
}
