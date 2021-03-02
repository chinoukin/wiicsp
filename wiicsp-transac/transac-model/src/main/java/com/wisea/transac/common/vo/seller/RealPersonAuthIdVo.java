package com.wisea.transac.common.vo.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("实人认证返回vo")
public class RealPersonAuthIdVo {


    @ApiModelProperty("认证添加ID")
    private Long realPersonAuthId;

    public Long getRealPersonAuthId() {
        return realPersonAuthId;
    }

    public void setRealPersonAuthId(Long realPersonAuthId) {
        this.realPersonAuthId = realPersonAuthId;
    }
}
