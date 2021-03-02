package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * jyncgscgje_mage 表实体
 * 近一年采购商采购金额管理
 * 2019/09/04 15:07:41
 */
public class JyncgscgjeMage extends DataLongEntity<JyncgscgjeMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 企业名称
     */
    private String entpName;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 购买金额
     */
    private Double buyAmount;

    /**
     * 地区
     */
    private String area;

    /**
     * 联系电话
     */
    private String tel;

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
}
