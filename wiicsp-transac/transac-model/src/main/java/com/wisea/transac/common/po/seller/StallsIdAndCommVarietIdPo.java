package com.wisea.transac.common.po.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author wangjiahao
 * @since 2020/5/6 10:20 上午
 */
@ApiModel("档口ID和品类ID")
public class StallsIdAndCommVarietIdPo {

    @ApiModelProperty("档口ID")
    private Long stallsId;
    @ApiModelProperty("品类ID")
    private Long commVarietId;

    public Long getStallsId() {
        return stallsId;
    }

    public void setStallsId(Long stallsId) {
        this.stallsId = stallsId;
    }

    public Long getCommVarietId() {
        return commVarietId;
    }

    public void setCommVarietId(Long commVarietId) {
        this.commVarietId = commVarietId;
    }
}
