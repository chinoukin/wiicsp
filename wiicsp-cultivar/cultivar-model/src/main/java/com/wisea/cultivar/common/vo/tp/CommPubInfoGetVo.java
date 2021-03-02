package com.wisea.cultivar.common.vo.tp;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.vo.tp.product.CommLevelPriceVo;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModelProperty;

/**
 * CommPubInfoGetVo
 * 2018/09/18 14:36:47
 */
public class CommPubInfoGetVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 会员id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "会员id")
    private Long membId;

    /**
     * 代理状态
     */
    @ApiModelProperty(value = "代理状态")
    private String agentStateType;

    /**
     * 商品id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品id")
    private Long commId;

    @ApiModelProperty(value = "商品分类名称")
    private String commCatgName;

    @ApiModelProperty("商品分类的名称")
    private String commCatgId;

    /**
     * 商品编号
     */
    @ApiModelProperty(value = "商品编号")
    private String commNum;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String commName;

    /**
     * 品牌名称
     */
    @ApiModelProperty("品牌名称")
    private String brandName;

    /**
     * 商品起订量价格
     */
    @ApiModelProperty("商品起订量价格(商品预览时使用)")
    private List<CommPrice> commPrice;
    /**
     * 商品原始价格
     */
    @ApiModelProperty("商品原始价格")
    private List<CommPrice> commPriceOri;

    /**
     * 原始代理价格表达式
     */
    @ApiModelProperty(value = "原始代理价格表达式")
    private String originalAgentPrice;

    @ApiModelProperty(value = "代理价指定方式")
    private String agentWholePriceMode;

    @ApiModelProperty(value = "代理价指定方式表达式")
    private String agentWholePricePfMode;

    /**
     * 商品品牌(品牌管理表id)
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品品牌(品牌管理表id)")
    private Long brandId;

    /**
     * 样品信息
     */
    private List<CommSampRelaGetVo> sampInfo;

    /**
     * 标签点亮信息
     */
    private List<LabelLitInfoGetVo> labelLitInfoGetVoList;

    /**
     * 商品规格
     */
    @ApiModelProperty(value = "商品规格")
    private Double commSpec;

    /**
     * 计量单位(计量单位管理表id)
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "计量单位(计量单位管理表id)")
    private Long measUnitId;

    public String getMeasUnitName() {
        return measUnitName;
    }

    public void setMeasUnitName(String measUnitName) {
        this.measUnitName = measUnitName;
    }

    public String getOriginalAgentPrice() {
        return originalAgentPrice;
    }

    public void setOriginalAgentPrice(String originalAgentPrice) {
        this.originalAgentPrice = originalAgentPrice;
    }

    /**
     * 计量单位
     */
    @ApiModelProperty(value = "计量单位名称")
    private String measUnitName;

    /**
     * 包装说明
     */
    @ApiModelProperty(value = "包装说明")
    private String packDesc;

    /**
     * 库存量
     */
    @ApiModelProperty(value = "库存量")
    private Integer stock;

    /**
     * 质保期
     */
    @ApiModelProperty(value = "质保期")
    private String timeOfWarr;

    /**
     * 起订量
     */
    @ApiModelProperty(value = "起订量")
    private Integer startOrdCount;

    /**
     * 批发价格表达式
     */
    @ApiModelProperty(value = "批发价格表达式")
    private String wholePrice;

    /**
     * 批发价格显示区间
     */
    @ApiModelProperty(value = "批发价格显示区间")
    private String wholePriceSection;

    @ApiModelProperty(value = "原始价格")
    private String originalPrice;

    /**
     * 代理价格表达式
     */
    @ApiModelProperty(value = "代理价格表达式")
    private String agentWholePrice;

    /**
     * 代理价格显示区间
     */
    @ApiModelProperty(value = "代理价格显示区间")
    private String agentWholePriceSection;
    /**
     * 数据库中代理价区间
     */
    private String agentWholeSection;

    /**
     * 商品货号
     */
    @ApiModelProperty(value = "商品货号")
    private String commArtNum;

    /**
     * 商品产地省
     */
    @ApiModelProperty(value = "商品产地省")
    private String commLocalProv;

    /**
     * 商品产地市
     */
    @ApiModelProperty(value = "商品产地市")
    private String commLocalCity;

    /**
     * 商品产地区县
     */
    @ApiModelProperty(value = "商品产地区县")
    private String commLocalCou;

    /**
     * 生产厂家(生产厂家管理表id)
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "生产厂家(生产厂家管理表id)")
    private Long manufacturerId;

    public String getManuFacturerName() {
        return manuFacturerName;
    }

    public void setManuFacturerName(String manuFacturerName) {
        this.manuFacturerName = manuFacturerName;
    }

    public String getAgentStateType() {
        return agentStateType;
    }

    public void setAgentStateType(String agentStateType) {
        this.agentStateType = agentStateType;
    }

    /**
     * 生产厂家名称
     */
    @ApiModelProperty("生产厂家名称")
    private String manuFacturerName;

    /**
     * 生产日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "生产日期")
    private OffsetDateTime prdctDate;

    /**
     * 生产批次
     */
    @ApiModelProperty(value = "生产批次")
    private String prdctBatch;

    /**
     * 生产许可
     */
    @ApiModelProperty(value = "生产许可")
    private String prdctLicense;

    /**
     * 视频url
     */
    @ApiModelProperty(value = "视频url")
    private String videoUrl;

    /**
     * 商品关键词
     */
    @ApiModelProperty(value = "商品关键词")
    private String commKeyWord;

    /**
     * 发货时间描述
     */
    @ApiModelProperty(value = "发货时间描述")
    private String deliveTimeDesc;

    /**
     * 商品状态类型
     */
    @ApiModelProperty(value = "商品状态类型")
    private String commStateType;

    /**
     * 销量
     */
    @ApiModelProperty(value = "销量")
    private Integer salesCount;

    /**
     * 运费模板_id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "运费模板_id")
    private Long freightFormworkId;

    /**
     * 运费模板_sys_id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "运费模板sys_id")
    private String sysFreightFormworkId;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    /**
     * 商品描述
     */
    @ApiModelProperty(value = "商品描述")
    private String commDesc;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime createDate;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime updateDate;

    /**
     * 30天内成交量 ,关联订单商品表中查询出来的数量
     */
    @ApiModelProperty("30天内成交量")
    private Integer volume;

    @ApiModelProperty("累计成交量")
    private Integer volumeCount;

    /**
     * 商品属性
     */
    private List<CommAttriGetVo> commAttri;

    /**
     * 商品图片
     */
    @ApiModelProperty("商品图片")
    private List<CommPictureListVo> commPicture;

    /**
     * 按规格报价返回值
     */
    @ApiModelProperty("按规格报价返回值")
    private List<CommLevelPriceVo> commLevelPrice;

    /**
     * 商品标签信息
     */
    @ApiModelProperty("商品标签")
    private List<LabelLitInfoGetVo> lavelLitInfo;

    /**
     * 商品与样品信息
     */
    private List<CommSampRelaGetVo> commSampRela;

    /**
     * 会员信息
     */
    private MembInfoGetVo membInfo;
    /**
     * 收藏的信息存在说明不能再次收藏
     */
    private CollFolderListVo collFolderListVo;

    /// ************** 新增字段 *******************

    /**
     * 新增字段 ********************
     *
     */
    @ApiModelProperty("报价方式 （按数量报价，按等级规格报价）")
    private String quotMethodType;

    /**
     * 商品等级
     */
    private String quotLevelType;

    /**
     * 定金比例
     */
    @ApiModelProperty("定金比例")
    private Double depositBl;

    /**
     * 验收标准
     */
    @ApiModelProperty("验收标准")
    private String ysbzBds;

    /**
     * 定向会员表达式
     */
    private String dxhyBds;

    /**
     * 是否支持混批
     */
    @ApiModelProperty("是否支持混批")
    private String hpType;

    /**
     * 货品总件数大于数量
     */
    @ApiModelProperty("货品总件数大于数量")
    private Double hpzjsdyCount;

    /**
     *  新增字段结束 ****************************
     */

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
    @JsonSerialize(using=IdSerializer.class)
    @ApiModelProperty(value = "国外产地id")
    private Long abroadId;

    @ApiModelProperty(value = "国外产地名称")
    private String abroadIdName;

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
    @ApiModelProperty(value = "挂牌类型")
    private String listValidityType;

    @ApiModelProperty(value = "挂牌有效时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime listValidity;

    /**
     * 挂牌量
     */
    @ApiModelProperty(value = "挂牌量")
    private Double listCount;

    /**
     * 可供货数量
     */
    @ApiModelProperty(value = "可供货数量")
    private Double avaiSupplyCount;

    /**
     * 运费类型（商家包邮、设置运费模板）
     */
    @ApiModelProperty(value = "运费类型（商家包邮、设置运费模板）")
    private String freightFormworkType;

    /**
     * 是否支持买家字体
     */
    @ApiModelProperty(value = "是否支持买家字体")
    private String sfzcmjztType;

    /**
     * 发货地省
     */
    @ApiModelProperty(value = "发货地省")
    private String stockPlaceProv;

    /**
     * 发货地市
     */
    @ApiModelProperty(value = "发货地市")
    private String stockPlaceCity;

    /**
     * 发货地区县
     */
    @ApiModelProperty(value = "发货地区县")
    private String stockPlaceCou;

    /**
     * 商品品种id
     */
    @JsonSerialize(using=IdSerializer.class)
    @ApiModelProperty(value = "商品品种id")
    private Long commVarietId;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "店铺id")
    private Long shopInfoMageId;

    /**
     * 登录用户关注店铺详情
     * @return
     */
    @ApiModelProperty("登录用户关注店铺情况")
    private FollowShopMageGetVo followShopMageGetVo;

    /// ************** 新增字段结束 *******************


    public Long getShopInfoMageId() {
        return shopInfoMageId;
    }

    public void setShopInfoMageId(Long shopInfoMageId) {
        this.shopInfoMageId = shopInfoMageId;
    }

    public FollowShopMageGetVo getFollowShopMageGetVo() {
        return followShopMageGetVo;
    }

    public void setFollowShopMageGetVo(FollowShopMageGetVo followShopMageGetVo) {
        this.followShopMageGetVo = followShopMageGetVo;
    }

    public OffsetDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(OffsetDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getVolumeCount() {
        return volumeCount;
    }

    public void setVolumeCount(Integer volumeCount) {
        this.volumeCount = volumeCount;
    }

    /**
     * 详情页商家热销信息
     */
    @ApiModelProperty("详情页商家热销信息-左侧商家列表取两个")
    private List<CommPubInfoListVo> commPubInfoHotListVoList;

    /**
     * 详情页商家新品信息
     */
    @ApiModelProperty("详情页商家新品信息-左侧商家列表取两个")
    private List<CommPubInfoGetVo> commPubInfoNewVoList;

    /**
     * 运费信息
     *
     * @return
     */
    @ApiModelProperty("运费信息")
    private FreightFormworkMageListVo freightFormworkMageListVo;

    /**
     * 代理价结合
     */
    private List<CommPriceAgentVo> commPriceAgent;

    /**
     * 默认地址信息
     */
    private ReceAddressMageListVo addressMageListVo;

    public String getQuotMethodType() {
        return quotMethodType;
    }

    public void setQuotMethodType(String quotMethodType) {
        this.quotMethodType = quotMethodType;
    }

    public String getQuotLevelType() {
        return quotLevelType;
    }

    public void setQuotLevelType(String quotLevelType) {
        this.quotLevelType = quotLevelType;
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

    public List<CommLevelPriceVo> getCommLevelPrice() {
        return commLevelPrice;
    }

    public void setCommLevelPrice(List<CommLevelPriceVo> commLevelPrice) {
        this.commLevelPrice = commLevelPrice;
    }

    public List<CommPubInfoGetVo> getCommPubInfoNewVoList() {
        return commPubInfoNewVoList;
    }

    public void setCommPubInfoNewVoList(List<CommPubInfoGetVo> commPubInfoNewVoList) {
        this.commPubInfoNewVoList = commPubInfoNewVoList;
    }

    public String getSfzcmjztType() {
        return sfzcmjztType;
    }

    public void setSfzcmjztType(String sfzcmjztType) {
        this.sfzcmjztType = sfzcmjztType;
    }

    public Double getListCount() {
        return listCount;
    }

    public void setListCount(Double listCount) {
        this.listCount = listCount;
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

    public String getCommCatgId() {
        return commCatgId;
    }

    public void setCommCatgId(String commCatgId) {
        this.commCatgId = commCatgId;
    }

    public String getCommCatgName() {
        return commCatgName;
    }

    public void setCommCatgName(String commCatgName) {
        this.commCatgName = commCatgName;
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

    public String getFreightFormworkType() {
        return freightFormworkType;
    }

    public void setFreightFormworkType(String freightFormworkType) {
        this.freightFormworkType = freightFormworkType;
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

    public Long getCommVarietId() {
        return commVarietId;
    }

    public void setCommVarietId(Long commVarietId) {
        this.commVarietId = commVarietId;
    }

    public List<CommPrice> getCommPriceOri() {
        return commPriceOri;
    }

    public void setCommPriceOri(List<CommPrice> commPriceOri) {
        this.commPriceOri = commPriceOri;
    }

    public Double getAvaiSupplyCount() {
        return avaiSupplyCount;
    }

    public void setAvaiSupplyCount(Double avaiSupplyCount) {
        this.avaiSupplyCount = avaiSupplyCount;
    }

    public List<LabelLitInfoGetVo> getLabelLitInfoGetVoList() {
        return labelLitInfoGetVoList;
    }

    public void setLabelLitInfoGetVoList(List<LabelLitInfoGetVo> labelLitInfoGetVoList) {
        this.labelLitInfoGetVoList = labelLitInfoGetVoList;
    }

    public String getAgentWholeSection() {
        return agentWholeSection;
    }

    public void setAgentWholeSection(String agentWholeSection) {
        this.agentWholeSection = agentWholeSection;
    }

    public String getAgentWholePriceMode() {
        return agentWholePriceMode;
    }

    public void setAgentWholePriceMode(String agentWholePriceMode) {
        this.agentWholePriceMode = agentWholePriceMode;
    }

    public CollFolderListVo getCollFolderListVo() {
        return collFolderListVo;
    }

    public void setCollFolderListVo(CollFolderListVo collFolderListVo) {
        this.collFolderListVo = collFolderListVo;
    }

    public List<CommSampRelaGetVo> getSampInfo() {
        return sampInfo;
    }

    public void setSampInfo(List<CommSampRelaGetVo> sampInfo) {
        this.sampInfo = sampInfo;
    }

    public Integer getVolume() {
        return volume;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public ReceAddressMageListVo getAddressMageListVo() {
        return addressMageListVo;
    }

    public void setAddressMageListVo(ReceAddressMageListVo addressMageListVo) {
        this.addressMageListVo = addressMageListVo;
    }

    public List<CommPriceAgentVo> getCommPriceAgent() {
        return commPriceAgent;
    }

    public void setCommPriceAgent(List<CommPriceAgentVo> commPriceAgent) {
        this.commPriceAgent = commPriceAgent;
    }

    public String getSysFreightFormworkId() {
        return sysFreightFormworkId;
    }

    public void setSysFreightFormworkId(String sysFreightFormworkId) {
        this.sysFreightFormworkId = sysFreightFormworkId;
    }

    public List<CommPubInfoListVo> getCommPubInfoHotListVoList() {
        return commPubInfoHotListVoList;
    }

    public void setCommPubInfoHotListVoList(List<CommPubInfoListVo> commPubInfoHotListVoList) {
        this.commPubInfoHotListVoList = commPubInfoHotListVoList;
    }

    public List<CommSampRelaGetVo> getCommSampRela() {
        return commSampRela;
    }

    public void setCommSampRela(List<CommSampRelaGetVo> commSampRela) {
        this.commSampRela = commSampRela;
    }

    public MembInfoGetVo getMembInfo() {
        return membInfo;
    }

    public void setMembInfo(MembInfoGetVo membInfo) {
        this.membInfo = membInfo;
    }

    public List<LabelLitInfoGetVo> getLavelLitInfo() {
        return lavelLitInfo;
    }

    public void setLavelLitInfo(List<LabelLitInfoGetVo> lavelLitInfo) {
        this.lavelLitInfo = lavelLitInfo;
    }

    public List<CommPictureListVo> getCommPicture() {
        return commPicture;
    }

    public void setCommPicture(List<CommPictureListVo> commPicture) {
        this.commPicture = commPicture;
    }

    public List<CommAttriGetVo> getCommAttri() {
        return commAttri;
    }

    public void setCommAttri(List<CommAttriGetVo> commAttri) {
        this.commAttri = commAttri;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public FreightFormworkMageListVo getFreightFormworkMageListVo() {
        return freightFormworkMageListVo;
    }

    public void setFreightFormworkMageListVo(FreightFormworkMageListVo freightFormworkMageListVo) {
        this.freightFormworkMageListVo = freightFormworkMageListVo;
    }

    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
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

    public String getAgentWholePricePfMode() {
        return agentWholePricePfMode;
    }

    public void setAgentWholePricePfMode(String agentWholePricePfMode) {
        this.agentWholePricePfMode = agentWholePricePfMode;
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
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
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

    public List<CommPrice> getCommPrice() {
        return commPrice;
    }

    public void setCommPrice(List<CommPrice> commPrice) {
        this.commPrice = commPrice;
    }

    public String getAbroadIdName() {
        return abroadIdName;
    }

    public void setAbroadIdName(String abroadIdName) {
        this.abroadIdName = abroadIdName;
    }
}
