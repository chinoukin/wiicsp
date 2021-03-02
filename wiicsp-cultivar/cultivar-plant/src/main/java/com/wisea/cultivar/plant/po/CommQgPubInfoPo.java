package com.wisea.cultivar.plant.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

@ApiModel("新增或修改CommQgPubInfoPo")
public class CommQgPubInfoPo {
    @ApiModelProperty(value="数据ID，修改时该字段必填")
    private Long id;

    @ApiModelProperty(value="会员id")
    private Long membId;

    @ApiModelProperty(value="供求产品类型")
    private String commQgType;

    @ApiModelProperty(value="发布供应标题")
    private String pubQgTitle;

    @ApiModelProperty(value="采购量")
    private Double cgl;

    @ApiModelProperty(value="产品标准")
    private String cpbzType;

    @ApiModelProperty(value="期望价格")
    private Double wishPrice;

    @ApiModelProperty(value="期望产地")
    private String qwcd;

    @ApiModelProperty(value="其他描述")
    private String qtcgyq;

    @ApiModelProperty(value="采购人姓名")
    private String contactsName;

    @ApiModelProperty(value="采购人手机")
    private String contactsTel;

    @ApiModelProperty(value="发布时间")
    private OffsetDateTime pubDate;

    @ApiModelProperty(value="交货方式")
    private String deliveryMode;

    @ApiModelProperty(value="供求状态类型 默认是0上架，1下架")
    private String qgStateType;

    @ApiModelProperty(value="联系数")
    private Integer contactsNum;

    @ApiModelProperty(value="浏览数")
    private Integer views;

    @ApiModelProperty(value="求购数量计量单位id")
    private Long cglMeasUnitId;

    @ApiModelProperty(value="期望价格计量单位id")
    private Long wishPriceMeasUnitId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
