package com.wisea.cultivar.common.entity.tp;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModelProperty;

/**
 * 会员基础信息
 *
 * @author wangh(wisea)
 *
 * @date 2018年10月10日
 * @version 1.0
 */
public class MembBaseInfo implements Serializable{


    /**
	 *
	 */
	private static final long serialVersionUID = 5496215684306621234L;

	/** ------会员基本信息   开始-------------------------- **/
	@ApiModelProperty(value="用户ID(如果是子账户为子账户ID会员为会员ID)")
	@JsonSerialize(using = IdSerializer.class)
	private Long id;//用户id（子账户或者会员ID）

	@ApiModelProperty(value="会员ID(如果是子账户则为空)")
	@JsonSerialize(using = IdSerializer.class)
	private Long membId;// 会员ID

	@ApiModelProperty(value="用户名")
    private String userName;

	@ApiModelProperty(value="注册手机号")
    private String registTel;

	@ApiModelProperty(value="注册时间")
    private OffsetDateTime registDate;

	@ApiModelProperty(value="会员昵称")
	private String petName;

	@ApiModelProperty(value="会员头像")
	private String url;

	@ApiModelProperty(value="会员类型(member_type0:个人1:企业)")
	private String memberType;

	@ApiModelProperty(value="企业入网商编",hidden = false)
    private String merchantNo;

	@ApiModelProperty(value="企业入网绑定手机号",hidden = false)
	private String bdTel;
	/** ------会员基本信息  结束-------------------------- **/
	/** ------会员状态信息   开始-------------------------- **/
	@ApiModelProperty(value="会员的企业认证状态(entp_auth_state_type0:已认证1:未认证)")
    private String entpAuthStateType;

	@ApiModelProperty(value="会员是否是代理商(agent_flag0:是1:否)")
    private String agentFlag;

	@ApiModelProperty(value="会员的状态(acct_state0:正常1:冻结)")
    private String acctState;
	/** ------会员状态信息   结束-------------------------- **/
	/** ------会员企业认证信息   开始-------------------------- **/
	@ApiModelProperty(value="企业类型(comp_type0:采购商认证1:供货商认证)")
	private String compType;

	@ApiModelProperty(value="审核中或者驳回的企业名称")
    private String authCompName;

	@ApiModelProperty(value="审核中或者驳回的企业ID")
	@JsonSerialize(using = IdSerializer.class)
    private Long authCompId;

	@ApiModelProperty(value="审核通过的企业名称")
    private String compName;

	@ApiModelProperty(value="审核通过的企业Id")
	@JsonSerialize(using = IdSerializer.class)
    private Long compId;
	/** ------会员企业认证信息   结束-------------------------- **/
	/** ------会员个人热证信息   开始-------------------------- **/
	@ApiModelProperty(value="认证通过的个人认证信息ID")
	@JsonSerialize(using = IdSerializer.class)
	private Long personId;
	@ApiModelProperty(value="认证通过的个人认证信息姓名")
	private String personName;
	@ApiModelProperty(value="审核中的个人认证信息ID")
	@JsonSerialize(using = IdSerializer.class)
	private Long authPersonId;
	@ApiModelProperty(value="审核中的个人认证信息姓名")
	private String authPersonName;
	/** ------会员个人热证信息   结束-------------------------- **/
	@ApiModelProperty(value="账期支付开通状态")
	private String apFlag;
	/** -------------发票设置信息----------开始--------- **/
	@ApiModelProperty(value="是否可以能开发票(nfkfp_type0:能1:不能)")
	private String nfkfpType;//是否可以能开发票(nfkfp_type0:能1:不能)
	@ApiModelProperty(value="发票内容")
	private String invoContent;// 发票内容
	@ApiModelProperty(value="发票类型,多个用逗号分隔（字典值invo_type）")
	private String invoType;// 发票类型（多个用逗号分隔）
	@ApiModelProperty(value="发票类型列表")
	private List<String> invoList;
	/** -------------发票设置信息----------结束--------- **/

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRegistTel() {
		return registTel;
	}

	public void setRegistTel(String registTel) {
		this.registTel = registTel;
	}

	public OffsetDateTime getRegistDate() {
		return registDate;
	}

	public void setRegistDate(OffsetDateTime registDate) {
		this.registDate = registDate;
	}

	public String getEntpAuthStateType() {
		return entpAuthStateType;
	}

	public void setEntpAuthStateType(String entpAuthStateType) {
		this.entpAuthStateType = entpAuthStateType;
	}

	public String getAgentFlag() {
		return agentFlag;
	}

	public void setAgentFlag(String agentFlag) {
		this.agentFlag = agentFlag;
	}

	public String getAcctState() {
		return acctState;
	}

	public void setAcctState(String acctState) {
		this.acctState = acctState;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAuthCompName() {
		return authCompName;
	}

	public void setAuthCompName(String authCompName) {
		this.authCompName = authCompName;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public Long getAuthCompId() {
		return authCompId;
	}

	public void setAuthCompId(Long authCompId) {
		this.authCompId = authCompId;
	}

	public Long getCompId() {
		return compId;
	}

	public void setCompId(Long compId) {
		this.compId = compId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMembId() {
		return membId;
	}

	public void setMembId(Long membId) {
		this.membId = membId;
	}

	public String getMerchantNo() {
		return merchantNo;
	}

	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}

	public String getBdTel() {
		return bdTel;
	}

	public void setBdTel(String bdTel) {
		this.bdTel = bdTel;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public Long getAuthPersonId() {
		return authPersonId;
	}

	public void setAuthPersonId(Long authPersonId) {
		this.authPersonId = authPersonId;
	}

	public String getApFlag() {
		return apFlag;
	}

	public void setApFlag(String apFlag) {
		this.apFlag = apFlag;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getAuthPersonName() {
		return authPersonName;
	}

	public void setAuthPersonName(String authPersonName) {
		this.authPersonName = authPersonName;
	}

	public String getNfkfpType() {
		return nfkfpType;
	}

	public void setNfkfpType(String nfkfpType) {
		this.nfkfpType = nfkfpType;
	}

	public String getInvoContent() {
		return invoContent;
	}

	public void setInvoContent(String invoContent) {
		this.invoContent = invoContent;
	}

	public String getInvoType() {
		return invoType;
	}

	public void setInvoType(String invoType) {
		this.invoType = invoType;
	}

	public List<String> getInvoList() {
		return invoList;
	}

	public void setInvoList(List<String> invoList) {
		this.invoList = invoList;
	}

	public String getCompType() {
		return compType;
	}

	public void setCompType(String compType) {
		this.compType = compType;
	}
}
