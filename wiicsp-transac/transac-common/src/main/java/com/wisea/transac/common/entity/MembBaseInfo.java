package com.wisea.transac.common.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.List;

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

	@ApiModelProperty(value="会员ID(如果是采购员或者销售员显示父节点会员ID)")
    @JsonSerialize(using = IdSerializer.class)
	private Long membId;// 会员ID

	@ApiModelProperty(value="用户名(当前ID的登录用户名)")
    private String loginName;

	@ApiModelProperty(value="用户来源区分(0:总运营平台用户1:批发市场用户2:其他(小程序/商家app用户))")
	private String userSourceType;

	@ApiModelProperty(value="注册手机号")
    private String registTel;

	@ApiModelProperty(value="注册时间")
    private OffsetDateTime registDate;

	@ApiModelProperty(value="会员昵称")
	private String petName;

	@ApiModelProperty("姓名 (当前ID的会员表中的姓名)")
	private String contName;

	@ApiModelProperty("销售员员工姓名(如果是销售员账户显示关联表中的员工姓名,如果是主账户则显示会员表中的姓名)")
	private String saleName;

	@ApiModelProperty("采购员工姓名(如果是采购员账户显示关联表中的员工姓名,如果是主账户则显示会员表中的姓名)")
	private String purchaseName;

	@ApiModelProperty(value="LOGO")
	private String logoUrl;

	@ApiModelProperty(value="会员类型(0:企业1:个体户2:个人)")
	private String membType;

	@ApiModelProperty(value="会员的状态(acct_state0:正常1:冻结)")
    private String acctState;

	@ApiModelProperty(value="会员区分(0:普通会员1:采购员2:销售员3:即使销售员又是采购员)")
	private String membClass;

	@ApiModelProperty(value="是否商家(agent_flag 0:是1:否)如果有父节点显示父节点的状态, 如果没有显示本身的状态")
	private String agentFlag;

	@ApiModelProperty(value="采购员ID(采购员工管理的ID和用户会员ID无关)")
	private String purId;

	@ApiModelProperty(value="采购员关联状态(0:正在关联1:正常采购2:关联失败3:解除绑定)")
	private String purTeamState;

	@ApiModelProperty(value="采购员是否设置成管理员(sf_admin_flag(0:是1:否))")
	private String purSfAdminFlag;

	@ApiModelProperty(value="销售员ID(销售员工信息管理的ID和用户会员ID无关)")
	private String saleId;

	@ApiModelProperty(value="销售员关联状态(0:正在关联1:正常采购2:关联失败3:解除绑定)")
	private String saleTeamState;
	@ApiModelProperty(value="销售员是否设置成管理员(sf_admin_flag(0:是1:否))")
	private String saleSfAdminFlag;
	/**  当前账号的企业,个体工商,实人认证信息 开始  **/
	@ApiModelProperty(value="审核状态区分[如果有父节点 显示父节点信息](0:企业认证1:个体户认证2:个人实名认证3:无认证)优先级顺序：企业>个体>个人")
	private String authType;

	@ApiModelProperty(value="审核名称[如果有父节点 显示父节点信息](如果个人认证显示姓名,个体和企业显示企业名称)优先级顺序：企业>个体>个人")
	private String authName;

	@ApiModelProperty(value="审核状态区分[会员自身的审核信息](0:企业认证1:个体户认证2:个人实名认证3:无认证)优先级顺序：企业>个体>个人")
	private String selfAuthType;

	@ApiModelProperty(value="审核名称[会员自身名称](如果个人认证显示姓名,个体和企业显示企业名称)优先级顺序：企业>个体>个人")
	private String selfAuthName;

	@ApiModelProperty(value="是否设置用户名(0:是(已经设置过)1：否)")
    private String loginNameSetFlag;

	@ApiModelProperty(value="是否设置密码(0:是(已经设置过)1：否)")
    private String passwordSetFlag;
	/**  当前账号的企业,个体工商,实人认证信息 结束  **/
	/** ------会员基本信息  结束-------------------------- **/
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
	@ApiModelProperty(value="企业入网商编",hidden = false)
    private String merchantNo;
	@ApiModelProperty("批发市场ID，如果为空则用户为平台运营人员，如果不为空则为市场人员")
	private Long marketId;
	@ApiModelProperty("批发市场名称")
	private String marketName;
	@ApiModelProperty("微信小程序openId")
	private String wechatOpenId;
	/** -----------产地信息----
	 * -------------- **/
	@ApiModelProperty("是否产地会员类型(0:是产地会员0以外的非产地会员)(如果是销售员返回父节点的信息)")
	private String localityMembType;
	@ApiModelProperty(value="基地ID(如果是销售员返回父节点的信息)")
    @JsonSerialize(using = IdSerializer.class)
	private Long baseId;
	/**
	 * 用户ID(如果是子账户为子账户ID会员为会员ID)
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 用户ID(如果是子账户为子账户ID会员为会员ID)
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 会员ID(如果是采购员或者销售员显示父节点会员ID)
	 */
	public Long getMembId() {
		return membId;
	}
	/**
	 * 会员ID(如果是采购员或者销售员显示父节点会员ID)
	 */
	public void setMembId(Long membId) {
		this.membId = membId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
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
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}

	/**
	 * 姓名 (当前ID的会员表中的姓名)
	 */
	public String getContName() {
		return contName;
	}
	/**
	 * 姓名 (当前ID的会员表中的姓名)
	 */
	public void setContName(String contName) {
		this.contName = contName;
	}

	public String getLogoUrl() {
		return logoUrl;
	}
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}
	/**
	 * 会员类型(0:企业1:个体户2:个人)
	 */
	public String getMembType() {
		return membType;
	}
	/**
	 * 会员类型(0:企业1:个体户2:个人)
	 */
	public void setMembType(String membType) {
		this.membType = membType;
	}
	/**
	 * 会员的状态(acct_state0:正常1:冻结)
	 */
	public String getAcctState() {
		return acctState;
	}
	/**
	 * 会员的状态(acct_state0:正常1:冻结)
	 */
	public void setAcctState(String acctState) {
		this.acctState = acctState;
	}
	/**
	 * 账期支付开通状态
	 */
	public String getApFlag() {
		return apFlag;
	}
	/**
	 * 账期支付开通状态
	 */
	public void setApFlag(String apFlag) {
		this.apFlag = apFlag;
	}
	/**
	 * 是否可以能开发票(nfkfp_type0:能1:不能)
	 */
	public String getNfkfpType() {
		return nfkfpType;
	}
	/**
	 * 是否可以能开发票(nfkfp_type0:能1:不能)
	 */
	public void setNfkfpType(String nfkfpType) {
		this.nfkfpType = nfkfpType;
	}
	/**
	 * 发票内容
	 */
	public String getInvoContent() {
		return invoContent;
	}
	/**
	 * 发票内容
	 */
	public void setInvoContent(String invoContent) {
		this.invoContent = invoContent;
	}
	/**
	 * 发票类型,多个用逗号分隔（字典值invo_type）
	 */
	public String getInvoType() {
		return invoType;
	}
	/**
	 * 发票类型,多个用逗号分隔（字典值invo_type）
	 */
	public void setInvoType(String invoType) {
		this.invoType = invoType;
	}
	/**
	 * 发票类型列表
	 */
	public List<String> getInvoList() {
		return invoList;
	}
	/**
	 * 发票类型列表
	 */
	public void setInvoList(List<String> invoList) {
		this.invoList = invoList;
	}
	/**
	 * 会员区分(0:普通会员1:采购员2:销售员3:即使销售员又是采购员)
	 */
	public String getMembClass() {
		return membClass;
	}
	/**
	 * 会员区分(0:普通会员1:采购员2:销售员3:即使销售员又是采购员)
	 */
	public void setMembClass(String membClass) {
		this.membClass = membClass;
	}
	/**
	 * 采购员ID(采购员工管理的ID和用户会员ID无关)
	 */
	public String getPurId() {
		return purId;
	}
	/**
	 * 采购员ID(采购员工管理的ID和用户会员ID无关)
	 */
	public void setPurId(String purId) {
		this.purId = purId;
	}
	/**
	 * 销售员ID(销售员工信息管理的ID和用户会员ID无关)
	 */
	public String getSaleId() {
		return saleId;
	}
	/**
	 * 销售员ID(销售员工信息管理的ID和用户会员ID无关)
	 */
	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}
	/**
	 * 审核状态区分(0:企业认证1:个体户认证2:个人实名认证3:无认证)优先级顺序：企业>个体>个人
	 */
	public String getAuthType() {
		return authType;
	}
	/**
	 * 审核状态区分(0:企业认证1:个体户认证2:个人实名认证3:无认证)优先级顺序：企业>个体>个人
	 */
	public void setAuthType(String authType) {
		this.authType = authType;
	}
	/**
	 * 审核名称(如果个人认证显示姓名,个体和企业显示企业名称)优先级顺序：企业>个体>个人
	 */
	public String getAuthName() {
		return authName;
	}
	/**
	 * 审核名称(如果个人认证显示姓名,个体和企业显示企业名称)优先级顺序：企业>个体>个人
	 */
	public void setAuthName(String authName) {
		this.authName = authName;
	}
	/**
	 * 企业入网商编
	 */
	public String getMerchantNo() {
		return merchantNo;
	}
	/**
	 * 企业入网商编
	 */
	public void setMerchantNo(String merchantNo) {
		this.merchantNo = merchantNo;
	}
	/**
	 * 销售员员工姓名(如果是销售员账户显示关联表中的员工姓名,如果是主账户则显示会员表中的姓名)
	 */
	public String getSaleName() {
		return saleName;
	}
	/**
	 * 销售员员工姓名(如果是销售员账户显示关联表中的员工姓名,如果是主账户则显示会员表中的姓名)
	 */
	public void setSaleName(String saleName) {
		this.saleName = saleName;
	}
	/**
	 * 采购员工姓名(如果是采购员账户显示关联表中的员工姓名,如果是主账户则显示会员表中的姓名)
	 */
	public String getPurchaseName() {
		return purchaseName;
	}
	/**
	 * 采购员工姓名(如果是采购员账户显示关联表中的员工姓名,如果是主账户则显示会员表中的姓名)
	 */
	public void setPurchaseName(String purchaseName) {
		this.purchaseName = purchaseName;
	}
	/**
	 * 用户来源区分(0:总运营平台用户1:批发市场用户2:其他(小程序/商家app用户))
	 */
	public String getUserSourceType() {
		return userSourceType;
	}
	/**
	 * 用户来源区分(0:总运营平台用户1:批发市场用户2:其他(小程序/商家app用户))
	 */
	public void setUserSourceType(String userSourceType) {
		this.userSourceType = userSourceType;
	}
	/**
	 * 采购员是否设置成管理员(sf_admin_flag(0:是1:否))
	 */
	public String getPurSfAdminFlag() {
		return purSfAdminFlag;
	}
	/**
	 * 采购员是否设置成管理员(sf_admin_flag(0:是1:否))
	 */
	public void setPurSfAdminFlag(String purSfAdminFlag) {
		this.purSfAdminFlag = purSfAdminFlag;
	}
	/**
	 * 销售员是否设置成管理员(sf_admin_flag(0:是1:否))
	 */
	public String getSaleSfAdminFlag() {
		return saleSfAdminFlag;
	}
	/**
	 * 销售员是否设置成管理员(sf_admin_flag(0:是1:否))
	 */
	public void setSaleSfAdminFlag(String saleSfAdminFlag) {
		this.saleSfAdminFlag = saleSfAdminFlag;
	}
	public String getAgentFlag() {
		return agentFlag;
	}
	public void setAgentFlag(String agentFlag) {
		this.agentFlag = agentFlag;
	}

	public Long getMarketId() {
		return marketId;
	}

	public void setMarketId(Long marketId) {
		this.marketId = marketId;
	}
	public String getMarketName() {
		return marketName;
	}
	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}
	public String getWechatOpenId() {
		return wechatOpenId;
	}
	public void setWechatOpenId(String wechatOpenId) {
		this.wechatOpenId = wechatOpenId;
	}
	public String getLocalityMembType() {
		return localityMembType;
	}
	public void setLocalityMembType(String localityMembType) {
		this.localityMembType = localityMembType;
	}
	public Long getBaseId() {
		return baseId;
	}
	public void setBaseId(Long baseId) {
		this.baseId = baseId;
	}
	public String getSelfAuthType() {
		return selfAuthType;
	}
	public void setSelfAuthType(String selfAuthType) {
		this.selfAuthType = selfAuthType;
	}
	public String getSelfAuthName() {
		return selfAuthName;
	}
	public void setSelfAuthName(String selfAuthName) {
		this.selfAuthName = selfAuthName;
	}
	public String getLoginNameSetFlag() {
		return loginNameSetFlag;
	}
	public void setLoginNameSetFlag(String loginNameSetFlag) {
		this.loginNameSetFlag = loginNameSetFlag;
	}
	public String getPasswordSetFlag() {
		return passwordSetFlag;
	}
	public void setPasswordSetFlag(String passwordSetFlag) {
		this.passwordSetFlag = passwordSetFlag;
	}
	public String getPurTeamState() {
		return purTeamState;
	}
	public void setPurTeamState(String purTeamState) {
		this.purTeamState = purTeamState;
	}
	public String getSaleTeamState() {
		return saleTeamState;
	}
	public void setSaleTeamState(String saleTeamState) {
		this.saleTeamState = saleTeamState;
	}
}
