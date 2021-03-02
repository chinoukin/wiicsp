package com.wisea.transac.common.po.seller;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.seller.StallsMagePageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("档口管理分页查询Po")
public class StallsMagePageListPo extends PagePo<StallsMagePageListVo> {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "店铺id")
    private Long shopId;

    @ApiModelProperty(value = "批发市场id")
    private Long wholeSaleMarketId;

    @ApiModelProperty(value = "档口名称")
    private String stallsName;

    @ApiModelProperty(value = "档口门牌号")
    private String stallsHouseNum;

    @ApiModelProperty(value = "联系人")
    private String contacts;

    @ApiModelProperty(value = "联系方式")
    private String contTel;

    @ApiModelProperty(value = "营业日期")
    private String businessDate;

    @ApiModelProperty(value = "营业时间")
    private String businessTime;

    @ApiModelProperty(value = "所在地区省")
    private String areaProv;

    @ApiModelProperty(value = "所在地区市")
    private String areaCity;

    @ApiModelProperty(value = "所在地区县")
    private String areaCou;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "显示位置")
    private Integer sort;

    @ApiModelProperty(value = "停启用状态")
    private String effeInvalState;

    @ApiModelProperty(value = "档口封面图片")
    private String backGroundUrl;

    @ApiModelProperty(value = "交易区ID")
    private Long tradAreaId;

    @ApiModelProperty(value = "交易区id 集合")
    private List<Long> tradAreaIds;

    @ApiModelProperty(value = "品类ID")
    private Long commId;

    @ApiModelProperty(value = "销售员工ID")
    private Long saleId;

    @ApiModelProperty("逛市场页面 使用- 关注排序标识")
    private String followCount;

    @ApiModelProperty("逛市场页面 使用- 销量标识")
    private Double salesVolume;

    @ApiModelProperty(value = "逛市场页面 使用 - 排序方式 正序 asc 倒序 desc")
    private String orderBy;

    @ApiModelProperty(value = "逛市场页面 使用 - 模糊查询信息")
    private String query;

    public List<Long> getTradAreaIds() {
        return tradAreaIds;
    }

    public void setTradAreaIds(List<Long> tradAreaIds) {
        this.tradAreaIds = tradAreaIds;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getFollowCount() {
        return followCount;
    }

    public void setFollowCount(String followCount) {
        this.followCount = followCount;
    }

    public Double getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Double salesVolume) {
        this.salesVolume = salesVolume;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public Long getTradAreaId() {
        return tradAreaId;
    }

    public void setTradAreaId(Long tradAreaId) {
        this.tradAreaId = tradAreaId;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
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
