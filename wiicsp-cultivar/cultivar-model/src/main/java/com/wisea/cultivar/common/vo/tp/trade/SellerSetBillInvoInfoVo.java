package com.wisea.cultivar.common.vo.tp.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 *
 * @author yangtao
 *
 */
@ApiModel("卖家查询账期发票列表vo")
public class SellerSetBillInvoInfoVo extends BuyerSettleBillInfoVo{

	@ApiModelProperty(value = "商家id")
    private Long entpId;

    @ApiModelProperty(value = "结算单id")
    private Long settleId;

    @ApiModelProperty(value = "结算单单号")
    private String settleBillNumb;

    @ApiModelProperty(value = "结算周期")
    private String settleCycle;

    @ApiModelProperty(value = "结算周期前部分")
    private String beforeTime;

    @ApiModelProperty(value = "省名称")
    private String provName;

    @ApiModelProperty(value = "市名称")
    private String cityName;

    @ApiModelProperty(value = "区县名称")
    private String couName;

    @ApiModelProperty(value = "应结金额")
    private Double totalMoney;

    @ApiModelProperty(value = "结算周期后部分")
    private String afterTime;

    @ApiModelProperty(value = "发票类型")
    private String invoType;

    @ApiModelProperty(value = "发票形式")
    private String invoForm;

    @ApiModelProperty(value = "发票类别")
    private String invoCatgType;

    @ApiModelProperty(value = "发票抬头")
    private String invoTitle;

    @ApiModelProperty(value = "纳税人识别号")
    private String taxIdentNum;

    @ApiModelProperty(value = "注册地址")
    private String registAddress;

    @ApiModelProperty(value = "注册电话")
    private String registTel;

    @ApiModelProperty(value = "开户银行")
    private String bankName;

    @ApiModelProperty(value = "银行账户")
    private String bankAccNum;

    @ApiModelProperty(value = "是否默认")
    private String defaultFlag;

    @ApiModelProperty(value = "收件人")
    private String receName;

    @ApiModelProperty(value = "所在地区省")
    private String addressProv;

    @ApiModelProperty(value = "所在地区市")
    private String addressCity;

    @ApiModelProperty(value = "所在地区区县")
    private String addressCou;

    @ApiModelProperty(value = "详细地址")
    private String addressDetail;

    @ApiModelProperty(value = "邮编")
    private String zipCode;

    @ApiModelProperty(value = "手机号码")
    private String tel;

    @ApiModelProperty(value = "物流公司名称")
    private String logisticsCompName;

    @ApiModelProperty(value = "物流单号")
    private String logisticsNum;

    @ApiModelProperty(value = "申请单号")
    private String applNum;

    @ApiModelProperty(value = "申请时间")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime applDate;

    @ApiModelProperty(value = "开票日期")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime drawDate;

    @ApiModelProperty(value = "开票金额")
    private Double drawAmount;

    @ApiModelProperty(value = "发票状态")
    private String invoState;

    @ApiModelProperty(value = "作废备注")
    private String cancelRemarks;

    @ApiModelProperty(value = "已开票订单金额")
    private String finisOrdInvoMoney;

    @ApiModelProperty(value = "已开票订单笔数")
    private String finisOrdInvoCount;

    @ApiModelProperty(value = "待开票订单笔数")
    private String notOrdInvoCount;

    @ApiModelProperty(value = "采购商名称")
    private String buyerName;

	@ApiModelProperty("电子发票url")
	private String dzInvoUrl;

	@ApiModelProperty("电子发票文件名称")
	private String dzInvoName;

    @ApiModelProperty("订单总金额")
    private Double ordTotalAmount;

    @ApiModelProperty("退货申请总数")
    private Integer refundCommApplTotalCount;

    @ApiModelProperty("退款总额")
    private Double refundCommTotalAmount;

	public Long getEntpId() {
		return entpId;
	}

	public void setEntpId(Long entpId) {
		this.entpId = entpId;
	}

	public Double getOrdTotalAmount() {
		return ordTotalAmount;
	}

	public void setOrdTotalAmount(Double ordTotalAmount) {
		this.ordTotalAmount = ordTotalAmount;
	}

	public Integer getRefundCommApplTotalCount() {
		return refundCommApplTotalCount;
	}

	public void setRefundCommApplTotalCount(Integer refundCommApplTotalCount) {
		this.refundCommApplTotalCount = refundCommApplTotalCount;
	}

	public Double getRefundCommTotalAmount() {
		return refundCommTotalAmount;
	}

	public void setRefundCommTotalAmount(Double refundCommTotalAmount) {
		this.refundCommTotalAmount = refundCommTotalAmount;
	}

	public Long getSettleId() {
		return settleId;
	}

	public void setSettleId(Long settleId) {
		this.settleId = settleId;
	}

	public String getSettleBillNumb() {
		return settleBillNumb;
	}

	public void setSettleBillNumb(String settleBillNumb) {
		this.settleBillNumb = settleBillNumb;
	}

	public String getSettleCycle() {
		return settleCycle;
	}

	public void setSettleCycle(String settleCycle) {
		this.settleCycle = settleCycle;
	}

	public String getBeforeTime() {
		return beforeTime;
	}

	public void setBeforeTime(String beforeTime) {
		this.beforeTime = beforeTime;
	}

	public Double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getAfterTime() {
		return afterTime;
	}

	public void setAfterTime(String afterTime) {
		this.afterTime = afterTime;
	}

	public String getInvoType() {
		return invoType;
	}

	public void setInvoType(String invoType) {
		this.invoType = invoType;
	}

	public String getInvoForm() {
		return invoForm;
	}

	public void setInvoForm(String invoForm) {
		this.invoForm = invoForm;
	}

	public String getInvoCatgType() {
		return invoCatgType;
	}

	public void setInvoCatgType(String invoCatgType) {
		this.invoCatgType = invoCatgType;
	}

	public String getInvoTitle() {
		return invoTitle;
	}

	public void setInvoTitle(String invoTitle) {
		this.invoTitle = invoTitle;
	}

	public String getTaxIdentNum() {
		return taxIdentNum;
	}

	public void setTaxIdentNum(String taxIdentNum) {
		this.taxIdentNum = taxIdentNum;
	}

	public String getRegistAddress() {
		return registAddress;
	}

	public void setRegistAddress(String registAddress) {
		this.registAddress = registAddress;
	}

	public String getRegistTel() {
		return registTel;
	}

	public void setRegistTel(String registTel) {
		this.registTel = registTel;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccNum() {
		return bankAccNum;
	}

	public void setBankAccNum(String bankAccNum) {
		this.bankAccNum = bankAccNum;
	}

	public String getDefaultFlag() {
		return defaultFlag;
	}

	public void setDefaultFlag(String defaultFlag) {
		this.defaultFlag = defaultFlag;
	}

	public String getReceName() {
		return receName;
	}

	public void setReceName(String receName) {
		this.receName = receName;
	}

	public String getAddressProv() {
		return addressProv;
	}

	public void setAddressProv(String addressProv) {
		this.addressProv = addressProv;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressCou() {
		return addressCou;
	}

	public void setAddressCou(String addressCou) {
		this.addressCou = addressCou;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getLogisticsCompName() {
		return logisticsCompName;
	}

	public void setLogisticsCompName(String logisticsCompName) {
		this.logisticsCompName = logisticsCompName;
	}

	public String getLogisticsNum() {
		return logisticsNum;
	}

	public void setLogisticsNum(String logisticsNum) {
		this.logisticsNum = logisticsNum;
	}

	public String getApplNum() {
		return applNum;
	}

	public void setApplNum(String applNum) {
		this.applNum = applNum;
	}

	public OffsetDateTime getApplDate() {
		return applDate;
	}

	public void setApplDate(OffsetDateTime applDate) {
		this.applDate = applDate;
	}

	public OffsetDateTime getDrawDate() {
		return drawDate;
	}

	public void setDrawDate(OffsetDateTime drawDate) {
		this.drawDate = drawDate;
	}

	public Double getDrawAmount() {
		return drawAmount;
	}

	public void setDrawAmount(Double drawAmount) {
		this.drawAmount = drawAmount;
	}

	public String getInvoState() {
		return invoState;
	}

	public void setInvoState(String invoState) {
		this.invoState = invoState;
	}

	public String getCancelRemarks() {
		return cancelRemarks;
	}

	public void setCancelRemarks(String cancelRemarks) {
		this.cancelRemarks = cancelRemarks;
	}

	public String getFinisOrdInvoMoney() {
		return finisOrdInvoMoney;
	}

	public void setFinisOrdInvoMoney(String finisOrdInvoMoney) {
		this.finisOrdInvoMoney = finisOrdInvoMoney;
	}

	public String getFinisOrdInvoCount() {
		return finisOrdInvoCount;
	}

	public void setFinisOrdInvoCount(String finisOrdInvoCount) {
		this.finisOrdInvoCount = finisOrdInvoCount;
	}

	public String getNotOrdInvoCount() {
		return notOrdInvoCount;
	}

	public void setNotOrdInvoCount(String notOrdInvoCount) {
		this.notOrdInvoCount = notOrdInvoCount;
	}

	public String getDzInvoUrl() {
		return dzInvoUrl;
	}

	public void setDzInvoUrl(String dzInvoUrl) {
		this.dzInvoUrl = dzInvoUrl;
	}

	public String getProvName() {
		return provName;
	}

	public void setProvName(String provName) {
		this.provName = provName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCouName() {
		return couName;
	}

	public void setCouName(String couName) {
		this.couName = couName;
	}

	public String getDzInvoName() {
		return dzInvoName;
	}

	public void setDzInvoName(String dzInvoName) {
		this.dzInvoName = dzInvoName;
	}
}
