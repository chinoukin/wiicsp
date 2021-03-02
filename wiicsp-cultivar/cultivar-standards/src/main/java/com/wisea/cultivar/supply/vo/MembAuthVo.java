package com.wisea.cultivar.supply.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

/**
 * 首页商店信息
 * @author chengq
 * @date 2020/8/12 9:57
 */
public class MembAuthVo {

    /**
     * 店铺名称
     */
    @ApiModelProperty("认证id")
    private String authId;

    /**
     * 主体类型
     */
    @ApiModelProperty("审核状态 0-审核通过 1-审核不通过 2-待审核 3-未填写审核信息")
    private String authStateType;

    /**
     * 认证类型
     */
    @JsonIgnore
    @ApiModelProperty(value = "认证类型 0-企业 1-个人", hidden = true)
    private String authType;

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public String getAuthStateType() {
        return authStateType;
    }

    public void setAuthStateType(String authStateType) {
        this.authStateType = authStateType;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public MembAuthVo() {
    }

    public MembAuthVo(String authId, String authStateType) {
        this.authId = authId;
        this.authStateType = authStateType;
    }
}
