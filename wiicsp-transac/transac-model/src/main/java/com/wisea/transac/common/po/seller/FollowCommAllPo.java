package com.wisea.transac.common.po.seller;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("批量添加商品")
public class FollowCommAllPo {

    @ApiModelProperty(value="id",hidden = true)
    private Long id;

    @ApiModelProperty(value="会员id",hidden = true)
    private Long membId;

    @ApiModelProperty(value="ID列表")
    @Check(test = "required")
    private List<Long> ids;

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

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
