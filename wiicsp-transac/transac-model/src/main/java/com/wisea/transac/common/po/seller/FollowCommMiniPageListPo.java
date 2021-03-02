package com.wisea.transac.common.po.seller;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.seller.FollowCommMiniPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("关注的商品分页查询Po")
public class FollowCommMiniPageListPo extends PagePo<FollowCommMiniPageListVo> {

    @ApiModelProperty(value = "会员id", hidden = true)
    private Long membId;

    @ApiModelProperty(value = "查询条件")
    private String val;

    @ApiModelProperty(value = "产地传值，同城不传", hidden = true)
    private String flag;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
