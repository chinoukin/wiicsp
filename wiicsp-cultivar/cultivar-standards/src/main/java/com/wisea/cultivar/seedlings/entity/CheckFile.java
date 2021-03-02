package com.wisea.cultivar.seedlings.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * check_file 表实体
 * 验收材料
 * 2020/08/06 14:19:24
 */
public class CheckFile extends DataLongEntity<CheckFile> {
    private static final long serialVersionUID = 1L;

    /**
     * 补贴申请管理id
     */
    private Long subsidyApplMageId;

    /**
     * 验收材料url
     */
    private String url;

    /**
     *
     * @mbg.generated
     */
    public CheckFile() {
        super();
    }

    /**
     * 获取补贴申请管理id
     */
    public Long getSubsidyApplMageId() {
        return subsidyApplMageId;
    }

    /**
     * 设置补贴申请管理id
     */
    public void setSubsidyApplMageId(Long subsidyApplMageId) {
        this.subsidyApplMageId = subsidyApplMageId;
    }

    /**
     * 获取验收材料url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置验收材料url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}
