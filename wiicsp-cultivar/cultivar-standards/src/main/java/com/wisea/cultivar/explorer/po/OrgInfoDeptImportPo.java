package com.wisea.cultivar.explorer.po;

import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import com.wisea.cultivar.explorer.utils.CheckUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Objects;

/**
 * 部门
 */
public class OrgInfoDeptImportPo implements Serializable{

    /**
     * 行政区划代码
     */
    private String areaCode;

    @ExcelField(title = "行政区划代码省")
    private String areaProv;
    @ExcelField(title = "行政区划代码市")
    private String areaCity;
    @ExcelField(title = "行政区划代码区县")
    private String areaCou;
    /**
    * 部门名称
    */
    @ExcelField(title = "部门名称")
    private String orgName;

    /**
    * 部门地址
    */
    @ExcelField(title = "部门地址")
    private String orgAddress;

    /**
    * 机构介绍
    */
    @ExcelField(title = "部门介绍")
    private String orgIntroduce;

    /**
    * 部门负责人
    */
    @ExcelField(title = "部门负责人")
    private String orgLeader;

    /**
    * 负责人职务
    */
    @ExcelField(title = "负责人职务")
    private String orgLeaderPosition;

    /**
    * 联系人
    */
    @ExcelField(title = "部门联系人")
    private String conter;

    /**
    * 联系方式
    */
    @ExcelField(title = "部门联系方式", cellDataFormateAuto = false,fieldType = String.class)
    private String contTel;

    /**
     * 经纬度--导入传参
     */
    @ExcelField(title = "经纬度", cellDataFormateAuto = false,fieldType = String.class)
    private String jdWd;

    /**
    * 纬度
    */
    private Double wd;

    /**
    * 经度
    */
    private Double jd;

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
     * 获取联系方式
     */
    public String getContTel() {
        return contTel;
    }

    /**
     * 设置联系方式
     */
    public void setContTel(String contTel)
    {
        this.contTel = contTel;
    }

    /**
     * 获取纬度
     */
    public Double getWd() {
        if(StringUtils.isNotBlank(this.jdWd)){
            this.wd = CheckUtils.getJdWdSplit(jdWd, 1);
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
            this.jd = CheckUtils.getJdWdSplit(jdWd, 0);
        }
        return jd;
    }

    /**
     * 设置经度
     */
    public void setJd(Double jd) {
        this.jd = jd;
    }

    public String getJdWd() {
        return jdWd;
    }

    public void setJdWd(String jdWd) {
        this.jdWd = jdWd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OrgInfoDeptImportPo that = (OrgInfoDeptImportPo) o;
        return areaCode.equals(that.areaCode) &&
                orgName.equals(that.orgName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, orgName);
    }

}
