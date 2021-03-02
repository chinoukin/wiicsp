package com.wisea.cultivar.explorer.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * OrgInfoMageListPo
 * 2020/07/24 11:21:45
 */
public class OrgInfoMageListPo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 机构类型
     */
    @ApiModelProperty(value = "机构类型--0：机构；1：部门",required = true)
    @Check(test = { "required" })
    private String orgType;

    /**
     * 机构名称
     */
    @ApiModelProperty(value = "机构名称")
    private String orgName;

    /**
     * 行政区划代码
     */
    @ApiModelProperty(value = "行政区划代码")
    private String areaCode;

    /**
     * 机构地址
     */
    @ApiModelProperty(value = "机构地址")
    private String orgAddress;

    /**
     * 机构介绍
     */
    @ApiModelProperty(value = "机构介绍")
    private String orgIntroduce;

    /**
     * 机构负责人
     */
    @ApiModelProperty(value = "机构负责人")
    private String orgLeader;

    /**
     * 负责人职务
     */
    @ApiModelProperty(value = "负责人职务")
    private String orgLeaderPosition;

    /**
     * 联系人
     */
    @ApiModelProperty(value = "联系人")
    private String conter;

    /**
     * 联系方式
     */
    @ApiModelProperty(value = "联系方式")
    private String contTel;

    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度")
    private Double wd;

    /**
     * 经度
     */
    @ApiModelProperty(value = "经度")
    private Double jd;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    /**
     * 是否具有坐标
     */
    @ApiModelProperty(value = "是否具有坐标--1：有；2：没有")
    private String coordinatesFlag;


    /**
     * 批量导出的ID
     */
    @ApiModelProperty(value = "批量导出的ID数组")
    private List<Long> exportList;

    public OrgInfoMageListPo() {
    }

    public OrgInfoMageListPo(String orgType) {
        this.orgType = orgType;
    }

    public List<Long> getExportList() {
        return exportList;
    }

    public void setExportList(List<Long> exportList) {
        this.exportList = exportList;
    }

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
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

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getCoordinatesFlag() {
        return coordinatesFlag;
    }

    public void setCoordinatesFlag(String coordinatesFlag) {
        this.coordinatesFlag = coordinatesFlag;
    }
}
