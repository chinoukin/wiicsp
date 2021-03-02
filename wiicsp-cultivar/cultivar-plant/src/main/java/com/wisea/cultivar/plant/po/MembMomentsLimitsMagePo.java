package com.wisea.cultivar.plant.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("新增或修改MembMomentsLimitsMagePo")
public class MembMomentsLimitsMagePo {
    @ApiModelProperty(value = "数据ID，修改时该字段必填")
    private Long id;

    @ApiModelProperty(value = "会员id")
    private Long membId;

    @ApiModelProperty(value = "圈子设置类型")
    private String membMomentsLimitsType;

    @ApiModelProperty(value = "是否设置")
    private String ifShow;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
