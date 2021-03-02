package com.wisea.cultivar.common.po.trade;

import io.swagger.annotations.ApiModel;

@ApiModel("首页认证企业传入参数")
public class MembAuthPo {

    private String statue;

    public String getStatue() {
        return statue;
    }

    public void setStatue(String statue) {
        this.statue = statue;
    }
}
