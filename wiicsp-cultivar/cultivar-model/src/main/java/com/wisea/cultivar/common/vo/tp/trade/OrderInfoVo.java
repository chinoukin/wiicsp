package com.wisea.cultivar.common.vo.tp.trade;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * 订单详情Vo
 */
@ApiModel("订单详情Vo")
public class OrderInfoVo {
    @ApiModelProperty("订单ID")
    private Long id;
    @ApiModelProperty("订单状态")
    private String orderStateType;
    @ApiModelProperty("提交订单日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime referOrdDate;
    @ApiModelProperty("卖家确认日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime buyerSureDate;
    @ApiModelProperty("支付订单日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime payOrdDate;
    @ApiModelProperty("尾款支付日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime tailAmountPayDate;
    @ApiModelProperty("发货日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime deliveDate;
    @ApiModelProperty("确认收货日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime confirmDate;
    @ApiModelProperty("完成评价日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime evalDate;
    @ApiModelProperty("确认收货截止日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime confirmDeadLineDate;
    @ApiModelProperty("自提时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime ztDate;
    @ApiModelProperty("订单取消日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime ordCancelDate;
    @ApiModelProperty("订单取消原因")
    private String ordCancelName;
    @ApiModelProperty("买家备注")
    private String buyerRemarks;


    /*****1.基本信息*****/
    @ApiModelProperty("订单编号")
    private String ordNum;
    @ApiModelProperty("买家用户ID")
    private Long buyerId;
    @ApiModelProperty("买家用户账号")
    private String buyerAccount;
    @ApiModelProperty("买家名称")
    private String buyerCompName;
    @ApiModelProperty("卖家用户ID")
    private Long sellerId;
    @ApiModelProperty("卖家用户账号")
    private String sellerAccount;
    @ApiModelProperty("卖家名称")
    private String sellerCompName;
    @ApiModelProperty("商品发布类型(挂牌方式)")
    private String commPubType;
    @ApiModelProperty("供货方式类型")
    private String supplyModeType;
    @ApiModelProperty("订单来源")
    private String sourceType;
    @ApiModelProperty("支付方式")
    private String payMethodType;

    /*****2.发票信息*****/
    @ApiModelProperty("订单发票信息")
    private OrdInvoVo ordInvo;

    /*****3.配送信息*****/
    @ApiModelProperty("配送信息类型")
    private String deliveryInfoType;
    @ApiModelProperty("订单发货类型")
    private String ordSendType;
    @ApiModelProperty("指定到货日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime latestArrivalDate;
    /**商家配送-商家送货字段**/
    @ApiModelProperty("运送人")
    private String sender;
    @ApiModelProperty("运送人联系电话")
    private String senderTel;
    @ApiModelProperty("车船号")
    private String cchNum;
    /**商家配送-物流配送字段**/
    @ApiModelProperty("配送物流公司ID")
    private Long logisticsCompId;
    @ApiModelProperty("配送物流公司名称")
    private String logisticsCompName;
    @ApiModelProperty("物流单号")
    private String logisticsNum;
    /**买家自提字段**/
    @ApiModelProperty("自提码")
    private String ztNum;
    @ApiModelProperty("提货人姓名")
    private String consigneeName;
    @ApiModelProperty("提货人手机号")
    private String consigneeTel;
    @ApiModelProperty("自提点名称")
    private String selfMentionAddressName;
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

    @ApiModelProperty("订单收货地址信息")
    private OrderReceAddress orderReceAddress;
    @ApiModelProperty("配送时间类型")
    private String distribDateType;

    /*****4.订单详情*****/
    @ApiModelProperty("订单商品列表")
    private List<OrderCommRelaVo> orderCommRelas;

    /*****5.费用信息*****/
    @ApiModelProperty("商品发布价总金额")
    private Double commTotalPrice;
    @ApiModelProperty("商品总件数")
    private Double commTotalCount;
    @ApiModelProperty("运费")
    private Double commTotalFreight;
    @ApiModelProperty("账期服务费")
    private Double zqSerCost;
    @ApiModelProperty("订单总金额")
    private Double amountPayable;
    @ApiModelProperty("订金金额")
    private Double depositAmount;
    @ApiModelProperty("尾款金额")
    private Double tailAmount;
    @ApiModelProperty("应付尾款金额")
    private Double yfTailAmount;

    @ApiModelProperty("商家结算金额")
    private Double sellerSettleAmount;
    @ApiModelProperty("服务费")
    private Double platfCost;
    @ApiModelProperty("商品结算价总金额")
    private Double commSettlePrice;

    @ApiModelProperty("验收标准表达式")
    private String ysbzBds;

    @ApiModelProperty("订单操作记录列表")
    private List<OrdOpreateInfoVo> ordOpreateInfos;

    @ApiModelProperty("买家下单备注")
    private String remarks;

    /********************************************/
    @ApiModelProperty("付款截止日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime payDeadDate;
    @ApiModelProperty("当前系统日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime nowDate;

    /*******************退款相关时间*************************/
    @ApiModelProperty("订单退款信息")
    private BuyerRefundApplInfoVo buyerRefundApplInfoVo;
    /*******************天数限制*************************/
    @ApiModelProperty("天数限制")
    private Integer limitDays;
    @ApiModelProperty("是否可以申请售后")
    private String reCommFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBuyerRemarks() {
		return buyerRemarks;
	}

	public void setBuyerRemarks(String buyerRemarks) {
		this.buyerRemarks = buyerRemarks;
	}

	public Double getYfTailAmount() {
		return yfTailAmount;
	}

	public void setYfTailAmount(Double yfTailAmount) {
		this.yfTailAmount = yfTailAmount;
	}

	public String getOrderStateType() {
        return orderStateType;
    }

    public void setOrderStateType(String orderStateType) {
        this.orderStateType = orderStateType;
    }

    public OffsetDateTime getReferOrdDate() {
        return referOrdDate;
    }

    public void setReferOrdDate(OffsetDateTime referOrdDate) {
        this.referOrdDate = referOrdDate;
    }

    public OffsetDateTime getTailAmountPayDate() {
		return tailAmountPayDate;
	}

	public void setTailAmountPayDate(OffsetDateTime tailAmountPayDate) {
		this.tailAmountPayDate = tailAmountPayDate;
	}

	public OffsetDateTime getBuyerSureDate() {
        return buyerSureDate;
    }

    public void setBuyerSureDate(OffsetDateTime buyerSureDate) {
        this.buyerSureDate = buyerSureDate;
    }

    public OffsetDateTime getPayOrdDate() {
        return payOrdDate;
    }

    public void setPayOrdDate(OffsetDateTime payOrdDate) {
        this.payOrdDate = payOrdDate;
    }

    public OffsetDateTime getDeliveDate() {
        return deliveDate;
    }

    public void setDeliveDate(OffsetDateTime deliveDate) {
        this.deliveDate = deliveDate;
    }

    public OffsetDateTime getConfirmDate() {
        return confirmDate;
    }

    public void setConfirmDate(OffsetDateTime confirmDate) {
        this.confirmDate = confirmDate;
    }

    public OffsetDateTime getEvalDate() {
        return evalDate;
    }

    public void setEvalDate(OffsetDateTime evalDate) {
        this.evalDate = evalDate;
    }

    public OffsetDateTime getConfirmDeadLineDate() {
        return confirmDeadLineDate;
    }

    public void setConfirmDeadLineDate(OffsetDateTime confirmDeadLineDate) {
        this.confirmDeadLineDate = confirmDeadLineDate;
    }

    public OffsetDateTime getZtDate() {
        return ztDate;
    }

    public void setZtDate(OffsetDateTime ztDate) {
        this.ztDate = ztDate;
    }

    public OffsetDateTime getOrdCancelDate() {
        return ordCancelDate;
    }

    public void setOrdCancelDate(OffsetDateTime ordCancelDate) {
        this.ordCancelDate = ordCancelDate;
    }

    public String getOrdCancelName() {
        return ordCancelName;
    }

    public void setOrdCancelName(String ordCancelName) {
        this.ordCancelName = ordCancelName;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerAccount() {
        return buyerAccount;
    }

    public void setBuyerAccount(String buyerAccount) {
        this.buyerAccount = buyerAccount;
    }

    public String getBuyerCompName() {
        return buyerCompName;
    }

    public void setBuyerCompName(String buyerCompName) {
        this.buyerCompName = buyerCompName;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerAccount() {
        return sellerAccount;
    }

    public void setSellerAccount(String sellerAccount) {
        this.sellerAccount = sellerAccount;
    }

    public String getSellerCompName() {
        return sellerCompName;
    }

    public void setSellerCompName(String sellerCompName) {
        this.sellerCompName = sellerCompName;
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

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(String payMethodType) {
        this.payMethodType = payMethodType;
    }

    public OrdInvoVo getOrdInvo() {
        return ordInvo;
    }

    public void setOrdInvo(OrdInvoVo ordInvo) {
        this.ordInvo = ordInvo;
    }

    public String getDeliveryInfoType() {
        return deliveryInfoType;
    }

    public void setDeliveryInfoType(String deliveryInfoType) {
        this.deliveryInfoType = deliveryInfoType;
    }

    public String getOrdSendType() {
        return ordSendType;
    }

    public void setOrdSendType(String ordSendType) {
        this.ordSendType = ordSendType;
    }

    public OffsetDateTime getLatestArrivalDate() {
        return latestArrivalDate;
    }

    public void setLatestArrivalDate(OffsetDateTime latestArrivalDate) {
        this.latestArrivalDate = latestArrivalDate;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSenderTel() {
        return senderTel;
    }

    public void setSenderTel(String senderTel) {
        this.senderTel = senderTel;
    }

    public String getCchNum() {
        return cchNum;
    }

    public void setCchNum(String cchNum) {
        this.cchNum = cchNum;
    }

    public Long getLogisticsCompId() {
        return logisticsCompId;
    }

    public void setLogisticsCompId(Long logisticsCompId) {
        this.logisticsCompId = logisticsCompId;
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

    public String getZtNum() {
        return ztNum;
    }

    public void setZtNum(String ztNum) {
        this.ztNum = ztNum;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getConsigneeTel() {
        return consigneeTel;
    }

    public void setConsigneeTel(String consigneeTel) {
        this.consigneeTel = consigneeTel;
    }

    public String getSelfMentionAddressName() {
        return selfMentionAddressName;
    }

    public void setSelfMentionAddressName(String selfMentionAddressName) {
        this.selfMentionAddressName = selfMentionAddressName;
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

    public OrderReceAddress getOrderReceAddress() {
        return orderReceAddress;
    }

    public void setOrderReceAddress(OrderReceAddress orderReceAddress) {
        this.orderReceAddress = orderReceAddress;
    }

    public String getDistribDateType() {
        return distribDateType;
    }

    public void setDistribDateType(String distribDateType) {
        this.distribDateType = distribDateType;
    }

    public List<OrderCommRelaVo> getOrderCommRelas() {
        return orderCommRelas;
    }

    public void setOrderCommRelas(List<OrderCommRelaVo> orderCommRelas) {
        this.orderCommRelas = orderCommRelas;
    }

    public Double getCommTotalPrice() {
        return commTotalPrice;
    }

    public void setCommTotalPrice(Double commTotalPrice) {
        this.commTotalPrice = commTotalPrice;
    }

    public Double getCommTotalCount() {
        return commTotalCount;
    }

    public void setCommTotalCount(Double commTotalCount) {
        this.commTotalCount = commTotalCount;
    }

    public Double getCommTotalFreight() {
        return commTotalFreight;
    }

    public void setCommTotalFreight(Double commTotalFreight) {
        this.commTotalFreight = commTotalFreight;
    }

    public Double getZqSerCost() {
        return zqSerCost;
    }

    public void setZqSerCost(Double zqSerCost) {
        this.zqSerCost = zqSerCost;
    }

    public Double getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(Double amountPayable) {
        this.amountPayable = amountPayable;
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

    public Double getSellerSettleAmount() {
        return sellerSettleAmount;
    }

    public void setSellerSettleAmount(Double sellerSettleAmount) {
        this.sellerSettleAmount = sellerSettleAmount;
    }

    public Double getPlatfCost() {
        return platfCost;
    }

    public void setPlatfCost(Double platfCost) {
        this.platfCost = platfCost;
    }

    public Double getCommSettlePrice() {
        return commSettlePrice;
    }

    public void setCommSettlePrice(Double commSettlePrice) {
        this.commSettlePrice = commSettlePrice;
    }

    public String getYsbzBds() {
        return ysbzBds;
    }

    public void setYsbzBds(String ysbzBds) {
        this.ysbzBds = ysbzBds;
    }

    public List<OrdOpreateInfoVo> getOrdOpreateInfos() {
        return ordOpreateInfos;
    }

    public void setOrdOpreateInfos(List<OrdOpreateInfoVo> ordOpreateInfos) {
        this.ordOpreateInfos = ordOpreateInfos;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public BuyerRefundApplInfoVo getBuyerRefundApplInfoVo() {
        return buyerRefundApplInfoVo;
    }

    public void setBuyerRefundApplInfoVo(BuyerRefundApplInfoVo buyerRefundApplInfoVo) {
        this.buyerRefundApplInfoVo = buyerRefundApplInfoVo;
    }

    public Integer getLimitDays() {
        return limitDays;
    }

    public void setLimitDays(Integer limitDays) {
        this.limitDays = limitDays;
    }

    public String getReCommFlag() {
        return reCommFlag;
    }

    public void setReCommFlag(String reCommFlag) {
        this.reCommFlag = reCommFlag;
    }
}
