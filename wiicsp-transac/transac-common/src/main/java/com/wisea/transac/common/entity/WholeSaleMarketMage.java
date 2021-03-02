package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;
import io.swagger.annotations.ApiModelProperty;

public class WholeSaleMarketMage extends DataLongEntity<WholeSaleMarketMage> {
    /**
     * 批发市场名称
     */
    private String wholeSaleMarketName;

    /**
     * 批发市场图片
     */
    private String wholeSaleMarketPicture;

    /**
     * 所在区域省
     */
    private String areaProv;

    /**
     * 所在区域市
     */
    private String areaCity;

    /**
     * 所在区域区县
     */
    private String areaCou;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 坐标点
     */
    private String coordinatePoint;

    /**
     * 交易范围
     */
    private String transScope;

    /**
     * 批发市场介绍
     */
    private String wholeSaleMarketSignature;

    /**
     * 市场管理员账号
     */
    private String marketMageNum;

    @ApiModelProperty(value="市场标签1")
    private String marketLabelOne;

    @ApiModelProperty(value="市场标签2")
    private String marketLabelTwo;

    @ApiModelProperty(value="市场标签3")
    private String marketLabelTree;

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

    public String getWholeSaleMarketName() {
        return wholeSaleMarketName;
    }

    public void setWholeSaleMarketName(String wholeSaleMarketName) {
        this.wholeSaleMarketName = wholeSaleMarketName;
    }

    public String getWholeSaleMarketPicture() {
        return wholeSaleMarketPicture;
    }

    public void setWholeSaleMarketPicture(String wholeSaleMarketPicture) {
        this.wholeSaleMarketPicture = wholeSaleMarketPicture;
    }

    public String getAreaProv() {
        return areaProv;
    }

    public void setAreaProv(String areaProv) {
        this.areaProv = areaProv;
    }

    public String getAreaCity() {
        return areaCity;
    }

    public void setAreaCity(String areaCity) {
        this.areaCity = areaCity;
    }

    public String getAreaCou() {
        return areaCou;
    }

    public void setAreaCou(String areaCou) {
        this.areaCou = areaCou;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCoordinatePoint() {
        return coordinatePoint;
    }

    public void setCoordinatePoint(String coordinatePoint) {
        this.coordinatePoint = coordinatePoint;
    }

    public String getTransScope() {
        return transScope;
    }

    public void setTransScope(String transScope) {
        this.transScope = transScope;
    }

    public String getWholeSaleMarketSignature() {
        return wholeSaleMarketSignature;
    }

    public void setWholeSaleMarketSignature(String wholeSaleMarketSignature) {
        this.wholeSaleMarketSignature = wholeSaleMarketSignature;
    }

    public String getMarketMageNum() {
        return marketMageNum;
    }

    public void setMarketMageNum(String marketMageNum) {
        this.marketMageNum = marketMageNum;
    }

}
