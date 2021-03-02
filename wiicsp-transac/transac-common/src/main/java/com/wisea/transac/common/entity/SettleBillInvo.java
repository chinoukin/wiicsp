package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;
import java.time.OffsetDateTime;

public class SettleBillInvo extends DataLongEntity<SettleBillInvo> {
    /**
     * 商家id
     */
    private Long entpId;

    /**
     * 结算单id
     */
    private Long settleId;

    /**
     * 发票类型
     */
    private String invoType;

    /**
     * 发票形式
     */
    private String invoForm;

    /**
     * 发票类别
     */
    private String invoCatgType;

    /**
     * 发票抬头
     */
    private String invoTitle;

    /**
     * 纳税人识别号
     */
    private String taxIdentNum;

    /**
     * 注册地址
     */
    private String registAddress;

    /**
     * 注册电话
     */
    private String registTel;

    /**
     * 开户银行
     */
    private String bankName;

    /**
     * 银行账户
     */
    private String bankAccNum;

    /**
     * 收件人
     */
    private String receName;

    /**
     * 所在地区省
     */
    private String addressProv;

    /**
     * 所在地区市
     */
    private String addressCity;

    /**
     * 所在地区区县
     */
    private String addressCou;

    /**
     * 详细地址
     */
    private String addressDetail;

    /**
     * 邮编
     */
    private String zipCode;

    /**
     * 手机号码
     */
    private String tel;

    /**
     * 物流公司名称
     */
    private String logisticsCompName;

    /**
     * 物流单号
     */
    private String logisticsNum;

    /**
     * 申请单号
     */
    private String applNum;

    /**
     * 申请时间
     */
    private OffsetDateTime applDate;

    /**
     * 开票日期
     */
    private OffsetDateTime drawDate;

    /**
     * 开票金额
     */
    private Double drawAmount;

    /**
     * 发票状态
     */
    private String invoState;

    /**
     * 验票异议状态
     */
    private String examInvoDissType;

    /**
     * 发票内容类型
     */
    private String invoContentType;

    /**
     * 申请备注
     */
    private String applRemarks;

    /**
     * 开票备注
     */
    private String openInvoRemarks;

    /**
     * 验票异议备注
     */
    private String examInvoDissRemarks;

    /**
     * 录入开票结果类型
     */
    private String entryOpenInvoType;

    public Long getEntpId() {
        return entpId;
    }

    public void setEntpId(Long entpId) {
        this.entpId = entpId;
    }

    public Long getSettleId() {
        return settleId;
    }

    public void setSettleId(Long settleId) {
        this.settleId = settleId;
    }

    public String getInvoContentType() {
        return invoContentType;
    }

    public void setInvoContentType(String invoContentType) {
        this.invoContentType = invoContentType;
    }

    public String getExamInvoDissRemarks() {
        return examInvoDissRemarks;
    }

    public void setExamInvoDissRemarks(String examInvoDissRemarks) {
        this.examInvoDissRemarks = examInvoDissRemarks;
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public String getExamInvoDissType() {
        return examInvoDissType;
    }

    public void setExamInvoDissType(String examInvoDissType) {
        this.examInvoDissType = examInvoDissType;
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
}
