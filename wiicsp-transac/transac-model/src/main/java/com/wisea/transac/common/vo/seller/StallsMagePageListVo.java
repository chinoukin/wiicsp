package com.wisea.transac.common.vo.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("档口分页查询Vo")
public class StallsMagePageListVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="店铺id")
    private Long shopId;

    @ApiModelProperty(value="批发市场id")
    private Long wholeSaleMarketId;

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
    @ApiModelProperty(value="所在地区省名称")
    private String areaProvName;

    @ApiModelProperty(value="所在地区市")
    private String areaCity;
    @ApiModelProperty(value="所在地区市名称")
    private String areaCityName;

    @ApiModelProperty(value="所在地区县")
    private String areaCou;
    @ApiModelProperty(value="所在地区县名称")
    private String areaCouName;

    @ApiModelProperty(value="详细地址")
    private String address;

    @ApiModelProperty(value="显示位置")
    private Integer sort;

    @ApiModelProperty(value="停启用状态，0启用")
    private String effeInvalState;

    @ApiModelProperty(value="档口封面图片")
    private String backGroundUrl;

    @ApiModelProperty(value="监控视频地址")
    private List<StallsVideoMagePageListVo> videos;

    @ApiModelProperty(value="是否开启实时监控，0开启，1不开启")
    private String videoContrl;

    @ApiModelProperty("默认播放视频地址")
    private String videoUrl;
    @ApiModelProperty(value="交易区id")
    private Long tradAreaId;
    @ApiModelProperty(value="交易区名称")
    private String tradAreaName;
    @ApiModelProperty(value="市场名称")
    private String wholeSaleMarketName;
    @ApiModelProperty(value="关注数量")
    private Long followCount;
    @ApiModelProperty(value="销量")
    private Double salesVolume;

    public Long getFollowCount() {
        return followCount;
    }

    public void setFollowCount(Long followCount) {
        this.followCount = followCount;
    }

    public Double getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Double salesVolume) {
        this.salesVolume = salesVolume;
    }

    public String getWholeSaleMarketName() {
        return wholeSaleMarketName;
    }

    public void setWholeSaleMarketName(String wholeSaleMarketName) {
        this.wholeSaleMarketName = wholeSaleMarketName;
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

    public String getTradAreaName() {
        return tradAreaName;
    }

    public void setTradAreaName(String tradAreaName) {
        this.tradAreaName = tradAreaName;
    }

    public Long getTradAreaId() {
        return tradAreaId;
    }

    public void setTradAreaId(Long tradAreaId) {
        this.tradAreaId = tradAreaId;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoContrl() {
        return videoContrl;
    }

    public void setVideoContrl(String videoContrl) {
        this.videoContrl = videoContrl;
    }

    public List<StallsVideoMagePageListVo> getVideos() {
        return videos;
    }

    public void setVideos(List<StallsVideoMagePageListVo> videos) {
        this.videos = videos;
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
