package com.wisea.cultivar.common.po.tp.system;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * JyncgscgjeMageInsertPo
 * 2019/09/04 15:07:41
 */
public class JyncgscgjeMageInsertPo {
    /**
     * 企业名称
     */
    @Check(test = { "maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "企业名称")
    private String entpName;

    /**
     * 联系人
     */
    @Check(test = { "maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "联系人")
    private String contacts;

    /**
     * 购买金额
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "购买金额")
    private Double buyAmount;

    /**
     * 地区
     */
    @Check(test = { "maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "地区")
    private String area;

    /**
     * 联系电话
     */
    @Check(test = { "maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "联系电话")
    private String tel;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 获取企业名称
     */
    public String getEntpName() {
        return entpName;
    }

    /**
     * 设置企业名称
     */
    public void setEntpName(String entpName) {
        this.entpName = entpName == null ? null : entpName.trim();
    }

    /**
     * 获取联系人
     */
    public String getContacts() {
        return contacts;
    }

    /**
     * 设置联系人
     */
    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    /**
     * 获取购买金额
     */
    public Double getBuyAmount() {
        return buyAmount;
    }

    /**
     * 设置购买金额
     */
    public void setBuyAmount(Double buyAmount) {
        this.buyAmount = buyAmount;
    }

    /**
     * 获取地区
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置地区
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * 获取联系电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置联系电话
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
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
