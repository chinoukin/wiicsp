package com.wisea.transac.common.vo.seller;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("店铺详细信息Vo")
public class ShopInfoInfoVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="商户id")
    private Long merchantId;

    @ApiModelProperty(value="店铺名称")
    private String shopName;

    @ApiModelProperty(value="店铺背景图")
    private String backGroundUrl;

    @ApiModelProperty(value="店铺介绍")
    private String shopSignature;

    @ApiModelProperty(value="是否商家，0是")
    private String agentFlag;

    @ApiModelProperty(value="创建日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime createDate;

    @ApiModelProperty(value="市场ID")
    private Long wholeSaleMarketId;
    @ApiModelProperty(value="市场名称")
    private String  wholeSaleMarketName;
    @ApiModelProperty(value="市场标签1")
    private String marketLabelOne;

    @ApiModelProperty(value="市场标签2")
    private String marketLabelTwo;

    @ApiModelProperty(value="市场标签3")
    private String marketLabelTree;

    @ApiModelProperty(value="是否被关注，0否，1是")
    private String follow;

    @ApiModelProperty("是否已修改过名称，1已修改过")
    private String remarks;

    @ApiModelProperty("省code")
    private String areaProv;
    @ApiModelProperty("省名称")
    private String areaProvName;
    @ApiModelProperty("市code")
    private String areaCity;
    @ApiModelProperty("市名称")
    private String areaCityName;
    @ApiModelProperty("县code")
    private String areaCou;
    @ApiModelProperty("县名称")
    private String areaCouName;
    @ApiModelProperty("地址")
    private String address;

    public String getMarketLabelOne() {
        return marketLabelOne;
    }

    public void setMarketLabelOne(String marketLabelOne) {
        this.marketLabelOne = marketLabelOne;
    }

    public String getMarketLabelTwo() {
        return marketLabelTwo;
    }

    public void setMarketLabelTwo(String marketLabelTwo) {
        this.marketLabelTwo = marketLabelTwo;
    }

    public String getMarketLabelTree() {
        return marketLabelTree;
    }

    public void setMarketLabelTree(String marketLabelTree) {
        this.marketLabelTree = marketLabelTree;
    }

    public String getAreaProv() {
        return areaProv;
    }

    public void setAreaProv(String areaProv) {
        this.areaProv = areaProv;
    }

    public String getAreaProvName() {
        return areaProvName;
    }

    public void setAreaProvName(String areaProvName) {
        this.areaProvName = areaProvName;
    }

    public String getAreaCity() {
        return areaCity;
    }

    public void setAreaCity(String areaCity) {
        this.areaCity = areaCity;
    }

    public String getAreaCityName() {
        return areaCityName;
    }

    public void setAreaCityName(String areaCityName) {
        this.areaCityName = areaCityName;
    }

    public String getAreaCou() {
        return areaCou;
    }

    public void setAreaCou(String areaCou) {
        this.areaCou = areaCou;
    }

    public String getAreaCouName() {
        return areaCouName;
    }

    public void setAreaCouName(String areaCouName) {
        this.areaCouName = areaCouName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getFollow() {
        return follow;
    }

    public void setFollow(String follow) {
        this.follow = follow;
    }

    public Long getWholeSaleMarketId() {
        return wholeSaleMarketId;
    }

    public void setWholeSaleMarketId(Long wholeSaleMarketId) {
        this.wholeSaleMarketId = wholeSaleMarketId;
    }

    public String getWholeSaleMarketName() {
        return wholeSaleMarketName;
    }

    public void setWholeSaleMarketName(String wholeSaleMarketName) {
        this.wholeSaleMarketName = wholeSaleMarketName;
    }

    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
    }

    public String getAgentFlag() {
        return agentFlag;
    }

    public void setAgentFlag(String agentFlag) {
        this.agentFlag = agentFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getBackGroundUrl() {
        return backGroundUrl;
    }

    public void setBackGroundUrl(String backGroundUrl) {
        this.backGroundUrl = backGroundUrl;
    }

    public String getShopSignature() {
        return shopSignature;
    }

    public void setShopSignature(String shopSignature) {
        this.shopSignature = shopSignature;
    }
}
