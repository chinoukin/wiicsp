package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class StallsMage extends DataLongEntity<StallsMage> {
    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 批发市场id
     */
    private Long wholeSaleMarketId;

    /**
     * 档口名称
     */
    private String stallsName;

    /**
     * 档口门牌号
     */
    private String stallsHouseNum;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 联系方式
     */
    private String contTel;

    /**
     * 营业日期
     */
    private String businessDate;

    /**
     * 营业时间
     */
    private String businessTime;

    /**
     * 所在地区省
     */
    private String areaProv;

    /**
     * 所在地区市
     */
    private String areaCity;

    /**
     * 所在地区县
     */
    private String areaCou;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 显示位置
     */
    private Integer sort;

    /**
     * 停启用状态
     */
    private String effeInvalState;

    /**
     * 档口封面图片
     */
    private String backGroundUrl;

    private Long tradAreaId;

    public Long getTradAreaId() {
        return tradAreaId;
    }

    public void setTradAreaId(Long tradAreaId) {
        this.tradAreaId = tradAreaId;
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
