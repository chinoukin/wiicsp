package com.wisea.cultivar.common.po.tp.memb;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModelProperty;

/**
 * 注册会员信息
 * MembInfoRegisterPo
 * 2018/09/18 14:36:47
 */
public class MembInfoRegisterPo {

    /**
     * 用户名
     */
    @Check(test = { "maxLength","required"}, mixLength = 255)
    @ApiModelProperty(value = "用户名")
    private String userName;
    /**
     * 注册手机号
     */
    @Check(test = { "maxLength","required"}, mixLength = 32)
    @ApiModelProperty(value = "注册手机号")
    private String registTel;
	/**
	 * 手机验证码
	 */
    @Check(test = {"required"})
    @ApiModelProperty(value = "手机验证码")
    private String mobileCode;
    /**
	 * 密码
	 */
    @Check(test = {"required"})
    @ApiModelProperty(value = "密码")
    private String password;
    /**
	 * 联系人姓名
	 */
    @Check(test = "logic", logic = "'1'.equals(#memberType)?#isNotEmpty(#contactsName):true", logicMsg = "会员类型是0(个人)的情况联系人姓名不能为空")
    @ApiModelProperty(value = "联系人姓名")
    private String  contactsName;//联系人姓名
    /**
	 * 企业名称
	 */
    @Check(test = "logic", logic = "'1'.equals(#memberType)?#isNotEmpty(#compName):true", logicMsg = "会员类型是1(企业)的情况公司名称不能为空")
    @ApiModelProperty(value = "企业名称")
    private String  compName;//企业名称
    /**
	 * 会员类型
	 */
    @Check(test = {"required", "liveable"}, liveable = {"0", "1"}, liveableMsg = "会员类型只能为0或者1")
    @ApiModelProperty(value = "会员类型(0：个人1:企业)")
    private String memberType;//会员类型(0：个人1:企业)

    /**
     * 所在地区-省
     */
    @Check(test = {"required"})
    @ApiModelProperty(value = "所在地区-省")
    private String areaProv;

    /**
     * 所在地区-市
     */
    @Check(test = {"required"})
    @ApiModelProperty(value = "所在地区-市")
    private String areaCity;

    /**
     * 所在地区-区县
     */
    @Check(test = {"required"})
    @ApiModelProperty(value = "所在地区-区县")
    private String areaCou;


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
	public String getMobileCode() {
		return mobileCode;
	}
	public void setMobileCode(String mobileCode) {
		this.mobileCode = mobileCode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
}
