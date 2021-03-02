package com.wisea.cultivar.plant.po;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.vo.MembMomentsLimitsMagePageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询MembMomentsLimitsMagePo")
public class MembMomentsLimitsMagePageListPo extends PagePo<MembMomentsLimitsMagePageListVo> {
    @ApiModelProperty(value="会员id")
    @Check(test = "required")
    private Long membId;

    @ApiModelProperty(value="圈子设置类型")
    private String membMomentsLimitsType;

    @ApiModelProperty(value="是否设置")
    private String ifShow;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getMembMomentsLimitsType() {
        return membMomentsLimitsType;
    }

    public void setMembMomentsLimitsType(String membMomentsLimitsType) {
        this.membMomentsLimitsType = membMomentsLimitsType;
    }

    public String getIfShow() {
        return ifShow;
    }

    public void setIfShow(String ifShow) {
        this.ifShow = ifShow;
    }
}
