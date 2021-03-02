package com.wisea.cultivar.common.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author wangjiahao
 * @since 2020/6/28 1:55 下午
 */
@ApiModel("app最新版本Po")
public class AppVersionPo {
    @ApiModelProperty(value="版本类型，0安卓,1ios")
    private String appVersionType;

    public String getAppVersionType() {
        return appVersionType;
    }

    public void setAppVersionType(String appVersionType) {
        this.appVersionType = appVersionType;
    }
}
