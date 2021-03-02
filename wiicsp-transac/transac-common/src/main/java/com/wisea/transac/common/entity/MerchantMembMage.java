package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class MerchantMembMage extends DataLongEntity<MerchantMembMage> {
    /**
     * 商户id
     */
    private Long merchantId;

    /**
     * 会员id
     */
    private Long membId;

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }
}
