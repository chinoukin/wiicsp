package com.wisea.cultivar.common.po.tp.system;

import com.wisea.cultivar.common.vo.tp.system.NmjCsdsMageListVo;
import com.wisea.cloud.model.po.PagePo;
import io.swagger.annotations.ApiModelProperty;

/**
 * nmj_csds_mage 表实体
 * 糯米蕉成熟吨数管理
 * 2019/08/29 17:45:19
 */
public class NmjCsdsMagePagePo extends PagePo<NmjCsdsMageListVo> {
    private static final long serialVersionUID = 1L;

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
