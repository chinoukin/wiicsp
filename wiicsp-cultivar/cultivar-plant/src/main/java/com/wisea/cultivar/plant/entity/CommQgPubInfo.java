package com.wisea.cultivar.plant.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class CommQgPubInfo extends DataLongEntity<CommQgPubInfo> {
    /**
     * 会员id
     */
    private Long membId;

    /**
     * 供求产品类型
     */
    private String commQgType;

    /**
     * 发布供应标题
     */
    private String pubQgTitle;

    /**
     * 采购量
     */
    private Double cgl;

    /**
     * 产品标准
     */
    private String cpbzType;

    /**
     * 期望价格
     */
    private Double wishPrice;

    /**
     * 期望产地
     */
    private String qwcd;

    /**
     * 采购人姓名
     */
    private String contactsName;

    /**
     * 采购人手机
     */
    private String contactsTel;

    /**
     * 发布时间
     */
    private OffsetDateTime pubDate;

    /**
     * 交货方式
     */
    private String deliveryMode;

    /**
     * 供求状态类型
     */
    private String qgStateType;

    /**
     * 联系数
     */
    private Integer contactsNum;

    /**
     * 浏览数
     */
    private Integer views;

    /**
     * 其他描述
     */
    private String qtcgyq;


    /**
     * 求购数量计量单位id
     */
    private Long cglMeasUnitId;
    /**
     * 期望价格计量单位id
     */
    private Long wishPriceMeasUnitId;


    public Long getCglMeasUnitId() {
        return cglMeasUnitId;
    }

    public void setCglMeasUnitId(Long cglMeasUnitId) {
        this.cglMeasUnitId = cglMeasUnitId;
    }

    public Long getWishPriceMeasUnitId() {
        return wishPriceMeasUnitId;
    }

    public void setWishPriceMeasUnitId(Long wishPriceMeasUnitId) {
        this.wishPriceMeasUnitId = wishPriceMeasUnitId;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getCommQgType() {
        return commQgType;
    }

    public void setCommQgType(String commQgType) {
        this.commQgType = commQgType;
    }

    public String getPubQgTitle() {
        return pubQgTitle;
    }

    public void setPubQgTitle(String pubQgTitle) {
        this.pubQgTitle = pubQgTitle;
    }

    public Double getCgl() {
        return cgl;
    }

    public void setCgl(Double cgl) {
        this.cgl = cgl;
    }

    public String getCpbzType() {
        return cpbzType;
    }

    public void setCpbzType(String cpbzType) {
        this.cpbzType = cpbzType;
    }

    public Double getWishPrice() {
        return wishPrice;
    }

    public void setWishPrice(Double wishPrice) {
        this.wishPrice = wishPrice;
    }

    public String getQwcd() {
        return qwcd;
    }

    public void setQwcd(String qwcd) {
        this.qwcd = qwcd;
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    public String getContactsTel() {
        return contactsTel;
    }

    public void setContactsTel(String contactsTel) {
        this.contactsTel = contactsTel;
    }

    public OffsetDateTime getPubDate() {
        return pubDate;
    }

    public void setPubDate(OffsetDateTime pubDate) {
        this.pubDate = pubDate;
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    public String getQgStateType() {
        return qgStateType;
    }

    public void setQgStateType(String qgStateType) {
        this.qgStateType = qgStateType;
    }

    public Integer getContactsNum() {
        return contactsNum;
    }

    public void setContactsNum(Integer contactsNum) {
        this.contactsNum = contactsNum;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getQtcgyq() {
        return qtcgyq;
    }

    public void setQtcgyq(String qtcgyq) {
        this.qtcgyq = qtcgyq;
    }
}
