package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * MeasUnitMageInsertPo
 * 2018/09/18 14:36:47
 */
public class MeasUnitMageInsertPo {
    /**
     * 计量单位名称
     */
    @Check(test = { "maxLength" }, mixLength = 32)
    @ApiModelProperty(value = "计量单位名称")
    private String measUnitName;

    /**
     * 序号
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "计量单位序号")
    private String unitNum;

    /**
     * 排序
     */
    @Check(test = { "maxLength" }, mixLength = 10)
    @ApiModelProperty(value = "排序")
    private String sort;

    /**
     * 计量单位状态（有效、无效）
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "计量单位状态（有效、无效）")
    private String effeInvalState;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    public String getUnitNum() {
        return unitNum;
    }

    public void setUnitNum(String unitNum) {
        this.unitNum = unitNum;
    }

    /**
     * 获取计量单位名称
     */
    public String getMeasUnitName() {
        return measUnitName;
    }

    /**
     * 设置计量单位名称
     */
    public void setMeasUnitName(String measUnitName) {
        this.measUnitName = measUnitName == null ? null : measUnitName.trim();
    }

    /**
     * 获取排序
     */
    public String getSort() {
        return sort;
    }

    /**
     * 设置排序
     */
    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    /**
     * 获取计量单位状态（有效、无效）
     */
    public String getEffeInvalState() {
        return effeInvalState;
    }

    /**
     * 设置计量单位状态（有效、无效）
     */
    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState == null ? null : effeInvalState.trim();
    }

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}
