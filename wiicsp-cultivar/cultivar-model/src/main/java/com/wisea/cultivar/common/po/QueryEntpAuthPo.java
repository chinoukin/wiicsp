package com.wisea.cultivar.common.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("查询认证信息po")
public class QueryEntpAuthPo {

    @ApiModelProperty(value = "会员id")
    private Long membId;
    @ApiModelProperty(value = "是否商家(是传值， 否不传)")
    private String agentFlag;
    @ApiModelProperty(value = "客户类型（企业商户、个体商户）")
    private String custType;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getAgentFlag() {
        return agentFlag;
    }

    public void setAgentFlag(String agentFlag) {
        this.agentFlag = agentFlag;
    }

    public String getCustType() {
        return custType;
    }

    public void setCustType(String custType) {
        this.custType = custType;
    }
}
