package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * SubEntpMageInsertPo
 * 2019/12/02 11:02:15
 */
public class SubEntpMageInsertPo {
    /**
     * 分公司名称
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "分公司名称", allowableValues = "mixLength:(,255]")
    private String subEntpName;

    /**
     * 分公司地址
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "分公司地址", allowableValues = "mixLength:(,255]")
    private String subEntpAddress;

    /**
     * 联系方式
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "联系方式", allowableValues = "mixLength:(,255]")
    private String contact;

    /**
     * 分公司介绍
     */
    @ApiModelProperty(value = "分公司介绍")
    private String subEntpJs;

    /**
     * 介绍图片
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "介绍图片", allowableValues = "mixLength:(,255]")
    private String jsUrl;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 经度
     */
    @ApiModelProperty("经度")
    private Double jd;

    /**
     * 纬度
     */
    @ApiModelProperty("纬度")
    private Double wd;

//	@ApiModelProperty(value = "分公司介绍图片")
//    private List<SubEntpPicture> subEntpPicture;
//
//
//    public List<SubEntpPicture> getSubEntpPicture() {
//		return subEntpPicture;
//	}
//
//	public void setSubEntpPicture(List<SubEntpPicture> subEntpPicture) {
//		this.subEntpPicture = subEntpPicture;
//	}

	public Double getJd() {
		return jd;
	}

	public void setJd(Double jd) {
		this.jd = jd;
	}

	public Double getWd() {
		return wd;
	}

	public void setWd(Double wd) {
		this.wd = wd;
	}

	/**
     * 获取分公司名称
     */
    public String getSubEntpName() {
        return subEntpName;
    }

    /**
     * 设置分公司名称
     */
    public void setSubEntpName(String subEntpName) {
        this.subEntpName = subEntpName == null ? null : subEntpName.trim();
    }

    /**
     * 获取分公司地址
     */
    public String getSubEntpAddress() {
        return subEntpAddress;
    }

    /**
     * 设置分公司地址
     */
    public void setSubEntpAddress(String subEntpAddress) {
        this.subEntpAddress = subEntpAddress == null ? null : subEntpAddress.trim();
    }

    /**
     * 获取联系方式
     */
    public String getContact() {
        return contact;
    }

    /**
     * 设置联系方式
     */
    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    /**
     * 获取分公司介绍
     */
    public String getSubEntpJs() {
        return subEntpJs;
    }

    /**
     * 设置分公司介绍
     */
    public void setSubEntpJs(String subEntpJs) {
        this.subEntpJs = subEntpJs == null ? null : subEntpJs.trim();
    }

    /**
     * 获取介绍图片
     */
    public String getJsUrl() {
        return jsUrl;
    }

    /**
     * 设置介绍图片
     */
    public void setJsUrl(String jsUrl) {
        this.jsUrl = jsUrl == null ? null : jsUrl.trim();
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
}
