package com.wisea.cultivar.plant.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class CommGyPubInfo extends DataLongEntity<CommGyPubInfo> {
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
    private String pubGyTitle;

    /**
     * 可供量
     */
    private Double listCount;

    /**
     * 期望价格
     */
    private Double wishPrice;

    /**
     * 产品标准
     */
    private String cpbzType;

    /**
     * 交货方式
     */
    private String deliveryMode;

    /**
     * 联系人姓名
     */
    private String contactsName;

    /**
     * 联系人手机
     */
    private String contactsTel;

    /**
     * 发布时间
     */
    private OffsetDateTime pubDate;

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
     * 所在产地
     */
    private String placeOrigin;

    /**
     * 求购数量计量单位id
     */
    private Long cglMeasUnitId;
    /**
     * 期望价格计量单位id
     */
    private Long wishPriceMeasUnitId;

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

    public String getPubGyTitle() {
        return pubGyTitle;
    }

    public void setPubGyTitle(String pubGyTitle) {
        this.pubGyTitle = pubGyTitle;
    }

    public Double getListCount() {
        return listCount;
    }

    public void setListCount(Double listCount) {
        this.listCount = listCount;
    }

    public Double getWishPrice() {
        return wishPrice;
    }

    public void setWishPrice(Double wishPrice) {
        this.wishPrice = wishPrice;
    }

    public String getCpbzType() {
        return cpbzType;
    }

    public void setCpbzType(String cpbzType) {
        this.cpbzType = cpbzType;
    }

    public String getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(String deliveryMode) {
        this.deliveryMode = deliveryMode;
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

    public String getPlaceOrigin() {
        return placeOrigin;
    }

    public void setPlaceOrigin(String placeOrigin) {
        this.placeOrigin = placeOrigin;
    }

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
}
