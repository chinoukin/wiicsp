package com.wisea.transac.common.vo;

import com.wisea.transac.common.vo.trade.OpreateInfoVo;
import com.wisea.transac.common.vo.trade.OrdCommRefundRelaVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

@ApiModel("退款信息Vo")
public class RefundApplInfoVo {
    @ApiModelProperty(value="id")
    private Long id;
    @ApiModelProperty(value="订单id")
    private Long ordId;
    @ApiModelProperty("卖家ID")
    private Long sellerId;
    @ApiModelProperty("卖家账号")
    private String sellerAccount;
    @ApiModelProperty("供应商联系人(档口)")
    private String contacts;
    @ApiModelProperty("供应商联系电话(档口)")
    private String contTel;
    @ApiModelProperty("买家ID")
    private Long buyerId;
    @ApiModelProperty("档口ID")
    private Long stallsId;
    @ApiModelProperty(value="订单编号")
    private String ordNum;
    @ApiModelProperty(value="服务单号")
    private String refundNum;
    @ApiModelProperty(value="申请时间")
    private OffsetDateTime applDate;
    @ApiModelProperty(value="退款申请状态类型")
    private String refundApplStateType;
    @ApiModelProperty(value="订单金额")
    private Double ordAmount;
    @ApiModelProperty(value="退款金额")
    private Double refundAmount;
    @ApiModelProperty(value="应退账期服务费金额")
    private Double refundZqSerCost;
    @ApiModelProperty(value="处理时间")
    private OffsetDateTime handleDate;

    @ApiModelProperty("买家账号（采购员）")
    private String purchaseAccount;
    @ApiModelProperty("买家手机号（采购员）")
    private String purchaseRegistTel;
    @ApiModelProperty("买家姓名（采购员）")
    private String purchaseStaffName;
    @ApiModelProperty("认证主体名称")
    private String authZtName;
    @ApiModelProperty("订单支付方式")
    private String payMethodType;
    @ApiModelProperty("退款商品列表")
    private List<OrdCommRefundRelaVo> commRefundRelas;
    @ApiModelProperty("退款操作记录列表")
    private List<OpreateInfoVo> refundOpreateInfos;
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

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContTel() {
        return contTel;
    }

    public void setContTel(String contTel) {
        this.contTel = contTel;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getStallsId() {
        return stallsId;
    }

    public void setStallsId(Long stallsId) {
        this.stallsId = stallsId;
    }

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public String getRefundNum() {
        return refundNum;
    }

    public void setRefundNum(String refundNum) {
        this.refundNum = refundNum;
    }

    public OffsetDateTime getApplDate() {
        return applDate;
    }

    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
    }

    public String getRefundApplStateType() {
        return refundApplStateType;
    }

    public void setRefundApplStateType(String refundApplStateType) {
        this.refundApplStateType = refundApplStateType;
    }

    public Double getOrdAmount() {
        return ordAmount;
    }

    public void setOrdAmount(Double ordAmount) {
        this.ordAmount = ordAmount;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Double getRefundZqSerCost() {
        return refundZqSerCost;
    }

    public void setRefundZqSerCost(Double refundZqSerCost) {
        this.refundZqSerCost = refundZqSerCost;
    }

    public OffsetDateTime getHandleDate() {
        return handleDate;
    }

    public void setHandleDate(OffsetDateTime handleDate) {
        this.handleDate = handleDate;
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

    public String getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(String payMethodType) {
        this.payMethodType = payMethodType;
    }

    public List<OrdCommRefundRelaVo> getCommRefundRelas() {
        return commRefundRelas;
    }

    public void setCommRefundRelas(List<OrdCommRefundRelaVo> commRefundRelas) {
        this.commRefundRelas = commRefundRelas;
    }

    public List<OpreateInfoVo> getRefundOpreateInfos() {
        return refundOpreateInfos;
    }

    public void setRefundOpreateInfos(List<OpreateInfoVo> refundOpreateInfos) {
        this.refundOpreateInfos = refundOpreateInfos;
    }
}
