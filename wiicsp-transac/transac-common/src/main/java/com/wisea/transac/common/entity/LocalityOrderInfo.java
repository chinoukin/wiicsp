package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class LocalityOrderInfo extends DataLongEntity<LocalityOrderInfo> {
    /**
     * 订单编号
     */
    private String ordNum;

    /**
     * 买方ID
     */
    private Long buyerId;

    /**
     * 采购员id
     */
    private Long purchaseId;

    /**
     * 卖方ID
     */
    private Long sellerId;

    /**
     * 下单人姓名
     */
    private String consigneeName;

    /**
     * 下单人手机号
     */
    private String consigneeTel;

    /**
     * 基地地址
     */
    private String selfMentionAddressName;

    /**
     * 交货开始时间
     */
    private OffsetDateTime ztStartDate;

    /**
     * 交货结束时间
     */
    private OffsetDateTime ztEndDate;

    /**
     * 交货地省
     */
    private String ztAddressProv;

    /**
     * 交货地市
     */
    private String ztAddressCity;

    /**
     * 交货地区县
     */
    private String ztAddressCou;

    /**
     * 交货详细地址
     */
    private String ztAddress;

    /**
     * 交货点联系人
     */
    private String ztContactsName;

    /**
     * 交货点联系电话
     */
    private String ztTel;

    /**
     * 商品总金额(商品发布价格)
     */
    private Double commTotalPrice;

    /**
     * 产地订单状态类型
     */
    private String baseOrderStateType;

    /**
     * 提交订单日期
     */
    private OffsetDateTime referOrdDate;

    /**
     * 卖方确定日期
     */
    private OffsetDateTime sellerSureDate;

    /**
     * 支付订单日期
     */
    private OffsetDateTime payOrdDate;

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
     * 订单备注
     */
    private String ordRemarks;

    /**
     * 支付方式（在线支付、账期支付）
     */
    private String payMethodType;

    /**
     * 自提完成日期
     */
    private OffsetDateTime ztCompleteDate;

    /**
     * 应付金额
     */
    private Double payableAmount;

    /**
     * 账期服务费金额
     */
    private Double zqSerCost;

    /**
     * 平台服务费
     */
    private Double platfCost;

    /**
     * 结算单生成状态
     */
    private String settleBillGenerateType;

    /**
     * 认证主体名称
     */
    private String authZtName;

    /**
     * 采购员工名称
     */
    private String purchaseStaffName;

    /**
     * 卖家确认订单截止日期
     */
    private OffsetDateTime sellerConfirmClosingDate;

    /**
     * 买家付款截止日期
     */
    private OffsetDateTime buyPayClosingDate;

    /**
     * 提货地址类型
     */
    private String ztAddressType;

    /**
     * 基地详细地址
     */
    private String stallsAddress;

    /**
     * 基地id
     */
    private Long baseId;

    /**
     * 自提码
     */
    private String ztNum;

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public String getZtNum() {
        return ztNum;
    }

    public void setZtNum(String ztNum) {
        this.ztNum = ztNum;
    }

    public Long getBaseId() {
        return baseId;
    }

    public void setBaseId(Long baseId) {
        this.baseId = baseId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getZtAddressType() {
        return ztAddressType;
    }

    public void setZtAddressType(String ztAddressType) {
        this.ztAddressType = ztAddressType;
    }

    public String getStallsAddress() {
        return stallsAddress;
    }

    public void setStallsAddress(String stallsAddress) {
        this.stallsAddress = stallsAddress;
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

    public String getBaseOrderStateType() {
        return baseOrderStateType;
    }

    public void setBaseOrderStateType(String baseOrderStateType) {
        this.baseOrderStateType = baseOrderStateType;
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

    public String getAuthZtName() {
        return authZtName;
    }

    public void setAuthZtName(String authZtName) {
        this.authZtName = authZtName;
    }

    public String getPurchaseStaffName() {
        return purchaseStaffName;
    }

    public void setPurchaseStaffName(String purchaseStaffName) {
        this.purchaseStaffName = purchaseStaffName;
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
}
