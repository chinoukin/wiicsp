package com.wisea.cultivar.seedlings.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * buy_sprout_info 表实体
 * 购苗信息
 * 2020/08/06 14:19:24
 */
public class BuySproutInfo extends DataLongEntity<BuySproutInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 补贴申请管理id
     */
    private Long subsidyApplMageId;

    /**
     * 服务单id
     */
    private Long serListId;

    /**
     *
     * @mbg.generated
     */
    public BuySproutInfo() {
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
     * 获取服务单id
     */
    public Long getSerListId() {
        return serListId;
    }

    /**
     * 设置服务单id
     */
    public void setSerListId(Long serListId) {
        this.serListId = serListId;
    }
}
