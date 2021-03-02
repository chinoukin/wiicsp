package com.wisea.cultivar.plant.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class MembMomentsLimitsMage extends DataLongEntity<MembMomentsLimitsMage> {
    /**
     * 会员id
     */
    private Long membId;

    /**
     * 圈子设置类型
     */
    private String membMomentsLimitsType;

    /**
     * 是否设置
     */
    private String ifShow;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getMembMomentsLimitsType() {
        return membMomentsLimitsType;
    }

    public void setMembMomentsLimitsType(String membMomentsLimitsType) {
        this.membMomentsLimitsType = membMomentsLimitsType;
    }

    public String getIfShow() {
        return ifShow;
    }

    public void setIfShow(String ifShow) {
        this.ifShow = ifShow;
    }
}
