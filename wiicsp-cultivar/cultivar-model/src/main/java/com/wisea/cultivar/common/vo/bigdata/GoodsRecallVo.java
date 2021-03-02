package com.wisea.cultivar.common.vo.bigdata;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @ClassNameGoodsRecallVo
 * @Description
 * @Author zhangbo
 * @Date2020/9/3 10:19
 **/
@ApiModel("GoodsRecall详细信息Vo")
public class GoodsRecallVo {

    @ApiModelProperty(value="总召回数量")
    private long totalRecall;

    @ApiModelProperty(value="城市和数量")
    private List<CityAndQuantity> cityAndQuantityList;

    @ApiModelProperty(value="召回的信息")
    private List<GoodsRecallInfoVo> goodsRecallInfoVo;

    public long getTotalRecall() {
        return totalRecall;
    }

    public void setTotalRecall(long totalRecall) {
        this.totalRecall = totalRecall;
    }

    public List<CityAndQuantity> getCityAndQuantityList() {
        return cityAndQuantityList;
    }

    public void setCityAndQuantityList(List<CityAndQuantity> cityAndQuantityList) {
        this.cityAndQuantityList = cityAndQuantityList;
    }

    public List<GoodsRecallInfoVo> getGoodsRecallInfoVo() {
        return goodsRecallInfoVo;
    }

    public void setGoodsRecallInfoVo(List<GoodsRecallInfoVo> goodsRecallInfoVo) {
        this.goodsRecallInfoVo = goodsRecallInfoVo;
    }
}

