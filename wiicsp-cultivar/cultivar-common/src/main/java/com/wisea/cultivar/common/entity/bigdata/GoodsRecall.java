package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class GoodsRecall extends DataLongEntity<GoodsRecall> {
    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 批次
     */
    private String goodsNum;

    /**
     * 召回地区省
     */
    private String recallProv;

    /**
     * 召回地区市
     */
    private String recallCity;

    /**
     * 召回地区区县
     */
    private String recallCounty;

    /**
     * 召回日期
     */
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
