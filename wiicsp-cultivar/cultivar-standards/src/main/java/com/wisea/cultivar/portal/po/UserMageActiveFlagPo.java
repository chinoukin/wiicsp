package com.wisea.cultivar.portal.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

public class UserMageActiveFlagPo {

    @Check(test = "required")
    @ApiModelProperty(value = "系统用户id")
    private Long sysUserId;
    @Check(test = "required")
    @ApiModelProperty(value = "账号状态")
    private String activeFlag;

    public Long getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(String activeFlag) {
        this.activeFlag = activeFlag;
    }
}
