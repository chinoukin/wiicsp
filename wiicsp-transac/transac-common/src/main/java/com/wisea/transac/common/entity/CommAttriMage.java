package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class CommAttriMage extends DataLongEntity<CommAttriMage> {
    /**
     * 属性名称
     */
    private String commAttriName;

    /**
     * 属性字段
     */
    private String commAttriColumn;

    /**
     * 属性类型
     */
    private String commAttriType;

    /**
     * 长度
     */
    private Integer length;

    /**
     * 商品属性状态（有效、无效）
     */
    private String effeInvalState;

    /**
     * 小数位
     */
    private Integer decimalDig;

    /**
     * 最大值
     */
    private Double maxVal;

    /**
     * 最小值
     */
    private Double minVal;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 字典值
     */
    private String dictVal;

    public String getCommAttriName() {
        return commAttriName;
    }

    public void setCommAttriName(String commAttriName) {
        this.commAttriName = commAttriName;
    }

    public String getCommAttriColumn() {
        return commAttriColumn;
    }

    public void setCommAttriColumn(String commAttriColumn) {
        this.commAttriColumn = commAttriColumn;
    }

    public String getCommAttriType() {
        return commAttriType;
    }

    public void setCommAttriType(String commAttriType) {
        this.commAttriType = commAttriType;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getEffeInvalState() {
        return effeInvalState;
    }

    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState;
    }

    public Integer getDecimalDig() {
        return decimalDig;
    }

    public void setDecimalDig(Integer decimalDig) {
        this.decimalDig = decimalDig;
    }

    public Double getMaxVal() {
        return maxVal;
    }

    public void setMaxVal(Double maxVal) {
        this.maxVal = maxVal;
    }

    public Double getMinVal() {
        return minVal;
    }

    public void setMinVal(Double minVal) {
        this.minVal = minVal;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getDictVal() {
        return dictVal;
    }

    public void setDictVal(String dictVal) {
        this.dictVal = dictVal;
    }
}
