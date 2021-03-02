package com.wisea.cultivar.common.vo.tp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * MembInfoGetVo
 * 2018/10/08 14:07:27
 */
public class MembInfoGetVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 注册手机号
     */
    @ApiModelProperty(value = "注册手机号")
    private String registTel;

    /**
     * 注册时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "注册时间")
    private OffsetDateTime registDate;

    /**
     * 认证状态类型
     */
    @ApiModelProperty(value = "认证状态类型(0:已认证1未认证)")
    private String entpAuthStateType;

    /**
     * 是否代理商标记
     */
    @ApiModelProperty(value = "是否代理商标记(0:是1:否)")
    private String agentFlag;

    /**
     * 账户状态
     */
    @ApiModelProperty(value = "账户状态(0:正常1:冻结)")
    private String acctState;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "昵称")
    private String petName;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String url;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标志
     */
    @ApiModelProperty(value = "删除标志")
    private String delFlag;

    /**
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称")
    private String compName;
    /**
     * 会员类型
     */
    @ApiModelProperty(value = "会员类型(0:个人1:企业)")
    private String memberType;


    /**
     * 账期支付开通状态
     **/
    @ApiModelProperty(value = "账期支付开通状态")
    private String apFlag;

    /**
     * 注册地省份信息
     */
    @ApiModelProperty(value = "注册地省份信息")
    private String registAddressProv;
    /**
     * 注册地市信息
     */
    @ApiModelProperty(value = "注册地市信息")
    private String registAddressCity;
    /**
     * 注册地县信息
     */
    @ApiModelProperty(value = "注册地县信息")
    private String registAddressCou;

    @ApiModelProperty(value = "会员ID")
    private String membId;

    @ApiModelProperty("联系人")
    private String contactsName;

    @ApiModelProperty("联系邮箱")
    private String contactsEmail;

    @ApiModelProperty(value = "注册地省份信息名称")
    private String registAddressProvName;
    /**
     * 注册地市信息
     */
    @ApiModelProperty(value = "注册地市名称")
    private String registAddressCityName;
    /**
     * 注册地县信息
     */
    @ApiModelProperty(value = "注册地县信息名称")
    private String registAddressCouName;

    public String getRegistAddressProvName() {
        return registAddressProvName;
    }

    public void setRegistAddressProvName(String registAddressProvName) {
        this.registAddressProvName = registAddressProvName;
    }

    public String getRegistAddressCityName() {
        return registAddressCityName;
    }

    public void setRegistAddressCityName(String registAddressCityName) {
        this.registAddressCityName = registAddressCityName;
    }

    public String getRegistAddressCouName() {
        return registAddressCouName;
    }

    public void setRegistAddressCouName(String registAddressCouName) {
        this.registAddressCouName = registAddressCouName;
    }

    public String getContactsEmail() {
        return contactsEmail;
    }

    public void setContactsEmail(String contactsEmail) {
        this.contactsEmail = contactsEmail;
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

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
     * 获取用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取注册手机号
     */
    public String getRegistTel() {
        return registTel;
    }

    /**
     * 设置注册手机号
     */
    public void setRegistTel(String registTel) {
        this.registTel = registTel == null ? null : registTel.trim();
    }

    /**
     * 获取注册时间
     */
    public OffsetDateTime getRegistDate() {
        return registDate;
    }

    /**
     * 设置注册时间
     */
    public void setRegistDate(OffsetDateTime registDate) {
        this.registDate = registDate;
    }

    /**
     * 获取企业认证状态类型
     */
    public String getEntpAuthStateType() {
        return entpAuthStateType;
    }

    /**
     * 设置企业认证状态类型
     */
    public void setEntpAuthStateType(String entpAuthStateType) {
        this.entpAuthStateType = entpAuthStateType == null ? null : entpAuthStateType.trim();
    }

    /**
     * 获取是否代理商标记
     */
    public String getAgentFlag() {
        return agentFlag;
    }

    /**
     * 设置是否代理商标记
     */
    public void setAgentFlag(String agentFlag) {
        this.agentFlag = agentFlag == null ? null : agentFlag.trim();
    }

    /**
     * 获取账户状态
     */
    public String getAcctState() {
        return acctState;
    }

    /**
     * 设置账户状态
     */
    public void setAcctState(String acctState) {
        this.acctState = acctState == null ? null : acctState.trim();
    }

    /**
     * 获取昵称
     */
    public String getPetName() {
        return petName;
    }

    /**
     * 设置昵称
     */
    public void setPetName(String petName) {
        this.petName = petName == null ? null : petName.trim();
    }

    /**
     * 获取头像
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置头像
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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
     * 获取删除标志
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标志
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getApFlag() {
        return apFlag;
    }

    public void setApFlag(String apFlag) {
        this.apFlag = apFlag;
    }

    public String getRegistAddressProv() {
        return registAddressProv;
    }

    public void setRegistAddressProv(String registAddressProv) {
        this.registAddressProv = registAddressProv;
    }

    public String getRegistAddressCity() {
        return registAddressCity;
    }

    public void setRegistAddressCity(String registAddressCity) {
        this.registAddressCity = registAddressCity;
    }

    public String getRegistAddressCou() {
        return registAddressCou;
    }

    public void setRegistAddressCou(String registAddressCou) {
        this.registAddressCou = registAddressCou;
    }

	public String getMembId() {
		return membId;
	}

	public void setMembId(String membId) {
		this.membId = membId;
	}
}
