package com.wisea.cultivar.common.po.tp.system;

import io.swagger.annotations.ApiModelProperty;

/**
 * nmj_ggmj_mage 表实体
 * 糯米蕉挂果面积管理
 * 2019/08/29 17:45:19
 */
public class NmjGgmjMageInsertPo {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "年月")
    private String date;
    /**
     * 年份
     */
    @ApiModelProperty(value = "年份",hidden = true)
    private Integer partYear;

    /**
     * 月份
     */
    @ApiModelProperty(value = "月份",hidden = true)
    private Integer month;

    /**
     * 挂果面积
     */
    @ApiModelProperty("挂果面积")
    private Double ggMj;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 获取年份
     */
    public Integer getPartYear() {
        return partYear;
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
