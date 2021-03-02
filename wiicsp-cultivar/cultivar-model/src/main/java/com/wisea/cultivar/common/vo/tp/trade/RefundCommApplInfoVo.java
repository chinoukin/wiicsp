package com.wisea.cultivar.common.vo.tp.trade;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.vo.tp.PictureVo;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 退货退款详细信息VO
 */
@ApiModel("退货退款详细信息VO")
public class RefundCommApplInfoVo {
    @ApiModelProperty("退货退款ID")
    private Long id;
    @ApiModelProperty("订单ID")
    private Long orderId;
    @ApiModelProperty("退货商品信息")
    private OrderCommRelaVo orderCommRela;
    @ApiModelProperty("服务单号")
    private String serNum;
    @ApiModelProperty("服务类型")
    private String serType;
    @ApiModelProperty("异议类型")
    private String examDissType;
    @ApiModelProperty("买家货物状态【买家端是否收到货】")
    private String buyerCommState;
    @ApiModelProperty("退货申请状态")
    private String refundCommState;
    @ApiModelProperty("订单编号")
    private String ordNum;
    @ApiModelProperty("提交申请时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime applDate;
    @ApiModelProperty("买家用户ID")
    private Long buyerId;
    @ApiModelProperty("买家用户账号")
    private String buyerAccount;
    @ApiModelProperty("买家联系人")
    private String buyerCustName;
    @ApiModelProperty("买家联系方式")
    private String buyerTel;
    @ApiModelProperty("卖家用户ID")
    private Long sellerId;
    @ApiModelProperty("卖家用户账号")
    private String sellerAccount;
    @ApiModelProperty("卖家联系人")
    private String sellerContacts;
    @ApiModelProperty("卖家联系方式")
    private String sellerCompTel;
    @ApiModelProperty("订单金额")
    private Double amountPayable;
    @ApiModelProperty("商品总额(申请退款金额)")
    private Double commTotalAmount;
    @ApiModelProperty("应退运费金额")
    private Double shouldYfAmount;
    @ApiModelProperty("应退账期服务费")
    private Double zqSerCost;
    @ApiModelProperty("实退金额合计(申请退款金额 + 应退运费金额 + 应退账期服务费)")
    private Double shouldRefundAmount;
    @ApiModelProperty("平台应退服务费")
    private Double platfCost;
    @ApiModelProperty("实退金额")
    private Double stAmount;
    @ApiModelProperty("商家应退金额")
    private String sellerShouldRefundAmount;

    @ApiModelProperty("退货原因")
    private String refundReasonId;
    @ApiModelProperty("退货原因描述")
    private String refundReason;
    @ApiModelProperty("问题描述")
    private String refundDesc;
    @ApiModelProperty("凭证照片")
    private List<PictureVo> pictures;
    @ApiModelProperty("收货人姓名")
    private String receName;
    @ApiModelProperty("收货人手机号")
    private String receTel;
    @ApiModelProperty("收货地址省")
    private String addressProv;
    @ApiModelProperty("收货地址市")
    private String addressCity;
    @ApiModelProperty("收货地址县")
    private String addressCou;
    @ApiModelProperty("收货详细地址")
    private String addressDetail;
    @ApiModelProperty("物流公司")
    private String logisticsCompName;
    @ApiModelProperty("物流单号")
    private String logisticsNum;
    @ApiModelProperty("退货申请操作记录")
    private List<RefundCommOperatorInfoVo> refundCommOperatorInfos;
    @ApiModelProperty("卖家货物状态类型 注：卖家同意退货，买家发货后货物状态，如果退款申请状态为已拒绝，并且该字段不为空，则显示拒绝退款模块，其中pictures中buySellFlag为1的是拒绝是上传的凭证")
    private String goodsStateType;
    @ApiModelProperty("拒收原因")
    private String rejeReason;
    @ApiModelProperty("处理方类型")
    private String handlerType;
    @ApiModelProperty("处理方式类型")
    private String handleType;
    @ApiModelProperty("发货时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime sendDate;

    @ApiModelProperty("退款时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime refundDate;
    @ApiModelProperty("流水号")
    private String tradeNo;
    @ApiModelProperty("实退金额")
    private Double refundAmount;
    @ApiModelProperty("退款状态")
    private String refundState;

    /**新增字段**/
    @ApiModelProperty("订单支付类型")
    private String payMethodType;
    @ApiModelProperty("买家发货类型")
    private String buyerSendType;
    @ApiModelProperty("运送人")
    private String sender;
    @ApiModelProperty("运送人联系电话")
    private String senderTel;
    @ApiModelProperty("车船号")
    private String cchNum;
    @ApiModelProperty("退货数量/补损数量")
    private Integer refundCounts;
    @ApiModelProperty("订单备注")
    private String remarks;
    @ApiModelProperty("补损状态")
    private String bsStateType;
    @ApiModelProperty("配送方式类型")
    private String deliveryInfoType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeliveryInfoType() {
        return deliveryInfoType;
    }

    public void setDeliveryInfoType(String deliveryInfoType) {
        this.deliveryInfoType = deliveryInfoType;
    }

    public Double getStAmount() {
		return stAmount;
	}

	public void setStAmount(Double stAmount) {
		this.stAmount = stAmount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getHandlerType() {
		return handlerType;
	}

	public void setHandlerType(String handlerType) {
		this.handlerType = handlerType;
	}

    public String getHandleType() {
        return handleType;
    }

    public void setHandleType(String handleType) {
        this.handleType = handleType;
    }

    public String getRefundReason() {
		return refundReason;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getSerType() {
		return serType;
	}

	public void setSerType(String serType) {
		this.serType = serType;
	}

    public String getExamDissType() {
        return examDissType;
    }

    public void setExamDissType(String examDissType) {
        this.examDissType = examDissType;
    }

    public String getBuyerCommState() {
        return buyerCommState;
    }

    public void setBuyerCommState(String buyerCommState) {
        this.buyerCommState = buyerCommState;
    }

    public OrderCommRelaVo getOrderCommRela() {
        return orderCommRela;
    }

    public void setOrderCommRela(OrderCommRelaVo orderCommRela) {
        this.orderCommRela = orderCommRela;
    }

    public String getSerNum() {
        return serNum;
    }

    public void setSerNum(String serNum) {
        this.serNum = serNum;
    }

    public String getRefundCommState() {
        return refundCommState;
    }

    public void setRefundCommState(String refundCommState) {
        this.refundCommState = refundCommState;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public OffsetDateTime getApplDate() {
        return applDate;
    }

    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
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

    public String getBuyerCustName() {
        return buyerCustName;
    }

    public void setBuyerCustName(String buyerCustName) {
        this.buyerCustName = buyerCustName;
    }

    public String getBuyerTel() {
        return buyerTel;
    }

    public void setBuyerTel(String buyerTel) {
        this.buyerTel = buyerTel;
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

    public String getSellerContacts() {
        return sellerContacts;
    }

    public void setSellerContacts(String sellerContacts) {
        this.sellerContacts = sellerContacts;
    }

    public String getSellerCompTel() {
        return sellerCompTel;
    }

    public void setSellerCompTel(String sellerCompTel) {
        this.sellerCompTel = sellerCompTel;
    }

    public Double getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(Double amountPayable) {
        this.amountPayable = amountPayable;
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

    public Double getPlatfCost() {
        return platfCost;
    }

    public void setPlatfCost(Double platfCost) {
        this.platfCost = platfCost;
    }

    public String getSellerShouldRefundAmount() {
        return sellerShouldRefundAmount;
    }

    public void setSellerShouldRefundAmount(String sellerShouldRefundAmount) {
        this.sellerShouldRefundAmount = sellerShouldRefundAmount;
    }

    public String getRefundReasonId() {
        return refundReasonId;
    }

    public void setRefundReasonId(String refundReasonId) {
        this.refundReasonId = refundReasonId;
    }

    public String getRefundDesc() {
        return refundDesc;
    }

    public void setRefundDesc(String refundDesc) {
        this.refundDesc = refundDesc;
    }

    public List<PictureVo> getPictures() {
        return pictures;
    }

    public void setPictures(List<PictureVo> pictures) {
        this.pictures = pictures;
    }

    public String getReceName() {
        return receName;
    }

    public void setReceName(String receName) {
        this.receName = receName;
    }

    public String getReceTel() {
        return receTel;
    }

    public void setReceTel(String receTel) {
        this.receTel = receTel;
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

    public List<RefundCommOperatorInfoVo> getRefundCommOperatorInfos() {
        return refundCommOperatorInfos;
    }

    public void setRefundCommOperatorInfos(List<RefundCommOperatorInfoVo> refundCommOperatorInfos) {
        this.refundCommOperatorInfos = refundCommOperatorInfos;
    }

    public String getGoodsStateType() {
        return goodsStateType;
    }

    public void setGoodsStateType(String goodsStateType) {
        this.goodsStateType = goodsStateType;
    }

    public String getRejeReason() {
        return rejeReason;
    }

    public void setRejeReason(String rejeReason) {
        this.rejeReason = rejeReason;
    }

    public OffsetDateTime getSendDate() {
        return sendDate;
    }

    public void setSendDate(OffsetDateTime sendDate) {
        this.sendDate = sendDate;
    }

    public OffsetDateTime getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(OffsetDateTime refundDate) {
        this.refundDate = refundDate;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundState() {
        return refundState;
    }

    public void setRefundState(String refundState) {
        this.refundState = refundState;
    }

    public String getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(String payMethodType) {
        this.payMethodType = payMethodType;
    }

    public String getBuyerSendType() {
        return buyerSendType;
    }

    public void setBuyerSendType(String buyerSendType) {
        this.buyerSendType = buyerSendType;
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

    public Integer getRefundCounts() {
        return refundCounts;
    }

    public void setRefundCounts(Integer refundCounts) {
        this.refundCounts = refundCounts;
    }

    public String getBsStateType() {
        return bsStateType;
    }

    public void setBsStateType(String bsStateType) {
        this.bsStateType = bsStateType;
    }
}
