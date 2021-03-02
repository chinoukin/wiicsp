package com.wisea.transac.common.po;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.WholeSaleMarketMagePageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询Po")
public class WholeSaleMarketMagePageListPo extends PagePo<WholeSaleMarketMagePageListVo> {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="批发市场名称")
    private String wholeSaleMarketName;

    @ApiModelProperty(value="批发市场图片")
    private String wholeSaleMarketPicture;

    @ApiModelProperty(value="所在区域省")
    private String areaProv;

    @ApiModelProperty(value="所在区域市")
    private String areaCity;

    @ApiModelProperty(value="所在区域区县")
    private String areaCou;

    @ApiModelProperty(value="详细地址")
    private String address;

    @ApiModelProperty(value="坐标点")
    private String coordinatePoint;

    @ApiModelProperty(value="交易范围")
    private String transScope;

    @ApiModelProperty(value="批发市场介绍")
    private String wholeSaleMarketSignature;

    @ApiModelProperty(value="市场管理员账号")
    private String marketMageNum;

    @ApiModelProperty(value="微信坐标点")
    private String wxCoordinate;

    public String getWxCoordinate() {
        return wxCoordinate;
    }

    public void setWxCoordinate(String wxCoordinate) {
        this.wxCoordinate = wxCoordinate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
