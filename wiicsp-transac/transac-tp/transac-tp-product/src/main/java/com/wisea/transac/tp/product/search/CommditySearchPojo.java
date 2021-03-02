package com.wisea.transac.tp.product.search;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.annotation.LongSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.transac.common.entity.BaseSearchPojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;


/**
 * demo搜索模型
 *
 * @author: wangs
 */
@ApiModel("供应大厅搜索条件")
public class CommditySearchPojo extends BaseSearchPojo {

    @ApiModelProperty("发布商品id")
    @JsonSerialize(using = LongSerializer.class)
    private String id;
    /**
     * 会员id
     */
    @JsonSerialize(using = LongSerializer.class)
    @ApiModelProperty("会员id")
    private String membId;

    @ApiModelProperty("会员公司名称")
    private String membAuthName;

    @JsonSerialize(using = LongSerializer.class)
    @ApiModelProperty("销售分类设置的id")
    private String commSaleSetId;

    /**
     * 销售分类的名称
     */
    @JsonSerialize(using = LongSerializer.class)
    @ApiModelProperty("销售分类设置的名称")
    private String commSaleCatgSetName;

    @ApiModelProperty("销售分类设置排序")
    private Integer salesSetSort;

    @JsonSerialize(using = LongSerializer.class)
    @ApiModelProperty("销售分类id")
    private String commSaleId;

    @JsonSerialize(using = LongSerializer.class)
    @ApiModelProperty("销售分类的名称")
    private String commSaleCatgName;

    @ApiModelProperty("销售分类排序")
    private Integer salesSort;

    /**
     * 销售分类设置数组
     */
    @ApiModelProperty("销售分类设置数组")
    private String[] commSaleSetIds;

    /**
     * 品种的名称
     */
    @JsonSerialize(using = LongSerializer.class)
    @ApiModelProperty("品种的名称")
    private String commVatrieName;

    /**
     * 档口id
     */
    @JsonSerialize(using = LongSerializer.class)
    @ApiModelProperty("档口id")
    private String stallsMageId;

    /**
     * 档口名称
     */
    @ApiModelProperty("档口名称")
    private String stallsMageName;

    @ApiModelProperty("档口营业工作日")
    private String businessDate;

    @ApiModelProperty("档口营业时间")
    private String businessTime;

    @ApiModelProperty("档口门牌号")
    private String stallsHouseNum;

    /**
     * 批发市场id
     */
    @JsonSerialize(using = LongSerializer.class)
    @ApiModelProperty("品种的名称")
    private String wholeSaleMarketId;
    /**
     * 品牌ID
     */
    @JsonSerialize(using = LongSerializer.class)
    @ApiModelProperty("品牌id")
    private String brandId;

    /**
     * 图片url
     */
    @ApiModelProperty(value = "url")
    private String imageUrl;
    /**
     * 商品编号
     */
    @ApiModelProperty("商品编号")
    private String commNum;
    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    private String commTitle;
    /**
     * 计量单位:公斤、吨
     */
    @ApiModelProperty("计量单位")
    private String measUnit;

    /**
     * 商品状态类型
     */
    @ApiModelProperty("商品状态")
    private String commStateType;

    /**
     * 销量
     */
    @ApiModelProperty(value = "销量")
    private Integer salesCount;

    /**
     * 商品品种id
     */
    @JsonSerialize(using = LongSerializer.class)
    @ApiModelProperty(value = "商品品种id")
    private String commVarietId;

    @ApiModelProperty(value = "最小起订量")
    private Double startOrdCount;

    @ApiModelProperty("服务支持,对应的id 值")
    private String serSupportType;

    private String serSupportIds;

    @ApiModelProperty("全部价格")
    private String allPrice;

    @ApiModelProperty("商品最小价格,小程序 搜索时 按最小价格排序 传值1")
    private Double minPrice;

    @ApiModelProperty("销量")
    private Integer salesVolume;

    @ApiModelProperty("店铺id")
    private String shopId;

    @ApiModelProperty("店铺名称")
    private String shopName;

    @ApiModelProperty("背景图")
    private String backGroundUrl;

    @ApiModelProperty("价格区间开始值")
    private Integer priceSectionStart;

    @ApiModelProperty("价格区间结束")
    private Integer priceSectionEnd;

    @ApiModelProperty("起批量开始值")
    private Integer startBullk;

    @ApiModelProperty("起批量结束")
    private Integer endBullk;

    @ApiModelProperty(value = "审核状态(auth_state_type[2:实名认证中3:审核通过(已认证)]为空为未填写认证信息)")
    private String realPersonAuth;

    @ApiModelProperty(value = "审核状态(auth_state_type[0:待平台审核1:待银盛开户3:审核通过(已认证)4:审核未通过]为空为未填写认证信息)")
    private String indBusiAuth;

    @ApiModelProperty(value = "审核状态(auth_state_type[0:待平台审核1:待银盛开户3:审核通过(已认证)4:审核未通过]为空为未填写认证信息)")
    private String entpAuth;

    @ApiModelProperty(value = "服务支持Id")
    private String[] supportTypeId;

    @ApiModelProperty(value = "搜索类型(searchType 0 查询店铺; searchType 1 查询相关档口)")
    private  String searchType;

    @ApiModelProperty(value = "搜索类型(commditySourceType 0 基地类型)")
    private  String commditySourceType;

    @ApiModelProperty("仓库类型")
    private String storageType;

    @ApiModelProperty("所在仓储id")
    private String storageId;

    @ApiModelProperty("所在种植园id")
    private String plantationId;

    @ApiModelProperty("口岸id")
    private String portId;

    @ApiModelProperty("口岸名称")
    private String portName;

    @ApiModelProperty("基地id")
    private String baseId;

    @ApiModelProperty("基地名称")
    private String baseName;

    @ApiModelProperty("库存量")
    private Integer avaiSupplyCount;

    @ApiModelProperty("货品类型:0 非标件; 1 标价")
    private String goodsType;

    @ApiModelProperty("一件代发服务标志 : 0 是 ; 1 否")
    private String yjdfFlag;

    @ApiModelProperty("国产精品分类type")
    private String domesticProducts;

    @ApiModelProperty("等级")
    private String grade;

    public String getSerSupportIds() {
        return serSupportIds;
    }

    public void setSerSupportIds(String serSupportIds) {
        this.serSupportIds = serSupportIds;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String[] getCommSaleSetIds() {
        return commSaleSetIds;
    }

    public void setCommSaleSetIds(String[] commSaleSetIds) {
        this.commSaleSetIds = commSaleSetIds;
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

    public String getStallsHouseNum() {
        return stallsHouseNum;
    }

    public void setStallsHouseNum(String stallsHouseNum) {
        this.stallsHouseNum = stallsHouseNum;
    }

    public String getDomesticProducts() {
        return domesticProducts;
    }

    public void setDomesticProducts(String domesticProducts) {
        this.domesticProducts = domesticProducts;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getYjdfFlag() {
        return yjdfFlag;
    }

    public void setYjdfFlag(String yjdfFlag) {
        this.yjdfFlag = yjdfFlag;
    }

    public String getCommditySourceType() {
        return commditySourceType;
    }

    public void setCommditySourceType(String commditySourceType) {
        this.commditySourceType = commditySourceType;
    }

    public Integer getAvaiSupplyCount() {
        return avaiSupplyCount;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public void setAvaiSupplyCount(Integer avaiSupplyCount) {
        this.avaiSupplyCount = avaiSupplyCount;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public String getStorageId() {
        return storageId;
    }

    public void setStorageId(String storageId) {
        this.storageId = storageId;
    }

    public String getPlantationId() {
        return plantationId;
    }

    public void setPlantationId(String plantationId) {
        this.plantationId = plantationId;
    }

    public String getPortId() {
        return portId;
    }

    public void setPortId(String portId) {
        this.portId = portId;
    }

    public String getBaseId() {
        return baseId;
    }

    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String[] getSupportTypeId() {
        return supportTypeId;
    }

    public void setSupportTypeId(String[] supportTypeId) {
        this.supportTypeId = supportTypeId;
    }

    public Integer getSalesSetSort() {
        return salesSetSort;
    }

    public void setSalesSetSort(Integer salesSetSort) {
        this.salesSetSort = salesSetSort;
    }

    public String getCommSaleId() {
        return commSaleId;
    }

    public void setCommSaleId(String commSaleId) {
        this.commSaleId = commSaleId;
    }

    public String getCommSaleCatgName() {
        return commSaleCatgName;
    }

    public void setCommSaleCatgName(String commSaleCatgName) {
        this.commSaleCatgName = commSaleCatgName;
    }

    public Integer getSalesSort() {
        return salesSort;
    }

    public void setSalesSort(Integer salesSort) {
        this.salesSort = salesSort;
    }

    /**
     * 更新时间开始
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty("更新时间开始")
    private OffsetDateTime startTime;

    /**
     * 更新时间结束
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty("更新时间结束")
    private OffsetDateTime endTime;

    @ApiModelProperty("搜索输入框")
    private String searchInput;

    /**
     * 搜索输入框为数字编号
     */
    @ApiModelProperty("搜索输入框为数字编号")
    private String searchInputNum;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "时间")
    private Long createDate;

    /**
     * 成交时间
     */
    @ApiModelProperty(value = "成交时间")
    private Long endTradTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime updateDate;

    /**
     * 排序字段，搜索引擎中字段名
     */
    @ApiModelProperty(value = "排序字段，搜索引擎中字段名")
    public String orderBy;
    /**
     * 排序模式  ASC或DESC,大小写均可
     */
    @ApiModelProperty(value = "排序模式  ASC或DESC,大小写均可")
    public String sortOrder;

    public Long getEndTradTime() {
        return endTradTime;
    }

    public void setEndTradTime(Long endTradTime) {
        this.endTradTime = endTradTime;
    }

    public String getRealPersonAuth() {
        return realPersonAuth;
    }

    public void setRealPersonAuth(String realPersonAuth) {
        this.realPersonAuth = realPersonAuth;
    }

    public String getIndBusiAuth() {
        return indBusiAuth;
    }

    public void setIndBusiAuth(String indBusiAuth) {
        this.indBusiAuth = indBusiAuth;
    }

    public String getEntpAuth() {
        return entpAuth;
    }

    public void setEntpAuth(String entpAuth) {
        this.entpAuth = entpAuth;
    }

    public String getStallsMageName() {
        return stallsMageName;
    }

    public void setStallsMageName(String stallsMageName) {
        this.stallsMageName = stallsMageName;
    }

    public String getBackGroundUrl() {
        return backGroundUrl;
    }

    public void setBackGroundUrl(String backGroundUrl) {
        this.backGroundUrl = backGroundUrl;
    }

    public OffsetDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(OffsetDateTime startTime) {
        this.startTime = startTime;
    }

    public OffsetDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(OffsetDateTime endTime) {
        this.endTime = endTime;
    }

    public String getSearchInput() {
        return searchInput;
    }

    public void setSearchInput(String searchInput) {
        this.searchInput = searchInput;
    }

    public String getSearchInputNum() {
        return searchInputNum;
    }

    public void setSearchInputNum(String searchInputNum) {
        this.searchInputNum = searchInputNum;
    }

    public Integer getStartBullk() {
        return startBullk;
    }

    public void setStartBullk(Integer startBullk) {
        this.startBullk = startBullk;
    }

    public Integer getEndBullk() {
        return endBullk;
    }

    public void setEndBullk(Integer endBullk) {
        this.endBullk = endBullk;
    }

    public Integer getPriceSectionStart() {
        return priceSectionStart;
    }

    public void setPriceSectionStart(Integer priceSectionStart) {
        this.priceSectionStart = priceSectionStart;
    }

    public Integer getPriceSectionEnd() {
        return priceSectionEnd;
    }

    public void setPriceSectionEnd(Integer priceSectionEnd) {
        this.priceSectionEnd = priceSectionEnd;
    }

    public String getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(String allPrice) {
        this.allPrice = allPrice;
    }

    public String getStallsMageId() {
        return stallsMageId;
    }

    public void setStallsMageId(String stallsMageId) {
        this.stallsMageId = stallsMageId;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Integer getSalesVolume() {
        return salesVolume;
    }

    public void setSalesVolume(Integer salesVolume) {
        this.salesVolume = salesVolume;
    }

    public String getSerSupportType() {
        return serSupportType;
    }

    public void setSerSupportType(String serSupportType) {
        this.serSupportType = serSupportType;
    }

    public String getMembAuthName() {
        return membAuthName;
    }

    public void setMembAuthName(String membAuthName) {
        this.membAuthName = membAuthName;
    }

    public String getWholeSaleMarketId() {
        return wholeSaleMarketId;
    }

    public void setWholeSaleMarketId(String wholeSaleMarketId) {
        this.wholeSaleMarketId = wholeSaleMarketId;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCommNum() {
        return commNum;
    }

    public void setCommNum(String commNum) {
        this.commNum = commNum;
    }

    public String getMeasUnit() {
        return measUnit;
    }

    public void setMeasUnit(String measUnit) {
        this.measUnit = measUnit;
    }

    public String getCommStateType() {
        return commStateType;
    }

    public void setCommStateType(String commStateType) {
        this.commStateType = commStateType;
    }

    public Double getStartOrdCount() {
        return startOrdCount;
    }

    public void setStartOrdCount(Double startOrdCount) {
        this.startOrdCount = startOrdCount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMembId() {
        return membId;
    }

    public void setMembId(String membId) {
        this.membId = membId;
    }

    public String getCommSaleSetId() {
        return commSaleSetId;
    }

    public void setCommSaleSetId(String commSaleSetId) {
        this.commSaleSetId = commSaleSetId;
    }

    public String getCommSaleCatgSetName() {
        return commSaleCatgSetName;
    }

    public void setCommSaleCatgSetName(String commSaleCatgSetName) {
        this.commSaleCatgSetName = commSaleCatgSetName;
    }

    public String getCommVatrieName() {
        return commVatrieName;
    }

    public void setCommVatrieName(String commVatrieName) {
        this.commVatrieName = commVatrieName;
    }

    public String getCommTitle() {
        return commTitle;
    }

    public void setCommTitle(String commTitle) {
        this.commTitle = commTitle;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }

    public OffsetDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(OffsetDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(Integer salesCount) {
        this.salesCount = salesCount;
    }

    public String getCommVarietId() {
        return commVarietId;
    }

    public void setCommVarietId(String commVarietId) {
        this.commVarietId = commVarietId;
    }

    @Override
    public String getOrderBy() {
        return orderBy;
    }

    @Override
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    @Override
    public String getSortOrder() {
        return sortOrder;
    }

    @Override
    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

}
