package com.wisea.transac.common.vo.trade;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BuyerRefundListVo
 * 2020/05/15 14:40:35
 */
@ApiModel("买家端服务单列表vo")
public class BuyerRefundListVo {

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "订单ID")
    private Long ordId;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "采购员ID")
    private Long purchaseId;
    @ApiModelProperty(value = "服务单编号")
    private String refundNum;
    @ApiModelProperty(value = "退款申请状态类型")
    private String refundApplStateType;
    @ApiModelProperty(value = "订单编号")
    private String ordNum;
    @ApiModelProperty(value = "退款金额")
    private Double refundAmount;
    @ApiModelProperty(value = "申请时间")
    private OffsetDateTime applDate;
    @ApiModelProperty(value = "提货地址类型")
    private String ztAddressType;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "档口ID")
    private String stallsId;
    @ApiModelProperty(value = "自提地址名称（档口名称）")
    private String selfMentionAddressName;
    @ApiModelProperty(value = "提货地址")
    private String ztAddress;
    @ApiModelProperty(value = "自提地市")
    private String city;
    @ApiModelProperty(value = "自提地区县")
    private String cou;
    @ApiModelProperty(value = "自提地省")
    private String prov;
    @ApiModelProperty(value = "自提点营业时间")
    private String ztBusinessHours;
    @ApiModelProperty(value = "自提点联系人")
    private String ztContactsName;
    @ApiModelProperty(value = "自提点联系电话")
    private String ztTel;
    @ApiModelProperty(value = "自提完成日期")
    private String ztCompleteDate;
    @ApiModelProperty(value = "自提开始时间")
    private String ztStartDate;
    @ApiModelProperty(value = "自提结束时间")
    private String ztEndDate;
    @ApiModelProperty(value = "档口详细地址")
    private String stallsAddress;
    @ApiModelProperty(value = "采购员名称(这个为空则表示当前用户就是下单人)")
    private String purchaseStaffName;
    @ApiModelProperty(value = "采购员电话")
    private String consigneeTel;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商家ID")
    private Long sellerId;
    @ApiModelProperty(value = "商家名称")
    private String entpName;
    @ApiModelProperty(value = "退款商品列表")
    private List<BuyerRefundCommRelaVo> buyerRefundCommRelaList;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrdId() {
        return ordId;
    }
    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }
    public String getRefundApplStateType() {
        return refundApplStateType;
    }
    public void setRefundApplStateType(String refundApplStateType) {
        this.refundApplStateType = refundApplStateType;
    }
    public List<BuyerRefundCommRelaVo> getBuyerRefundCommRelaList() {
        return buyerRefundCommRelaList;
    }
    public void setBuyerRefundCommRelaList(List<BuyerRefundCommRelaVo> buyerRefundCommRelaList) {
        this.buyerRefundCommRelaList = buyerRefundCommRelaList;
    }
    public Long getPurchaseId() {
        return purchaseId;
    }
    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }
    public String getRefundNum() {
        return refundNum;
    }
    public void setRefundNum(String refundNum) {
        this.refundNum = refundNum;
    }
    public String getOrdNum() {
        return ordNum;
    }
    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }
    public Double getRefundAmount() {
        return refundAmount;
    }
    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }
    public OffsetDateTime getApplDate() {
        return applDate;
    }
    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
    }
    public String getZtAddressType() {
        return ztAddressType;
    }
    public void setZtAddressType(String ztAddressType) {
        this.ztAddressType = ztAddressType;
    }
    public String getStallsId() {
        return stallsId;
    }
    public void setStallsId(String stallsId) {
        this.stallsId = stallsId;
    }
    public String getSelfMentionAddressName() {
        return selfMentionAddressName;
    }
    public void setSelfMentionAddressName(String selfMentionAddressName) {
        this.selfMentionAddressName = selfMentionAddressName;
    }
    public String getZtAddress() {
        return ztAddress;
    }
    public void setZtAddress(String ztAddress) {
        this.ztAddress = ztAddress;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCou() {
        return cou;
    }
    public void setCou(String cou) {
        this.cou = cou;
    }
    public String getProv() {
        return prov;
    }
    public void setProv(String prov) {
        this.prov = prov;
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
    public String getZtCompleteDate() {
        return ztCompleteDate;
    }
    public void setZtCompleteDate(String ztCompleteDate) {
        this.ztCompleteDate = ztCompleteDate;
    }
    public String getZtStartDate() {
        return ztStartDate;
    }
    public void setZtStartDate(String ztStartDate) {
        this.ztStartDate = ztStartDate;
    }
    public String getZtEndDate() {
        return ztEndDate;
    }
    public void setZtEndDate(String ztEndDate) {
        this.ztEndDate = ztEndDate;
    }
    public String getStallsAddress() {
        return stallsAddress;
    }
    public void setStallsAddress(String stallsAddress) {
        this.stallsAddress = stallsAddress;
    }
    public String getPurchaseStaffName() {
        return purchaseStaffName;
    }
    public void setPurchaseStaffName(String purchaseStaffName) {
        this.purchaseStaffName = purchaseStaffName;
    }
    public String getConsigneeTel() {
        return consigneeTel;
    }
    public void setConsigneeTel(String consigneeTel) {
        this.consigneeTel = consigneeTel;
    }
    public Long getSellerId() {
        return sellerId;
    }
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
    public String getEntpName() {
        return entpName;
    }
    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }
}
