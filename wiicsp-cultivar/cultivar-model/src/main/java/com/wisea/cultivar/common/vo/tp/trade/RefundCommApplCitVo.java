package com.wisea.cultivar.common.vo.tp.trade;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.vo.tp.RefundReasonMageListVo;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 退货申请提交页面
 */
@ApiModel("退货申请提交页面")
public class RefundCommApplCitVo {

	/***商品信息**/
	@ApiModelProperty("订单商品id")
    private Long id;
	@ApiModelProperty("订单id")
    private Long ordId;
	@ApiModelProperty("订单编号")
    private String ordNum;
	@ApiModelProperty("商品发布ID")
    private Long commPubId;
    @ApiModelProperty("商品名称")
    private String commName;
    @ApiModelProperty("商品货号")
    private String commArtNum;
    @ApiModelProperty("购买数量")
    private Integer count;
    @ApiModelProperty("商品计量单位")
    private String measUnitName;
    @ApiModelProperty("商品规格")
    private Double commSpec;
    @ApiModelProperty("商品图片")
    private String commUrl;
    @ApiModelProperty("商品单价")
    private Double price;
    @ApiModelProperty("可退数量")
    private Integer subCount;
    @ApiModelProperty(value = "应退商品金额")
    private Double commTotalAmount;
    @ApiModelProperty(value = "应退运费金额")
    private Double shouldYfAmount;
    @ApiModelProperty(value = "应退金额")
    private Double shouldRefundAmount;
    @ApiModelProperty(value = "最大应退运费金额")
    private Double maxYfAmount;
    @ApiModelProperty(value = "最大应退金额")
    private Double maxRefundAmount;
    @ApiModelProperty(value = "最大应退账期服务费")
    private Double maxZqSerCost;
    @ApiModelProperty(value = "最大应退商品金额")
    private Double maxCommTotalAmount;
    @ApiModelProperty(value = "应退账期服务费")
    private Double zqSerCost;
    @ApiModelProperty("卖家用户ID")
    private Long sellerId;
    @ApiModelProperty("买家用户ID")
    private Long buyerId;
    @ApiModelProperty("订单状态")
    private String orderStateType;
    @ApiModelProperty("确认收货日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime confirmDate;
    @ApiModelProperty("卖家名称")
    private String sellerCompName;
    @ApiModelProperty("订金金额")
    private Double depositAmount;
    @ApiModelProperty("尾款金额")
    private Double tailAmount;
    @ApiModelProperty("支付方式类型")
    private String payMethodType;
	/***退货原因列表**/
    private List<RefundReasonMageListVo> refundReasonMageList;
	/***收货人信息**/
    @ApiModelProperty("订单收货地址信息")
    private OrderReceAddress orderReceAddress;

	public Long getCommPubId() {
		return commPubId;
	}
	public void setCommPubId(Long commPubId) {
		this.commPubId = commPubId;
	}
	public Double getMaxZqSerCost() {
		return maxZqSerCost;
	}
	public void setMaxZqSerCost(Double maxZqSerCost) {
		this.maxZqSerCost = maxZqSerCost;
	}
	public Double getMaxCommTotalAmount() {
		return maxCommTotalAmount;
	}
	public void setMaxCommTotalAmount(Double maxCommTotalAmount) {
		this.maxCommTotalAmount = maxCommTotalAmount;
	}
	public Double getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(Double depositAmount) {
		this.depositAmount = depositAmount;
	}
	public Double getTailAmount() {
		return tailAmount;
	}
	public void setTailAmount(Double tailAmount) {
		this.tailAmount = tailAmount;
	}
	public String getPayMethodType() {
		return payMethodType;
	}
	public void setPayMethodType(String payMethodType) {
		this.payMethodType = payMethodType;
	}
	public Double getMaxYfAmount() {
		return maxYfAmount;
	}
	public void setMaxYfAmount(Double maxYfAmount) {
		this.maxYfAmount = maxYfAmount;
	}
	public Double getMaxRefundAmount() {
		return maxRefundAmount;
	}
	public void setMaxRefundAmount(Double maxRefundAmount) {
		this.maxRefundAmount = maxRefundAmount;
	}
	public Double getZqSerCost() {
		return zqSerCost;
	}
	public void setZqSerCost(Double zqSerCost) {
		this.zqSerCost = zqSerCost;
	}
	public Double getShouldRefundAmount() {
		return shouldRefundAmount;
	}
	public void setShouldRefundAmount(Double shouldRefundAmount) {
		this.shouldRefundAmount = shouldRefundAmount;
	}
	public Double getCommTotalAmount() {
		return commTotalAmount;
	}
	public void setCommTotalAmount(Double commTotalAmount) {
		this.commTotalAmount = commTotalAmount;
	}
	public Double getShouldYfAmount() {
		return shouldYfAmount;
	}
	public void setShouldYfAmount(Double shouldYfAmount) {
		this.shouldYfAmount = shouldYfAmount;
	}
	public String getOrdNum() {
		return ordNum;
	}
	public void setOrdNum(String ordNum) {
		this.ordNum = ordNum;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}
	public Long getOrdId() {
		return ordId;
	}
	public void setOrdId(Long ordId) {
		this.ordId = ordId;
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
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getMeasUnitName() {
		return measUnitName;
	}
	public void setMeasUnitName(String measUnitName) {
		this.measUnitName = measUnitName;
	}
	public Double getCommSpec() {
		return commSpec;
	}
	public void setCommSpec(Double commSpec) {
		this.commSpec = commSpec;
	}
	public String getCommUrl() {
		return commUrl;
	}
	public void setCommUrl(String commUrl) {
		this.commUrl = commUrl;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getSubCount() {
		return subCount;
	}
	public void setSubCount(Integer subCount) {
		this.subCount = subCount;
	}
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	public String getSellerCompName() {
		return sellerCompName;
	}
	public void setSellerCompName(String sellerCompName) {
		this.sellerCompName = sellerCompName;
	}
	public List<RefundReasonMageListVo> getRefundReasonMageList() {
		return refundReasonMageList;
	}
	public void setRefundReasonMageList(List<RefundReasonMageListVo> refundReasonMageList) {
		this.refundReasonMageList = refundReasonMageList;
	}
	public OrderReceAddress getOrderReceAddress() {
		return orderReceAddress;
	}
	public void setOrderReceAddress(OrderReceAddress orderReceAddress) {
		this.orderReceAddress = orderReceAddress;
	}
	public String getOrderStateType() {
		return orderStateType;
	}
	public void setOrderStateType(String orderStateType) {
		this.orderStateType = orderStateType;
	}
	public OffsetDateTime getConfirmDate() {
		return confirmDate;
	}
	public void setConfirmDate(OffsetDateTime confirmDate) {
		this.confirmDate = confirmDate;
	}
}
