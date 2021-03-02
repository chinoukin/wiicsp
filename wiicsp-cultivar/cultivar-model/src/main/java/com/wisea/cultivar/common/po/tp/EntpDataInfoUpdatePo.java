package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * EntpDataInfoUpdatePo
 * 2018/09/18 14:36:47
 */
public class EntpDataInfoUpdatePo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 会员id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "会员id")
    private Long membId;

    /**
     * 企业名称
     */
    @Check(test = { "maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "企业名称")
    private String compName;

    /**
     * 注册地址省
     */
    @Check(test = { "maxLength" }, mixLength = 10)
    @ApiModelProperty(value = "注册地址省")
    private String registAddressProv;

    /**
     * 注册地址市
     */
    @Check(test = { "maxLength" }, mixLength = 10)
    @ApiModelProperty(value = "注册地址市")
    private String registAddressCity;

    /**
     * 注册地址区县
     */
    @Check(test = { "maxLength" }, mixLength = 10)
    @ApiModelProperty(value = "注册地址区县")
    private String registAddressCou;

    /**
     * 详细地址
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "详细地址")
    private String address;

    /**
     * 注册资本
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "注册资本")
    private Double registCapital;

    /**
     * 成立日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "成立日期")
    private OffsetDateTime estaDate;

    /**
     * 统一社会信用代码
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "统一社会信用代码")
    private String ctscc;

    /**
     * 法人代表
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "法人代表")
    private String legalPerson;

    /**
     * 登记机关
     */
    @Check(test = { "maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "登记机关")
    private String registAuth;

    /**
     * 企业类型
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "企业类型")
    private String compType;

    /**
     * 营业开始日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "营业开始日期")
    private OffsetDateTime businessStartDate;

    /**
     * 营业结束日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "营业结束日期")
    private OffsetDateTime businessEndDate;

    /**
     * 经营范围
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "经营范围")
    private String operateRange;

    /**
     * 企业邮箱
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "企业邮箱")
    private String compEmail;

    /**
     * 联系人
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "联系人")
    private String contacts;

    /**
     * 企业电话
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "企业电话")
    private String compTel;

    /**
     * 企业微博地址
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "企业微博地址")
    private String compMicroBlog;

    /**
     * 企业介绍
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "企业介绍")
    private String compIntro;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @Check(test = { "maxLength" }, mixLength = 1)
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取会员id
     */
    public Long getMembId() {
        return membId;
    }

    /**
     * 设置会员id
     */
    public void setMembId(Long membId) {
        this.membId = membId;
    }

    /**
     * 获取企业名称
     */
    public String getCompName() {
        return compName;
    }

    /**
     * 设置企业名称
     */
    public void setCompName(String compName) {
        this.compName = compName == null ? null : compName.trim();
    }

    /**
     * 获取注册地址省
     */
    public String getRegistAddressProv() {
        return registAddressProv;
    }

    /**
     * 设置注册地址省
     */
    public void setRegistAddressProv(String registAddressProv) {
        this.registAddressProv = registAddressProv == null ? null : registAddressProv.trim();
    }

    /**
     * 获取注册地址市
     */
    public String getRegistAddressCity() {
        return registAddressCity;
    }

    /**
     * 设置注册地址市
     */
    public void setRegistAddressCity(String registAddressCity) {
        this.registAddressCity = registAddressCity == null ? null : registAddressCity.trim();
    }

    /**
     * 获取注册地址区县
     */
    public String getRegistAddressCou() {
        return registAddressCou;
    }

    /**
     * 设置注册地址区县
     */
    public void setRegistAddressCou(String registAddressCou) {
        this.registAddressCou = registAddressCou == null ? null : registAddressCou.trim();
    }

    /**
     * 获取详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置详细地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取注册资本
     */
    public Double getRegistCapital() {
        return registCapital;
    }

    /**
     * 设置注册资本
     */
    public void setRegistCapital(Double registCapital) {
        this.registCapital = registCapital;
    }

    /**
     * 获取成立日期
     */
    public OffsetDateTime getEstaDate() {
        return estaDate;
    }

    /**
     * 设置成立日期
     */
    public void setEstaDate(OffsetDateTime estaDate) {
        this.estaDate = estaDate;
    }

    /**
     * 获取统一社会信用代码
     */
    public String getCtscc() {
        return ctscc;
    }

    /**
     * 设置统一社会信用代码
     */
    public void setCtscc(String ctscc) {
        this.ctscc = ctscc == null ? null : ctscc.trim();
    }

    /**
     * 获取法人代表
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /**
     * 设置法人代表
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson == null ? null : legalPerson.trim();
    }

    /**
     * 获取登记机关
     */
    public String getRegistAuth() {
        return registAuth;
    }

    /**
     * 设置登记机关
     */
    public void setRegistAuth(String registAuth) {
        this.registAuth = registAuth == null ? null : registAuth.trim();
    }

    /**
     * 获取企业类型
     */
    public String getCompType() {
        return compType;
    }

    /**
     * 设置企业类型
     */
    public void setCompType(String compType) {
        this.compType = compType == null ? null : compType.trim();
    }

    /**
     * 获取营业开始日期
     */
    public OffsetDateTime getBusinessStartDate() {
        return businessStartDate;
    }

    /**
     * 设置营业开始日期
     */
    public void setBusinessStartDate(OffsetDateTime businessStartDate) {
        this.businessStartDate = businessStartDate;
    }

    /**
     * 获取营业结束日期
     */
    public OffsetDateTime getBusinessEndDate() {
        return businessEndDate;
    }

    /**
     * 设置营业结束日期
     */
    public void setBusinessEndDate(OffsetDateTime businessEndDate) {
        this.businessEndDate = businessEndDate;
    }

    /**
     * 获取经营范围
     */
    public String getOperateRange() {
        return operateRange;
    }

    /**
     * 设置经营范围
     */
    public void setOperateRange(String operateRange) {
        this.operateRange = operateRange == null ? null : operateRange.trim();
    }

    /**
     * 获取企业邮箱
     */
    public String getCompEmail() {
        return compEmail;
    }

    /**
     * 设置企业邮箱
     */
    public void setCompEmail(String compEmail) {
        this.compEmail = compEmail == null ? null : compEmail.trim();
    }

    /**
     * 获取联系人
     */
    public String getContacts() {
        return contacts;
    }

    /**
     * 设置联系人
     */
    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    /**
     * 获取企业电话
     */
    public String getCompTel() {
        return compTel;
    }

    /**
     * 设置企业电话
     */
    public void setCompTel(String compTel) {
        this.compTel = compTel == null ? null : compTel.trim();
    }

    /**
     * 获取企业微博地址
     */
    public String getCompMicroBlog() {
        return compMicroBlog;
    }

    /**
     * 设置企业微博地址
     */
    public void setCompMicroBlog(String compMicroBlog) {
        this.compMicroBlog = compMicroBlog == null ? null : compMicroBlog.trim();
    }

    /**
     * 获取企业介绍
     */
    public String getCompIntro() {
        return compIntro;
    }

    /**
     * 设置企业介绍
     */
    public void setCompIntro(String compIntro) {
        this.compIntro = compIntro == null ? null : compIntro.trim();
    }

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}
