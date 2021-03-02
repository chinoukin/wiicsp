package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.vo.tp.CommPubInfoListVo;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * @Author
 * CommPubInfoPagePo
 * 2018/09/18 14:36:47
 */
public class CommPubInfoPagePo extends PagePo<CommPubInfoListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * 会员id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "会员id", hidden = true)
    private Long membId;

    /**
     * 商品id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品id")
    private Long commId;

    /**
     * 品牌id
     */
    @JsonSerialize(using = IdSerializer.class)
    private Long brandId;

    /**
     *  商品搜索信息
     */
    @ApiModelProperty(value = "商品搜索信息")
     private String search;

    /**
     * 商品发布类型
     */
    @ApiModelProperty(value = "商品发布类型")
    private String commPubType;

    /**
     * 供货方式类型
     */
    @ApiModelProperty(value = "供货方式类型")
    private String supplyModeType;

    /**
     * 结算支付类型
     */
    @ApiModelProperty(value = "结算支付类型")
    private String payMethodType;

    /**
     * 是否支持买家自提类型（是、否）
     */
    @ApiModelProperty(value = "是否支持买家自提类型（是、否）")
    private String sfzcmjztType;

    /**
     * 挂牌有效期开始时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "挂牌有效期开始时间")
    private OffsetDateTime startDate;

    /**
     * "挂牌有效期结束时间"
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "挂牌有效期结束时间")
    private OffsetDateTime endDate;

    /**
     * 商品状态类型
     */
    @ApiModelProperty(value = "商品状态类型")
    private String commStateType;

    public String getCommPubType() {
        return commPubType;
    }

    public void setCommPubType(String commPubType) {
        this.commPubType = commPubType;
    }

    public String getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(String payMethodType) {
        this.payMethodType = payMethodType;
    }

    public String getSfzcmjztType() {
        return sfzcmjztType;
    }

    public void setSfzcmjztType(String sfzcmjztType) {
        this.sfzcmjztType = sfzcmjztType;
    }

    public String getSupplyModeType() {
        return supplyModeType;
    }

    public void setSupplyModeType(String supplyModeType) {
        this.supplyModeType = supplyModeType;
    }

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
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

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
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
     * 获取搜索条件
     * @return
     */
    public String getSearch() {
        return search;
    }

    /**
     * 设置
     * @param search
     */
    public void setSearch(String search) {
        this.search = search;
    }
}
