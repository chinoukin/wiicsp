package com.wisea.cultivar.common.vo.tp.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @author: wangs
 * @date :2019/5/31
 */
@ApiModel("首页返回几家供货,以及多少吨供货")
public class AvailableSupplyVo {

    @ApiModelProperty("可供货数量")
    private Double avaiSupplyCount;

    @ApiModelProperty("共有几家供货")
    private Integer avaiSupplyCountMemb;

    @ApiModelProperty("相关商品")
    private Integer releCommCount;

    public Integer getReleCommCount() {
        return releCommCount;
    }

    public void setReleCommCount(Integer releCommCount) {
        this.releCommCount = releCommCount;
    }

    public Double getAvaiSupplyCount() {
        return avaiSupplyCount;
    }

    public void setAvaiSupplyCount(Double avaiSupplyCount) {
        this.avaiSupplyCount = avaiSupplyCount;
    }

    public Integer getAvaiSupplyCountMemb() {
        return avaiSupplyCountMemb;
    }

    public void setAvaiSupplyCountMemb(Integer avaiSupplyCountMemb) {
        this.avaiSupplyCountMemb = avaiSupplyCountMemb;
    }
}
