package com.wisea.cultivar.common.vo.tp.product;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @Description:
 * @author: wangs
 * @date :2019/6/5
 */
public class PjcsmxSetListVo {

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 属性字段
     */
    @ApiModelProperty(value = "属性字段")
    private String commAttriColumn;

    /**
     * 商品id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品id")
    private Long commId;

    /**
     * 属性ID
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "属性ID")
    private Long attriId;

    /**
     * 商品分类名称
     */
    @ApiModelProperty(value = "商品分类名称")
    private String commCatgName;

    /**
     * 属性名称
     */
    @ApiModelProperty(value = "属性名称")
    private String commAttriName;

    /**
     * 是否必填
     */
    @ApiModelProperty(value = "是否必填")
    private String ifRequ;

    /**
     * 搜索条件
     */
    @ApiModelProperty(value = "搜索条件")
    private String ifSearch;

    /**
     * 显示顺序
     */
    @ApiModelProperty(value = "显示顺序")
    private Integer sort;

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
     * 创建时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime createDate;

    /**
     * 顺序Long
     * */
    private Long sortLong;

    public String getCommAttriColumn() {
        return commAttriColumn;
    }

    public void setCommAttriColumn(String commAttriColumn) {
        this.commAttriColumn = commAttriColumn;
    }

    public Long getSortLong() {
        return sortLong;
    }

    public void setSortLong(Long sortLong) {
        this.sortLong = sortLong;
    }

    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
    }

    public String getCommCatgName() {
        return commCatgName;
    }

    public void setCommCatgName(String commCatgName) {
        this.commCatgName = commCatgName;
    }

    public String getCommAttriName() {
        return commAttriName;
    }

    public void setCommAttriName(String commAttriName) {
        this.commAttriName = commAttriName;
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
     * 获取商品id
     */
    public Long getCommId() {
        return commId;
    }

    /**
     * 设置商品id
     */
    public void setCommId(Long commId) {
        this.commId = commId;
    }

    /**
     * 获取属性ID
     */
    public Long getAttriId() {
        return attriId;
    }

    /**
     * 设置属性ID
     */
    public void setAttriId(Long attriId) {
        this.attriId = attriId;
    }

    /**
     * 获取是否必填
     */
    public String getIfRequ() {
        return ifRequ;
    }

    /**
     * 设置是否必填
     */
    public void setIfRequ(String ifRequ) {
        this.ifRequ = ifRequ == null ? null : ifRequ.trim();
    }

    /**
     * 获取搜索条件
     */
    public String getIfSearch() {
        return ifSearch;
    }

    /**
     * 设置搜索条件
     */
    public void setIfSearch(String ifSearch) {
        this.ifSearch = ifSearch == null ? null : ifSearch.trim();
    }

    /**
     * 获取显示顺序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置显示顺序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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
