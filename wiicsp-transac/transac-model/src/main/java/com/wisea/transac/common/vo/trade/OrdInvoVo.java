package com.wisea.transac.common.vo.trade;


import com.wisea.transac.common.vo.EleInvoFileInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * 订单发票VO
 */
@ApiModel("订单发票VO")
public class OrdInvoVo {
	@ApiModelProperty("订单id")
    private Long id;
	@ApiModelProperty("订单id")
    private Long ordId;
	@ApiModelProperty("发票类型")
    private String invoType;
    @ApiModelProperty("发票类别")
    private String invoCatgType;
	@ApiModelProperty("发票形式")
    private String invoForm;
	@ApiModelProperty("发票抬头")
    private String invoTitle;
	@ApiModelProperty("发票内容类型")
    private String invoContentType;
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
	@ApiModelProperty("收件人")
    private String receName;
	@ApiModelProperty("收件人手机号")
    private String consigneeTel;
	@ApiModelProperty("所在地区省")
    private String addressProv;
	@ApiModelProperty("所在地区市")
    private String addressCity;
	@ApiModelProperty("所在地区区县")
    private String addressCou;
	@ApiModelProperty("详细地址")
    private String addressDetail;
	@ApiModelProperty("邮编")
    private String zipCode;
	@ApiModelProperty("申请单号")
    private String applNum;
	@ApiModelProperty("申请时间")
    private OffsetDateTime applDate;
	@ApiModelProperty("开票日期")
    private OffsetDateTime drawDate;
	@ApiModelProperty("开票金额")
    private Double drawAmount;
	@ApiModelProperty("发票状态")
    private String invoState;
	@ApiModelProperty("申请备注")
    private String applRemarks;
	@ApiModelProperty("开票备注")
    private String openInvoRemarks;
	@ApiModelProperty("物流公司名称")
    private String logisticsCompName;
	@ApiModelProperty("物流单号")
    private String logisticsNum;
	@ApiModelProperty("录入开票结果类型")
    private String entryOpenInvoType;
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

    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }

    public String getEntryOpenInvoType() {
        return entryOpenInvoType;
    }

    public void setEntryOpenInvoType(String entryOpenInvoType) {
        this.entryOpenInvoType = entryOpenInvoType;
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

    public String getInvoForm() {
        return invoForm;
    }

    public void setInvoForm(String invoForm) {
        this.invoForm = invoForm;
    }

    public String getInvoTitle() {
        return invoTitle;
    }

    public void setInvoTitle(String invoTitle) {
        this.invoTitle = invoTitle;
    }

    public String getInvoContentType() {
        return invoContentType;
    }

    public void setInvoContentType(String invoContentType) {
        this.invoContentType = invoContentType;
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

    public List<EleInvoFileInfoVo> getInvoFiles() {
        return invoFiles;
    }

    public void setInvoFiles(List<EleInvoFileInfoVo> invoFiles) {
        this.invoFiles = invoFiles;
    }
}
