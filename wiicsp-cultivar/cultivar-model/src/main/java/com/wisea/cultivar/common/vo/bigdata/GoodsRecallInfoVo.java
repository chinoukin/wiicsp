package com.wisea.cultivar.common.vo.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.serializer.OffsetDateSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("GoodsRecallInfoVo详细信息Vo")
public class GoodsRecallInfoVo {
    @ApiModelProperty(value="商品名称")
    private String goodsName;

    @ApiModelProperty(value="批次")
    private String goodsNum;

    @ApiModelProperty(value="召回地区市")
    private String recallCity;

    @ApiModelProperty(value="召回日期")
    @JsonSerialize(
            using = OffsetDateSerializer.class
    )
    private OffsetDateTime goodsDate;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(String goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getRecallCity() {
        return recallCity;
    }

    public void setRecallCity(String recallCity) {
        this.recallCity = recallCity;
    }

    public OffsetDateTime getGoodsDate() {
        return goodsDate;
    }

    public void setGoodsDate(OffsetDateTime goodsDate) {
        this.goodsDate = goodsDate;
    }
}
