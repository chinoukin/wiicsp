package com.wisea.transac.common.vo.seller;

import io.swagger.annotations.ApiModelProperty;

public class StallsMageSelesVo {

    @ApiModelProperty("根据档口查询商品的总销量")
    private Double salesVolume;

    public Double getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Double salesVolume) {
        this.salesVolume = salesVolume;
    }
}
