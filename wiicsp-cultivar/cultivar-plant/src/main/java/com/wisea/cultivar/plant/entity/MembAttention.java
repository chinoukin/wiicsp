package com.wisea.cultivar.plant.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class MembAttention extends DataLongEntity<MembAttention> {
    /**
     * 会员id
     */
    private Long membId;

    /**
     * 关注类型
     */
    private String membAttentionType;

    /**
     * 被关注会员id
     */
    private Long membAttentionId;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getMembAttentionType() {
        return membAttentionType;
    }

    public void setMembAttentionType(String membAttentionType) {
        this.membAttentionType = membAttentionType;
    }

    public Long getMembAttentionId() {
        return membAttentionId;
    }

    public void setMembAttentionId(Long membAttentionId) {
        this.membAttentionId = membAttentionId;
    }
}
