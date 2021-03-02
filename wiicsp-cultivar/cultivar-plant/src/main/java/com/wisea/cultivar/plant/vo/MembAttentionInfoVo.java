package com.wisea.cultivar.plant.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("MembAttention详细信息Vo")
public class MembAttentionInfoVo {

    @ApiModelProperty(value="MembAttentionid")
    private Long id;
    @ApiModelProperty(value="会员id")
    private Long membId;

    @ApiModelProperty(value="关注类型")
    private String membAttentionType;

    @ApiModelProperty(value="被关注会员id")
    private Long membAttentionId;

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

    public String getMembAttentionType() {
        return membAttentionType;
    }

    public void setMembAttentionType(String membAttentionType) {
        this.membAttentionType = membAttentionType;
    }

    public Long getMembAttentionId() {
        return membAttentionId;
    }

    public void setMembAttentionId(Long membAttentionId) {
        this.membAttentionId = membAttentionId;
    }
}
