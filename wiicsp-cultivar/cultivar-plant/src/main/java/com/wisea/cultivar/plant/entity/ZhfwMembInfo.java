package com.wisea.cultivar.plant.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class ZhfwMembInfo extends DataLongEntity<ZhfwMembInfo> {
    /**
     * pid
     */
    private Long pid;

    /**
     * 用户名
     */
    private String loginName;

    /**
     * 姓名
     */
    private String contName;

    /**
     * 头像
     */
    private String logoUrl;

    /**
     * 企业名称
     */
    private String entpName;

    /**
     * 注册手机号
     */
    private String registTel;

    /**
     * 注册时间
     */
    private OffsetDateTime registerDate;

    /**
     * 认证状态
     */
    private String entpAuthStateType;

    /**
     * 职位
     */
    private String position;

    /**
     * 账户状态
     */
    private String acctState;

    /**
     * 性别类型
     */
    private String sexType;

    /**
     * 会员类型
     */
    private String membType;

    /**
     * 个性签名
     */
    private String signature;

    /**
     * 农场或公司名称
     */
    private String orgName;

    /**
     * 区域_省
     */
    private String areaCodeProv;

    /**
     * 区域_市
     */
    private String areaCodeCity;

    /**
     * 区域_区县
     */
    private String areaCodeCou;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 联系人手机号
     */
    private String contTel;

    /**
     * 主体类型（企业，合作社，散户，经纪人）
     */
    private String subjectType;

    /**
     * 账号状态
     */
    private String acctStatus;

    /**
     * 账户类型
     */
    private String acctType;

    /**
     * 经度
     */
    private String jd;

    /**
     * 纬度
     */
    private String wd;

    /**
     * 介绍
     */
    private String introduce;

    /**
     * 认证类型
     */
    private String authType;

    /**
     * 圈子背景图
     */
    private String momentsBjtUrl;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public String getRegistTel() {
        return registTel;
    }

    public void setRegistTel(String registTel) {
        this.registTel = registTel;
    }

    public OffsetDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(OffsetDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public String getEntpAuthStateType() {
        return entpAuthStateType;
    }

    public void setEntpAuthStateType(String entpAuthStateType) {
        this.entpAuthStateType = entpAuthStateType;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAcctState() {
        return acctState;
    }

    public void setAcctState(String acctState) {
        this.acctState = acctState;
    }

    public String getSexType() {
        return sexType;
    }

    public void setSexType(String sexType) {
        this.sexType = sexType;
    }

    public String getMembType() {
        return membType;
    }

    public void setMembType(String membType) {
        this.membType = membType;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getAreaCodeProv() {
        return areaCodeProv;
    }

    public void setAreaCodeProv(String areaCodeProv) {
        this.areaCodeProv = areaCodeProv;
    }

    public String getAreaCodeCity() {
        return areaCodeCity;
    }

    public void setAreaCodeCity(String areaCodeCity) {
        this.areaCodeCity = areaCodeCity;
    }

    public String getAreaCodeCou() {
        return areaCodeCou;
    }

    public void setAreaCodeCou(String areaCodeCou) {
        this.areaCodeCou = areaCodeCou;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContTel() {
        return contTel;
    }

    public void setContTel(String contTel) {
        this.contTel = contTel;
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    public String getAcctStatus() {
        return acctStatus;
    }

    public void setAcctStatus(String acctStatus) {
        this.acctStatus = acctStatus;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public String getJd() {
        return jd;
    }

    public void setJd(String jd) {
        this.jd = jd;
    }

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getMomentsBjtUrl() {
        return momentsBjtUrl;
    }

    public void setMomentsBjtUrl(String momentsBjtUrl) {
        this.momentsBjtUrl = momentsBjtUrl;
    }
}
