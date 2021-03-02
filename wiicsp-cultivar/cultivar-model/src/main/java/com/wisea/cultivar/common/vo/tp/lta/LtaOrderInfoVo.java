package com.wisea.cultivar.common.vo.tp.lta;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cultivar.common.vo.tp.trade.BuyerRefundApplInfoVo;
import com.wisea.cultivar.common.vo.tp.trade.OrdInvoVo;
import com.wisea.cultivar.common.vo.tp.trade.OrdOpreateInfoVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className LtaOrderInfoVo
 * @date 2019/5/8 10:06
 * @Description 长期协议订单详细信息Vo
 */
@ApiModel("长期协议订单详细信息Vo")
public class LtaOrderInfoVo {
    @ApiModelProperty("订单ID")
    private Long id;
    @ApiModelProperty("订单状态")
    private String orderStateType;
    @ApiModelProperty("提交订单日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime buyerOrdDate;
    @ApiModelProperty("卖家确认日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime sellerConfirmOrdDate;
    @ApiModelProperty("买方支付日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime buyerPayDate;
    @ApiModelProperty("商家发货日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime sellerSendDate;
    @ApiModelProperty("确认收货日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime confirmDate;
    @ApiModelProperty("确认收货截止日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime confirmDeadLineDate;
    @ApiModelProperty("订单完成日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime ordCompleteDate;
    @ApiModelProperty("订单取消日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime ordCancelDate;
    @ApiModelProperty("订单取消原因")
    private String ordCancelName;
    @ApiModelProperty("最晚到货日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime latestArrivalDate;
    @ApiModelProperty("合同编号")
    private String ltaContNumb;
    @ApiModelProperty("订单编号")
    private String ltaOrdNumb;

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
    @ApiModelProperty("订单来源")
    private String sourceType;
    @ApiModelProperty("配送信息类型")
    private String deliveryInfoType;
    @ApiModelProperty("支付方式")
    private String payMethodType;

    /**订单发票信息**/
    @ApiModelProperty("订单发票信息")
    private OrdInvoVo ordInvo;

    /**商家配送-商家送货字段**/
    @ApiModelProperty("订单发货类型")
    private String ordSendType;
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
    @ApiModelProperty("提货人姓名")
    private String consigneeName;
    @ApiModelProperty("提货人手机号")
    private String consigneeTel;
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
    @ApiModelProperty("自提点名称")
    private String ztName;
    @ApiModelProperty("自提营业时间")
    private String ztBusinessHours;
    @ApiModelProperty("自提码")
    private String ztNum;

    /***订单收货地址信息***/
    @ApiModelProperty("收货人姓名")
    private String receName;
    @ApiModelProperty("手机号码")
    private String tel;
    @ApiModelProperty("邮政编码")
    private String zipCode;
    @ApiModelProperty("收货地址省份编码")
    private String receAddressProvCode;
    @ApiModelProperty("收货地址市编码")
    private String receAddressCityCode;
    @ApiModelProperty("收货地址区县编码")
    private String receAddressCouCode;
    @ApiModelProperty("收货地址省份")
    private String receAddressProv;
    @ApiModelProperty("收货地址市")
    private String receAddressCity;
    @ApiModelProperty("收货地址区县")
    private String receAddressCou;
    @ApiModelProperty("收货地址街道")
    private String receAddressStreet;
    @ApiModelProperty("详细地址")
    private String receAddressDetail;

    @ApiModelProperty("订单商品列表")
    private List<LtaOrdCommRelaVo> orderCommRelas;

    @ApiModelProperty("商品发布价总金额")
    private Double commAmount;
    @ApiModelProperty("运费")
    private Double freight;
    @ApiModelProperty("订单总金额")
    private Double yfAmount;
    @ApiModelProperty("总件数")
    private int commTotalCount;
    @ApiModelProperty("商品结算价总金额")
    private Double commSettlePrice;
    @ApiModelProperty("商家结算金额")
    private Double sellerSettleAmount;
    @ApiModelProperty("服务费")
    private Double platfCost;

    @ApiModelProperty("订单操作记录列表")
    private List<OrdOpreateInfoVo> ordOpreateInfos;

    /********************************************/
    @ApiModelProperty("付款截止日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime payDeadDate;
    @ApiModelProperty("当前系统日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
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

    public String getZtName() {
		return ztName;
	}

	public void setZtName(String ztName) {
		this.ztName = ztName;
	}

	public String getZtNum() {
		return ztNum;
	}

	public void setZtNum(String ztNum) {
		this.ztNum = ztNum;
	}

	public int getCommTotalCount() {
		return commTotalCount;
	}

	public void setCommTotalCount(int commTotalCount) {
		this.commTotalCount = commTotalCount;
	}

	public String getOrderStateType() {
        return orderStateType;
    }

    public void setOrderStateType(String orderStateType) {
        this.orderStateType = orderStateType;
    }

    public OffsetDateTime getBuyerOrdDate() {
        return buyerOrdDate;
    }

    public void setBuyerOrdDate(OffsetDateTime buyerOrdDate) {
        this.buyerOrdDate = buyerOrdDate;
    }

    public OffsetDateTime getSellerConfirmOrdDate() {
        return sellerConfirmOrdDate;
    }

    public void setSellerConfirmOrdDate(OffsetDateTime sellerConfirmOrdDate) {
        this.sellerConfirmOrdDate = sellerConfirmOrdDate;
    }

    public OffsetDateTime getBuyerPayDate() {
        return buyerPayDate;
    }

    public void setBuyerPayDate(OffsetDateTime buyerPayDate) {
        this.buyerPayDate = buyerPayDate;
    }


	public OffsetDateTime getSellerSendDate() {
        return sellerSendDate;
    }

    public void setSellerSendDate(OffsetDateTime sellerSendDate) {
        this.sellerSendDate = sellerSendDate;
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

    public OffsetDateTime getOrdCompleteDate() {
        return ordCompleteDate;
    }

    public void setOrdCompleteDate(OffsetDateTime ordCompleteDate) {
        this.ordCompleteDate = ordCompleteDate;
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

    public OffsetDateTime getLatestArrivalDate() {
        return latestArrivalDate;
    }

    public void setLatestArrivalDate(OffsetDateTime latestArrivalDate) {
        this.latestArrivalDate = latestArrivalDate;
    }

    public String getLtaContNumb() {
        return ltaContNumb;
    }

    public void setLtaContNumb(String ltaContNumb) {
        this.ltaContNumb = ltaContNumb;
    }

    public String getLtaOrdNumb() {
        return ltaOrdNumb;
    }

    public void setLtaOrdNumb(String ltaOrdNumb) {
        this.ltaOrdNumb = ltaOrdNumb;
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

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getDeliveryInfoType() {
        return deliveryInfoType;
    }

    public void setDeliveryInfoType(String deliveryInfoType) {
        this.deliveryInfoType = deliveryInfoType;
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

    public String getReceAddressProvCode() {
        return receAddressProvCode;
    }

    public void setReceAddressProvCode(String receAddressProvCode) {
        this.receAddressProvCode = receAddressProvCode;
    }

    public String getReceAddressCityCode() {
        return receAddressCityCode;
    }

    public void setReceAddressCityCode(String receAddressCityCode) {
        this.receAddressCityCode = receAddressCityCode;
    }

    public String getReceAddressCouCode() {
        return receAddressCouCode;
    }

    public void setReceAddressCouCode(String receAddressCouCode) {
        this.receAddressCouCode = receAddressCouCode;
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

    public String getReceAddressDetail() {
        return receAddressDetail;
    }

    public void setReceAddressDetail(String receAddressDetail) {
        this.receAddressDetail = receAddressDetail;
    }

    public List<LtaOrdCommRelaVo> getOrderCommRelas() {
        return orderCommRelas;
    }

    public void setOrderCommRelas(List<LtaOrdCommRelaVo> orderCommRelas) {
        this.orderCommRelas = orderCommRelas;
    }

    public Double getCommAmount() {
        return commAmount;
    }

    public void setCommAmount(Double commAmount) {
        this.commAmount = commAmount;
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

    public Double getCommSettlePrice() {
        return commSettlePrice;
    }

    public void setCommSettlePrice(Double commSettlePrice) {
        this.commSettlePrice = commSettlePrice;
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

    public List<OrdOpreateInfoVo> getOrdOpreateInfos() {
        return ordOpreateInfos;
    }

    public void setOrdOpreateInfos(List<OrdOpreateInfoVo> ordOpreateInfos) {
        this.ordOpreateInfos = ordOpreateInfos;
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
