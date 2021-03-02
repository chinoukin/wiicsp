package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class FollowComm extends DataLongEntity<FollowComm> {
    /**
     * 会员id
     */
    private Long membId;

    /**
     * 商品发布id
     */
    private Long commPubId;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public Long getCommPubId() {
        return commPubId;
    }

    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }
}
