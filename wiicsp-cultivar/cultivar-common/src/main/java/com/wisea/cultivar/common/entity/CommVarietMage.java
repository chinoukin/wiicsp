package com.wisea.cultivar.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class CommVarietMage extends DataLongEntity<CommVarietMage> {
    /**
     * 商品id
     */
    private Long commId;

    /**
     * 品种名称
     */
    private String commVarietName;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     * 基础分类id
     */
    private String commCatgId;

    /**
     * 基础分类实体
     */
    private CommMage commMage;

    public CommMage getCommMage() {
        return commMage;
    }

    public void setCommMage(CommMage commMage) {
        this.commMage = commMage;
    }

    public String getCommCatgId() {
        return commCatgId;
    }

    public void setCommCatgId(String commCatgId) {
        this.commCatgId = commCatgId;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public String getCommVarietName() {
        return commVarietName;
    }

    public void setCommVarietName(String commVarietName) {
        this.commVarietName = commVarietName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
