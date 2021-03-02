package com.wisea.cultivar.common.po.tp;

import java.util.List;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * EntpDataInfoPo
 * 2018/09/18 14:36:47
 */
@ApiModel("保存商家信息(不需要审批的部分)PO")
public class EntpDataInfoBasePo {

    /**
     * 企业邮箱
     */
    @Check(test = { "required","maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "企业邮箱")
    private String compEmail;

    /**
     * 联系人
     */
    @Check(test = {"required","maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "企业联系人")
    private String propContacts;

    /**
     * 企业电话
     */
    @Check(test = {"required","maxLength" }, mixLength = 30)
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
    @Check(test = { "maxLength" }, mixLength = 4000)
    @ApiModelProperty(value = "企业介绍")
    private String compIntro;
    /**
     * 企业图片
     */
    @ApiModelProperty(value = "企业图片")
    private List<EntpPictureInsertPo> entpPicList;

	public String getCompEmail() {
		return compEmail;
	}
	public void setCompEmail(String compEmail) {
		this.compEmail = compEmail;
	}
	public String getCompTel() {
		return compTel;
	}
	public void setCompTel(String compTel) {
		this.compTel = compTel;
	}
	public String getCompMicroBlog() {
		return compMicroBlog;
	}
	public void setCompMicroBlog(String compMicroBlog) {
		this.compMicroBlog = compMicroBlog;
	}
	public String getCompIntro() {
		return compIntro;
	}
	public void setCompIntro(String compIntro) {
		this.compIntro = compIntro;
	}
	public List<EntpPictureInsertPo> getEntpPicList() {
		return entpPicList;
	}
	public void setEntpPicList(List<EntpPictureInsertPo> entpPicList) {
		this.entpPicList = entpPicList;
	}
	public String getPropContacts() {
		return propContacts;
	}
	public void setPropContacts(String propContacts) {
		this.propContacts = propContacts;
	}
}
