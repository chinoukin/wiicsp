package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * CommAttriMageInsertPo
 * 2018/09/18 14:36:47
 */
public class CommAttriMageInsertPo {
    /**
     * 属性名称
     */
    @Check(test = { "maxLength" }, mixLength = 32)
    @ApiModelProperty(value = "属性名称")
    private String commAttriName;

    /**
     * 属性字段
     */
    @Check(test = { "maxLength" }, mixLength = 32)
    @ApiModelProperty(value = "属性字段")
    private String commAttriColumn;

    /**
     * 属性类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "属性类型")
    private String commAttriType;

    /**
     * 长度
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "长度")
    private Integer length;

    /**
     * 商品属性状态（有效、无效）
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "商品属性状态（有效、无效）")
    private String effeInvalState;

    /**
     * 小数位
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "小数位")
    private Integer decimalDig;

    /**
     * 最大值
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "最大值")
    private Double maxVal;

    /**
     * 最小值
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "最小值")
    private Double minVal;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 字典值
     */
    @Check(test = { "maxLength" }, mixLength = 65535)
    @ApiModelProperty(value = "字典值")
    private String dictVal;

    /**
     * 获取属性名称
     */
    public String getCommAttriName() {
        return commAttriName;
    }

    /**
     * 设置属性名称
     */
    public void setCommAttriName(String commAttriName) {
        this.commAttriName = commAttriName == null ? null : commAttriName.trim();
    }

    /**
     * 获取属性字段
     */
    public String getCommAttriColumn() {
        return commAttriColumn;
    }

    /**
     * 设置属性字段
     */
    public void setCommAttriColumn(String commAttriColumn) {
        this.commAttriColumn = commAttriColumn == null ? null : commAttriColumn.trim();
    }

    /**
     * 获取属性类型
     */
    public String getCommAttriType() {
        return commAttriType;
    }

    /**
     * 设置属性类型
     */
    public void setCommAttriType(String commAttriType) {
        this.commAttriType = commAttriType == null ? null : commAttriType.trim();
    }

    /**
     * 获取长度
     */
    public Integer getLength() {
        return length;
    }

    /**
     * 设置长度
     */
    public void setLength(Integer length) {
        this.length = length;
    }

    /**
     * 获取商品属性状态（有效、无效）
     */
    public String getEffeInvalState() {
        return effeInvalState;
    }

    /**
     * 设置商品属性状态（有效、无效）
     */
    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState == null ? null : effeInvalState.trim();
    }

    /**
     * 获取小数位
     */
    public Integer getDecimalDig() {
        return decimalDig;
    }

    /**
     * 设置小数位
     */
    public void setDecimalDig(Integer decimalDig) {
        this.decimalDig = decimalDig;
    }

    /**
     * 获取最大值
     */
    public Double getMaxVal() {
        return maxVal;
    }

    /**
     * 设置最大值
     */
    public void setMaxVal(Double maxVal) {
        this.maxVal = maxVal;
    }

    /**
     * 获取最小值
     */
    public Double getMinVal() {
        return minVal;
    }

    /**
     * 设置最小值
     */
    public void setMinVal(Double minVal) {
        this.minVal = minVal;
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
     * 获取字典值
     */
    public String getDictVal() {
        return dictVal;
    }

    /**
     * 设置字典值
     */
    public void setDictVal(String dictVal) {
        this.dictVal = dictVal == null ? null : dictVal.trim();
    }
}
