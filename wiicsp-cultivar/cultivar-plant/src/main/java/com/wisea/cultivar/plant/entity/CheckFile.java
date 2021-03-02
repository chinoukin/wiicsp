package com.wisea.cultivar.plant.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class CheckFile extends DataLongEntity<CheckFile> {
    /**
     * 补贴申请管理id
     */
    private Long subsidyApplMageId;

    /**
     * 验收材料url
     */
    private String url;

    public Long getSubsidyApplMageId() {
        return subsidyApplMageId;
    }

    public void setSubsidyApplMageId(Long subsidyApplMageId) {
        this.subsidyApplMageId = subsidyApplMageId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
