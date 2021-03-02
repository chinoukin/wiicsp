package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModelProperty;

/**
 * ReceAddressMageUpdateDefaultFlagPo
 * 2018/09/18 14:36:47
 */
public class ReceAddressMageUpdateDefaultFlagPo{
    @Check(test = "required")
    @ApiModelProperty(value = "会员ID")
    private Long membId;


    public ReceAddressMageUpdateDefaultFlagPo() {
    }

    public ReceAddressMageUpdateDefaultFlagPo(Long membId) {
        this.membId = membId;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }
}
