package com.wisea.cultivar.common.vo.tp.lta;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cultivar.common.vo.tp.RefundReasonMageListVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 退货申请提交页面
 */
@ApiModel("退货申请提交页面")
public class LtaRefundCommApplCitVo {

	/***商品信息**/
	@ApiModelProperty("订单商品id")
    private Long id;
	@ApiModelProperty("订单id")
    private Long ordId;
	@ApiModelProperty("商品id")
    private Long ltaCommRelaId;
	@ApiModelProperty("商品规格id")
    private Long ltaCommPackId;
	@ApiModelProperty("订单编号")
    private String ordNum;
	@ApiModelProperty("商品发布ID")
    private Long commPubId;
    @ApiModelProperty("商品名称")
    private String commName;
    @ApiModelProperty("商品编号")
    private String commNum;
    @ApiModelProperty("商品货号")
    private String commHh;
    @ApiModelProperty("购买数量")
    private Integer count;
    @ApiModelProperty("等级")
    private String level;
    @ApiModelProperty(value = "应退商品金额")
    private Double commTotalAmount;
    @ApiModelProperty(value = "应退运费金额")
    private Double shouldYfAmount;
    @ApiModelProperty(value = "应退金额")
    private Double shouldRefundAmount;
    @ApiModelProperty(value = "运费")
    private Double freight;
    @ApiModelProperty("结算支付类型")
    private String payMethodType;
    @ApiModelProperty("商品计量单位")
    private String measUnitName;
    @ApiModelProperty("商品图片")
    private String commUrl;
    @ApiModelProperty("包装说明")
    private String packInstr;
    @ApiModelProperty("规格重量")
    private Double spec;
    @ApiModelProperty("商品单价")
    private Double price;
    @ApiModelProperty("平台服务费")
    private Double platfCost;
    @ApiModelProperty("可退数量")
    private Integer subCount;
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
	/***退货原因列表**/
    private List<RefundReasonMageListVo> refundReasonMageList;
	/***收货人信息**/
    @ApiModelProperty("收货人姓名")
    private String receName;
    @ApiModelProperty("手机号码")
    private String tel;
    @ApiModelProperty("邮政编码")
    private String zipCode;
    @ApiModelProperty("收货地址省份")
    private String receAddressProv;
    @ApiModelProperty("收货地址市")
    private String receAddressCity;
    @ApiModelProperty("收货地址区县")
    private String receAddressCou;
    @ApiModelProperty("收货地址街道")
    private String receAddressStreet;
    @ApiModelProperty("收货地址省份名字")
    private String receAddressProvName;
    @ApiModelProperty("收货地址市名字")
    private String receAddressCityName;
    @ApiModelProperty("收货地址区县名字")
    private String receAddressCouName;
    @ApiModelProperty("收货地址街道名字")
    private String receAddressStreetName;
    @ApiModelProperty("详细地址")
    private String receAddressDetail;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Double getShouldRefundAmount() {
		return shouldRefundAmount;
	}
	public void setShouldRefundAmount(Double shouldRefundAmount) {
		this.shouldRefundAmount = shouldRefundAmount;
	}
	public String getPayMethodType() {
		return payMethodType;
	}
	public void setPayMethodType(String payMethodType) {
		this.payMethodType = payMethodType;
	}
	public Double getFreight() {
		return freight;
	}
	public void setFreight(Double freight) {
		this.freight = freight;
	}
	public Long getOrdId() {
		return ordId;
	}
	public void setOrdId(Long ordId) {
		this.ordId = ordId;
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
	public Long getLtaCommRelaId() {
		return ltaCommRelaId;
	}
	public void setLtaCommRelaId(Long ltaCommRelaId) {
		this.ltaCommRelaId = ltaCommRelaId;
	}
	public Long getLtaCommPackId() {
		return ltaCommPackId;
	}
	public void setLtaCommPackId(Long ltaCommPackId) {
		this.ltaCommPackId = ltaCommPackId;
	}
	public String getOrdNum() {
		return ordNum;
	}
	public void setOrdNum(String ordNum) {
		this.ordNum = ordNum;
	}
	public Long getCommPubId() {
		return commPubId;
	}
	public void setCommPubId(Long commPubId) {
		this.commPubId = commPubId;
	}
	public String getCommName() {
		return commName;
	}
	public void setCommName(String commName) {
		this.commName = commName;
	}
	public String getCommNum() {
		return commNum;
	}
	public void setCommNum(String commNum) {
		this.commNum = commNum;
	}
	public String getCommHh() {
		return commHh;
	}
	public void setCommHh(String commHh) {
		this.commHh = commHh;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getMeasUnitName() {
		return measUnitName;
	}
	public void setMeasUnitName(String measUnitName) {
		this.measUnitName = measUnitName;
	}
	public String getCommUrl() {
		return commUrl;
	}
	public void setCommUrl(String commUrl) {
		this.commUrl = commUrl;
	}
	public String getPackInstr() {
		return packInstr;
	}
	public void setPackInstr(String packInstr) {
		this.packInstr = packInstr;
	}
	public Double getSpec() {
		return spec;
	}
	public void setSpec(Double spec) {
		this.spec = spec;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getPlatfCost() {
		return platfCost;
	}
	public void setPlatfCost(Double platfCost) {
		this.platfCost = platfCost;
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
	public Long getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
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
	public String getReceName() {
		return receName;
	}
	public void setReceName(String receName) {
		this.receName = receName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getReceAddressProv() {
		return receAddressProv;
	}
	public void setReceAddressProv(String receAddressProv) {
		this.receAddressProv = receAddressProv;
	}
	public String getReceAddressCity() {
		return receAddressCity;
	}
	public void setReceAddressCity(String receAddressCity) {
		this.receAddressCity = receAddressCity;
	}
	public String getReceAddressCou() {
		return receAddressCou;
	}
	public void setReceAddressCou(String receAddressCou) {
		this.receAddressCou = receAddressCou;
	}
	public String getReceAddressStreet() {
		return receAddressStreet;
	}
	public void setReceAddressStreet(String receAddressStreet) {
		this.receAddressStreet = receAddressStreet;
	}
	public String getReceAddressProvName() {
		return receAddressProvName;
	}
	public void setReceAddressProvName(String receAddressProvName) {
		this.receAddressProvName = receAddressProvName;
	}
	public String getReceAddressCityName() {
		return receAddressCityName;
	}
	public void setReceAddressCityName(String receAddressCityName) {
		this.receAddressCityName = receAddressCityName;
	}
	public String getReceAddressCouName() {
		return receAddressCouName;
	}
	public void setReceAddressCouName(String receAddressCouName) {
		this.receAddressCouName = receAddressCouName;
	}
	public String getReceAddressStreetName() {
		return receAddressStreetName;
	}
	public void setReceAddressStreetName(String receAddressStreetName) {
		this.receAddressStreetName = receAddressStreetName;
	}
	public String getReceAddressDetail() {
		return receAddressDetail;
	}
	public void setReceAddressDetail(String receAddressDetail) {
		this.receAddressDetail = receAddressDetail;
	}
}
