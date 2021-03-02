package com.wisea.cultivar.common.vo.tp.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 地图信息查询
 * @author: wangs
 * @date :2019/5/31
 */
@ApiModel("地图信息查询返回值")
public class SupplyListMapVo {

    @ApiModelProperty("会员id")
    private Long membId;

    @ApiModelProperty("供货数量")
    private Double value;

    @ApiModelProperty("城市code")
    private String cityCode;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}
