package com.wisea.cultivar.common.po.tp.system;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * nmj_ggmj_mage 表实体
 * 糯米蕉挂果面积管理
 * 2019/08/29 17:45:19
 */
public class NmjCsdsMageUpdatePo {
    private static final long serialVersionUID = 1L;
    @JsonSerialize(using = IdSerializer.class)
    private Long id;
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
     * 成熟吨数
     */
    @ApiModelProperty("成熟吨数")
    private Double csDs;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getCsDs() {
        return csDs;
    }

    public void setCsDs(Double csDs) {
        this.csDs = csDs;
    }
}
