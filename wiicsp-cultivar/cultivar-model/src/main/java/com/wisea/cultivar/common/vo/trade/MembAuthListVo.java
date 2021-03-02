package com.wisea.cultivar.common.vo.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("认证企业返回参数")
public class MembAuthListVo {

    @ApiModelProperty("认证企业数量")
    private Integer membCount;

    public Integer getMembCount() {
        return membCount;
    }

    public void setMembCount(Integer membCount) {
        this.membCount = membCount;
    }
}
