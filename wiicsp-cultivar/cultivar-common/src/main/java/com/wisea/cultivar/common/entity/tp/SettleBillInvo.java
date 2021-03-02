package com.wisea.cultivar.common.entity.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import com.wisea.cloud.model.annotation.IdSerializer;

import java.time.OffsetDateTime;

/**
 * settle_bill_invo 表实体
 * 结算单发票
 * 2018/10/12 11:10:09
 */
public class SettleBillInvo extends DataLongEntity<SettleBillInvo> {
    private static final long serialVersionUID = 1L;

    /**
     * 商家id
     */
    private Long entpId;

    /**
     * 结算单id
     */
    @JsonSerialize(using = IdSerializer.class)
    private Long settleId;

    /**
     * 结算单单号
     */
    @ExcelField(title = "结算单号", sort = 1)
    private String settleNum;

    /**
     * 结算周期
     */
    @ExcelField(title = "结算周期", sort = 2)
    private String settleCycle;

    /**
     * 结算周期前部分
     */
    private String beforeTime;

    /**
     * 应结金额
     */
    @ExcelField(title = "应结金额", sort = 3)
    private Double totalMoney;

    /**
     * 结算周期后部分
     */
    private String afterTime;

    /**
     * 发票类型
     */
    @ExcelField(title = "发票类型", sort = 4)
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
    @ExcelField(title = "发票抬头", sort = 5)
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
     * 是否默认
     */
    private String defaultFlag;

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

    private OffsetDateTime drawBeforeDate;

    private OffsetDateTime drawAfterDate;

    /**
     * 开票金额
     */
    private Double drawAmount;

    /**
     * 发票状态
     */
    @ExcelField(title = "发票状态", sort = 6)
    private String invoState;

    /**
     * 作废备注
     */
    private String cancelRemarks;

    /**
     * 电子发票url
     */
    private String dzInvoUrl;

    /**
     * 电子发票文件名称
     */
    private String dzInvoName;

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getSettleCycle() {
        return settleCycle;
    }

    public void setSettleCycle(String settleCycle) {
        this.settleCycle = settleCycle;
    }

    public String getBeforeTime() {
        return beforeTime;
    }

    public void setBeforeTime(String beforeTime) {
        this.beforeTime = beforeTime;
    }

    public String getAfterTime() {
        return afterTime;
    }

    public void setAfterTime(String afterTime) {
        this.afterTime = afterTime;
    }

    public String getSettleNum() {
        return settleNum;
    }

    public void setSettleNum(String settleNum) {
        this.settleNum = settleNum;
    }

    public OffsetDateTime getDrawBeforeDate() {
        return drawBeforeDate;
    }

    public void setDrawBeforeDate(OffsetDateTime drawBeforeDate) {
        this.drawBeforeDate = drawBeforeDate;
    }

    public OffsetDateTime getDrawAfterDate() {
        return drawAfterDate;
    }

    public void setDrawAfterDate(OffsetDateTime drawAfterDate) {
        this.drawAfterDate = drawAfterDate;
    }

    /**
     * 获取商家id
     */
    public Long getEntpId() {
        return entpId;
    }

    /**
     * 设置商家id
     */
    public void setEntpId(Long entpId) {
        this.entpId = entpId;
    }

    /**
     * 获取结算单id
     */
    public Long getSettleId() {
        return settleId;
    }

    /**
     * 设置结算单id
     */
    public void setSettleId(Long settleId) {
        this.settleId = settleId;
    }

    /**
     * 获取发票类型
     */
    public String getInvoType() {
        return invoType;
    }

    /**
     * 设置发票类型
     */
    public void setInvoType(String invoType) {
        this.invoType = invoType == null ? null : invoType.trim();
    }

    /**
     * 获取发票形式
     */
    public String getInvoForm() {
        return invoForm;
    }

    /**
     * 设置发票形式
     */
    public void setInvoForm(String invoForm) {
        this.invoForm = invoForm == null ? null : invoForm.trim();
    }

    public String getInvoCatgType() {
        return invoCatgType;
    }

    public void setInvoCatgType(String invoCatgType) {
        this.invoCatgType = invoCatgType;
    }

    /**
     * 获取发票抬头
     */
    public String getInvoTitle() {
        return invoTitle;
    }

    /**
     * 设置发票抬头
     */
    public void setInvoTitle(String invoTitle) {
        this.invoTitle = invoTitle == null ? null : invoTitle.trim();
    }

    /**
     * 获取纳税人识别号
     */
    public String getTaxIdentNum() {
        return taxIdentNum;
    }

    /**
     * 设置纳税人识别号
     */
    public void setTaxIdentNum(String taxIdentNum) {
        this.taxIdentNum = taxIdentNum == null ? null : taxIdentNum.trim();
    }

    /**
     * 获取注册地址
     */
    public String getRegistAddress() {
        return registAddress;
    }

    /**
     * 设置注册地址
     */
    public void setRegistAddress(String registAddress) {
        this.registAddress = registAddress == null ? null : registAddress.trim();
    }

    /**
     * 获取注册电话
     */
    public String getRegistTel() {
        return registTel;
    }

    /**
     * 设置注册电话
     */
    public void setRegistTel(String registTel) {
        this.registTel = registTel == null ? null : registTel.trim();
    }

    /**
     * 获取开户银行
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 设置开户银行
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * 获取银行账户
     */
    public String getBankAccNum() {
        return bankAccNum;
    }

    /**
     * 设置银行账户
     */
    public void setBankAccNum(String bankAccNum) {
        this.bankAccNum = bankAccNum == null ? null : bankAccNum.trim();
    }

    /**
     * 获取是否默认
     */
    public String getDefaultFlag() {
        return defaultFlag;
    }

    /**
     * 设置是否默认
     */
    public void setDefaultFlag(String defaultFlag) {
        this.defaultFlag = defaultFlag == null ? null : defaultFlag.trim();
    }

    /**
     * 获取收件人
     */
    public String getReceName() {
        return receName;
    }

    /**
     * 设置收件人
     */
    public void setReceName(String receName) {
        this.receName = receName == null ? null : receName.trim();
    }

    /**
     * 获取所在地区省
     */
    public String getAddressProv() {
        return addressProv;
    }

    /**
     * 设置所在地区省
     */
    public void setAddressProv(String addressProv) {
        this.addressProv = addressProv == null ? null : addressProv.trim();
    }

    /**
     * 获取所在地区市
     */
    public String getAddressCity() {
        return addressCity;
    }

    /**
     * 设置所在地区市
     */
    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity == null ? null : addressCity.trim();
    }

    /**
     * 获取所在地区区县
     */
    public String getAddressCou() {
        return addressCou;
    }

    /**
     * 设置所在地区区县
     */
    public void setAddressCou(String addressCou) {
        this.addressCou = addressCou == null ? null : addressCou.trim();
    }

    /**
     * 获取详细地址
     */
    public String getAddressDetail() {
        return addressDetail;
    }

    /**
     * 设置详细地址
     */
    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail == null ? null : addressDetail.trim();
    }

    /**
     * 获取邮编
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 设置邮编
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    /**
     * 获取手机号码
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置手机号码
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * 获取物流公司名称
     */
    public String getLogisticsCompName() {
        return logisticsCompName;
    }

    /**
     * 设置物流公司名称
     */
    public void setLogisticsCompName(String logisticsCompName) {
        this.logisticsCompName = logisticsCompName == null ? null : logisticsCompName.trim();
    }

    /**
     * 获取物流单号
     */
    public String getLogisticsNum() {
        return logisticsNum;
    }

    /**
     * 设置物流单号
     */
    public void setLogisticsNum(String logisticsNum) {
        this.logisticsNum = logisticsNum == null ? null : logisticsNum.trim();
    }

    /**
     * 获取申请单号
     */
    public String getApplNum() {
        return applNum;
    }

    /**
     * 设置申请单号
     */
    public void setApplNum(String applNum) {
        this.applNum = applNum == null ? null : applNum.trim();
    }

    /**
     * 获取申请时间
     */
    public OffsetDateTime getApplDate() {
        return applDate;
    }

    /**
     * 设置申请时间
     */
    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
    }

    /**
     * 获取开票日期
     */
    public OffsetDateTime getDrawDate() {
        return drawDate;
    }

    /**
     * 设置开票日期
     */
    public void setDrawDate(OffsetDateTime drawDate) {
        this.drawDate = drawDate;
    }

    /**
     * 获取开票金额
     */
    public Double getDrawAmount() {
        return drawAmount;
    }

    /**
     * 设置开票金额
     */
    public void setDrawAmount(Double drawAmount) {
        this.drawAmount = drawAmount;
    }

    /**
     * 获取发票状态
     */
    public String getInvoState() {
        return invoState;
    }

    /**
     * 设置发票状态
     */
    public void setInvoState(String invoState) {
        this.invoState = invoState == null ? null : invoState.trim();
    }

    /**
     * 获取作废备注
     */
    public String getCancelRemarks() {
        return cancelRemarks;
    }

    /**
     * 设置作废备注
     */
    public void setCancelRemarks(String cancelRemarks) {
        this.cancelRemarks = cancelRemarks == null ? null : cancelRemarks.trim();
    }

    public String getDzInvoUrl() {
        return dzInvoUrl;
    }

    public void setDzInvoUrl(String dzInvoUrl) {
        this.dzInvoUrl = dzInvoUrl;
    }

    public String getDzInvoName() {
        return dzInvoName;
    }

    public void setDzInvoName(String dzInvoName) {
        this.dzInvoName = dzInvoName;
    }
}
