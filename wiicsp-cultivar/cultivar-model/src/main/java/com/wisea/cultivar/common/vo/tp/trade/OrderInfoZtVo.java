package com.wisea.cultivar.common.vo.tp.trade;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className OrderInfoZtVo
 * @date 2019/4/19 15:45
 * @Description 自提订单VO
 */
public class OrderInfoZtVo {
    @ApiModelProperty("订单ID")
    private Long id;
    @ApiModelProperty("订单商品列表")
    private List<ZtCommRelaVo> ztCommRelaVos;
    @ApiModelProperty("商品发布价总金额")
    private Double commTotalPrice;
    @ApiModelProperty("商品总件数")
    private Double commTotalCount;
    @ApiModelProperty("支付方式")
    private String payMethodType;
    @ApiModelProperty("运费")
    private Double commTotalFreight;
    @ApiModelProperty("账期服务费")
    private Double zqSerCost;
    @ApiModelProperty("订金金额")
    private Double depositAmount;
    @ApiModelProperty("尾款金额")
    private Double tailAmount;
    @ApiModelProperty("订单总金额")
    private Double amountPayable;
    @ApiModelProperty("订单编号")
    private String ordNum;
    @ApiModelProperty("提交订单日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime referOrdDate;
    @ApiModelProperty("提货人姓名")
    private String consigneeName;
    @ApiModelProperty("提货人手机号")
    private String consigneeTel;
    @ApiModelProperty("自提地省")
    private String ztAddressProv;
    @ApiModelProperty("自提地市")
    private String ztAddressCity;
    @ApiModelProperty("自提地区县")
    private String ztAddressCou;
    @ApiModelProperty("自提详细地址")
    private String ztAddress;
    @ApiModelProperty("订单状态")
    private String orderStateType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ZtCommRelaVo> getZtCommRelaVos() {
        return ztCommRelaVos;
    }

    public void setZtCommRelaVos(List<ZtCommRelaVo> ztCommRelaVos) {
        this.ztCommRelaVos = ztCommRelaVos;
    }

    public Double getCommTotalPrice() {
        return commTotalPrice;
    }

    public void setCommTotalPrice(Double commTotalPrice) {
        this.commTotalPrice = commTotalPrice;
    }

    public Double getCommTotalCount() {
        return commTotalCount;
    }

    public void setCommTotalCount(Double commTotalCount) {
        this.commTotalCount = commTotalCount;
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

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public OffsetDateTime getReferOrdDate() {
        return referOrdDate;
    }

    public void setReferOrdDate(OffsetDateTime referOrdDate) {
        this.referOrdDate = referOrdDate;
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

    public Double getZqSerCost() {
        return zqSerCost;
    }

    public void setZqSerCost(Double zqSerCost) {
        this.zqSerCost = zqSerCost;
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
}
