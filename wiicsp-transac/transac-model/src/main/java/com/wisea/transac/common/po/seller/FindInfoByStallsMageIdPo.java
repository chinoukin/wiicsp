package com.wisea.transac.common.po.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("根据档口ID查询销售员工po")
public class FindInfoByStallsMageIdPo {

    @ApiModelProperty("档口ids")
    private List<Long> staffMageIds;

    @ApiModelProperty(value = "是否为管理员 1:否 0:是")
    private String sfAdminFlag;

    @ApiModelProperty(value = "会员ID")
    private Long membId;

    public List<Long> getStaffMageIds() {
        return staffMageIds;
    }

    public void setStaffMageIds(List<Long> staffMageIds) {
        this.staffMageIds = staffMageIds;
    }

    public String getSfAdminFlag() {
        return sfAdminFlag;
    }

    public void setSfAdminFlag(String sfAdminFlag) {
        this.sfAdminFlag = sfAdminFlag;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

}
