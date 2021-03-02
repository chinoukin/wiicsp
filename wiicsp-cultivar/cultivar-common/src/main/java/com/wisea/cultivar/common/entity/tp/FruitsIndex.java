package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * fruits_index 表实体
 * 水果指数
 * 2019/05/28 16:20:20
 */
public class FruitsIndex extends DataLongEntity<FruitsIndex> {
    private static final long serialVersionUID = 1L;

    /**
     * 日期
     */
    private OffsetDateTime fiDate;

    /**
     * 商品名称
     */
    private String commName;

    /**
     * 价格指数
     */
    private Double priceIndex;

    /**
     * 获取日期
     */
    public OffsetDateTime getFiDate() {
        return fiDate;
    }

    /**
     * 设置日期
     */
    public void setFiDate(OffsetDateTime fiDate) {
        this.fiDate = fiDate;
    }

    /**
     * 获取商品名称
     */
    public String getCommName() {
        return commName;
    }

    /**
     * 设置商品名称
     */
    public void setCommName(String commName) {
        this.commName = commName == null ? null : commName.trim();
    }

    /**
     * 获取价格指数
     */
    public Double getPriceIndex() {
        return priceIndex;
    }

    /**
     * 设置价格指数
     */
    public void setPriceIndex(Double priceIndex) {
        this.priceIndex = priceIndex;
    }
}
