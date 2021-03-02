package com.wisea.transac.common.entity;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 基础搜索模型
 * @author: wangs
 * @date :2018/1/3
 */
public class BaseSearchPojo {

    /** 页数，从0开始 */
    public Integer pageNo = 1;
    /** 每页大小 */
    public Integer pageSize = 20;
    /** 排序字段，搜索引擎中字段名，若按地理位置排序，必须为geo */
    @ApiModelProperty(value="排序字段，搜索引擎中字段名，若按地理位置排序，必须为geo ")
    public String orderBy;
    /** 排序模式  ASC或DESC,大小写均可*/
    @ApiModelProperty(value="排序模式  ASC或DESC,大小写均可")
    public String sortOrder;

    public Integer getPageNo() {
        return pageNo;
    }
    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public String getOrderBy() {
        return orderBy;
    }
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
    public String getSortOrder() {
        return sortOrder;
    }
    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }
}
