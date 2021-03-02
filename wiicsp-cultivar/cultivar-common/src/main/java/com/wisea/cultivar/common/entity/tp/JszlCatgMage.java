package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * jszl_catg_mage 表实体
 * 技术资料分类管理
 * 2019/08/29 17:45:19
 */
public class JszlCatgMage extends DataLongEntity<JszlCatgMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 分类名称
     */
    private String catgName;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     * 是否显示
     */
    private String ifRequ;

    /**
     * 获取分类名称
     */
    public String getCatgName() {
        return catgName;
    }

    /**
     * 设置分类名称
     */
    public void setCatgName(String catgName) {
        this.catgName = catgName == null ? null : catgName.trim();
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
     * 获取是否显示
     */
    public String getIfRequ() {
        return ifRequ;
    }

    /**
     * 设置是否显示
     */
    public void setIfRequ(String ifRequ) {
        this.ifRequ = ifRequ == null ? null : ifRequ.trim();
    }
}
