package com.wisea.transac.common.po;

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

    @ApiModelProperty(value="来源类型,0.采购app，1.档口app，2.产地app")
    private String sourceType;

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getAppVersionType() {
        return appVersionType;
    }

    public void setAppVersionType(String appVersionType) {
        this.appVersionType = appVersionType;
    }
}
