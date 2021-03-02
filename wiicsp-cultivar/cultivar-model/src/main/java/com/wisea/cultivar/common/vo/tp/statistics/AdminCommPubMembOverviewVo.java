package com.wisea.cultivar.common.vo.tp.statistics;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 后台商品/用户总览Vo
 */
@ApiModel("后台商品/用户总览Vo")
public class AdminCommPubMembOverviewVo {
    @ApiModelProperty("已上架商品总数")
    private Integer onShelvesCount;
    @ApiModelProperty("已下架商品总数")
    private Integer outShelvesCount;
    @ApiModelProperty("全部商品")
    private Integer commPubCount;
    @ApiModelProperty("今日新增用户数")
    private Integer todayAddMemberCount;
    @ApiModelProperty("本月新增用户数")
    private Integer monthAddMemberCount;
    @ApiModelProperty("会员总数")
    private Integer memberCount;

    public Integer getOnShelvesCount() {
        return onShelvesCount;
    }

    public void setOnShelvesCount(Integer onShelvesCount) {
        this.onShelvesCount = onShelvesCount;
    }

    public Integer getOutShelvesCount() {
        return outShelvesCount;
    }

    public void setOutShelvesCount(Integer outShelvesCount) {
        this.outShelvesCount = outShelvesCount;
    }

    public Integer getCommPubCount() {
        return commPubCount;
    }

    public void setCommPubCount(Integer commPubCount) {
        this.commPubCount = commPubCount;
    }

    public Integer getTodayAddMemberCount() {
        return todayAddMemberCount;
    }

    public void setTodayAddMemberCount(Integer todayAddMemberCount) {
        this.todayAddMemberCount = todayAddMemberCount;
    }

    public Integer getMonthAddMemberCount() {
        return monthAddMemberCount;
    }

    public void setMonthAddMemberCount(Integer monthAddMemberCount) {
        this.monthAddMemberCount = monthAddMemberCount;
    }

    public Integer getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }
}
