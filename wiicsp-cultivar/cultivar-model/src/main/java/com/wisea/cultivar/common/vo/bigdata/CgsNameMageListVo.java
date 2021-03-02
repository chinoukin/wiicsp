package com.wisea.cultivar.common.vo.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * CgsNameMageListVo
 * 2019/12/02 11:02:14
 */
public class CgsNameMageListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 采购商名称
     */
    @ApiModelProperty(value = "采购商名称")
    private String cgsName;

    /**
     * 采购商简称
     */
    @ApiModelProperty(value = "采购商简称")
    private String cgsJc;

    /**
     * 采购商地址
     */
    @ApiModelProperty(value = "采购商地址")
    private String cgsAddress;

    /**
     * 成交金额
     */
    @ApiModelProperty(value = "成交金额")
    private Double cjje;

    /**
     * 经度
     */
    @ApiModelProperty(value = "经度")
    private Double jd;

    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度")
    private Double wd;

    @ApiModelProperty(value = "经纬度拼接")
    private String jdwd;

    /**
     * 是否已选
     */
    @ApiModelProperty(value = "是否已选")
    private String sfyxFlag;

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
     * 获取采购商名称
     */
    public String getCgsName() {
        return cgsName;
    }

    /**
     * 设置采购商名称
     */
    public void setCgsName(String cgsName) {
        this.cgsName = cgsName == null ? null : cgsName.trim();
    }

    public String getJdwd() {
        return jdwd;
    }

    public void setJdwd(String jdwd) {
        this.jdwd = jdwd;
    }

    /**
     * 获取采购商简称
     */
    public String getCgsJc() {
        return cgsJc;
    }

    /**
     * 设置采购商简称
     */
    public void setCgsJc(String cgsJc) {
        this.cgsJc = cgsJc == null ? null : cgsJc.trim();
    }

    /**
     * 获取采购商地址
     */
    public String getCgsAddress() {
        return cgsAddress;
    }

    /**
     * 设置采购商地址
     */
    public void setCgsAddress(String cgsAddress) {
        this.cgsAddress = cgsAddress == null ? null : cgsAddress.trim();
    }

    /**
     * 获取成交金额
     */
    public Double getCjje() {
        return cjje;
    }

    /**
     * 设置成交金额
     */
    public void setCjje(Double cjje) {
        this.cjje = cjje;
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
     * 获取是否已选
     */
    public String getSfyxFlag() {
        return sfyxFlag;
    }

    /**
     * 设置是否已选
     */
    public void setSfyxFlag(String sfyxFlag) {
        this.sfyxFlag = sfyxFlag == null ? null : sfyxFlag.trim();
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
}
