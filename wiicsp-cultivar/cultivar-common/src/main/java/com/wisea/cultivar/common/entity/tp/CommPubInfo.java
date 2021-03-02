package com.wisea.cultivar.common.entity.tp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.annotation.LongSerializer;
import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * comm_pub_info 表实体
 * 2018/09/18 14:36:47
 */
public class CommPubInfo extends DataLongEntity<CommPubInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 会员id
     */
    private Long membId;

    /**
     * 代理状态
     */
    private String agentStateType;

    /**
     * 收藏夹ID
     */
    private Long collId;

    /**
     * 商品id
     */
    private Long commId;

    /**
     * 商品编号
     */
    private String commNum;

    /**
     * 商品名称
     */
    private String commName;

    /**
     * 商品品牌(品牌管理表id)
     */
    private Long brandId;

    /**
     * 商品发布ID集合
     */
    private List<Long> commPublishId;

    /**
     * 商品规格
     */
    private Double commSpec;

    /**
     * 计量单位(计量单位管理表id)
     */
    private Long measUnitId;

    /**
     * 计量单位名称
     */
    private String measUnitName;

    /**
     * 包装说明
     */
    private String packDesc;

    /**
     * 库存量
     */
    private Integer stock;

    /**
     * 质保期
     */
    private String timeOfWarr;

    /**
     * 起订量
     */
    private Integer startOrdCount;

    /**
     * 原始代理价格表达式
     */
    private String originalAgentPrice;

    /**
     * 批发价格表达式
     */
    private String wholePrice;

    /**
     * 批发价格显示区间
     */
    private String wholePriceSection;

    /**
     * 原始价格
     */
    private String originalPrice;

    /**
     * 代理价格表达式
     */
    private String agentWholePrice;

    /**
     * 代理价格显示区间
     */
    private String agentWholePriceSection;

    /**
     * 代理结算价指定方式表达式
     */
    private String agentWholePriceMode;

    /**
     * 代理结算价比例/固定表达式
     */
    private String agentWholePricePfMode;

    /**
     * 商品货号
     */
    private String commArtNum;

    /**
     * 商品产地省
     */
    private String commLocalProv;

    /**
     * 商品产地市
     */
    private String commLocalCity;

    /**
     * 商品产地区县
     */
    private String commLocalCou;

    /**
     * 生产厂家(生产厂家管理表id)
     */
    private Long manufacturerId;

    /**
     * 生产日期
     */
    private OffsetDateTime prdctDate;

    /**
     * 生产批次
     */
    private String prdctBatch;

    /**
     * 生产许可
     */
    private String prdctLicense;

    /**
     * 新增字段 ********************
     * 报价方式 （按数量报价，按等级规格报价）
     */
    private String quotMethodType;

    /**
     * 商品等级
     */
    private String quotLevelType;

    /**
     * 定金比例
     */
    private Double depositBl;

    /**
     * 验收标准
     */
    private String ysbzBds;

    /**
     * 定向会员表达式
     */
    private String dxhyBds;

    /**
     * 混批总件数
     */
    private String hpType;

    /**
     * 货品总件数大于数量
     */
    private Double hpzjsdyCount;

    /**
     *  新增字段结束 ****************************
     */

    /**
     * 视频url
     */
    private String videoUrl;

    /**
     * 商品关键词
     */
    private String commKeyWord;

    /**
     * 发货时间描述
     */
    private String deliveTimeDesc;

    /**
     * 商品状态类型
     */
    private String commStateType;

    /**
     * 销量
     */
    private Integer salesCount;

    /**
     * 运费模板_id
     */
    private Long freightFormworkId;

    /**
     * 商品描述
     */
    private String commDesc;

    /**
     * 冗余商品属性表中value值
     */
    @ApiModelProperty("属性表中value值")
    private String commAttriVal;

    /**
     * 多检索模糊字段
     * */
    @ApiModelProperty("多检索模糊字段")
    private String blurWord;

    /**
     * 冗余商品属性表中属性name
     */
    @ApiModelProperty("属性name")
    private String commAttriName;

    @ApiModelProperty("代理价状态（正常：false） 、 （失效：true）")
    private Boolean agentPriceReleaseType;

    /**
     * 收藏夹中最终的金额区间
     * */
    private String price;

    @ApiModelProperty("商品图片")
    private List<CommPicture> commPictures;

    @ApiModelProperty("商品标签后台配置项不包含品,检")
    private List<EntpCertMage> entpCertMages;

    @ApiModelProperty("商品,品,检标签")
    private List<CommSampRela> commSampRelas;

    /*商品ids*/
    private String commPubInfoIds;

    /*冗余商品的数量  count*/
    private int count;

    /**
     * 买家id
     */
    private Long buyId;

    /// ************** 新增字段 *******************

    /**
     * 商品发布类型
     */
    @ApiModelProperty(value = "商品发布类型")
    private String commPubType;

    /**
     * 产地类型
     */
    @ApiModelProperty(value = "产地类型")
    private String originPlaceType;

    /**
     * 国外产地id
     */
    @JsonSerialize(using=LongSerializer.class)
    @ApiModelProperty(value = "国外产地id")
    private Long abroadId;

    /**
     * 供货方式类型
     */
    @ApiModelProperty(value = "供货方式类型")
    private String supplyModeType;

    /**
     * 发货时间类型
     */
    @ApiModelProperty(value = "发货时间类型")
    private String deliveryTimeType;

    /**
     * 预售发货开始时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "预售发货开始时间")
    private OffsetDateTime advanceSaleStartDate;

    /**
     * 预售发货结束时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "预售发货结束时间")
    private OffsetDateTime advanceSaleEndDate;

    /**
     * 预售发货文本
     */
    @ApiModelProperty(value = "预售发货文本")
    private String advanceSaleText;

    /**
     * 预售发货时间设置类型（设置模糊日期、设置具体日期）
     */
    @ApiModelProperty(value = "预售发货时间设置类型（设置模糊日期、设置具体日期）")
    private String advanceSaleTimeType;

    /**
     * 挂牌有效期类型（长期有效、选择有效期）
     */
    @ApiModelProperty(value = "挂牌有效期类型（长期有效、选择有效期）")
    private String listValidityType;

    /**
     * 有效期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "有效期")
    private OffsetDateTime listValidity;

    /**
     * 可售数量
     */
    @ApiModelProperty(value = "可售数量")
    private Double listCount;

    /**
     * 单位转换后的可供货数量
     */
    @ApiModelProperty("单位转换后的可供货数量")
    private Double avaiSupplyCount;

    /**
     * 推荐名称表达式
     */
    @ApiModelProperty(value = "推荐名称表达式")
    private String recommendNameExpre;

    /**
     * 推荐量表达式
     */
    @ApiModelProperty(value = "推荐量表达式")
    private String recommendCountExpre;

    /**
     * 结算支付类型
     */
    @ApiModelProperty(value = "结算支付类型")
    private String payMethodType;

    /**
     * 物流服务类型
     */
    @ApiModelProperty(value = "物流服务类型")
    private String logisticsSerType;

    /**
     * 存货地省
     */
    @ApiModelProperty(value = "存货地省")
    private String stockPlaceProv;

    /**
     * 存货地市
     */
    @ApiModelProperty(value = "存货地市")
    private String stockPlaceCity;

    /**
     * 存货地区县
     */
    @ApiModelProperty(value = "存货地区县")
    private String stockPlaceCou;

    /**
     * 存货地详细地址
     */
    @ApiModelProperty(value = "存货地详细地址")
    private String stockPlaceAddress;

    /**
     * 是否支持买家自提类型（是、否）
     */
    @ApiModelProperty(value = "是否支持买家自提类型（是、否）")
    private String sfzcmjztType;

    /**
     * 运费类型（商家包邮、设置运费模板）
     */
    @ApiModelProperty(value = "运费类型（商家包邮、设置运费模板）")
    private String freightFormworkType;

    /**
     * 商品品种id
     */
    @JsonSerialize(using=LongSerializer.class)
    @ApiModelProperty(value = "商品品种id")
    private Long commVarietId;

    @ApiModelProperty(value = "商品等级待定")
    private String commLevelType;

    private List<Long>  commIds;

    public String getMeasUnitName() {
        return measUnitName;
    }

    public void setMeasUnitName(String measUnitName) {
        this.measUnitName = measUnitName;
    }

    public List<Long> getCommIds() {
        return commIds;
    }

    public void setCommIds(List<Long> commIds) {
        this.commIds = commIds;
    }

    /// ************** 新增字段结束 *******************

    public String getCommLevelType() {
        return commLevelType;
    }

    public void setCommLevelType(String commLevelType) {
        this.commLevelType = commLevelType;
    }

    public String getQuotLevelType() {
        return quotLevelType;
    }

    public void setQuotLevelType(String quotLevelType) {
        this.quotLevelType = quotLevelType;
    }

    public String getQuotMethodType() {
        return quotMethodType;
    }

    public void setQuotMethodType(String quotMethodType) {
        this.quotMethodType = quotMethodType;
    }

    public Double getDepositBl() {
        return depositBl;
    }

    public void setDepositBl(Double depositBl) {
        this.depositBl = depositBl;
    }

    public String getYsbzBds() {
        return ysbzBds;
    }

    public void setYsbzBds(String ysbzBds) {
        this.ysbzBds = ysbzBds;
    }

    public String getDxhyBds() {
        return dxhyBds;
    }

    public void setDxhyBds(String dxhyBds) {
        this.dxhyBds = dxhyBds;
    }

    public String getHpType() {
        return hpType;
    }

    public void setHpType(String hpType) {
        this.hpType = hpType;
    }

    public Double getHpzjsdyCount() {
        return hpzjsdyCount;
    }

    public void setHpzjsdyCount(Double hpzjsdyCount) {
        this.hpzjsdyCount = hpzjsdyCount;
    }

    public Boolean getAgentPriceReleaseType() {
        return agentPriceReleaseType;
    }

    public String getCommPubType() {
        return commPubType;
    }

    public void setCommPubType(String commPubType) {
        this.commPubType = commPubType;
    }

    public String getOriginPlaceType() {
        return originPlaceType;
    }

    public void setOriginPlaceType(String originPlaceType) {
        this.originPlaceType = originPlaceType;
    }

    public Long getAbroadId() {
        return abroadId;
    }

    public void setAbroadId(Long abroadId) {
        this.abroadId = abroadId;
    }

    public String getSupplyModeType() {
        return supplyModeType;
    }

    public void setSupplyModeType(String supplyModeType) {
        this.supplyModeType = supplyModeType;
    }

    public String getDeliveryTimeType() {
        return deliveryTimeType;
    }

    public void setDeliveryTimeType(String deliveryTimeType) {
        this.deliveryTimeType = deliveryTimeType;
    }

    public OffsetDateTime getAdvanceSaleStartDate() {
        return advanceSaleStartDate;
    }

    public void setAdvanceSaleStartDate(OffsetDateTime advanceSaleStartDate) {
        this.advanceSaleStartDate = advanceSaleStartDate;
    }

    public OffsetDateTime getAdvanceSaleEndDate() {
        return advanceSaleEndDate;
    }

    public void setAdvanceSaleEndDate(OffsetDateTime advanceSaleEndDate) {
        this.advanceSaleEndDate = advanceSaleEndDate;
    }

    public String getAdvanceSaleText() {
        return advanceSaleText;
    }

    public void setAdvanceSaleText(String advanceSaleText) {
        this.advanceSaleText = advanceSaleText;
    }

    public String getAdvanceSaleTimeType() {
        return advanceSaleTimeType;
    }

    public void setAdvanceSaleTimeType(String advanceSaleTimeType) {
        this.advanceSaleTimeType = advanceSaleTimeType;
    }

    public String getListValidityType() {
        return listValidityType;
    }

    public void setListValidityType(String listValidityType) {
        this.listValidityType = listValidityType;
    }

    public OffsetDateTime getListValidity() {
        return listValidity;
    }

    public void setListValidity(OffsetDateTime listValidity) {
        this.listValidity = listValidity;
    }

    public Double getListCount() {
        return listCount;
    }

    public void setListCount(Double listCount) {
        this.listCount = listCount;
    }

    public Double getAvaiSupplyCount() {
        return avaiSupplyCount;
    }

    public void setAvaiSupplyCount(Double avaiSupplyCount) {
        this.avaiSupplyCount = avaiSupplyCount;
    }

    public String getRecommendNameExpre() {
        return recommendNameExpre;
    }

    public void setRecommendNameExpre(String recommendNameExpre) {
        this.recommendNameExpre = recommendNameExpre;
    }

    public String getRecommendCountExpre() {
        return recommendCountExpre;
    }

    public void setRecommendCountExpre(String recommendCountExpre) {
        this.recommendCountExpre = recommendCountExpre;
    }

    public String getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(String payMethodType) {
        this.payMethodType = payMethodType;
    }

    public String getLogisticsSerType() {
        return logisticsSerType;
    }

    public void setLogisticsSerType(String logisticsSerType) {
        this.logisticsSerType = logisticsSerType;
    }

    public String getStockPlaceProv() {
        return stockPlaceProv;
    }

    public void setStockPlaceProv(String stockPlaceProv) {
        this.stockPlaceProv = stockPlaceProv;
    }

    public String getStockPlaceCity() {
        return stockPlaceCity;
    }

    public void setStockPlaceCity(String stockPlaceCity) {
        this.stockPlaceCity = stockPlaceCity;
    }

    public String getStockPlaceCou() {
        return stockPlaceCou;
    }

    public void setStockPlaceCou(String stockPlaceCou) {
        this.stockPlaceCou = stockPlaceCou;
    }

    public String getStockPlaceAddress() {
        return stockPlaceAddress;
    }

    public void setStockPlaceAddress(String stockPlaceAddress) {
        this.stockPlaceAddress = stockPlaceAddress;
    }

    public String getSfzcmjztType() {
        return sfzcmjztType;
    }

    public void setSfzcmjztType(String sfzcmjztType) {
        this.sfzcmjztType = sfzcmjztType;
    }

    public String getFreightFormworkType() {
        return freightFormworkType;
    }

    public void setFreightFormworkType(String freightFormworkType) {
        this.freightFormworkType = freightFormworkType;
    }

    public Long getCommVarietId() {
        return commVarietId;
    }

    public void setCommVarietId(Long commVarietId) {
        this.commVarietId = commVarietId;
    }

    public void setAgentPriceReleaseType(Boolean agentPriceReleaseType) {
        this.agentPriceReleaseType = agentPriceReleaseType;
    }

    public String getAgentStateType() {
        return agentStateType;
    }

    public void setAgentStateType(String agentStateType) {
        this.agentStateType = agentStateType;
    }

    public String getOriginalAgentPrice() {
        return originalAgentPrice;
    }

    public void setOriginalAgentPrice(String originalAgentPrice) {
        this.originalAgentPrice = originalAgentPrice;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getAgentWholePriceMode() {
        return agentWholePriceMode;
    }

    public void setAgentWholePriceMode(String agentWholePriceMode) {
        this.agentWholePriceMode = agentWholePriceMode;
    }

    public String getAgentWholePricePfMode() {
        return agentWholePricePfMode;
    }

    public void setAgentWholePricePfMode(String agentWholePricePfMode) {
        this.agentWholePricePfMode = agentWholePricePfMode;
    }

    public Long getCollId() {
        return collId;
    }

    public void setCollId(Long collId) {
        this.collId = collId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<Long> getCommPublishId() {
        return commPublishId;
    }

    public void setCommPublishId(List<Long> commPublishId) {
        this.commPublishId = commPublishId;
    }

    public String getBlurWord() {
        return blurWord;
    }

    public void setBlurWord(String blurWord) {
        this.blurWord = blurWord;
    }

    public List<CommPicture> getCommPictures() {
        return commPictures;
    }

    public void setCommPictures(List<CommPicture> commPictures) {
        this.commPictures = commPictures;
    }

    public List<EntpCertMage> getEntpCertMages() {
        return entpCertMages;
    }

    public void setEntpCertMages(List<EntpCertMage> entpCertMages) {
        this.entpCertMages = entpCertMages;
    }

    public List<CommSampRela> getCommSampRelas() {
        return commSampRelas;
    }

    public void setCommSampRelas(List<CommSampRela> commSampRelas) {
        this.commSampRelas = commSampRelas;
    }

    public String getCommAttriName() {
        return commAttriName;
    }

    public void setCommAttriName(String commAttriName) {
        this.commAttriName = commAttriName;
    }

    public String getCommAttriVal() {
        return commAttriVal;
    }

    public void setCommAttriVal(String commAttriVal) {
        this.commAttriVal = commAttriVal;
    }

    /**
     * 获取会员id
     */
    public Long getMembId() {
        return membId;
    }

    /**
     * 设置会员id
     */
    public void setMembId(Long membId) {
        this.membId = membId;
    }

    /**
     * 获取商品id
     */
    public Long getCommId() {
        return commId;
    }

    /**
     * 设置商品id
     */
    public void setCommId(Long commId) {
        this.commId = commId;
    }

    /**
     * 获取商品编号
     */
    public String getCommNum() {
        return commNum;
    }

    /**
     * 设置商品编号
     */
    public void setCommNum(String commNum) {
        this.commNum = commNum == null ? null : commNum.trim();
    }

    /**
     * 获取商品名称
     */
    public String getCommName() {
        return commName;
    }

    /**
     * 设置商品名称
     */
    public void setCommName(String commName) {
        this.commName = commName == null ? null : commName.trim();
    }

    /**
     * 获取商品品牌(品牌管理表id)
     */
    public Long getBrandId() {
        return brandId;
    }

    /**
     * 设置商品品牌(品牌管理表id)
     */
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    /**
     * 获取商品规格
     */
    public Double getCommSpec() {
        return commSpec;
    }

    /**
     * 设置商品规格
     */
    public void setCommSpec(Double commSpec) {
        this.commSpec = commSpec;
    }

    /**
     * 获取计量单位(计量单位管理表id)
     */
    public Long getMeasUnitId() {
        return measUnitId;
    }

    /**
     * 设置计量单位(计量单位管理表id)
     */
    public void setMeasUnitId(Long measUnitId) {
        this.measUnitId = measUnitId;
    }

    /**
     * 获取包装说明
     */
    public String getPackDesc() {
        return packDesc;
    }

    /**
     * 设置包装说明
     */
    public void setPackDesc(String packDesc) {
        this.packDesc = packDesc == null ? null : packDesc.trim();
    }

    /**
     * 获取库存量
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 设置库存量
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 获取质保期
     */
    public String getTimeOfWarr() {
        return timeOfWarr;
    }

    /**
     * 设置质保期
     */
    public void setTimeOfWarr(String timeOfWarr) {
        this.timeOfWarr = timeOfWarr;
    }

    /**
     * 获取起订量
     */
    public Integer getStartOrdCount() {
        return startOrdCount;
    }

    /**
     * 设置起订量
     */
    public void setStartOrdCount(Integer startOrdCount) {
        this.startOrdCount = startOrdCount;
    }

    /**
     * 获取批发价格表达式
     */
    public String getWholePrice() {
        return wholePrice;
    }

    /**
     * 设置批发价格表达式
     */
    public void setWholePrice(String wholePrice) {
        this.wholePrice = wholePrice == null ? null : wholePrice.trim();
    }

    /**
     * 获取批发价格显示区间
     */
    public String getWholePriceSection() {
        return wholePriceSection;
    }

    /**
     * 设置批发价格显示区间
     */
    public void setWholePriceSection(String wholePriceSection) {
        this.wholePriceSection = wholePriceSection == null ? null : wholePriceSection.trim();
    }

    /**
     * 获取代理价格表达式
     */
    public String getAgentWholePrice() {
        return agentWholePrice;
    }

    /**
     * 设置代理价格表达式
     */
    public void setAgentWholePrice(String agentWholePrice) {
        this.agentWholePrice = agentWholePrice == null ? null : agentWholePrice.trim();
    }

    /**
     * 获取代理价格显示区间
     */
    public String getAgentWholePriceSection() {
        return agentWholePriceSection;
    }

    /**
     * 设置代理价格显示区间
     */
    public void setAgentWholePriceSection(String agentWholePriceSection) {
        this.agentWholePriceSection = agentWholePriceSection == null ? null : agentWholePriceSection.trim();
    }

    /**
     * 获取商品货号
     */
    public String getCommArtNum() {
        return commArtNum;
    }

    /**
     * 设置商品货号
     */
    public void setCommArtNum(String commArtNum) {
        this.commArtNum = commArtNum == null ? null : commArtNum.trim();
    }

    /**
     * 获取商品产地省
     */
    public String getCommLocalProv() {
        return commLocalProv;
    }

    /**
     * 设置商品产地省
     */
    public void setCommLocalProv(String commLocalProv) {
        this.commLocalProv = commLocalProv == null ? null : commLocalProv.trim();
    }

    /**
     * 获取商品产地市
     */
    public String getCommLocalCity() {
        return commLocalCity;
    }

    /**
     * 设置商品产地市
     */
    public void setCommLocalCity(String commLocalCity) {
        this.commLocalCity = commLocalCity == null ? null : commLocalCity.trim();
    }

    /**
     * 获取商品产地区县
     */
    public String getCommLocalCou() {
        return commLocalCou;
    }

    /**
     * 设置商品产地区县
     */
    public void setCommLocalCou(String commLocalCou) {
        this.commLocalCou = commLocalCou == null ? null : commLocalCou.trim();
    }

    /**
     * 获取生产厂家(生产厂家管理表id)
     */
    public Long getManufacturerId() {
        return manufacturerId;
    }

    /**
     * 设置生产厂家(生产厂家管理表id)
     */
    public void setManufacturerId(Long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    /**
     * 获取生产日期
     */
    public OffsetDateTime getPrdctDate() {
        return prdctDate;
    }

    /**
     * 设置生产日期
     */
    public void setPrdctDate(OffsetDateTime prdctDate) {
        this.prdctDate = prdctDate;
    }

    /**
     * 获取生产批次
     */
    public String getPrdctBatch() {
        return prdctBatch;
    }

    /**
     * 设置生产批次
     */
    public void setPrdctBatch(String prdctBatch) {
        this.prdctBatch = prdctBatch == null ? null : prdctBatch.trim();
    }

    /**
     * 获取生产许可
     */
    public String getPrdctLicense() {
        return prdctLicense;
    }

    /**
     * 设置生产许可
     */
    public void setPrdctLicense(String prdctLicense) {
        this.prdctLicense = prdctLicense == null ? null : prdctLicense.trim();
    }

    /**
     * 获取视频url
     */
    public String getVideoUrl() {
        return videoUrl;
    }

    /**
     * 设置视频url
     */
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    /**
     * 获取商品关键词
     */
    public String getCommKeyWord() {
        return commKeyWord;
    }

    /**
     * 设置商品关键词
     */
    public void setCommKeyWord(String commKeyWord) {
        this.commKeyWord = commKeyWord == null ? null : commKeyWord.trim();
    }

    /**
     * 获取发货时间描述
     */
    public String getDeliveTimeDesc() {
        return deliveTimeDesc;
    }

    /**
     * 设置发货时间描述
     */
    public void setDeliveTimeDesc(String deliveTimeDesc) {
        this.deliveTimeDesc = deliveTimeDesc == null ? null : deliveTimeDesc.trim();
    }

    /**
     * 获取商品状态类型
     */
    public String getCommStateType() {
        return commStateType;
    }

    /**
     * 设置商品状态类型
     */
    public void setCommStateType(String commStateType) {
        this.commStateType = commStateType == null ? null : commStateType.trim();
    }

    /**
     * 获取销量
     */
    public Integer getSalesCount() {
        return salesCount;
    }

    /**
     * 设置销量
     */
    public void setSalesCount(Integer salesCount) {
        this.salesCount = salesCount;
    }

    /**
     * 获取运费模板_id
     */
    public Long getFreightFormworkId() {
        return freightFormworkId;
    }

    /**
     * 设置运费模板_id
     */
    public void setFreightFormworkId(Long freightFormworkId) {
        this.freightFormworkId = freightFormworkId;
    }

    /**
     * 获取商品描述
     */
    public String getCommDesc() {
        return commDesc;
    }

    /**
     * 设置商品描述
     */
    public void setCommDesc(String commDesc) {
        this.commDesc = commDesc == null ? null : commDesc.trim();
    }

    public String getCommPubInfoIds() {
        return commPubInfoIds;
    }

    public void setCommPubInfoIds(String commPubInfoIds) {
        this.commPubInfoIds = commPubInfoIds;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

	public Long getBuyId() {
		return buyId;
	}

	public void setBuyId(Long buyId) {
		this.buyId = buyId;
	}
}
