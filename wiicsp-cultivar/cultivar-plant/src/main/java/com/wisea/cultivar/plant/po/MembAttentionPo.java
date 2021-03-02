package com.wisea.cultivar.plant.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.junit.Test;

@ApiModel("新增或修改MembAttentionPo")
public class MembAttentionPo {
    @ApiModelProperty(value="数据ID，修改时该字段必填")
    private Long id;

    @ApiModelProperty(value="会员id")
    @Check(test = { "required" })
    private Long membId;

    @ApiModelProperty(value="关注类型")
    @Check(test = { "required" })
    private String membAttentionType;

    @ApiModelProperty(value="被关注会员id")
    @Check(test = { "required" })
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
