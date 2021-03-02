package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * order_info 表实体
 * 冗余商品发布id
 * 2018/09/20 16:05:49
 */
public class OrderInfo extends DataLongEntity<OrderInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 订单编号
     */
    private String ordNum;

    /**
     * 买方ID
     */
    private Long buyerId;

    /**
     * 卖方ID
     */
    private Long sellerId;

    /**
     * 供货方式类型
     */
    private String supplyModeType;

    /**
     * 支付方式类型
     */
    private String payMethodType;

    /**
     * 来源类型
     */
    private String sourceType;

    /**
     * 提货人姓名
     */
    private String consigneeName;

    /**
     * 提货人手机号
     */
    private String consigneeTel;

    /**
     * 收货地址id
     */
    private Long receAddressId;

    /**
     * 商品总金额(商品发布价格)
     */
    private Double commTotalPrice;

    /**
     * 运费总金额
     */
    private Double commTotalFreight;

    /**
     * 应付款金额
     */
    private Double amountPayable;

    /**
     * 优惠金额
     */
    private Double prefAmount;

    /**
     * 验收标准表达式
     */
    private String ysbzBds;

    /**
     * 发票信息ID
     */
    private Long invoId;

    /**
     * 商品发布类型
     */
    private String commPubType;

    /**
     * 配送信息类型
     */
    private String deliveryInfoType;

    /**
     * 配送时间类型
     */
    private String distribDateType;

    /**
     * 平台服务费
     */
    private Double platfCost;

    /**
     * 订单状态类型
     */
    private String orderStateType;

    /**
     * 提交订单日期
     */
    private OffsetDateTime referOrdDate;

    /**
     * 卖方确定日期
     */
    private OffsetDateTime buyerSureDate;

    /**
     * 支付订单日期
     */
    private OffsetDateTime payOrdDate;

    /**
     * 发货日期
     */
    private OffsetDateTime deliveDate;

    /**
     * 确认收货日期
     */
    private OffsetDateTime confirmDate;

    /**
     * 商品总件数
     */
    private Integer commTotalCount;

    /**
     * 订单取消原因id
     */
    private Long ordCancelReasonId;

    /**
     * 订单取消时间
     */
    private OffsetDateTime ordCancelDate;

    /**
     * 物流公司id
     */
    private Long logisticsCompId;

    /**
     * 物流单号
     */
    private String logisticsNum;

    /**
     * 订单发货类型
     */
    private String ordSendType;

    /**
     * 运送人
     */
    private String sender;

    /**
     * 运送人联系电话
     */
    private String senderTel;

    /**
     * 车船号
     */
    private String cchNum;

    /**
     * 自提码
     */
    private String ztNum;

    /**
     * 自提地址名称
     */
    private String selfMentionAddressName;

    /**
     * 自提时间
     */
    private OffsetDateTime ztDate;

    /**
     * 自提地省
     */
    private String ztAddressProv;

    /**
     * 自提地市
     */
    private String ztAddressCity;

    /**
     * 自提地区县
     */
    private String ztAddressCou;

    /**
     * 自提详细地址
     */
    private String ztAddress;

    /**
     * 自提点联系人
     */
    private String ztContactsName;

    /**
     * 自提点联系电话
     */
    private String ztTel;

    /**
     * 自提点营业时间
     */
    private String ztBusinessHours;

    /**
     * 买家删除标记
     */
    private String buyerDelFlag;

    /**
     * 卖家删除标记
     */
    private String sellerDelFlag;

    /**
     * 评价日期
     */
    private OffsetDateTime evalDate;

    /**
     * 延期收货原因
     */
    private String delayReason;

    /**
     * 延期期限
     */
    private Integer delayDate;

    /**
     * 支付渠道
     */
    private String payChannel;

    /**
     * 平台分类
     */
    private String platformType;

    /**
     * 付款截止日期
     */
    private OffsetDateTime payDeadDate;

    /**
     * 确认收货截止日期
     */
    private OffsetDateTime confirmDeadLineDate;

    /**
     * 最晚到货日期
     */
    private OffsetDateTime latestArrivalDate;

    /**
     * 订金金额
     */
    private Double depositAmount;

    /**
     * 尾款金额
     */
    private Double tailAmount;

    /**
     * 尾款支付日期
     */
    private OffsetDateTime tailAmountPayDate;

    /**
     * 账期服务费
     */
    private Double zqSerCost;

    /**
     * 买家备注
     */
    private String buyerRemarks;

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public String getBuyerRemarks() {
		return buyerRemarks;
	}

	public void setBuyerRemarks(String buyerRemarks) {
		this.buyerRemarks = buyerRemarks;
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

    public String getSupplyModeType() {
        return supplyModeType;
    }

    public void setSupplyModeType(String supplyModeType) {
        this.supplyModeType = supplyModeType;
    }

    public String getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(String payMethodType) {
        this.payMethodType = payMethodType;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
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

    public Long getReceAddressId() {
        return receAddressId;
    }

    public void setReceAddressId(Long receAddressId) {
        this.receAddressId = receAddressId;
    }

    public Double getCommTotalPrice() {
        return commTotalPrice;
    }

    public void setCommTotalPrice(Double commTotalPrice) {
        this.commTotalPrice = commTotalPrice;
    }

    public Double getCommTotalFreight() {
        return commTotalFreight;
    }

    public void setCommTotalFreight(Double commTotalFreight) {
        this.commTotalFreight = commTotalFreight;
    }

    public Double getAmountPayable() {
        return amountPayable;
    }

    public void setAmountPayable(Double amountPayable) {
        this.amountPayable = amountPayable;
    }

    public Double getPrefAmount() {
        return prefAmount;
    }

    public void setPrefAmount(Double prefAmount) {
        this.prefAmount = prefAmount;
    }

    public String getYsbzBds() {
        return ysbzBds;
    }

    public void setYsbzBds(String ysbzBds) {
        this.ysbzBds = ysbzBds;
    }

    public Long getInvoId() {
        return invoId;
    }

    public void setInvoId(Long invoId) {
        this.invoId = invoId;
    }

    public String getCommPubType() {
        return commPubType;
    }

    public void setCommPubType(String commPubType) {
        this.commPubType = commPubType;
    }

    public String getDeliveryInfoType() {
        return deliveryInfoType;
    }

    public void setDeliveryInfoType(String deliveryInfoType) {
        this.deliveryInfoType = deliveryInfoType;
    }

    public String getDistribDateType() {
        return distribDateType;
    }

    public void setDistribDateType(String distribDateType) {
        this.distribDateType = distribDateType;
    }

    public Double getPlatfCost() {
        return platfCost;
    }

    public void setPlatfCost(Double platfCost) {
        this.platfCost = platfCost;
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

    public Integer getCommTotalCount() {
        return commTotalCount;
    }

    public void setCommTotalCount(Integer commTotalCount) {
        this.commTotalCount = commTotalCount;
    }

    public Long getOrdCancelReasonId() {
        return ordCancelReasonId;
    }

    public void setOrdCancelReasonId(Long ordCancelReasonId) {
        this.ordCancelReasonId = ordCancelReasonId;
    }

    public OffsetDateTime getOrdCancelDate() {
        return ordCancelDate;
    }

    public void setOrdCancelDate(OffsetDateTime ordCancelDate) {
        this.ordCancelDate = ordCancelDate;
    }

    public Long getLogisticsCompId() {
        return logisticsCompId;
    }

    public void setLogisticsCompId(Long logisticsCompId) {
        this.logisticsCompId = logisticsCompId;
    }

    public String getLogisticsNum() {
        return logisticsNum;
    }

    public void setLogisticsNum(String logisticsNum) {
        this.logisticsNum = logisticsNum;
    }

    public String getOrdSendType() {
        return ordSendType;
    }

    public void setOrdSendType(String ordSendType) {
        this.ordSendType = ordSendType;
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

    public String getZtNum() {
        return ztNum;
    }

    public void setZtNum(String ztNum) {
        this.ztNum = ztNum;
    }

    public String getSelfMentionAddressName() {
        return selfMentionAddressName;
    }

    public void setSelfMentionAddressName(String selfMentionAddressName) {
        this.selfMentionAddressName = selfMentionAddressName;
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

    public String getBuyerDelFlag() {
        return buyerDelFlag;
    }

    public void setBuyerDelFlag(String buyerDelFlag) {
        this.buyerDelFlag = buyerDelFlag;
    }

    public String getSellerDelFlag() {
        return sellerDelFlag;
    }

    public void setSellerDelFlag(String sellerDelFlag) {
        this.sellerDelFlag = sellerDelFlag;
    }

    public OffsetDateTime getEvalDate() {
        return evalDate;
    }

    public void setEvalDate(OffsetDateTime evalDate) {
        this.evalDate = evalDate;
    }

    public String getDelayReason() {
        return delayReason;
    }

    public void setDelayReason(String delayReason) {
        this.delayReason = delayReason;
    }

    public Integer getDelayDate() {
        return delayDate;
    }

    public void setDelayDate(Integer delayDate) {
        this.delayDate = delayDate;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public String getPlatformType() {
        return platformType;
    }

    public void setPlatformType(String platformType) {
        this.platformType = platformType;
    }

    public OffsetDateTime getPayDeadDate() {
        return payDeadDate;
    }

    public void setPayDeadDate(OffsetDateTime payDeadDate) {
        this.payDeadDate = payDeadDate;
    }

    public OffsetDateTime getConfirmDeadLineDate() {
        return confirmDeadLineDate;
    }

    public void setConfirmDeadLineDate(OffsetDateTime confirmDeadLineDate) {
        this.confirmDeadLineDate = confirmDeadLineDate;
    }

    public OffsetDateTime getLatestArrivalDate() {
        return latestArrivalDate;
    }

    public void setLatestArrivalDate(OffsetDateTime latestArrivalDate) {
        this.latestArrivalDate = latestArrivalDate;
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

    public OffsetDateTime getTailAmountPayDate() {
        return tailAmountPayDate;
    }

    public void setTailAmountPayDate(OffsetDateTime tailAmountPayDate) {
        this.tailAmountPayDate = tailAmountPayDate;
    }

    public Double getZqSerCost() {
        return zqSerCost;
    }

    public void setZqSerCost(Double zqSerCost) {
        this.zqSerCost = zqSerCost;
    }
}
