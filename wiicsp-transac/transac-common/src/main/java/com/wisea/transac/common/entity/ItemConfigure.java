package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class ItemConfigure extends DataLongEntity<ItemConfigure> {
    /**
     * 公司名称
     */
    private String entpName;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 联系邮箱
     */
    private String email;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 版权所有
     */
    private String copyright;

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
