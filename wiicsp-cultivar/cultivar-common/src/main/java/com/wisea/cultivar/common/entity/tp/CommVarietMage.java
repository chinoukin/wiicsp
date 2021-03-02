package com.wisea.cultivar.common.entity.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.model.annotation.IdSerializer;

/**
 * comm_variet_mage 表实体
 * 商品品种管理
 * 2019/04/15 09:49:09
 */
public class CommVarietMage extends DataLongEntity<CommVarietMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 商品id
     */
    @JsonSerialize(using = IdSerializer.class)
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
     * 商品分类id
     */
    private String commCatgId;

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
     * 获取品种名称
     */
    public String getCommVarietName() {
        return commVarietName;
    }

    /**
     * 设置品种名称
     */
    public void setCommVarietName(String commVarietName) {
        this.commVarietName = commVarietName == null ? null : commVarietName.trim();
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
}
