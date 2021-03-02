package com.wisea.transac.common.vo;

import com.wisea.transac.common.vo.trade.SettleBillEleInvoFileVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

@ApiModel("结算单发票详细信息Vo")
public class SettleBillInvoInfoVo {
    @ApiModelProperty("账期发票Id")
    private Long id;
    @ApiModelProperty("结算单Id")
    private Long settleId;
    @ApiModelProperty("发票类型")
    private String invoType;
    @ApiModelProperty("发票形式")
    private String invoForm;
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
    @ApiModelProperty("录入开票结果类型")
    private String entryOpenInvoType;
    @ApiModelProperty("收件人")
    private String receName;
    @ApiModelProperty("所在地区省")
    private String addressProv;
    @ApiModelProperty("所在地区市")
    private String addressCity;
    @ApiModelProperty("发票内容类型")
    private String invoContentType;
    @ApiModelProperty("所在地区区县")
    private String addressCou;
    @ApiModelProperty("所在地区省名称")
    private String prov;
    @ApiModelProperty("所在地区市名称")
    private String city;
    @ApiModelProperty("所在地区区县名称")
    private String cou;
    @ApiModelProperty("详细地址")
    private String addressDetail;
    @ApiModelProperty("邮编")
    private String zipCode;
    @ApiModelProperty("手机号码")
    private String tel;
    @ApiModelProperty("物流公司名称")
    private String logisticsCompName;
    @ApiModelProperty("物流单号")
    private String logisticsNum;
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
    @ApiModelProperty("验票异议状态")
    private String examInvoDissType;
    @ApiModelProperty("申请备注")
    private String applRemarks;
    @ApiModelProperty("开票备注")
    private String openInvoRemarks;
    @ApiModelProperty("验票异议备注")
    private String examInvoDissRemarks;
    @ApiModelProperty("电子发票文件")
    private List<SettleBillEleInvoFileVo> invoFiles;

    /**账期信息**/
    @ApiModelProperty("开票截止日")
    private OffsetDateTime openBillDeadline;
    @ApiModelProperty("验票截止日")
    private OffsetDateTime examBillDeadline;
    @ApiModelProperty("当前时间")
    private OffsetDateTime nowDate;

    @ApiModelProperty(value="卖方id")
    private Long sellerId;
    @ApiModelProperty("卖方账号")
    private String sellerAccount;
    @ApiModelProperty("卖方名称")
    private String sellerName;
    @ApiModelProperty(value="买方id")
    private Long buyerId;
    @ApiModelProperty("买方账号")
    private String buyerAccount;
    @ApiModelProperty("买方名称")
    private String buyerName;
    @ApiModelProperty("结算单号")
    private String settleBillNumb;
    @ApiModelProperty("应结总额")
    private Double totalMoney;
    @ApiModelProperty("已支付总金额")
    private Double paymentAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEntryOpenInvoType() {
        return entryOpenInvoType;
    }

    public void setEntryOpenInvoType(String entryOpenInvoType) {
        this.entryOpenInvoType = entryOpenInvoType;
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

    public List<SettleBillEleInvoFileVo> getInvoFiles() {
        return invoFiles;
    }

    public void setInvoFiles(List<SettleBillEleInvoFileVo> invoFiles) {
        this.invoFiles = invoFiles;
    }

    public OffsetDateTime getOpenBillDeadline() {
        return openBillDeadline;
    }

    public void setOpenBillDeadline(OffsetDateTime openBillDeadline) {
        this.openBillDeadline = openBillDeadline;
    }

    public OffsetDateTime getExamBillDeadline() {
        return examBillDeadline;
    }

    public void setExamBillDeadline(OffsetDateTime examBillDeadline) {
        this.examBillDeadline = examBillDeadline;
    }

    public OffsetDateTime getNowDate() {
        return nowDate;
    }

    public void setNowDate(OffsetDateTime nowDate) {
        this.nowDate = nowDate;
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

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerAccount() {
        return buyerAccount;
    }

    public void setBuyerAccount(String buyerAccount) {
        this.buyerAccount = buyerAccount;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getSettleBillNumb() {
        return settleBillNumb;
    }

    public void setSettleBillNumb(String settleBillNumb) {
        this.settleBillNumb = settleBillNumb;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }
}
