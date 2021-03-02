package com.wisea.transac.common.vo.trade;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.transac.common.po.trade.BuyerOrdCommRela;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * OrderInfoListVo
 * 2018/09/18 17:40:35
 */
@ApiModel("买家端订单列表vo")
public class BuyerOrderInfoListVo {

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商家ID")
    private Long sellerId;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "采购员ID")
    private Long purchaseId;
    @ApiModelProperty(value = "订单编号")
    private String ordNum;
    @ApiModelProperty(value = "自提码")
    private String ztNum;
    @ApiModelProperty(value = "提货地址类型")
    private String ztAddressType;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "档口ID")
    private String stallsId;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "基地ID")
    private String baseId;
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
    @ApiModelProperty(value = "订单状态")
    private String orderStateType;
    @ApiModelProperty(value = "基地订单状态")
    private String baseOrderStateType;
    @ApiModelProperty(value = "应付金额")
    private Double payableAmount;
    @ApiModelProperty(value = "商品金额")
    private Double commTotalPrice;
    @ApiModelProperty(value = "商品总数量")
    private String commTotalCount;
    @ApiModelProperty(value = "账期服务费")
    private Double zqSerCost;
    @ApiModelProperty(value = "支付类型")
    private String payMethodType;
    @ApiModelProperty(value = "采购员名称(这个为空则表示当前用户就是下单人)")
    private String purchaseStaffName;
    @ApiModelProperty(value = "采购员电话")
    private String consigneeTel;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商家ID")
    private Long selleId;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "发票ID")
    private Long ordInvoId;
    @ApiModelProperty(value = "发票状态")
    private String invoState;
    @ApiModelProperty(value = "商家名称")
    private String entpName;
    @ApiModelProperty(value = "订单备注")
    private String ordRemarks;
    @ApiModelProperty(value = "订单商品列表")
    private List<BuyerOrdCommRela> ordCommRelaList;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getOrdRemarks() {
        return ordRemarks;
    }
    public void setOrdRemarks(String ordRemarks) {
        this.ordRemarks = ordRemarks;
    }
    public Long getOrdInvoId() {
        return ordInvoId;
    }
    public void setOrdInvoId(Long ordInvoId) {
        this.ordInvoId = ordInvoId;
    }
    public String getInvoState() {
        return invoState;
    }
    public void setInvoState(String invoState) {
        this.invoState = invoState;
    }
    public String getStallsAddress() {
        return stallsAddress;
    }
    public void setStallsAddress(String stallsAddress) {
        this.stallsAddress = stallsAddress;
    }
    public String getBaseId() {
        return baseId;
    }
    public void setBaseId(String baseId) {
        this.baseId = baseId;
    }
    public String getBaseOrderStateType() {
        return baseOrderStateType;
    }
    public void setBaseOrderStateType(String baseOrderStateType) {
        this.baseOrderStateType = baseOrderStateType;
    }
    public Long getPurchaseId() {
        return purchaseId;
    }
    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }
    public Long getSelleId() {
        return selleId;
    }
    public String getEntpName() {
        return entpName;
    }
    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }
    public void setSelleId(Long selleId) {
        this.selleId = selleId;
    }
    public String getOrdNum() {
        return ordNum;
    }
    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
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
    public String getOrderStateType() {
        return orderStateType;
    }
    public void setOrderStateType(String orderStateType) {
        this.orderStateType = orderStateType;
    }
    public String getCommTotalCount() {
        return commTotalCount;
    }
    public void setCommTotalCount(String commTotalCount) {
        this.commTotalCount = commTotalCount;
    }
    public Long getSellerId() {
        return sellerId;
    }
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }
    public String getZtNum() {
        return ztNum;
    }
    public void setZtNum(String ztNum) {
        this.ztNum = ztNum;
    }
    public Double getPayableAmount() {
        return payableAmount;
    }
    public void setPayableAmount(Double payableAmount) {
        this.payableAmount = payableAmount;
    }
    public Double getCommTotalPrice() {
        return commTotalPrice;
    }
    public void setCommTotalPrice(Double commTotalPrice) {
        this.commTotalPrice = commTotalPrice;
    }
    public Double getZqSerCost() {
        return zqSerCost;
    }
    public void setZqSerCost(Double zqSerCost) {
        this.zqSerCost = zqSerCost;
    }
    public String getPayMethodType() {
        return payMethodType;
    }
    public void setPayMethodType(String payMethodType) {
        this.payMethodType = payMethodType;
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
    public List<BuyerOrdCommRela> getOrdCommRelaList() {
        return ordCommRelaList;
    }
    public void setOrdCommRelaList(List<BuyerOrdCommRela> ordCommRelaList) {
        this.ordCommRelaList = ordCommRelaList;
    }
}
