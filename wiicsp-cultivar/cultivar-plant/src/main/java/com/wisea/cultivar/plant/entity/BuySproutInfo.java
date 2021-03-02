package com.wisea.cultivar.plant.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class BuySproutInfo extends DataLongEntity<BuySproutInfo> {
    /**
     * 补贴申请管理id
     */
    private Long subsidyApplMageId;

    /**
     * 服务单id
     */
    private Long serListId;

    public Long getSubsidyApplMageId() {
        return subsidyApplMageId;
    }

    public void setSubsidyApplMageId(Long subsidyApplMageId) {
        this.subsidyApplMageId = subsidyApplMageId;
    }

    public Long getSerListId() {
        return serListId;
    }

    public void setSerListId(Long serListId) {
        this.serListId = serListId;
    }
}
