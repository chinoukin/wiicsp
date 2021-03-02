package com.wisea.transac.common.po.product;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.product.CommPubInfoListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @Author CommPubInfoPagePo
 * 2018/09/18 14:36:47
 */
@ApiModel("商品发布列表")
public class CommPubInfoPagePo extends PagePo<CommPubInfoListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * 商品编号
     */
    @ApiModelProperty("商品编号")
    private String commNum;

    /**
     * 商品标题
     */
    @ApiModelProperty("商品标题")
    private String commTitle;

    /**
     * 商品搜索信息
     */
    @ApiModelProperty(value = "商品搜索信息")
    private String search;

    @ApiModelProperty("基地商品页面 使用- 商品价格排序(商品管理列表中不用传递)")
    private String price;

    @ApiModelProperty("基地商品页面 使用- 成交金额(商品管理列表中不用传递)")
    private Double transactionAmount;

    @ApiModelProperty(value = "基地商品页面 使用 - 排序方式 正序 asc 倒序 desc")
    private String orderBy;

    @ApiModelProperty("销售分类设置id")
    private Long commSalesSetId;

    @ApiModelProperty("基地商品页面 - 销售分类id")
    private Long commSaleCatgId;

    @ApiModelProperty(value = "销售分类设置id 集合")
    private List<Long> commSaleSetIds;
    /**
     * 商品状态类型
     */
    @ApiModelProperty(value = "商品状态类型")
    private String commStateType;

    @ApiModelProperty("所在仓储id")
    private Long storageId;

    @ApiModelProperty("所在种植园id")
    private Long plantationId;

    @ApiModelProperty("基地id")
    private Long baseId;

    @ApiModelProperty(value = "档口ID，如果当前登录用户关联了档口，传关联的档口ID，如果当前登录用户没有关联档口，默认不传，用户选择时再传", hidden = true)
    private List<Long> stallsMageIds;

    @ApiModelProperty(value = "商户id(小程序中商家店铺商品页面)", hidden = true)
    private Long merchantId;

    @ApiModelProperty("近一个月的时间")
    private OffsetDateTime nearlyMonth;

    public OffsetDateTime getNearlyMonth() {
        return nearlyMonth;
    }

    public void setNearlyMonth(OffsetDateTime nearlyMonth) {
        this.nearlyMonth = nearlyMonth;
    }

    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }

    public Long getPlantationId() {
        return plantationId;
    }

    public void setPlantationId(Long plantationId) {
        this.plantationId = plantationId;
    }

    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getCommSaleCatgId() {
        return commSaleCatgId;
    }

    public void setCommSaleCatgId(Long commSaleCatgId) {
        this.commSaleCatgId = commSaleCatgId;
    }

    public List<Long> getCommSaleSetIds() {
        return commSaleSetIds;
    }

    public void setCommSaleSetIds(List<Long> commSaleSetIds) {
        this.commSaleSetIds = commSaleSetIds;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getCommStateType() {
        return commStateType;
    }

    public void setCommStateType(String commStateType) {
        this.commStateType = commStateType;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Long getCommSalesSetId() {
        return commSalesSetId;
    }

    public void setCommSalesSetId(Long commSalesSetId) {
        this.commSalesSetId = commSalesSetId;
    }

    public List<Long> getStallsMageIds() {
        return stallsMageIds;
    }

    public void setStallsMageIds(List<Long> stallsMageIds) {
        this.stallsMageIds = stallsMageIds;
    }

    public String getCommNum() {
        return commNum;
    }

    public void setCommNum(String commNum) {
        this.commNum = commNum;
    }

    public String getCommTitle() {
        return commTitle;
    }

    public void setCommTitle(String commTitle) {
        this.commTitle = commTitle;
    }
}
