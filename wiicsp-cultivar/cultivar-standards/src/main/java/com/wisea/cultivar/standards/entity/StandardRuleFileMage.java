package com.wisea.cultivar.standards.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * standard_rule_file_mage 表实体
 * 标准规范附件管理
 * 2020/07/24 11:21:45
 */
public class StandardRuleFileMage extends DataLongEntity<StandardRuleFileMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 标准规范管理id
     */
    private Long standardRuleMageId;

    /**
     * 标准附件url
     */
    private String url;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     * 获取标准规范管理id
     */
    public Long getStandardRuleMageId() {
        return standardRuleMageId;
    }

    /**
     * 设置标准规范管理id
     */
    public void setStandardRuleMageId(Long standardRuleMageId) {
        this.standardRuleMageId = standardRuleMageId;
    }

    /**
     * 获取标准附件url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置标准附件url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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
