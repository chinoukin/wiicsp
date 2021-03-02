package com.wisea.cultivar.standards.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * ics_class_mage 表实体
 * ICS分类管理
 * 2020/07/24 11:21:45
 */
public class IcsClassMage extends DataLongEntity<IcsClassMage> {
    private static final long serialVersionUID = 1L;

    /**
     * pid
     */
    private Long pid;

    /**
     * 父分类名称
     */
    private String pName;

    /**
     * 分类编码
     */
    private String icsClassCode;

    /**
     * 分类名称
     */
    private String icsClassName;

    /**
     * 显示顺序
     */
    private Integer sort;

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
    public String getpName() {
        return pName;
    }

    /**
     * 设置父分类名称
     */
    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    /**
     * 获取分类编码
     */
    public String getIcsClassCode() {
        return icsClassCode;
    }

    /**
     * 设置分类编码
     */
    public void setIcsClassCode(String icsClassCode) {
        this.icsClassCode = icsClassCode == null ? null : icsClassCode.trim();
    }

    /**
     * 获取分类名称
     */
    public String getIcsClassName() {
        return icsClassName;
    }

    /**
     * 设置分类名称
     */
    public void setIcsClassName(String icsClassName) {
        this.icsClassName = icsClassName == null ? null : icsClassName.trim();
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
