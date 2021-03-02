package com.wisea.cultivar.common.vo.tp.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * OrderInfoListVo
 * 2018/09/18 17:40:35
 */
@ApiModel("买家端订单列表vo")
public class BuyerOrderInfoListVo {

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "订单编号")
    private String ordNum;

    @ApiModelProperty(value = "订单发货类型")
    private String ordSendType;

    @ApiModelProperty(value = "运送人")
    private String sender;

    @ApiModelProperty(value = "运送人联系电话")
    private String senderTel;

    @ApiModelProperty(value = "车船号")
    private String cchNum;

    @ApiModelProperty(value = "买家名称")
    private String buyerName;

    @ApiModelProperty(value = "卖家名称")
    private String sellerName;

    @ApiModelProperty(value = "买家账号")
    private String buyerUserName;

    @ApiModelProperty(value = "运费总金额")
    private Double commTotalFreight;

    @ApiModelProperty(value = "商品总件数")
    private Double commTotalCount;

    @ApiModelProperty(value = "应付款金额（商品发布价+运费）")
    private Double amountPayable;

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
    private OffsetDateTime referOrdDate;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @ApiModelProperty(value = "付款截止日期")
    private OffsetDateTime payDeadDate;

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @ApiModelProperty(value = "定金、订单支付日期")
    private OffsetDateTime payOrdDate;

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
    private List<BuyerOrdCommRela> ordCommRelaList;

    @ApiModelProperty("物流公司")
    private String logisticsCompName;

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

    @ApiModelProperty("自提地省名称")
    private String addressProvName;
    @ApiModelProperty("自提地市名称")
    private String addressCityName;
    @ApiModelProperty("自提地区县名称")
    private String addressCouName;

    @ApiModelProperty("自提详细地址")
    private String ztAddress;

    @ApiModelProperty("自提联系人")
    private String ztContactsName;

    @ApiModelProperty("自提联系电话")
    private String ztTel;

    @ApiModelProperty("自提营业时间")
    private String ztBusinessHours;

    @ApiModelProperty("自提点名称")
    private String selfMentionAddressName;

    @ApiModelProperty("订金金额")
    private Double depositAmount;

    @ApiModelProperty("尾款金额")
    private Double tailAmount;

    @ApiModelProperty("尾款支付日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime tailAmountPayDate;

    public List<BuyerOrdCommRela> getOrdCommRelaList() {
		return ordCommRelaList;
	}

	public void setOrdCommRelaList(List<BuyerOrdCommRela> ordCommRelaList) {
		this.ordCommRelaList = ordCommRelaList;
	}

	public String getAddressProvName() {
		return addressProvName;
	}

	public void setAddressProvName(String addressProvName) {
		this.addressProvName = addressProvName;
	}

	public OffsetDateTime getPayOrdDate() {
		return payOrdDate;
	}

	public void setPayOrdDate(OffsetDateTime payOrdDate) {
		this.payOrdDate = payOrdDate;
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

	public String getSelfMentionAddressName() {
		return selfMentionAddressName;
	}

	public void setSelfMentionAddressName(String selfMentionAddressName) {
		this.selfMentionAddressName = selfMentionAddressName;
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

	public String getOrderCommCount() {
		return orderCommCount;
	}

	public void setOrderCommCount(String orderCommCount) {
		this.orderCommCount = orderCommCount;
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

	public OffsetDateTime getConfirmDeadLineDate() {
		return confirmDeadLineDate;
	}

	public void setConfirmDeadLineDate(OffsetDateTime confirmDeadLineDate) {
		this.confirmDeadLineDate = confirmDeadLineDate;
	}

	public String getLeftTime() {
		return leftTime;
	}

	public void setLeftTime(String leftTime) {
		this.leftTime = leftTime;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public Double getCommTotalCount() {
		return commTotalCount;
	}

	public void setCommTotalCount(Double commTotalCount) {
		this.commTotalCount = commTotalCount;
	}

	public OffsetDateTime getNowDate() {
		return nowDate;
	}

	public String getReCommFlag() {
		return reCommFlag;
	}

	public void setReCommFlag(String reCommFlag) {
		this.reCommFlag = reCommFlag;
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

	/**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取订单编号
     */
    public String getOrdNum() {
        return ordNum;
    }

    /**
     * 设置订单编号
     */
    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum == null ? null : ordNum.trim();
    }


    /**
     * 获取运费总金额
     */
    public Double getCommTotalFreight() {
        return commTotalFreight;
    }

    /**
     * 设置运费总金额
     */
    public void setCommTotalFreight(Double commTotalFreight) {
        this.commTotalFreight = commTotalFreight;
    }

    /**
     * 获取应付款金额（商品发布价+运费）
     */
    public Double getAmountPayable() {
        return amountPayable;
    }

    /**
     * 设置应付款金额（商品发布价+运费）
     */
    public void setAmountPayable(Double amountPayable) {
        this.amountPayable = amountPayable;
    }

    /**
     * 获取订单状态类型
     */
    public String getOrderStateType() {
        return orderStateType;
    }

    /**
     * 设置订单状态类型
     */
    public void setOrderStateType(String orderStateType) {
        this.orderStateType = orderStateType == null ? null : orderStateType.trim();
    }

    /**
     * 获取买方ID
     */
    public Long getBuyerId() {
        return buyerId;
    }

    /**
     * 设置买方ID
     */
    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    /**
     * 获取卖方ID
     */
    public Long getSellerId() {
        return sellerId;
    }

    /**
     * 设置卖方ID
     */
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * 获取提交订单日期
     */
    public OffsetDateTime getReferOrdDate() {
        return referOrdDate;
    }

    /**
     * 设置提交订单日期
     */
    public void setReferOrdDate(OffsetDateTime referOrdDate) {
        this.referOrdDate = referOrdDate;
    }

    /**
     * 获取付款截止日期
     */
    public OffsetDateTime getPayDeadDate() {
        return payDeadDate;
    }

    /**
     * 设置付款截止日期
     */
    public void setPayDeadDate(OffsetDateTime payDeadDate) {
        this.payDeadDate = payDeadDate;
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
}
