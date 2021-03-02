package com.wisea.transac.common.po.product;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.product.CommDataListVo;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author wangs
 */
public class CommDataListPo extends PagePo<CommDataListVo> {

    private static final long serialVersionUID = -3865130845697189245L;

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
     * 商品货号
     */
    @ApiModelProperty(value = "商品货号")
    private String commArtNum;

    /**
     * 商家名称
     */
    @ApiModelProperty(value = "商家名称",hidden = true)
    private String sellerName;

    /**
     * 商品状态类型
     */
    @ApiModelProperty(value = "商品状态类型")
    private String commStateType;

    /**
     * 商品编号、货号、名称、检索字段
     */
    @ApiModelProperty(value = "商品编号,货号,名称")
    private String likeName;
    /**
     * 商品品类 id
     */
    @ApiModelProperty(value = "商品品类id(门户 - 大宗单品页面默认传递第一个品类信息)")
    private Long commId;

    /**
     * 是否分页的标识
     */
    @ApiModelProperty(value = "是否分页的标识(1:不分页)")
    private String isPageFlag;

    /**
     * 档口id
     */
    @ApiModelProperty(value = "档口id")
    private Long stallsMageId;

    /**
     * 批发市场id
     */
    @ApiModelProperty("批发市场id")
    private Long marketId;

    /**
     * 商家名称
     */
    @ApiModelProperty("商家名称")
    private String entpName;

    /**
     * 基地名称
     */
    @ApiModelProperty("商家名称")
    private String baseName;

    @ApiModelProperty(value = "档口ID，如果当前登录用户关联了档口，传关联的档口ID，如果当前登录用户没有关联档口，默认不传，用户选择时再传")
    private List<Long> stallsMageIds;

    @ApiModelProperty(value = "店铺ID即商家名称，默认不传,查询的是当前批发市场下的所有店铺信息，用户选择时再传")
    private List<Long> shopMageIds;

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public List<Long> getShopMageIds() {
        return shopMageIds;
    }

    public void setShopMageIds(List<Long> shopMageIds) {
        this.shopMageIds = shopMageIds;
    }

    public List<Long> getStallsMageIds() {
        return stallsMageIds;
    }

    public void setStallsMageIds(List<Long> stallsMageIds) {
        this.stallsMageIds = stallsMageIds;
    }

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public Long getMarketId() {
        return marketId;
    }

    public void setMarketId(Long marketId) {
        this.marketId = marketId;
    }

    public Long getStallsMageId() {
        return stallsMageId;
    }

    public void setStallsMageId(Long stallsMageId) {
        this.stallsMageId = stallsMageId;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getLikeName() {
        return likeName;
    }

    public void setLikeName(String likeName) {
        this.likeName = likeName;
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

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getCommArtNum() {
        return commArtNum;
    }

    public void setCommArtNum(String commArtNum) {
        this.commArtNum = commArtNum;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getCommStateType() {
        return commStateType;
    }

    public void setCommStateType(String commStateType) {
        this.commStateType = commStateType;
    }

    public String getIsPageFlag() {
        return isPageFlag;
    }

    public void setIsPageFlag(String isPageFlag) {
        this.isPageFlag = isPageFlag;
    }
}
