package com.wisea.cultivar.explorer.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

/**
 * OrgInfoMageInsertPo
 * 2020/07/24 11:21:45
 */
public class OrgInfoMageInsertPo {
    /**
     * 机构类型
     */
    @Check(test = {"required", "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "机构类型-0:机构；1:部门", allowableValues = "mixLength:(,5]")
    private String orgType;

    /**
     * 机构名称
     */
    @Check(test = {"required", "minLength", "maxLength" }, lengthRange = { 2, 100 })
    @ApiModelProperty(value = "机构名称", allowableValues = "mixLength:(2,100]")
    private String orgName;

    /**
     * 行政区划代码
     */
    @ApiModelProperty(value = "行政区划代码", allowableValues = "mixLength:(,12]")
    private String areaCode;
    @Check(test = {"required", "minLength", "maxLength","regex" }, lengthRange = { 12,12 },regex = "^[0-9]{12}$")

    @ApiModelProperty(value = "行政区划代码省")
    private String areaProv;
    @Check(test = {"required", "minLength", "maxLength","regex" }, lengthRange = { 12,12 },regex = "^[0-9]{12}$")
    @ApiModelProperty(value = "行政区划代码市")
    private String areaCity;
    @Check(test = {"required", "minLength", "maxLength","regex" }, lengthRange = { 12,12 },regex = "^[0-9]{12}$")
    @ApiModelProperty(value = "行政区划代码区县")
    private String areaCou;
    /**
     * 机构地址
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "机构地址", allowableValues = "mixLength:(,255]")
    private String orgAddress;

    /**
     * 机构介绍
     */
    @Check(test = { "maxLength" }, mixLength = 600)
    @ApiModelProperty(value = "机构介绍", allowableValues = "mixLength:(,600]")
    private String orgIntroduce;

    /**
     * 机构负责人
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "机构负责人", allowableValues = "mixLength:(,30]")
    private String orgLeader;

    /**
     * 负责人职务
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "负责人职务", allowableValues = "mixLength:(,30]")
    private String orgLeaderPosition;

    /**
     * 联系人
     */
    @Check(test = { "maxLength" }, mixLength = 20)
    @ApiModelProperty(value = "联系人", allowableValues = "mixLength:(,20]")
    private String conter;

    /**
     * 联系方式
     */
    @Check(test = { "maxLength" }, mixLength = 20)
    @ApiModelProperty(value = "联系方式", allowableValues = "mixLength:(,20]")
    private String contTel;

    /**
     * 纬度
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$",nullSkip = true)
    @ApiModelProperty(value = "纬度", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double wd;

    /**
     * 经度
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$",nullSkip = true)
    @ApiModelProperty(value = "经度", allowableValues = "regex:^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    private Double jd;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 经纬度
     */
    @Check(test = { "regex" }, regex = "^\\d+(\\.\\d+)?,\\d+(\\.\\d+)?",nullSkip = true)
    @ApiModelProperty(value = "经度纬度", allowableValues = "regex:^\\d+(\\.\\d+)?,\\d+(\\.\\d+)?")
    private String jdWd;

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

    public String getJdWd() {
        return jdWd;
    }

    public void setJdWd(String jdWd) {
        this.jdWd = jdWd;
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
        if(StringUtils.isNotBlank(this.jdWd)){
            String[] jdWdSplit;
            try {
                jdWdSplit = this.jdWd.split(",");
            } catch (Exception e) {
                try {
                    jdWdSplit = this.jdWd.split("，");
                } catch (Exception exception) {
                    jdWdSplit = new String[]{"0","0"};
                }
            }
            this.wd =  Double.valueOf(jdWdSplit[1]);
        }
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
        if(StringUtils.isNotBlank(this.jdWd)){
            String[] jdWdSplit;
            try {
                jdWdSplit = this.jdWd.split(",");
            } catch (Exception e) {
                try {
                    jdWdSplit = this.jdWd.split("，");
                } catch (Exception exception) {
                    jdWdSplit = new String[]{"0","0"};
                }
            }
            this.jd =  Double.valueOf(jdWdSplit[0]);
        }
        return jd;
    }

    /**
     * 设置经度
     */
    public void setJd(Double jd) {
        this.jd = jd;
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
