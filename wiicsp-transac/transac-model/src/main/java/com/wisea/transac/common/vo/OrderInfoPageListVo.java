package com.wisea.transac.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("分页查询Vo")
public class OrderInfoPageListVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="订单编号")
    private String ordNum;

    @ApiModelProperty(value="买方ID")
    private Long buyerId;

    @ApiModelProperty(value="采购员id")
    private Long purchaseId;

    @ApiModelProperty(value="卖方ID")
    private Long sellerId;

    @ApiModelProperty(value="提货人姓名(采购员)")
    private String consigneeName;

    @ApiModelProperty(value="提货人手机号(采购员)")
    private String consigneeTel;

    @ApiModelProperty(value="档口id")
    private Long stallsId;

    @ApiModelProperty(value="自提码")
    private String ztNum;

    @ApiModelProperty(value="自提地址名称（档口名称）")
    private String selfMentionAddressName;

    @ApiModelProperty(value="自提开始时间")
    private OffsetDateTime ztStartDate;

    @ApiModelProperty(value="自提结束时间")
    private OffsetDateTime ztEndDate;

    @ApiModelProperty(value="自提地省")
    private String ztAddressProv;

    @ApiModelProperty(value="自提地市")
    private String ztAddressCity;

    @ApiModelProperty(value="自提地区县")
    private String ztAddressCou;

    @ApiModelProperty(value="自提详细地址")
    private String ztAddress;

    @ApiModelProperty(value="自提点营业时间")
    private String ztBusinessHours;

    @ApiModelProperty(value="自提点联系人")
    private String ztContactsName;

    @ApiModelProperty(value="自提点联系电话")
    private String ztTel;

    @ApiModelProperty(value="商品总金额(商品发布价格)")
    private Double commTotalPrice;

    @ApiModelProperty(value="订单状态类型")
    private String orderStateType;

    @ApiModelProperty(value="提交订单日期")
    private OffsetDateTime referOrdDate;

    @ApiModelProperty(value="卖方确定日期")
    private OffsetDateTime buyerSureDate;

    @ApiModelProperty(value="支付订单日期")
    private OffsetDateTime payOrdDate;

    @ApiModelProperty(value="商品总件数")
    private Integer commTotalCount;

    @ApiModelProperty(value="订单取消原因id")
    private Long ordCancelReasonId;

    @ApiModelProperty(value="订单取消时间")
    private OffsetDateTime ordCancelDate;

    @ApiModelProperty(value="订单备注")
    private String ordRemarks;

    @ApiModelProperty(value="支付方式（在线支付、账期支付）")
    private String payMethodType;

    @ApiModelProperty(value="自提完成日期")
    private OffsetDateTime ztCompleteDate;

    @ApiModelProperty(value="应付金额")
    private Double payableAmount;

    @ApiModelProperty(value="账期服务费金额")
    private Double zqSerCost;

    @ApiModelProperty(value="平台服务费")
    private Double platfCost;

    @ApiModelProperty(value="结算单生成状态")
    private String settleBillGenerateType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
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

    public Long getStallsId() {
        return stallsId;
    }

    public void setStallsId(Long stallsId) {
        this.stallsId = stallsId;
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

    public String getZtBusinessHours() {
        return ztBusinessHours;
    }

    public void setZtBusinessHours(String ztBusinessHours) {
        this.ztBusinessHours = ztBusinessHours;
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

    public Double getCommTotalPrice() {
        return commTotalPrice;
    }

    public void setCommTotalPrice(Double commTotalPrice) {
        this.commTotalPrice = commTotalPrice;
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

    public String getOrdRemarks() {
        return ordRemarks;
    }

    public void setOrdRemarks(String ordRemarks) {
        this.ordRemarks = ordRemarks;
    }

    public String getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(String payMethodType) {
        this.payMethodType = payMethodType;
    }

    public OffsetDateTime getZtCompleteDate() {
        return ztCompleteDate;
    }

    public void setZtCompleteDate(OffsetDateTime ztCompleteDate) {
        this.ztCompleteDate = ztCompleteDate;
    }

    public Double getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(Double payableAmount) {
        this.payableAmount = payableAmount;
    }

    public Double getZqSerCost() {
        return zqSerCost;
    }

    public void setZqSerCost(Double zqSerCost) {
        this.zqSerCost = zqSerCost;
    }

    public Double getPlatfCost() {
        return platfCost;
    }

    public void setPlatfCost(Double platfCost) {
        this.platfCost = platfCost;
    }

    public String getSettleBillGenerateType() {
        return settleBillGenerateType;
    }

    public void setSettleBillGenerateType(String settleBillGenerateType) {
        this.settleBillGenerateType = settleBillGenerateType;
    }
}
