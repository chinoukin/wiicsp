package com.wisea.cultivar.plant.po;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.vo.MembAttentionPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询MembAttentionPo")
public class MembAttentionPageListPo extends PagePo<MembAttentionPageListVo> {
    @ApiModelProperty(value="会员id")
    private Long membId;

    @ApiModelProperty(value="关注类型0油茶圈1服务商")
    @Check(test = { "required" })
    private String membAttentionType;

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

}
