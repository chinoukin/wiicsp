package com.wisea.cultivar.common.vo.tp.memb;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 用户注册信息详情VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年4月23日
 * @version 1.0
 */
@ApiModel("用户注册信息详情VO")
public class UserRegisterInfoVo {

	@ApiModelProperty(value="ID")
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
	 * 联系人姓名
	 */
    @ApiModelProperty(value = "联系人姓名")
    private String  contactsName;//联系人姓名
    /**
	 * 企业名称
	 */
    @ApiModelProperty(value = "注册企业名称")
    private String  compName;//企业名称
    /**
	 * 会员类型
	 */
    @ApiModelProperty(value = "会员类型(0：个人1:企业)")
    private String memberType;//会员类型(0：个人1:企业)

    /**
     * 所在地区-省
     */
    @ApiModelProperty(value = "所在地区-省")
    private String areaProv;

    /**
     * 所在地区-市
     */
    @ApiModelProperty(value = "所在地区-市")
    private String areaCity;

    /**
     * 所在地区-区县
     */
    @ApiModelProperty(value = "所在地区-区县")
    private String areaCou;

    @ApiModelProperty(value = "注册时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private  OffsetDateTime registDate;
    @ApiModelProperty(value = "认证状态(0:已认证1：未认证)")
    private String entpAuthStateType;

    /**
     * 是否代理商标记(0	:是1:否)[agent_flag]
     */
    @ApiModelProperty(value = "是否是代理商(0:是1:否)")
    private String agentFlag;

    /**
     * 账户状态(0:正常1:冻结)[acct_state]
     */
    @ApiModelProperty(value = "账户状态(0:正常1:冻结)")
    private String acctState;
    @ApiModelProperty(value = "能否开发票类型(0:能1:不能)")
    private String nfkfpType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getContactsName() {
		return contactsName;
	}

	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
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

	public String getAreaProv() {
		return areaProv;
	}

	public void setAreaProv(String areaProv) {
		this.areaProv = areaProv;
	}

	public String getAreaCity() {
		return areaCity;
	}

	public void setAreaCity(String areaCity) {
		this.areaCity = areaCity;
	}

	public String getAreaCou() {
		return areaCou;
	}

	public void setAreaCou(String areaCou) {
		this.areaCou = areaCou;
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

	public String getNfkfpType() {
		return nfkfpType;
	}

	public void setNfkfpType(String nfkfpType) {
		this.nfkfpType = nfkfpType;
	}
}
