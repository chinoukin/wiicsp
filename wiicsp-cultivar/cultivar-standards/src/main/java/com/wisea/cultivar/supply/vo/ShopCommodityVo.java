package com.wisea.cultivar.supply.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 店铺商品
 * @author chengq
 * @date 2020/8/12 10:18
 */
public class ShopCommodityVo {

    /**
     * 商品id
     */
    @ApiModelProperty("商品id")
    private String id;

    /**
     * 商品标题
     */
    @ApiModelProperty("商品标题")
    private String title;

    /**
     * 商品分类
     */
    @ApiModelProperty("商品分类")
    private String variet;

    /**
     * 商品图片
     */
    @ApiModelProperty("商品图片")
    private String pictureUrl;

    /**
     * 图片类型
     */
    @ApiModelProperty("图片类型 0-图片 1-视频")
    private String pictureType;

    /**
     * 商品金额
     */
    @ApiModelProperty(value = "商品金额", example = "¥3.00")
    private String price;

    /**
     * 商品编号
     */
    @ApiModelProperty("商品编号")
    private String commNum;

    /**
     * 商品状态类型
     */
    @ApiModelProperty("商品状态类型 0-销售中 1-草稿 2-待审核 3-已下架 4-被驳回")
    private String commStateType;

    /**
     * 商品被驳回原因
     */
    @ApiModelProperty("商品被驳回原因")
    private String rejectReason;

    /**
     * 销量
     */
    @ApiModelProperty("销量")
    private Double salesVolume;

    /**
     * 最低价
     */
    @ApiModelProperty("最低价")
    private String lowestPrice;

    /**
     * 最高价
     */
    @ApiModelProperty("最高价")
    private String highestPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVariet() {
        return variet;
    }

    public void setVariet(String variet) {
        this.variet = variet;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPictureType() {
        return pictureType;
    }

    public void setPictureType(String pictureType) {
        this.pictureType = pictureType;
    }

    public String getCommNum() {
        return commNum;
    }

    public void setCommNum(String commNum) {
        this.commNum = commNum;
    }

    public String getCommStateType() {
        return commStateType;
    }

    public Double stateToDouble() {
        return Double.valueOf(commStateType);
    }

    public void setCommStateType(String commStateType) {
        this.commStateType = commStateType;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public Double getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Double salesVolume) {
        this.salesVolume = salesVolume;
    }

    public String getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(String lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public String getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(String highestPrice) {
        this.highestPrice = highestPrice;
    }
}
