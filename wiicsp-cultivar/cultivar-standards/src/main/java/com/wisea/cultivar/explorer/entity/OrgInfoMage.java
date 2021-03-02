package com.wisea.cultivar.explorer.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * org_info_mage 表实体
 * 机构信息维护
 * 2020/07/24 11:21:45
 */
public class OrgInfoMage extends DataLongEntity<OrgInfoMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 机构类型
     */
    private String orgType;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 行政区划代码
     */
    private String areaCode;
    private String areaProv;
    private String areaCity;
    private String areaCou;

    /**
     * 机构地址
     */
    private String orgAddress;

    /**
     * 机构介绍
     */
    private String orgIntroduce;

    /**
     * 机构负责人
     */
    private String orgLeader;

    /**
     * 负责人职务
     */
    private String orgLeaderPosition;

    /**
     * 联系人
     */
    private String conter;

    /**
     * 联系方式
     */
    private String contTel;

    /**
     * 纬度
     */
    private Double wd;

    /**
     * 经度
     */
    private Double jd;

    public String getAreaProv() {
        return areaProv;
    }

    public void setAreaProv(String areaProv) {
        this.areaProv = areaProv;
    }

    public String getAreaCity() {
        return areaCity;
    }

    public void setAreaCity(String areaCity) {
        this.areaCity = areaCity;
    }

    public String getAreaCou() {
        return areaCou;
    }

    public void setAreaCou(String areaCou) {
        this.areaCou = areaCou;
    }

    /**
     * 获取机构类型
     */
    public String getOrgType() {
        return orgType;
    }

    /**
     * 设置机构类型
     */
    public void setOrgType(String orgType) {
        this.orgType = orgType == null ? null : orgType.trim();
    }

    /**
     * 获取机构名称
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 设置机构名称
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    /**
     * 获取行政区划代码
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 设置行政区划代码
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    /**
     * 获取机构地址
     */
    public String getOrgAddress() {
        return orgAddress;
    }

    /**
     * 设置机构地址
     */
    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress == null ? null : orgAddress.trim();
    }

    /**
     * 获取机构介绍
     */
    public String getOrgIntroduce() {
        return orgIntroduce;
    }

    /**
     * 设置机构介绍
     */
    public void setOrgIntroduce(String orgIntroduce) {
        this.orgIntroduce = orgIntroduce == null ? null : orgIntroduce.trim();
    }

    /**
     * 获取机构负责人
     */
    public String getOrgLeader() {
        return orgLeader;
    }

    /**
     * 设置机构负责人
     */
    public void setOrgLeader(String orgLeader) {
        this.orgLeader = orgLeader == null ? null : orgLeader.trim();
    }

    /**
     * 获取负责人职务
     */
    public String getOrgLeaderPosition() {
        return orgLeaderPosition;
    }

    /**
     * 设置负责人职务
     */
    public void setOrgLeaderPosition(String orgLeaderPosition) {
        this.orgLeaderPosition = orgLeaderPosition == null ? null : orgLeaderPosition.trim();
    }

    /**
     * 获取联系人
     */
    public String getConter() {
        return conter;
    }

    /**
     * 设置联系人
     */
    public void setConter(String conter) {
        this.conter = conter == null ? null : conter.trim();
    }

    /**
     * 获取联系方式
     */
    public String getContTel() {
        return contTel;
    }

    /**
     * 设置联系方式
     */
    public void setContTel(String contTel) {
        this.contTel = contTel == null ? null : contTel.trim();
    }

    /**
     * 获取纬度
     */
    public Double getWd() {
        return wd;
    }

    /**
     * 设置纬度
     */
    public void setWd(Double wd) {
        this.wd = wd;
    }

    /**
     * 获取经度
     */
    public Double getJd() {
        return jd;
    }

    /**
     * 设置经度
     */
    public void setJd(Double jd) {
        this.jd = jd;
    }
}
