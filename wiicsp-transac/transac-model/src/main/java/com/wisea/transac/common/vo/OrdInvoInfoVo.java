package com.wisea.transac.common.vo;

import java.time.OffsetDateTime;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("订单发票详细信息Vo")
public class OrdInvoInfoVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="订单id")
    private Long ordId;

    @ApiModelProperty("买家id")
    private Long buyerId;

    @ApiModelProperty("买家账号")
    private String loginName;

    @ApiModelProperty("买家名称")
    private String entpName;

    @ApiModelProperty(value="发票类型")
    private String invoType;

    @ApiModelProperty(value="发票形式")
    private String invoForm;

    @ApiModelProperty(value="发票类别")
    private String invoCatgType;

    @ApiModelProperty(value="发票抬头")
    private String invoTitle;

    @ApiModelProperty(value="纳税人识别号")
    private String taxIdentNum;

    @ApiModelProperty(value="注册地址")
    private String registAddress;

    @ApiModelProperty(value="注册电话")
    private String registTel;

    @ApiModelProperty(value="开户银行")
    private String bankName;

    @ApiModelProperty(value="银行账户")
    private String bankAccNum;

    @ApiModelProperty(value="收件人")
    private String receName;

    @ApiModelProperty(value="收件人手机号")
    private String consigneeTel;

    @ApiModelProperty(value="所在地区省")
    private String addressProv;

    @ApiModelProperty(value="所在地区市")
    private String addressCity;

    @ApiModelProperty(value="所在地区区县")
    private String addressCou;

    @ApiModelProperty(value="所在地区省名字")
    private String prov;

    @ApiModelProperty(value="所在地区市名字")
    private String city;

    @ApiModelProperty(value="所在地区区县名字")
    private String cou;

    @ApiModelProperty(value="详细地址")
    private String addressDetail;

    @ApiModelProperty("物流公司名称")
    private String logisticsCompName;

    @ApiModelProperty("物流单号")
    private String logisticsNum;

    @ApiModelProperty("申请备注")
    private String applRemarks;

    @ApiModelProperty("开票备注")
    private String openInvoRemarks;

    @ApiModelProperty("录入开票结果类型")
    private String entryOpenInvoType;

    @ApiModelProperty(value="邮编")
    private String zipCode;

    @ApiModelProperty(value="申请单号")
    private String applNum;

    @ApiModelProperty(value="订单单号")
    private String ordNum;

    @ApiModelProperty(value="申请时间")
    private OffsetDateTime applDate;

    @ApiModelProperty(value="订单下单时间")
    private OffsetDateTime referOrdDate;

    @ApiModelProperty(value="开票日期")
    private OffsetDateTime drawDate;

    @ApiModelProperty(value="开票金额")
    private Double drawAmount;

    @ApiModelProperty(value="发票状态")
    private String invoState;

    @ApiModelProperty(value="发票内容类型")
    private String invoContentType;

    @ApiModelProperty("发票文件")
    private List<EleInvoFileInfoVo> invoFiles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrdId() {
        return ordId;
    }

    public List<EleInvoFileInfoVo> getInvoFiles() {
        return invoFiles;
    }

    public void setInvoFiles(List<EleInvoFileInfoVo> invoFiles) {
        this.invoFiles = invoFiles;
    }

    public void setOrdId(Long ordId) {
        this.ordId = ordId;
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

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
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

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public String getInvoType() {
        return invoType;
    }

    public void setInvoType(String invoType) {
        this.invoType = invoType;
    }

    public String getInvoForm() {
        return invoForm;
    }

    public void setInvoForm(String invoForm) {
        this.invoForm = invoForm;
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

    public String getConsigneeTel() {
        return consigneeTel;
    }

    public void setConsigneeTel(String consigneeTel) {
        this.consigneeTel = consigneeTel;
    }

    public String getAddressProv() {
        return addressProv;
    }

    public void setAddressProv(String addressProv) {
        this.addressProv = addressProv;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressCou() {
        return addressCou;
    }

    public void setAddressCou(String addressCou) {
        this.addressCou = addressCou;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
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

    public String getApplRemarks() {
        return applRemarks;
    }

    public void setApplRemarks(String applRemarks) {
        this.applRemarks = applRemarks;
    }

    public String getOpenInvoRemarks() {
        return openInvoRemarks;
    }

    public void setOpenInvoRemarks(String openInvoRemarks) {
        this.openInvoRemarks = openInvoRemarks;
    }

    public String getEntryOpenInvoType() {
        return entryOpenInvoType;
    }

    public void setEntryOpenInvoType(String entryOpenInvoType) {
        this.entryOpenInvoType = entryOpenInvoType;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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

    public OffsetDateTime getDrawDate() {
        return drawDate;
    }

    public void setDrawDate(OffsetDateTime drawDate) {
        this.drawDate = drawDate;
    }

    public Double getDrawAmount() {
        return drawAmount;
    }

    public void setDrawAmount(Double drawAmount) {
        this.drawAmount = drawAmount;
    }

    public String getInvoState() {
        return invoState;
    }

    public void setInvoState(String invoState) {
        this.invoState = invoState;
    }

    public String getInvoContentType() {
        return invoContentType;
    }

    public void setInvoContentType(String invoContentType) {
        this.invoContentType = invoContentType;
    }
}
