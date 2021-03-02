package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * MeasUnitMageListPo
 * 2018/09/18 14:36:47
 */
public class MeasUnitMageListPo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 序号
     */
    @ApiModelProperty(value = "计量单位序号")
    private String unitNum;

    /**
     * 计量单位名称
     */
    @ApiModelProperty(value = "计量单位名称")
    private String measUnitName;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private String sort;

    /**
     * 计量单位状态（有效、无效）
     */
    @ApiModelProperty(value = "计量单位状态（有效、无效）")
    private String effeInvalState;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    public String getUnitNum() {
        return unitNum;
    }

    public void setUnitNum(String unitNum) {
        this.unitNum = unitNum;
    }

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
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

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}
