package com.wisea.cultivar.common.vo.product;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * @author wangs
 * CommAttriMageListVo
 * 2018/09/18 14:36:47
 */
public class CommAttriMageListVo {
    /**
     * 属性ID
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "属性ID")
    private Long id;

    /**
     * 品类id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "品类ID")
    private Long commId;

    /**
     * attriId
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "属性ID")
    private Long attriId;

    /**
     * 属性名称
     */
    @ApiModelProperty(value = "属性名称")
    private String commAttriName;

    /**
     * 属性字段
     */
    @ApiModelProperty(value = "属性字段")
    private String commAttriColumn;

    /**
     * 属性类型
     */
    @ApiModelProperty(value = "属性类型")
    private String commAttriType;

    /**
     * 长度
     */
    @ApiModelProperty(value = "长度")
    private Integer length;

    /**
     *下拉框内容中的Key：Value值_治民；
     * */
    private String dictTest;

    /**
     * 商品属性状态（有效、无效）
     */
    @ApiModelProperty(value = "商品属性状态（有效、无效）")
    private String effeInvalState;

    /**
     * 小数位
     */
    @ApiModelProperty(value = "小数位")
    private Integer decimalDig;

    /**
     * 最大值
     */
    @ApiModelProperty(value = "最大值")
    private Double maxVal;

    /**
    * 是否是查询条件
    * */
    private String ifSearch;

    /**
     * 最小值
     */
    @ApiModelProperty(value = "最小值")
    private Double minVal;

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

    /**
     * 字典值
     */
    @ApiModelProperty(value = "字典值")
    private String dictVal;

    /**
     * 是否必填
     */
    @ApiModelProperty(value = "是否必填")
    private String ifRequ;

    /**
     * 显示顺序
     */
    @ApiModelProperty(value = "显示顺序")
    private Integer sort;

    /**
     * 属性顺序
     */
    @ApiModelProperty(value = "显示顺序")
    private Integer camSort;

    /**
     * 显示顺序Long
     */
    @ApiModelProperty(value = "显示顺序")
    private Long sortLong;

    public Integer getCamSort() {
        return camSort;
    }

    public void setCamSort(Integer camSort) {
        this.camSort = camSort;
    }

    public Long getSortLong() {
        return sortLong;
    }

    public void setSortLong(Long sortLong) {
        this.sortLong = sortLong;
    }

    public String getDictTest() {
        return dictTest;
    }

    public void setDictTest(String dictTest) {
        this.dictTest = dictTest;
    }

    public String getIfSearch() {
        return ifSearch;
    }

    public void setIfSearch(String ifSearch) {
        this.ifSearch = ifSearch;
    }

    public String getIfRequ() {
        return ifRequ;
    }

    public void setIfRequ(String ifRequ) {
        this.ifRequ = ifRequ;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public Long getAttriId() {
        return attriId;
    }

    public void setAttriId(Long attriId) {
        this.attriId = attriId;
    }

    /**
     * 获取属性ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置属性ID
     */
    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommAttriMageListVo that = (CommAttriMageListVo) o;
        return Objects.equals(commId, that.commId) &&
                Objects.equals(attriId, that.attriId) &&
                Objects.equals(commAttriName, that.commAttriName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commId, attriId, commAttriName);
    }
}
