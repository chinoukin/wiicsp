package com.wisea.equipment.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class EquEntpMage extends DataLongEntity<EquEntpMage> {
    /**
     * 厂商名称
     */
    private String equEntpName;

    /**
     * 联系人
     */
    private String contact;

    /**
     * 联系电话
     */
    private String contactTel;

    /**
     * 厂商地址
     */
    private String equEntpAddress;

    public String getEquEntpName() {
        return equEntpName;
    }

    public void setEquEntpName(String equEntpName) {
        this.equEntpName = equEntpName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getEquEntpAddress() {
        return equEntpAddress;
    }

    public void setEquEntpAddress(String equEntpAddress) {
        this.equEntpAddress = equEntpAddress;
    }
}