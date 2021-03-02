package com.wisea.cultivar.common.vo.tp.lta;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * OrderInfoListVo
 * 2018/09/18 17:40:35
 */
@ApiModel("买家端订单列表vo")
public class LtaBuyerOrderInfoListVo {

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "合同id")
    private Long ltaContId;

    @ApiModelProperty(value = "订单编号")
    private String ltaOrdNumb;

    @ApiModelProperty(value = "来源类型")
    private String sourceType;

    @ApiModelProperty(value = "买家名称")
    private String buyerName;

    @ApiModelProperty(value = "卖家名称")
    private String sellerName;

    @ApiModelProperty(value = "买家账号")
    private String buyerUserName;

    @ApiModelProperty(value = "商品总件数")
    private int commTotalCount;

    @ApiModelProperty(value = "运费总金额")
    private Double freight;

    @ApiModelProperty(value = "应付总金额")
    private Double yfAmount;

    @ApiModelProperty(value = "订单状态类型")
    private String orderStateType;

    @ApiModelProperty(value = "订单商品数量")
    private String orderCommCount;

    @ApiModelProperty(value = "剩余付款时间")
    private String leftTime;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "买方ID")
    private Long buyerId;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "卖方ID")
    private Long sellerId;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @ApiModelProperty(value = "提交订单日期")
    private OffsetDateTime buyerOrdDate;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @ApiModelProperty(value = "付款截止日期")
    private OffsetDateTime payDeadDate;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @ApiModelProperty(value = "当前日期（与付款截止日期计算付款计时）")
    private OffsetDateTime nowDate;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @ApiModelProperty(value = "确认收货日期")
    private OffsetDateTime confirmDate;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @ApiModelProperty(value = "确认收货截止日期")
    private OffsetDateTime confirmDeadLineDate;

    @ApiModelProperty(value = "是否可以退货标识（0：可以。1：不可以）")
    private String reCommFlag;

    @ApiModelProperty(value = "订单商品")
    private List<LtaBuyerOrdCommRela> ordCommRelaList;

    @ApiModelProperty("物流公司")
    private String logisticsCompName;

    @ApiModelProperty("物流公司电话")
    private String logisticsCompTel;

    @ApiModelProperty("物流单号")
    private String logisticsNum;

    @ApiModelProperty("支付方式类型")
    private String payMethodType;

    @ApiModelProperty("商品发布类型")
    private String commPubType;

    @ApiModelProperty("自提码")
    private String ztNum;

    @ApiModelProperty("自提时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime ztDate;

    @ApiModelProperty("自提地省")
    private String ztAddressProv;

    @ApiModelProperty("自提地市")
    private String ztAddressCity;

    @ApiModelProperty("自提地区县")
    private String ztAddressCou;

    @ApiModelProperty("自提详细地址")
    private String ztAddress;

    @ApiModelProperty("自提联系人")
    private String ztContactsName;

    @ApiModelProperty("自提联系电话")
    private String ztTel;

    @ApiModelProperty("自提营业时间")
    private String ztBusinessHours;

    @ApiModelProperty("自提地省Name")
    private String addressProvName;

    @ApiModelProperty("自提地市Name")
    private String addressCityName;

    @ApiModelProperty("自提地区县Name")
    private String addressCouName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSourceType() {
		return sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getAddressProvName() {
		return addressProvName;
	}

	public void setAddressProvName(String addressProvName) {
		this.addressProvName = addressProvName;
	}

	public String getAddressCityName() {
		return addressCityName;
	}

	public void setAddressCityName(String addressCityName) {
		this.addressCityName = addressCityName;
	}

	public String getAddressCouName() {
		return addressCouName;
	}

	public void setAddressCouName(String addressCouName) {
		this.addressCouName = addressCouName;
	}

	public Long getLtaContId() {
		return ltaContId;
	}

	public void setLtaContId(Long ltaContId) {
		this.ltaContId = ltaContId;
	}

	public int getCommTotalCount() {
		return commTotalCount;
	}

	public void setCommTotalCount(int commTotalCount) {
		this.commTotalCount = commTotalCount;
	}

	public String getLtaOrdNumb() {
		return ltaOrdNumb;
	}

	public void setLtaOrdNumb(String ltaOrdNumb) {
		this.ltaOrdNumb = ltaOrdNumb;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getBuyerUserName() {
		return buyerUserName;
	}

	public void setBuyerUserName(String buyerUserName) {
		this.buyerUserName = buyerUserName;
	}

	public Double getFreight() {
		return freight;
	}

	public void setFreight(Double freight) {
		this.freight = freight;
	}

	public Double getYfAmount() {
		return yfAmount;
	}

	public void setYfAmount(Double yfAmount) {
		this.yfAmount = yfAmount;
	}

	public String getOrderStateType() {
		return orderStateType;
	}

	public void setOrderStateType(String orderStateType) {
		this.orderStateType = orderStateType;
	}

	public String getOrderCommCount() {
		return orderCommCount;
	}

	public void setOrderCommCount(String orderCommCount) {
		this.orderCommCount = orderCommCount;
	}

	public String getLeftTime() {
		return leftTime;
	}

	public void setLeftTime(String leftTime) {
		this.leftTime = leftTime;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public OffsetDateTime getBuyerOrdDate() {
		return buyerOrdDate;
	}

	public void setBuyerOrdDate(OffsetDateTime buyerOrdDate) {
		this.buyerOrdDate = buyerOrdDate;
	}

	public OffsetDateTime getPayDeadDate() {
		return payDeadDate;
	}

	public void setPayDeadDate(OffsetDateTime payDeadDate) {
		this.payDeadDate = payDeadDate;
	}

	public OffsetDateTime getNowDate() {
		return nowDate;
	}

	public void setNowDate(OffsetDateTime nowDate) {
		this.nowDate = nowDate;
	}

	public OffsetDateTime getConfirmDate() {
		return confirmDate;
	}

	public void setConfirmDate(OffsetDateTime confirmDate) {
		this.confirmDate = confirmDate;
	}

	public OffsetDateTime getConfirmDeadLineDate() {
		return confirmDeadLineDate;
	}

	public void setConfirmDeadLineDate(OffsetDateTime confirmDeadLineDate) {
		this.confirmDeadLineDate = confirmDeadLineDate;
	}

	public String getReCommFlag() {
		return reCommFlag;
	}

	public void setReCommFlag(String reCommFlag) {
		this.reCommFlag = reCommFlag;
	}

	public List<LtaBuyerOrdCommRela> getOrdCommRelaList() {
		return ordCommRelaList;
	}

	public void setOrdCommRelaList(List<LtaBuyerOrdCommRela> ordCommRelaList) {
		this.ordCommRelaList = ordCommRelaList;
	}

	public String getLogisticsCompName() {
		return logisticsCompName;
	}

	public void setLogisticsCompName(String logisticsCompName) {
		this.logisticsCompName = logisticsCompName;
	}

	public String getLogisticsCompTel() {
		return logisticsCompTel;
	}

	public void setLogisticsCompTel(String logisticsCompTel) {
		this.logisticsCompTel = logisticsCompTel;
	}

	public String getLogisticsNum() {
		return logisticsNum;
	}

	public void setLogisticsNum(String logisticsNum) {
		this.logisticsNum = logisticsNum;
	}

	public String getPayMethodType() {
		return payMethodType;
	}

	public void setPayMethodType(String payMethodType) {
		this.payMethodType = payMethodType;
	}

	public String getCommPubType() {
		return commPubType;
	}

	public void setCommPubType(String commPubType) {
		this.commPubType = commPubType;
	}

	public String getZtNum() {
		return ztNum;
	}

	public void setZtNum(String ztNum) {
		this.ztNum = ztNum;
	}

	public OffsetDateTime getZtDate() {
		return ztDate;
	}

	public void setZtDate(OffsetDateTime ztDate) {
		this.ztDate = ztDate;
	}

	public String getZtAddressProv() {
		return ztAddressProv;
	}

	public void setZtAddressProv(String ztAddressProv) {
		this.ztAddressProv = ztAddressProv;
	}

	public String getZtAddressCity() {
		return ztAddressCity;
	}

	public void setZtAddressCity(String ztAddressCity) {
		this.ztAddressCity = ztAddressCity;
	}

	public String getZtAddressCou() {
		return ztAddressCou;
	}

	public void setZtAddressCou(String ztAddressCou) {
		this.ztAddressCou = ztAddressCou;
	}

	public String getZtAddress() {
		return ztAddress;
	}

	public void setZtAddress(String ztAddress) {
		this.ztAddress = ztAddress;
	}

	public String getZtContactsName() {
		return ztContactsName;
	}

	public void setZtContactsName(String ztContactsName) {
		this.ztContactsName = ztContactsName;
	}

	public String getZtTel() {
		return ztTel;
	}

	public void setZtTel(String ztTel) {
		this.ztTel = ztTel;
	}

	public String getZtBusinessHours() {
		return ztBusinessHours;
	}

	public void setZtBusinessHours(String ztBusinessHours) {
		this.ztBusinessHours = ztBusinessHours;
	}

}
