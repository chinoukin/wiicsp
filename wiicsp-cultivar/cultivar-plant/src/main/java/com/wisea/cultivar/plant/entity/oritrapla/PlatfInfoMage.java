package com.wisea.cultivar.plant.entity.oritrapla;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * 平台信息管理
 */
public class PlatfInfoMage extends DataLongEntity<PlatfInfoMage> {
    /**
     * 公司名称
     */
    private String orgName;

    /**
     * 联系电话
     */
    private String contTel;

    /**
     * 联系地址
     */
    private String address;

    /**
     * 版权所有
     */
    private String copyright;

    /**
     * 公司介绍
     */
    private String introduce;

    /**
     * 用户服务协议
     */
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
