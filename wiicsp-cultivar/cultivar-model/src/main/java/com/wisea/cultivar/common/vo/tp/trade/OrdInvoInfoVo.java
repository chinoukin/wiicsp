package com.wisea.cultivar.common.vo.tp.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className OrdInvoInfoVo
 * @date 2019/4/24 17:48
 * @Description 发票详细信息Vo
 */
@ApiModel("发票详细信息Vo")
public class OrdInvoInfoVo {
    /**开票信息**/
    @ApiModelProperty("发票ID")
    private Long id;
    @ApiModelProperty("订单ID")
    private Long ordId;
    @ApiModelProperty("申请单号")
    private String applNum;
    @ApiModelProperty(value = "申请时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime applDate;
    @ApiModelProperty("采购商名称")
    private String buyerAccountName;
    @ApiModelProperty("开票金额")
    private Double drawAmount;

    /**订单及商品信息**/
    @ApiModelProperty("订单编号")
    private String ordNum;
    @ApiModelProperty("提交订单日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime referOrdDate;
    @ApiModelProperty("订单配送信息类型，注：买家自提的发票不展示收票信息")
    private String deliveryInfoType;
    @ApiModelProperty("商品总金额")
    private Double commTotalPrice;
    @ApiModelProperty("运费总金额")
    private Double commTotalFreight;
    @ApiModelProperty("应退货款总金额")
    private Double shouldYfAmountCount;
    @ApiModelProperty("订单发票商品列表")
    private List<OrdInvoCommVo> ordInvoComms;

    /**发票信息**/
    @ApiModelProperty("发票类型")
    private String invoType;
    @ApiModelProperty("发票类别")
    private String invoCatgType;
    @ApiModelProperty("发票抬头")
    private String invoTitle;
    @ApiModelProperty("纳税人识别号")
    private String taxIdentNum;
    @ApiModelProperty("注册地址")
    private String registAddress;
    @ApiModelProperty("注册电话")
    private String registTel;
    @ApiModelProperty("开户银行")
    private String bankName;
    @ApiModelProperty("银行账户")
    private String bankAccNum;

    /**收票信息**/
    @ApiModelProperty("收件人")
    private String receName;
    @ApiModelProperty("所在地区省")
    private String addressProvName;
    @ApiModelProperty("所在地区市")
    private String addressCityName;
    @ApiModelProperty("所在地区区县")
    private String addressCouName;
    @ApiModelProperty("详细地址")
    private String addressDetail;
    @ApiModelProperty("邮编")
    private String zipCode;
    @ApiModelProperty("手机号码")
    private String tel;

    /**开票结果**/
    @ApiModelProperty("发票形式")
    private String invoForm;
    @ApiModelProperty("电子发票url")
    private String eleInvoUrl;
    @ApiModelProperty("电子发票文件名称")
    private String eleInvoFileName;
    @ApiModelProperty("物流公司名称")
    private String logisticsCompName;
    @ApiModelProperty("物流单号")
    private String logisticsNum;

    /**其它字段**/
    @ApiModelProperty("发票状态")
    private String invoState;
    @ApiModelProperty("作废备注")
    private String cancelRemarks;
    @ApiModelProperty("开票日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime drawDate;

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

    public String getApplNum() {
        return applNum;
    }

    public void setApplNum(String applNum) {
        this.applNum = applNum;
    }

    public OffsetDateTime getApplDate() {
        return applDate;
    }

    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
    }

    public String getBuyerAccountName() {
        return buyerAccountName;
    }

    public void setBuyerAccountName(String buyerAccountName) {
        this.buyerAccountName = buyerAccountName;
    }

    public Double getDrawAmount() {
        return drawAmount;
    }

    public void setDrawAmount(Double drawAmount) {
        this.drawAmount = drawAmount;
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

    public String getDeliveryInfoType() {
        return deliveryInfoType;
    }

    public void setDeliveryInfoType(String deliveryInfoType) {
        this.deliveryInfoType = deliveryInfoType;
    }

    public Double getCommTotalPrice() {
        return commTotalPrice;
    }

    public void setCommTotalPrice(Double commTotalPrice) {
        this.commTotalPrice = commTotalPrice;
    }

    public Double getCommTotalFreight() {
        return commTotalFreight;
    }

    public void setCommTotalFreight(Double commTotalFreight) {
        this.commTotalFreight = commTotalFreight;
    }

    public Double getShouldYfAmountCount() {
        return shouldYfAmountCount;
    }

    public void setShouldYfAmountCount(Double shouldYfAmountCount) {
        this.shouldYfAmountCount = shouldYfAmountCount;
    }

    public List<OrdInvoCommVo> getOrdInvoComms() {
        return ordInvoComms;
    }

    public void setOrdInvoComms(List<OrdInvoCommVo> ordInvoComms) {
        this.ordInvoComms = ordInvoComms;
    }

    public String getInvoType() {
        return invoType;
    }

    public void setInvoType(String invoType) {
        this.invoType = invoType;
    }

    public String getInvoCatgType() {
        return invoCatgType;
    }

    public void setInvoCatgType(String invoCatgType) {
        this.invoCatgType = invoCatgType;
    }

    public String getInvoTitle() {
        return invoTitle;
    }

    public void setInvoTitle(String invoTitle) {
        this.invoTitle = invoTitle;
    }

    public String getTaxIdentNum() {
        return taxIdentNum;
    }

    public void setTaxIdentNum(String taxIdentNum) {
        this.taxIdentNum = taxIdentNum;
    }

    public String getRegistAddress() {
        return registAddress;
    }

    public void setRegistAddress(String registAddress) {
        this.registAddress = registAddress;
    }

    public String getRegistTel() {
        return registTel;
    }

    public void setRegistTel(String registTel) {
        this.registTel = registTel;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccNum() {
        return bankAccNum;
    }

    public void setBankAccNum(String bankAccNum) {
        this.bankAccNum = bankAccNum;
    }

    public String getReceName() {
        return receName;
    }

    public void setReceName(String receName) {
        this.receName = receName;
    }

    public String getAddressProvName() {
        return addressProvName;
    }

    public void setAddressProvName(String addressProvName) {
        this.addressProvName = addressProvName;
    }

    public String getAddressCityName() {
        return addressCityName;
    }

    public void setAddressCityName(String addressCityName) {
        this.addressCityName = addressCityName;
    }

    public String getAddressCouName() {
        return addressCouName;
    }

    public void setAddressCouName(String addressCouName) {
        this.addressCouName = addressCouName;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getInvoForm() {
        return invoForm;
    }

    public void setInvoForm(String invoForm) {
        this.invoForm = invoForm;
    }

    public String getEleInvoUrl() {
        return eleInvoUrl;
    }

    public void setEleInvoUrl(String eleInvoUrl) {
        this.eleInvoUrl = eleInvoUrl;
    }

    public String getEleInvoFileName() {
        return eleInvoFileName;
    }

    public void setEleInvoFileName(String eleInvoFileName) {
        this.eleInvoFileName = eleInvoFileName;
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

    public String getInvoState() {
        return invoState;
    }

    public void setInvoState(String invoState) {
        this.invoState = invoState;
    }

    public String getCancelRemarks() {
        return cancelRemarks;
    }

    public void setCancelRemarks(String cancelRemarks) {
        this.cancelRemarks = cancelRemarks;
    }

    public OffsetDateTime getDrawDate() {
        return drawDate;
    }

    public void setDrawDate(OffsetDateTime drawDate) {
        this.drawDate = drawDate;
    }
}
