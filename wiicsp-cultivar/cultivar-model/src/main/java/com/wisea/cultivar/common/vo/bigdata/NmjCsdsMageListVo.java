package com.wisea.cultivar.common.vo.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * nmj_csds_mage 表实体
 * 糯米蕉成熟吨数管理
 * 2019/08/29 17:45:19
 */
public class NmjCsdsMageListVo {
    private static final long serialVersionUID = 1L;
    @JsonSerialize(using = IdSerializer.class)
    private Long id;
    /**
     * 年份
     */
    @ApiModelProperty("年份")
    private Integer partYear;

    /**
     * 月份
     */
    @ApiModelProperty("月份")
    private Integer month;

    /**
     * 成熟吨数
     */
    @ApiModelProperty("成熟吨数")
    private Double csDs;

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
