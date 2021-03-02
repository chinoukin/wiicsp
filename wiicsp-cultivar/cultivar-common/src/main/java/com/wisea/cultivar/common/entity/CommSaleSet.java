package com.wisea.cultivar.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class CommSaleSet extends DataLongEntity<CommSaleSet> {
    /**
     * 商品销售分类id
     */
    private Long commSaleCatgId;

    /**
     * 商品id
     */
    private Long commId;

    /**
     * 商品名称
     */
    private String commName;

    /**
     * 显示顺序
     */
    private Integer sort;

    public Long getCommSaleCatgId() {
        return commSaleCatgId;
    }

    public void setCommSaleCatgId(Long commSaleCatgId) {
        this.commSaleCatgId = commSaleCatgId;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
