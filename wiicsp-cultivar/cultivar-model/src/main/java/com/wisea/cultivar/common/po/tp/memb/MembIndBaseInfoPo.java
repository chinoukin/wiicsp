package com.wisea.cultivar.common.po.tp.memb;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 个人用户基本信息的保存PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年4月16日
 * @version 1.0
 */
@ApiModel("个人用户基本信息的保存PO")
public class MembIndBaseInfoPo {

	@ApiModelProperty(value = "会员ID",hidden = true)
	private Long id;

	/**
     * 姓名
     */
	@Check(test = { "maxLength","required"}, mixLength = 100)
    @ApiModelProperty(value = "姓名")
    private String name;

    /**
     * 性别类型
     */
	@Check(test = {"required"})
    @ApiModelProperty(value = "性别类型")
    private String sexType;

    /**
     * 固定电话
     */
    @ApiModelProperty(value = "固定电话")
    private String fixedTel;

    /**
     * 业务联系邮箱
     */
    @ApiModelProperty(value = "业务联系邮箱")
    private String contactsEmail;

    /**
     * 所在地区省
     */
    @Check(test = {"required","maxLength"},mixLength=25)
    @ApiModelProperty(value = "所在地区省")
    private String areaProv;

    /**
     * 所在地区市
     */
    @Check(test = {"required","maxLength"},mixLength=25)
    @ApiModelProperty(value = "所在地区市")
    private String areaCity;

    /**
     * 所在地区区县
     */
    @Check(test = {"required","maxLength"},mixLength=25)
    @ApiModelProperty(value = "所在地区区县")
    private String areaCou;

    /**
     * 详细地址
     */
    @Check(test = {"required","maxLength"},mixLength=250)
    @ApiModelProperty(value = "详细地址")
    private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSexType() {
		return sexType;
	}

	public void setSexType(String sexType) {
		this.sexType = sexType;
	}

	public String getFixedTel() {
		return fixedTel;
	}

	public void setFixedTel(String fixedTel) {
		this.fixedTel = fixedTel;
	}

	public String getContactsEmail() {
		return contactsEmail;
	}

	public void setContactsEmail(String contactsEmail) {
		this.contactsEmail = contactsEmail;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
