package com.wisea.transac.common.vo.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className BillOfLadingVo
 * @date 2020/5/7 10:05
 * @Description
 */
@ApiModel("提货单VO")
public class BillOfLadingVo {
    @ApiModelProperty("订单ID")
    private Long id;
    @ApiModelProperty("档口ID")
    private Long stallsId;
    @ApiModelProperty("订单编号")
    private String ordNum;
    @ApiModelProperty("订单状态")
    private String orderStateType;
    @ApiModelProperty("提交订单日期")
    private OffsetDateTime referOrdDate;
    @ApiModelProperty("提交订单日期字符串")
    private String referOrdDateStr;
    @ApiModelProperty("买家认证主体名称")
    private String authZtName;
    @ApiModelProperty("提货人姓名(采购员)")
    private String consigneeName;
    @ApiModelProperty("提货人手机号(采购员)")
    private String consigneeTel;
    @ApiModelProperty("商家Id")
    private Long sellerId;
    @ApiModelProperty("商家名称")
    private String sellerName;
    @ApiModelProperty("支付方式")
    private String payMethodType;
    @ApiModelProperty("支付方式字符串")
    private String payMethodTypeStr;
    @ApiModelProperty("账期服务费")
    private Double zqSerCost;
    @ApiModelProperty("应付金额")
    private Double payableAmount;
    @ApiModelProperty("支付订单日期")
    private OffsetDateTime payOrdDate;
    @ApiModelProperty("支付订单日期字符串")
    private String payOrdDateStr;
    @ApiModelProperty("提货地址类型")
    private String ztAddressType;
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
    @ApiModelProperty("提货地址")
    private String thAddressInfo;
    @ApiModelProperty("自提联系人")
    private String ztContactsName;
    @ApiModelProperty("自提联系电话")
    private String ztTel;
    @ApiModelProperty("配送方式类型")
    private String sendZtType;
    @ApiModelProperty("订单商品列表")
    private List<OrdCommRelaVo> ordCommRelas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getReferOrdDateStr() {
        return referOrdDateStr;
    }

    public void setReferOrdDateStr(String referOrdDateStr) {
        this.referOrdDateStr = referOrdDateStr;
    }

    public String getAuthZtName() {
        return authZtName;
    }

    public void setAuthZtName(String authZtName) {
        this.authZtName = authZtName;
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

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(String payMethodType) {
        this.payMethodType = payMethodType;
    }

    public String getPayMethodTypeStr() {
        return payMethodTypeStr;
    }

    public void setPayMethodTypeStr(String payMethodTypeStr) {
        this.payMethodTypeStr = payMethodTypeStr;
    }

    public Double getZqSerCost() {
        return zqSerCost;
    }

    public void setZqSerCost(Double zqSerCost) {
        this.zqSerCost = zqSerCost;
    }

    public Double getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(Double payableAmount) {
        this.payableAmount = payableAmount;
    }

    public OffsetDateTime getPayOrdDate() {
        return payOrdDate;
    }

    public void setPayOrdDate(OffsetDateTime payOrdDate) {
        this.payOrdDate = payOrdDate;
    }

    public String getPayOrdDateStr() {
        return payOrdDateStr;
    }

    public void setPayOrdDateStr(String payOrdDateStr) {
        this.payOrdDateStr = payOrdDateStr;
    }

    public String getZtAddressType() {
        return ztAddressType;
    }

    public void setZtAddressType(String ztAddressType) {
        this.ztAddressType = ztAddressType;
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

    public String getThAddressInfo() {
        return thAddressInfo;
    }

    public void setThAddressInfo(String thAddressInfo) {
        this.thAddressInfo = thAddressInfo;
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

    public String getSendZtType() {
        return sendZtType;
    }

    public void setSendZtType(String sendZtType) {
        this.sendZtType = sendZtType;
    }

    public List<OrdCommRelaVo> getOrdCommRelas() {
        return ordCommRelas;
    }

    public void setOrdCommRelas(List<OrdCommRelaVo> ordCommRelas) {
        this.ordCommRelas = ordCommRelas;
    }
}
