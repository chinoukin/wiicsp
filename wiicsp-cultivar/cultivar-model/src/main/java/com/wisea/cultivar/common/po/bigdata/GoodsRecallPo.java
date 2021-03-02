package com.wisea.cultivar.common.po.bigdata;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("新增或修改GoodsRecallPo")
public class GoodsRecallPo {
    @ApiModelProperty(value="数据ID，修改时该字段必填")
    private Long id;

    @ApiModelProperty(value="商品名称")
    private String goodsName;

    @ApiModelProperty(value="批次")
    private String goodsNum;

    @ApiModelProperty(value="召回地区省")
    private String recallProv;

    @ApiModelProperty(value="召回地区市")
    private String recallCity;

    @ApiModelProperty(value="召回地区区县")
    private String recallCounty;

    @ApiModelProperty(value="召回日期")
    private OffsetDateTime goodsDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getRecallProv() {
        return recallProv;
    }

    public void setRecallProv(String recallProv) {
        this.recallProv = recallProv;
    }

    public String getRecallCity() {
        return recallCity;
    }

    public void setRecallCity(String recallCity) {
        this.recallCity = recallCity;
    }

    public String getRecallCounty() {
        return recallCounty;
    }

    public void setRecallCounty(String recallCounty) {
        this.recallCounty = recallCounty;
    }

    public OffsetDateTime getGoodsDate() {
        return goodsDate;
    }

    public void setGoodsDate(OffsetDateTime goodsDate) {
        this.goodsDate = goodsDate;
    }
}
