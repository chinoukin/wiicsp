package com.wisea.transac.tp.product.search;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.annotation.LongSerializer;
import com.wisea.transac.common.entity.BaseSearchPojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * demo搜索模型
 *
 * @author: wangs
 */
@ApiModel("供应大厅搜索条件")
public class HotKeyWordsSearchPojo extends BaseSearchPojo {

    @ApiModelProperty("id值")
    @JsonSerialize(using = LongSerializer.class)
    private String id;

    @ApiModelProperty("搜索输入框")
    private String searchInput;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "时间")
    private Long createDate;

    /**
     * 排序字段，搜索引擎中字段名
     */
    @ApiModelProperty(value = "排序字段，搜索引擎中字段名")
    public String orderBy;

    /**
     * 排序模式  ASC或DESC,大小写均可
     */
    @ApiModelProperty(value = "排序模式  ASC或DESC,大小写均可")
    public String sortOrder;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSearchInput() {
        return searchInput;
    }

    public void setSearchInput(String searchInput) {
        this.searchInput = searchInput;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    @Override
    public String getOrderBy() {
        return orderBy;
    }

    @Override
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    @Override
    public String getSortOrder() {
        return sortOrder;
    }

    @Override
    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

}
