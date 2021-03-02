package com.wisea.cultivar.common.vo.tp.statistics;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @author: wangs
 * @date :2018/12/10
 */
@ApiModel("服务费最大值,最小值信息")
public class PlatfCostVo {

    @ApiModelProperty("服务费最大值")
    private String platfCostTatalMax;
    @ApiModelProperty("服务费最小值")
    private String platfCostTatalMin;

    public String getPlatfCostTatalMax() {
        return platfCostTatalMax;
    }

    public void setPlatfCostTatalMax(String platfCostTatalMax) {
        this.platfCostTatalMax = platfCostTatalMax;
    }

    public String getPlatfCostTatalMin() {
        return platfCostTatalMin;
    }

    public void setPlatfCostTatalMin(String platfCostTatalMin) {
        this.platfCostTatalMin = platfCostTatalMin;
    }
}
