package com.wisea.cultivar.plant.entity.oritrapla;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * 会员信息
 */
public class MembInfo extends DataLongEntity<MembInfo> {
    private static final long serialVersionUID = -2689447468861484988L;
	private Long pid; //pid
    private String logoUrl; //logo_url
    private String orgName; //农场或公司名称
    private String areaCodeProv; //区域_省
    private String areaCodeCity; //区域_市
    private String areaCodeCou; //区域_区县
    private String address; //详细地址
    private String contName; //联系人姓名
    private String sexType; //性别类型
    private String position; //职位
    private String contTel; //联系人手机号
    private String subjectType; //主体类型（企业，合作社，散户，经纪人）
    private String acctStatus; //账号状态
    private String loginName; //登陆用户名
    private String signature; //个性签名
    private String introduce; //介绍
    private String acctType; // 用户类型
    private OffsetDateTime registerDate; //注册时间

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
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

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }

    public String getSexType() {
        return sexType;
    }

    public void setSexType(String sexType) {
        this.sexType = sexType;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public OffsetDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(OffsetDateTime registerDate) {
        this.registerDate = registerDate;
    }
}
