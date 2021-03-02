package com.wisea.cultivar.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class ZhfwCommCurrencyInfo extends DataLongEntity<ZhfwCommCurrencyInfo> {
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
