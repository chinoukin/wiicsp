package com.wisea.cultivar.plant.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class MembCollection extends DataLongEntity<MembCollection> {
    /**
     * 会员id
     */
    private Long membId;

    /**
     * 收藏类型
     */
    private Long collectionType;

    /**
     * 收藏id
     */
    private Long collectionId;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public Long getCollectionType() {
        return collectionType;
    }

    public void setCollectionType(Long collectionType) {
        this.collectionType = collectionType;
    }

    public Long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }
}
