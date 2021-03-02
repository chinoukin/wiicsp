package com.wisea.cultivar.common.vo.tp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cultivar.common.po.tp.AgentSetPo;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @Author:Liangzy(Wisea)
 * @Date:Create in 2018/9/20 上午10:54
 * @Description:查询商品信息List的VO
 */
public class CommDataListVo {

    /**
     * 商品id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品id")
    private Long id;

    /**
     * 代理状态
     */
    @ApiModelProperty(value = "代理状态")
    private String agentStateType;

    /**
     * 商品编号
     */
    @ApiModelProperty(value = "商品编号")
    private String commNum;

    /**
     * 商品货号
     */
    @ApiModelProperty(value = "商品货号")
    private String commArtNum;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String commName;

    /**
     * 品牌名称
     */
    @ApiModelProperty(value = "品牌名称")
    private String brandName;

    /**
     * 商家名称
     */
    @ApiModelProperty(value = "商家名称")
    private String sellerName;

    /**
     * 计量单位
     */
    @ApiModelProperty(value = "计量单位")
    private String measUnitName;


    /**
     * 结算价表达式
     */
    @ApiModelProperty(value = "结算价表达式")
    private String wholePrice;

    /**
     * 代理结算价表达式
     */
    @ApiModelProperty(value = "代理结算价表达式")
    private String agentWholePrice;

    /**
     * 结算价区间
     */
    @ApiModelProperty(value = "结算价区间")
    private String wholePriceSection;

    /**
     * 代理结算价区间
     */
    @ApiModelProperty(value = "代理结算价区间")
    private String agentWholePriceSection;

    /**
     * 平台结算价区间
     */
    @ApiModelProperty(value = "平台结算价区间")
    private String platformWholePriceSection;

    /**
     * 平台代理结算价
     */
    @ApiModelProperty(value = "平台代理结算价")
    private String platformAgentWholePriceSection;

    /**
     * 商品原始结算价
     */
    @ApiModelProperty(value = "商品原始结算价")
    private String originalPrice;

    /**
     * 商品原始代理结算价
     */
    @ApiModelProperty(value = "商品原始代理结算价")
    private String originalAgentPrice;

    /**
     * 商品状态类型
     */
    @ApiModelProperty(value = "商品状态类型")
    private String commStateType;

    /**
     * 图片url
     */
    @ApiModelProperty(value = "图片url")
    private String url;

    /**
     * 图片排序
     */
    @ApiModelProperty(value = "图片排序")
    private Integer sort;

    /**
     * 生产厂商
     */
    @ApiModelProperty(value = "生产厂商")
    private String manufacturerName;

    /**
     * 代理结算价指定方式
     */
    @ApiModelProperty(value = "代理结算价指定方式")
    private String agentSettType;

    /**
     * 代理结算值（可为：固定值/小数）
     */
    @ApiModelProperty(value = "代理结算固定值")
    private String agentPrice;

    /**
     * 代理价解析的集合
     */
    private List<AgentSetPo> agentSetPos;

    /**
     *
     */
    private List<CommPictureListVo> commPicture;

    @ApiModelProperty(value = "挂牌方式")
    private String commPubType;

    @ApiModelProperty(value = "供货方式")
    private String supplyModeType;

    @ApiModelProperty(value = "商品分类")
    @JsonSerialize(using = IdSerializer.class)
    private Long commId;

    /**
     * 有效期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "更新时间")
    private OffsetDateTime updateDate;

    public List<CommPictureListVo> getCommPicture() {
        return commPicture;
    }

    public void setCommPicture(List<CommPictureListVo> commPicture) {
        this.commPicture = commPicture;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public OffsetDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(OffsetDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getCommPubType() {

        return commPubType;
    }

    public void setCommPubType(String commPubType) {
        this.commPubType = commPubType;
    }

    public String getSupplyModeType() {
        return supplyModeType;
    }

    public void setSupplyModeType(String supplyModeType) {
        this.supplyModeType = supplyModeType;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommNum() {
        return commNum;
    }

    public void setCommNum(String commNum) {
        this.commNum = commNum;
    }

    public String getCommArtNum() {
        return commArtNum;
    }

    public void setCommArtNum(String commArtNum) {
        this.commArtNum = commArtNum;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getMeasUnitName() {
        return measUnitName;
    }

    public void setMeasUnitName(String measUnitName) {
        this.measUnitName = measUnitName;
    }

    public String getWholePrice() {
        return wholePrice;
    }

    public void setWholePrice(String wholePrice) {
        this.wholePrice = wholePrice;
    }

    public String getAgentWholePrice() {
        return agentWholePrice;
    }

    public void setAgentWholePrice(String agentWholePrice) {
        this.agentWholePrice = agentWholePrice;
    }

    public String getWholePriceSection() {
        return wholePriceSection;
    }

    public void setWholePriceSection(String wholePriceSection) {
        this.wholePriceSection = wholePriceSection;
    }

    public String getPlatformWholePriceSection() {
        return platformWholePriceSection;
    }

    public void setPlatformWholePriceSection(String platformWholePriceSection) {
        this.platformWholePriceSection = platformWholePriceSection;
    }

    public String getAgentWholePriceSection() {
        return agentWholePriceSection;
    }

    public void setAgentWholePriceSection(String agentWholePriceSection) {
        this.agentWholePriceSection = agentWholePriceSection;
    }

    public String getPlatformAgentWholePriceSection() {
        return platformAgentWholePriceSection;
    }

    public void setPlatformAgentWholePriceSection(String platformAgentWholePriceSection) {
        this.platformAgentWholePriceSection = platformAgentWholePriceSection;
    }

    public String getCommStateType() {
        return commStateType;
    }

    public void setCommStateType(String commStateType) {
        this.commStateType = commStateType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getAgentSettType() {
        return agentSettType;
    }

    public void setAgentSettType(String agentSettType) {
        this.agentSettType = agentSettType;
    }

    public String getAgentPrice() {
        return agentPrice;
    }

    public void setAgentPrice(String agentPrice) {
        this.agentPrice = agentPrice;
    }

    public List<AgentSetPo> getAgentSetPos() {
        return agentSetPos;
    }

    public void setAgentSetPos(List<AgentSetPo> agentSetPos) {
        this.agentSetPos = agentSetPos;
    }
}
