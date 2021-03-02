package com.wisea.cultivar.common.entity.tp;

import java.time.OffsetDateTime;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * bulk_transaction_activity 表实体
 * 大宗交易动态
 * 2019/05/28 16:20:20
 */
public class BulkTransactionActivity extends DataLongEntity<BulkTransactionActivity> {
    private static final long serialVersionUID = 1L;

    /**
     * 图片地址
     */
	private String imgUrl;
    /**
     * 商品名称
     */
    private String commName;

    /**
     * 交易额
     */
    private Double transPrice;

    /**
     * 交易内容
     */
    private String transSubject;

    /**
     * 交易日期
     */
    private OffsetDateTime transDate;

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
     * 获取交易额
     */
    public Double getTransPrice() {
        return transPrice;
    }

    /**
     * 设置交易额
     */
    public void setTransPrice(Double transPrice) {
        this.transPrice = transPrice;
    }

    /**
     * 获取交易内容
     */
    public String getTransSubject() {
        return transSubject;
    }

    /**
     * 设置交易内容
     */
    public void setTransSubject(String transSubject) {
        this.transSubject = transSubject == null ? null : transSubject.trim();
    }

    /**
     * 获取交易日期
     */
    public OffsetDateTime getTransDate() {
        return transDate;
    }

    /**
     * 设置交易日期
     */
    public void setTransDate(OffsetDateTime transDate) {
        this.transDate = transDate;
    }

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}
