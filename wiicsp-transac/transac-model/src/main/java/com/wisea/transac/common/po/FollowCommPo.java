package com.wisea.transac.common.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("关注的商品新增或修改Po")
public class FollowCommPo {
    @ApiModelProperty(value="id",hidden = true)
    private Long id;

    @ApiModelProperty(value="会员id",hidden = true)
    private Long membId;

    @ApiModelProperty(value="商品发布id")
    @Check(
            test = {"required"}
    )
    private Long commPubId;

    @ApiModelProperty(value="标示",hidden = true)
    private String flag;


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

    public Long getCommPubId() {
        return commPubId;
    }

    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
