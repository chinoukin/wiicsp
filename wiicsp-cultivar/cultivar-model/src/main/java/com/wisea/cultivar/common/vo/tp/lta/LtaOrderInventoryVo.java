package com.wisea.cultivar.common.vo.tp.lta;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className LtaOrderInventoryVo
 * @date 2019/5/9 9:21
 * @Description 长期协议订单发货单列表Vo
 */
@ApiModel("长期协议订单发货单列表Vo")
public class LtaOrderInventoryVo {
    @ApiModelProperty("订单ID")
    private Long id;
    @ApiModelProperty("订单商品列表")
    private List<LtaOrdCommRelaVo> ordCommRelaVos;
    @ApiModelProperty("提交订单日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime buyerOrdDate;
    @ApiModelProperty("订单编号")
    private String ltaOrdNumb;
    @ApiModelProperty("商品发布价总金额")
    private Double commAmount;
    @ApiModelProperty("运费")
    private Double freight;
    @ApiModelProperty("订单总金额")
    private Double yfAmount;
    @ApiModelProperty("配送信息类型（商家配送、买家自提）")
    private String deliveryInfoType;

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

    /***自提信息***/
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<LtaOrdCommRelaVo> getOrdCommRelaVos() {
        return ordCommRelaVos;
    }

    public void setOrdCommRelaVos(List<LtaOrdCommRelaVo> ordCommRelaVos) {
        this.ordCommRelaVos = ordCommRelaVos;
    }

    public OffsetDateTime getBuyerOrdDate() {
        return buyerOrdDate;
    }

    public void setBuyerOrdDate(OffsetDateTime buyerOrdDate) {
        this.buyerOrdDate = buyerOrdDate;
    }

    public String getLtaOrdNumb() {
        return ltaOrdNumb;
    }

    public void setLtaOrdNumb(String ltaOrdNumb) {
        this.ltaOrdNumb = ltaOrdNumb;
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

    public String getDeliveryInfoType() {
        return deliveryInfoType;
    }

    public void setDeliveryInfoType(String deliveryInfoType) {
        this.deliveryInfoType = deliveryInfoType;
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
}
