package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * CommPubInfoInsertPo
 * 2018/09/18 14:36:47
 */
public class CommPubInfoInsertPo {
    /**
     * 会员id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "会员id")
    private Long membId;

    /**
     * 商品id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "商品id")
    private Long commId;

    /**
     * 商品编号
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "商品编号")
    private String commNum;

    /**
     * 商品名称
     */
    @Check(test = { "maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "商品名称")
    private String commName;

    /**
     * 代理状态
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "代理状态")
    private String agentStateType;

    /**
     * 商品品牌(品牌管理表id)
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "商品品牌(品牌管理表id)")
    private Long brandId;

    /**
     * 商品规格
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "商品规格")
    private Double commSpec;

    /**
     * 计量单位(计量单位管理表id)
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "计量单位(计量单位管理表id)")
    private Long measUnitId;

    /**
     * 包装说明
     */
    @Check(test = { "maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "包装说明")
    private String packDesc;

    /**
     * 库存量
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "库存量")
    private Integer stock;

    /**
     * 质保期
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "质保期")
    private Integer timeOfWarr;

    /**
     * 起订量
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "起订量")
    private Integer startOrdCount;

    /**
     * 原始价格表达式
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "原始价格表达式")
    private String originalPrice;

    /**
     * 原始代理价格表达式
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "原始代理价格表达式")
    private String originalAgentPrice;

    /**
     * 批发价格表达式
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "批发价格表达式")
    private String wholePrice;

    /**
     * 批发价格显示区间
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "批发价格显示区间")
    private String wholePriceSection;

    /**
     * 代理价格表达式
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "代理价格表达式")
    private String agentWholePrice;

    /**
     * 代理价格显示区间
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "代理价格显示区间")
    private String agentWholePriceSection;

    /**
     * 商品货号
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "商品货号")
    private String commArtNum;

    /**
     * 商品产地省
     */
    @Check(test = { "maxLength" }, mixLength = 10)
    @ApiModelProperty(value = "商品产地省")
    private String commLocalProv;

    /**
     * 商品产地市
     */
    @Check(test = { "maxLength" }, mixLength = 10)
    @ApiModelProperty(value = "商品产地市")
    private String commLocalCity;

    /**
     * 商品产地区县
     */
    @Check(test = { "maxLength" }, mixLength = 10)
    @ApiModelProperty(value = "商品产地区县")
    private String commLocalCou;

    /**
     * 生产厂家(生产厂家管理表id)
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "生产厂家(生产厂家管理表id)")
    private Long manufacturerId;

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
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "生产批次")
    private String prdctBatch;

    /**
     * 生产许可
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "生产许可")
    private String prdctLicense;

    /**
     * 视频url
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "视频url")
    private String videoUrl;

    /**
     * 商品关键词
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "商品关键词")
    private String commKeyWord;

    /**
     * 发货时间描述
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "发货时间描述")
    private String deliveTimeDesc;

    /**
     * 商品状态类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "商品状态类型")
    private String commStateType;

    /**
     * 销量
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "销量")
    private Integer salesCount;

    /**
     * 运费模板_id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "运费模板_id")
    private Long freightFormworkId;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 商品描述
     */
    @Check(test = { "maxLength" }, mixLength = 16777215)
    @ApiModelProperty(value = "商品描述")
    private String commDesc;

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getOriginalAgentPrice() {
        return originalAgentPrice;
    }

    public void setOriginalAgentPrice(String originalAgentPrice) {
        this.originalAgentPrice = originalAgentPrice;
    }

    public String getAgentStateType() {
        return agentStateType;
    }

    public void setAgentStateType(String agentStateType) {
        this.agentStateType = agentStateType;
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
    public Integer getTimeOfWarr() {
        return timeOfWarr;
    }

    /**
     * 设置质保期
     */
    public void setTimeOfWarr(Integer timeOfWarr) {
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
}
