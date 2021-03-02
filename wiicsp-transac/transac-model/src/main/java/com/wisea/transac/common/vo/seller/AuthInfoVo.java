package com.wisea.transac.common.vo.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("我要认证")
public class AuthInfoVo {

    @ApiModelProperty(value="是否商家(agent_flag 0:是1:否)")
    private String agentFlag;

    @ApiModelProperty(value="实人认证状态")
    private String realPersonAuth;

    @ApiModelProperty(value="个体工商户认证状态")
    private String indBusiAuth;

    @ApiModelProperty(value="企业认证状态")
    private String entpAuth;

    @ApiModelProperty(value="实人认证ID")
    private Long realPersonAuthId;

    @ApiModelProperty(value="个体工商户认证ID")
    private Long indBusiAuthId;

    @ApiModelProperty(value="企业认证ID")
    private Long entpAuthId;

    public String getRealPersonAuth() {
        return realPersonAuth;
    }

    public void setRealPersonAuth(String realPersonAuth) {
        this.realPersonAuth = realPersonAuth;
    }


    public String getEntpAuth() {
        return entpAuth;
    }

    public void setEntpAuth(String entpAuth) {
        this.entpAuth = entpAuth;
    }

    public String getIndBusiAuth() {
        return indBusiAuth;
    }

    public void setIndBusiAuth(String indBusiAuth) {
        this.indBusiAuth = indBusiAuth;
    }

    public Long getEntpAuthId() {
        return entpAuthId;
    }

    public void setEntpAuthId(Long entpAuthId) {
        this.entpAuthId = entpAuthId;
    }

    public Long getIndBusiAuthId() {
        return indBusiAuthId;
    }

    public void setIndBusiAuthId(Long indBusiAuthId) {
        this.indBusiAuthId = indBusiAuthId;
    }

    public Long getRealPersonAuthId() {
        return realPersonAuthId;
    }

    public void setRealPersonAuthId(Long realPersonAuthId) {
        this.realPersonAuthId = realPersonAuthId;
    }

    public String getAgentFlag() {
        return agentFlag;
    }

    public void setAgentFlag(String agentFlag) {
        this.agentFlag = agentFlag;
    }

}
