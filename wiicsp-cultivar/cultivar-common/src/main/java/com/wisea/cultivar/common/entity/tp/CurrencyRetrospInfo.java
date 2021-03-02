package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

public class CurrencyRetrospInfo extends DataLongEntity<CurrencyRetrospInfo> {
    /**
     * 会员id
     */
    private Long membId;

    /**
     * 追溯信息模板
     */
    private String currencyRetrospTemplate;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getCurrencyRetrospTemplate() {
        return currencyRetrospTemplate;
    }

    public void setCurrencyRetrospTemplate(String currencyRetrospTemplate) {
        this.currencyRetrospTemplate = currencyRetrospTemplate;
    }
}
