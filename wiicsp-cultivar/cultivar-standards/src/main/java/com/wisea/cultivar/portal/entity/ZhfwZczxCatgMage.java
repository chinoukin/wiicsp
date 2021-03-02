package com.wisea.cultivar.portal.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * zhfw_zczx_catg_mage 表实体
 * 种植服务资料分类管理
 * 2020/08/24 20:28:13
 */
public class ZhfwZczxCatgMage extends DataLongEntity<ZhfwZczxCatgMage> {
    private static final long serialVersionUID = 1L;

    /**
     * pid
     */
    private Long pid;

    /**
     * 父分类名称
     */
    private String pCatgName;

    /**
     * 分类名称
     */
    private String catgName;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     *
     * @mbg.generated
     */
    public ZhfwZczxCatgMage() {
        super();
    }

    /**
     * 获取pid
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 设置pid
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * 获取父分类名称
     */
    public String getpCatgName() {
        return pCatgName;
    }

    /**
     * 设置父分类名称
     */
    public void setpCatgName(String pCatgName) {
        this.pCatgName = pCatgName == null ? null : pCatgName.trim();
    }

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
}
