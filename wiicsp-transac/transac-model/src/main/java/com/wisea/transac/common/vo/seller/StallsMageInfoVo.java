package com.wisea.transac.common.vo.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("档口详细信息Vo")
public class StallsMageInfoVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="店铺id")
    private Long shopId;

    @ApiModelProperty(value="批发市场id")
    private Long wholeSaleMarketId;
    @ApiModelProperty(value="批发市场名称")
    private String  wholeSaleMarketName;

    @ApiModelProperty(value="档口名称")
    private String stallsName;

    @ApiModelProperty(value="档口门牌号")
    private String stallsHouseNum;

    @ApiModelProperty(value="联系人")
    private String contacts;

    @ApiModelProperty(value="联系方式")
    private String contTel;

    @ApiModelProperty(value="营业日期")
    private String businessDate;

    @ApiModelProperty(value="营业时间")
    private String businessTime;

    @ApiModelProperty(value="所在地区省")
    private String areaProv;

    @ApiModelProperty(value="所在地区市")
    private String areaCity;

    @ApiModelProperty(value="所在地区县")
    private String areaCou;

    @ApiModelProperty(value="所在地区省名称")
    private String areaProvName;

    @ApiModelProperty(value="所在地区市名称")
    private String areaCityName;

    @ApiModelProperty(value="所在地区县名称")
    private String areaCouName;

    @ApiModelProperty(value="详细地址")
    private String address;

    @ApiModelProperty(value="显示位置")
    private Integer sort;

    @ApiModelProperty(value="停启用状态")
    private String effeInvalState;

    @ApiModelProperty(value="档口封面图片")
    private String backGroundUrl;

    @ApiModelProperty("店铺名称")
    private String shopName;
    @ApiModelProperty(value="交易区id")
    private Long tradAreaId;
    @ApiModelProperty(value="交易区名称")
    private String tradAreaName;

    public String getWholeSaleMarketName() {
        return wholeSaleMarketName;
    }

    public void setWholeSaleMarketName(String wholeSaleMarketName) {
        this.wholeSaleMarketName = wholeSaleMarketName;
    }

    public Long getTradAreaId() {
        return tradAreaId;
    }

    public void setTradAreaId(Long tradAreaId) {
        this.tradAreaId = tradAreaId;
    }

    public String getTradAreaName() {
        return tradAreaName;
    }

    public void setTradAreaName(String tradAreaName) {
        this.tradAreaName = tradAreaName;
    }

    public String getAreaProvName() {
        return areaProvName;
    }

    public void setAreaProvName(String areaProvName) {
        this.areaProvName = areaProvName;
    }

    public String getAreaCityName() {
        return areaCityName;
    }

    public void setAreaCityName(String areaCityName) {
        this.areaCityName = areaCityName;
    }

    public String getAreaCouName() {
        return areaCouName;
    }

    public void setAreaCouName(String areaCouName) {
        this.areaCouName = areaCouName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Long getWholeSaleMarketId() {
        return wholeSaleMarketId;
    }

    public void setWholeSaleMarketId(Long wholeSaleMarketId) {
        this.wholeSaleMarketId = wholeSaleMarketId;
    }

    public String getStallsName() {
        return stallsName;
    }

    public void setStallsName(String stallsName) {
        this.stallsName = stallsName;
    }

    public String getStallsHouseNum() {
        return stallsHouseNum;
    }

    public void setStallsHouseNum(String stallsHouseNum) {
        this.stallsHouseNum = stallsHouseNum;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContTel() {
        return contTel;
    }

    public void setContTel(String contTel) {
        this.contTel = contTel;
    }

    public String getBusinessDate() {
        return businessDate;
    }

    public void setBusinessDate(String businessDate) {
        this.businessDate = businessDate;
    }

    public String getBusinessTime() {
        return businessTime;
    }

    public void setBusinessTime(String businessTime) {
        this.businessTime = businessTime;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getEffeInvalState() {
        return effeInvalState;
    }

    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState;
    }

    public String getBackGroundUrl() {
        return backGroundUrl;
    }

    public void setBackGroundUrl(String backGroundUrl) {
        this.backGroundUrl = backGroundUrl;
    }
}
