package com.wisea.transac.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("详细信息Vo")
public class CommAttriMageInfoVo {
    @ApiModelProperty(value="属性id")
    private Long id;

    @ApiModelProperty(value="属性名称")
    private String commAttriName;

    @ApiModelProperty(value="属性字段")
    private String commAttriColumn;

    @ApiModelProperty(value="属性类型")
    private String commAttriType;

    @ApiModelProperty(value="长度")
    private Integer length;

    @ApiModelProperty(value="商品属性状态（有效、无效）")
    private String effeInvalState;

    @ApiModelProperty(value="小数位")
    private Integer decimalDig;

    @ApiModelProperty(value="最大值")
    private Double maxVal;

    @ApiModelProperty(value="最小值")
    private Double minVal;

    @ApiModelProperty(value="排序")
    private Integer sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
