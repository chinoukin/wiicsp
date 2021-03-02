package com.wisea.cultivar.plant.po;

import com.wisea.cultivar.plant.entity.CommGyPubPicture;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.List;

@ApiModel("新增或修改CommGyPubInfoPo")
public class CommGyPubInfoPo {
    @ApiModelProperty(value="数据ID，修改时该字段必填")
    private Long id;

    @ApiModelProperty(value="会员id")
    private Long membId;

    @ApiModelProperty(value="供求产品类型")
    private String commQgType;

    @ApiModelProperty(value="发布供应标题")
    private String pubGyTitle;

    @ApiModelProperty(value="供应的图片")
    private List<CommGyPubPicture> commGyPubPictureList;

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

    @ApiModelProperty(value="发布时间")
    private OffsetDateTime pubDate;

    @ApiModelProperty(value="供求状态类型")
    private String qgStateType;

    @ApiModelProperty(value="所在产地")
    private String placeOrigin;

    @ApiModelProperty(value="联系数")
    private Integer contactsNum;

    @ApiModelProperty(value="浏览数")
    private Integer views;

    @ApiModelProperty(value="其他描述")
    private String qtcgyq;

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

    public List<CommGyPubPicture> getCommGyPubPictureList() {
        return commGyPubPictureList;
    }

    public void setCommGyPubPictureList(List<CommGyPubPicture> commGyPubPictureList) {
        this.commGyPubPictureList = commGyPubPictureList;
    }

    public String getPlaceOrigin() {
        return placeOrigin;
    }

    public void setPlaceOrigin(String placeOrigin) {
        this.placeOrigin = placeOrigin;
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
