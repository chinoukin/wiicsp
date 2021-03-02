package com.wisea.cultivar.standards.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * china_standard_type_mage 表实体
 * 中标分类管理
 * 2020/07/24 11:21:45
 */
public class ChinaStandardTypeMage extends DataLongEntity<ChinaStandardTypeMage> {
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
    private String standardTypeCode;

    /**
     * 分类名称
     */
    private String standardTypeName;

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
    public String getStandardTypeCode() {
        return standardTypeCode;
    }

    /**
     * 设置分类编码
     */
    public void setStandardTypeCode(String standardTypeCode) {
        this.standardTypeCode = standardTypeCode == null ? null : standardTypeCode.trim();
    }

    /**
     * 获取分类名称
     */
    public String getStandardTypeName() {
        return standardTypeName;
    }

    /**
     * 设置分类名称
     */
    public void setStandardTypeName(String standardTypeName) {
        this.standardTypeName = standardTypeName == null ? null : standardTypeName.trim();
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
