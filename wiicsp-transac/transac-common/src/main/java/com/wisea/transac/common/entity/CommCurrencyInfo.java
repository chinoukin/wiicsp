package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class CommCurrencyInfo extends DataLongEntity<CommCurrencyInfo> {
    /**
     * 通用信息内容
     */
    private String commCurrencyContent;

    public String getCommCurrencyContent() {
        return commCurrencyContent;
    }

    public void setCommCurrencyContent(String commCurrencyContent) {
        this.commCurrencyContent = commCurrencyContent;
    }
}
