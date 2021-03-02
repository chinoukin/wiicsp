package com.wisea.cultivar.plant.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

@ApiModel("分页查询CommGyPubInfoVo")
public class CommGyPubInfoPageListVo {

    @ApiModelProperty(value="供应id")
    private Long id;
    @ApiModelProperty(value="会员id")
    private Long membId;
    @ApiModelProperty(value="供求产品类型")
    private String commQgType;
    @ApiModelProperty(value="发布供应标题")
    private String pubGyTitle;
    @ApiModelProperty(value="可供量")
    private Double listCount;
    @ApiModelProperty(value="期望价格")
    private Double wishPrice;
    @ApiModelProperty(value="产品标准")
    private String cpbzType;
    @ApiModelProperty(value="交货方式")
    private String deliveryMode;
    @ApiModelProperty(value="联系人姓名")
    private String contactsName;
    @ApiModelProperty(value="联系人手机")
    private String contactsTel;
    @ApiModelProperty(value="求购数量计量单位名称")
    private String cglMeasUnitName;
    @ApiModelProperty(value="期望价格计量单位名称")
    private String  wishPriceMeasUnitName;
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value="发布时间")
    private OffsetDateTime pubDate;
    @ApiModelProperty(value="供求状态类型  0 上架 不需要删除 1 需要删除")
    private String qgStateType;
    @ApiModelProperty(value="联系数")
    private Integer contactsNum;
    @ApiModelProperty(value="其他描述")
    private String   qtcgyq;
    @ApiModelProperty(value="所在产地")
    private String   placeOrigin;
    @ApiModelProperty(value="浏览数")
    private Integer views;
    @ApiModelProperty(value="商品供应图片")
    private String commGyPubPicture;
    @ApiModelProperty(value="收藏状态 如果有值说明收藏了  他的值就是收藏表的id")
    private Long membCollectionId;
    @ApiModelProperty(value="收藏状态  0表示有效  1表示失效")
    private String status;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getMembCollectionId() {
        return membCollectionId;
    }

    public void setMembCollectionId(Long membCollectionId) {
        this.membCollectionId = membCollectionId;
    }

    public String getCommGyPubPicture() {
        return commGyPubPicture;
    }

    public void setCommGyPubPicture(String commGyPubPicture) {
        this.commGyPubPicture = commGyPubPicture;
    }

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

    public String getCglMeasUnitName() {
        return cglMeasUnitName;
    }

    public void setCglMeasUnitName(String cglMeasUnitName) {
        this.cglMeasUnitName = cglMeasUnitName;
    }

    public String getWishPriceMeasUnitName() {
        return wishPriceMeasUnitName;
    }

    public void setWishPriceMeasUnitName(String wishPriceMeasUnitName) {
        this.wishPriceMeasUnitName = wishPriceMeasUnitName;
    }
}
