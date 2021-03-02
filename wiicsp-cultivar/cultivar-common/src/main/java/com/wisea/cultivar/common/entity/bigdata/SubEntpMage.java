package com.wisea.cultivar.common.entity.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * sub_entp_mage 表实体
 * 分公司名录管理
 * 2019/12/02 11:02:15
 */
public class SubEntpMage extends DataLongEntity<SubEntpMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 分公司名称
     */
    private String subEntpName;

    /**
     * 分公司地址
     */
    private String subEntpAddress;

    /**
     * 联系方式
     */
    private String contact;

    /**
     * 分公司介绍
     */
    private String subEntpJs;

    /**
     * 经度
     */
    private Double jd;

    /**
     * 纬度
     */
    private Double wd;

    /**
     * 介绍图片
     */
    private String jsUrl;

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


}
