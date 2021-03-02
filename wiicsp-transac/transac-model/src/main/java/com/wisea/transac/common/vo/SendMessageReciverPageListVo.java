package com.wisea.transac.common.vo;

import java.util.List;

import com.google.common.collect.Lists;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询Vo")
public class SendMessageReciverPageListVo {
    @ApiModelProperty(value = "会员列表")
    private List<MembInfoInfoVo> membList = Lists.newArrayList();

    public List<MembInfoInfoVo> getMembList() {
        return membList;
    }

    public void setMembList(List<MembInfoInfoVo> membList) {
        this.membList = membList;
    }

}
