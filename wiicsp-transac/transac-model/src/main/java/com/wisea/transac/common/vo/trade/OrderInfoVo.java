package com.wisea.transac.common.vo.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

/**
 * 订单详情Vo
 */
@ApiModel("订单详情Vo")
public class OrderInfoVo {
    /***** 订单信息 *****/
    @ApiModelProperty("订单ID")
    private Long id;
    @ApiModelProperty("档口ID")
    private Long stallsId;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "基地ID")
    private String baseId;
    @ApiModelProperty("订单编号")
    private String ordNum;
    @ApiModelProperty("订单状态")
    private String orderStateType;
    @ApiModelProperty("支付方式")
    private String payMethodType;
    @ApiModelProperty("买家ID")
    private Long buyerId;
    @ApiModelProperty("买家账号")
    private String buyerAccount;
    @ApiModelProperty("买家名称")
    private String buyerName;
    @ApiModelProperty("采购员id")
    private Long purchaseId;
    @ApiModelProperty("买家账号（采购员）")
    private String purchaseAccount;
    @ApiModelProperty("买家手机号（采购员）")
    private String purchaseRegistTel;
    @ApiModelProperty("买家姓名（采购员）")
    private String purchaseStaffName;
    @ApiModelProperty("认证主体名称")
    private String authZtName;
    @ApiModelProperty("卖家ID")
    private Long sellerId;
    @ApiModelProperty("商家账号")
    private String sellerAccount;
    @ApiModelProperty("商家名称")
    private String sellerName;
    @ApiModelProperty("商品总金额")
    private Double commTotalPrice;
    @ApiModelProperty("应付金额")
    private Double payableAmount;
    @ApiModelProperty("平台服务费")
    private Double platfCost;
    @ApiModelProperty("账期服务费")
    private Double zqSerCost;
    @ApiModelProperty("商家应收金额")
    private Double sellerReceivableAmount;
    @ApiModelProperty("提交订单日期")
    private OffsetDateTime referOrdDate;
    @ApiModelProperty("卖方确定日期")
    private OffsetDateTime sellerSureDate;
    @ApiModelProperty("支付订单日期")
    private OffsetDateTime payOrdDate;
    @ApiModelProperty("当前时间（用于和各截止时间计算剩余时间）")
    private OffsetDateTime nowDateTime;
    @ApiModelProperty("卖家确认截止时间")
    private OffsetDateTime sellerConfirmClosingDate;
    @ApiModelProperty("买家支付截止时间")
    private OffsetDateTime buyPayClosingDate;
    @ApiModelProperty("买家提货截止时间")
    private OffsetDateTime ztClosingDate;
    @ApiModelProperty("订单取消时间")
    private OffsetDateTime ordCancelDate;
    @ApiModelProperty("取消原因")
    private String ordCancelReason;
    @ApiModelProperty("退款ID")
    private Long refundApplId;
    @ApiModelProperty("退款申请状态")
    private String refundApplStateType;
    @ApiModelProperty("退款单号")
    private String refundNum;
    @ApiModelProperty("付款后自提截止天数")
    private Integer ztDeadDay;
    @ApiModelProperty("退款金额")
    private Double refundAmount;
    @ApiModelProperty("配送方式类型")
    private String sendZtType;
    @ApiModelProperty("物流公司名称")
    private String logisticsCompName;
    @ApiModelProperty("物流公司代码")
    private String logisticsCompCode;
    @ApiModelProperty("物流单号")
    private String logisticsNum;
    @ApiModelProperty("物流公司电话")
    private String logisticsTel;

    /***** 提货信息 *****/
    @ApiModelProperty("提货人姓名(采购员)")
    private String consigneeName;
    @ApiModelProperty("提货人手机号(采购员)")
    private String consigneeTel;
    @ApiModelProperty("自提码")
    private String ztNum;
    @ApiModelProperty("自提二维码")
    private String ztUrl;
    @ApiModelProperty("提货地址类型")
    private String ztAddressType;
    @ApiModelProperty("所属档口")
    private String selfMentionAddressName;
    @ApiModelProperty("档口所在地省Code")
    private String ztAddressProvCode;
    @ApiModelProperty("档口所在地市Code")
    private String ztAddressCityCode;
    @ApiModelProperty("档口所在地区县Code")
    private String ztAddressCouCode;
    @ApiModelProperty("档口所在地省")
    private String ztAddressProv;
    @ApiModelProperty("档口所在地市")
    private String ztAddressCity;
    @ApiModelProperty("档口所在地区县")
    private String ztAddressCou;
    @ApiModelProperty("档口所在地详细地址")
    private String stallsAddress;
    @ApiModelProperty("买卖双方商量提货地址")
    private String ztAddress;
    @ApiModelProperty("自提联系人")
    private String ztContactsName;
    @ApiModelProperty("自提联系电话")
    private String ztTel;
    @ApiModelProperty("自提点营业时间")
    private String ztBusinessHours;
    @ApiModelProperty("自提开始时间")
    private OffsetDateTime ztStartDate;
    @ApiModelProperty("自提结束时间")
    private OffsetDateTime ztEndDate;
    @ApiModelProperty("自提完成日期")
    private OffsetDateTime ztCompleteDate;
    @ApiModelProperty("订单备注")
    private String ordRemarks;
    /***** 发票信息 *****/
    @ApiModelProperty("订单发票信息")
    private OrdInvoVo ordInvo;
    /***** 订单商品信息 *****/
    @ApiModelProperty("订单商品列表")
    private List<OrdCommRelaVo> ordCommRelas;
    /***** 操作记录 *****/
    @ApiModelProperty("订单操作记录列表")
    private List<OpreateInfoVo> ordOpreateInfos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogisticsNum() {
        return logisticsNum;
    }

    public void setLogisticsNum(String logisticsNum) {
        this.logisticsNum = logisticsNum;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getSendZtType() {
        return sendZtType;
    }

    public void setSendZtType(String sendZtType) {
        this.sendZtType = sendZtType;
    }

    public String getBaseId() {
        return baseId;
    }

    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }

    public String getZtUrl() {
        return ztUrl;
    }

    public void setZtUrl(String ztUrl) {
        this.ztUrl = ztUrl;
    }

    public Integer getZtDeadDay() {
        return ztDeadDay;
    }

    public void setZtDeadDay(Integer ztDeadDay) {
        this.ztDeadDay = ztDeadDay;
    }

    public String getLogisticsTel() {
        return logisticsTel;
    }

    public void setLogisticsTel(String logisticsTel) {
        this.logisticsTel = logisticsTel;
    }

    public String getLogisticsCompName() {
        return logisticsCompName;
    }

    public void setLogisticsCompName(String logisticsCompName) {
        this.logisticsCompName = logisticsCompName;
    }

    public String getLogisticsCompCode() {
        return logisticsCompCode;
    }

    public void setLogisticsCompCode(String logisticsCompCode) {
        this.logisticsCompCode = logisticsCompCode;
    }

    public OffsetDateTime getZtCompleteDate() {
        return ztCompleteDate;
    }

    public void setZtCompleteDate(OffsetDateTime ztCompleteDate) {
        this.ztCompleteDate = ztCompleteDate;
    }

    public String getRefundApplStateType() {
        return refundApplStateType;
    }

    public String getRefundNum() {
        return refundNum;
    }

    public void setRefundNum(String refundNum) {
        this.refundNum = refundNum;
    }

    public void setRefundApplStateType(String refundApplStateType) {
        this.refundApplStateType = refundApplStateType;
    }

    public Long getStallsId() {
        return stallsId;
    }

    public void setStallsId(Long stallsId) {
        this.stallsId = stallsId;
    }

    public OffsetDateTime getOrdCancelDate() {
        return ordCancelDate;
    }

    public void setOrdCancelDate(OffsetDateTime ordCancelDate) {
        this.ordCancelDate = ordCancelDate;
    }

    public String getOrdCancelReason() {
        return ordCancelReason;
    }

    public void setOrdCancelReason(String ordCancelReason) {
        this.ordCancelReason = ordCancelReason;
    }

    public Long getRefundApplId() {
        return refundApplId;
    }

    public void setRefundApplId(Long refundApplId) {
        this.refundApplId = refundApplId;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public String getOrderStateType() {
        return orderStateType;
    }

    public void setOrderStateType(String orderStateType) {
        this.orderStateType = orderStateType;
    }

    public String getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(String payMethodType) {
        this.payMethodType = payMethodType;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
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

    public String getZtNum() {
        return ztNum;
    }

    public void setZtNum(String ztNum) {
        this.ztNum = ztNum;
    }

    public String getBuyerAccount() {
        return buyerAccount;
    }

    public void setBuyerAccount(String buyerAccount) {
        this.buyerAccount = buyerAccount;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getPurchaseAccount() {
        return purchaseAccount;
    }

    public void setPurchaseAccount(String purchaseAccount) {
        this.purchaseAccount = purchaseAccount;
    }

    public String getPurchaseRegistTel() {
        return purchaseRegistTel;
    }

    public void setPurchaseRegistTel(String purchaseRegistTel) {
        this.purchaseRegistTel = purchaseRegistTel;
    }

    public String getPurchaseStaffName() {
        return purchaseStaffName;
    }

    public void setPurchaseStaffName(String purchaseStaffName) {
        this.purchaseStaffName = purchaseStaffName;
    }

    public String getAuthZtName() {
        return authZtName;
    }

    public void setAuthZtName(String authZtName) {
        this.authZtName = authZtName;
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

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Double getCommTotalPrice() {
        return commTotalPrice;
    }

    public void setCommTotalPrice(Double commTotalPrice) {
        this.commTotalPrice = commTotalPrice;
    }

    public Double getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(Double payableAmount) {
        this.payableAmount = payableAmount;
    }

    public Double getPlatfCost() {
        return platfCost;
    }

    public void setPlatfCost(Double platfCost) {
        this.platfCost = platfCost;
    }

    public Double getZqSerCost() {
        return zqSerCost;
    }

    public void setZqSerCost(Double zqSerCost) {
        this.zqSerCost = zqSerCost;
    }

    public Double getSellerReceivableAmount() {
        return sellerReceivableAmount;
    }

    public void setSellerReceivableAmount(Double sellerReceivableAmount) {
        this.sellerReceivableAmount = sellerReceivableAmount;
    }

    public OffsetDateTime getReferOrdDate() {
        return referOrdDate;
    }

    public void setReferOrdDate(OffsetDateTime referOrdDate) {
        this.referOrdDate = referOrdDate;
    }

    public OffsetDateTime getSellerSureDate() {
        return sellerSureDate;
    }

    public void setSellerSureDate(OffsetDateTime sellerSureDate) {
        this.sellerSureDate = sellerSureDate;
    }

    public OffsetDateTime getPayOrdDate() {
        return payOrdDate;
    }

    public void setPayOrdDate(OffsetDateTime payOrdDate) {
        this.payOrdDate = payOrdDate;
    }

    public OffsetDateTime getNowDateTime() {
        return nowDateTime;
    }

    public void setNowDateTime(OffsetDateTime nowDateTime) {
        this.nowDateTime = nowDateTime;
    }

    public OffsetDateTime getSellerConfirmClosingDate() {
        return sellerConfirmClosingDate;
    }

    public void setSellerConfirmClosingDate(OffsetDateTime sellerConfirmClosingDate) {
        this.sellerConfirmClosingDate = sellerConfirmClosingDate;
    }

    public OffsetDateTime getBuyPayClosingDate() {
        return buyPayClosingDate;
    }

    public void setBuyPayClosingDate(OffsetDateTime buyPayClosingDate) {
        this.buyPayClosingDate = buyPayClosingDate;
    }

    public OffsetDateTime getZtClosingDate() {
        return ztClosingDate;
    }

    public void setZtClosingDate(OffsetDateTime ztClosingDate) {
        this.ztClosingDate = ztClosingDate;
    }

    public String getZtAddressType() {
        return ztAddressType;
    }

    public void setZtAddressType(String ztAddressType) {
        this.ztAddressType = ztAddressType;
    }

    public String getSelfMentionAddressName() {
        return selfMentionAddressName;
    }

    public void setSelfMentionAddressName(String selfMentionAddressName) {
        this.selfMentionAddressName = selfMentionAddressName;
    }

    public String getZtAddressProvCode() {
        return ztAddressProvCode;
    }

    public void setZtAddressProvCode(String ztAddressProvCode) {
        this.ztAddressProvCode = ztAddressProvCode;
    }

    public String getZtAddressCityCode() {
        return ztAddressCityCode;
    }

    public void setZtAddressCityCode(String ztAddressCityCode) {
        this.ztAddressCityCode = ztAddressCityCode;
    }

    public String getZtAddressCouCode() {
        return ztAddressCouCode;
    }

    public void setZtAddressCouCode(String ztAddressCouCode) {
        this.ztAddressCouCode = ztAddressCouCode;
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

    public String getStallsAddress() {
        return stallsAddress;
    }

    public void setStallsAddress(String stallsAddress) {
        this.stallsAddress = stallsAddress;
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

    public OffsetDateTime getZtStartDate() {
        return ztStartDate;
    }

    public void setZtStartDate(OffsetDateTime ztStartDate) {
        this.ztStartDate = ztStartDate;
    }

    public OffsetDateTime getZtEndDate() {
        return ztEndDate;
    }

    public void setZtEndDate(OffsetDateTime ztEndDate) {
        this.ztEndDate = ztEndDate;
    }

    public String getOrdRemarks() {
        return ordRemarks;
    }

    public void setOrdRemarks(String ordRemarks) {
        this.ordRemarks = ordRemarks;
    }

    public OrdInvoVo getOrdInvo() {
        return ordInvo;
    }

    public void setOrdInvo(OrdInvoVo ordInvo) {
        this.ordInvo = ordInvo;
    }

    public List<OrdCommRelaVo> getOrdCommRelas() {
        return ordCommRelas;
    }

    public void setOrdCommRelas(List<OrdCommRelaVo> ordCommRelas) {
        this.ordCommRelas = ordCommRelas;
    }

    public List<OpreateInfoVo> getOrdOpreateInfos() {
        return ordOpreateInfos;
    }

    public void setOrdOpreateInfos(List<OpreateInfoVo> ordOpreateInfos) {
        this.ordOpreateInfos = ordOpreateInfos;
    }
}
