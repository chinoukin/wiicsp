package com.wisea.cultivar.plant.po.oritrapla;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *  平台信息管理
 * @author wzx
 *
 */
@ApiModel("平台信息管理Po")
public class WebPlatfInfoMageAddPo {

	@ApiModelProperty("公司名称")
    private String orgName;

	@ApiModelProperty("联系电话")
    private String contTel;

	@ApiModelProperty("联系地址")
    private String address;

	@ApiModelProperty("版权所有")
    private String copyright;

	@ApiModelProperty("公司介绍")
    private String introduce;

	@ApiModelProperty("用户服务协议(注册协议时不能为空,其它接口该字段不传值)")
    private String userSerAgreement;
	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getContTel() {
		return contTel;
	}

	public void setContTel(String contTel) {
		this.contTel = contTel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCopyright() {
		return copyright;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getUserSerAgreement() {
		return userSerAgreement;
	}

	public void setUserSerAgreement(String userSerAgreement) {
		this.userSerAgreement = userSerAgreement;
	}

}
