package com.wisea.cultivar.plant.po;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.vo.BuySproutInfoPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询BuySproutInfoPo")
public class BuySproutInfoPageListPo extends PagePo<BuySproutInfoPageListVo> {
    @ApiModelProperty(value="补贴申请管理id")
    private Long subsidyApplMageId;

    @ApiModelProperty(value="服务单id")
    private Long serListId;

    public Long getSubsidyApplMageId() {
        return subsidyApplMageId;
    }

    public void setSubsidyApplMageId(Long subsidyApplMageId) {
        this.subsidyApplMageId = subsidyApplMageId;
    }

    public Long getSerListId() {
        return serListId;
    }

    public void setSerListId(Long serListId) {
        this.serListId = serListId;
    }
}
