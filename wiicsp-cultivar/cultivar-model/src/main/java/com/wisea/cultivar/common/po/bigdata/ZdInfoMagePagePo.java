package com.wisea.cultivar.common.po.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.bigdata.ZdInfoMageListVo;
import io.swagger.annotations.ApiModelProperty;

/**
 * ZdInfoMagePagePo
 * 2019/12/02 11:02:15
 */
public class ZdInfoMagePagePo extends PagePo<ZdInfoMageListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 采购商id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "采购商id")
    @Check(test = "required")
    private Long cgsId;

    /**
     * 站点名称
     */
    @ApiModelProperty(value = "站点名称")
    private String zdName;

    /**
     * 站点地址
     */
    @ApiModelProperty(value = "站点地址")
    private String zdAddress;

    /**
     * 站点类型
     */
    @ApiModelProperty(value = "站点类型")
    private String zdType;

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
     * 获取采购商id
     */
    public Long getCgsId() {
        return cgsId;
    }

    /**
     * 设置采购商id
     */
    public void setCgsId(Long cgsId) {
        this.cgsId = cgsId;
    }

    /**
     * 获取站点名称
     */
    public String getZdName() {
        return zdName;
    }

    /**
     * 设置站点名称
     */
    public void setZdName(String zdName) {
        this.zdName = zdName == null ? null : zdName.trim();
    }

    /**
     * 获取站点地址
     */
    public String getZdAddress() {
        return zdAddress;
    }

    /**
     * 设置站点地址
     */
    public void setZdAddress(String zdAddress) {
        this.zdAddress = zdAddress == null ? null : zdAddress.trim();
    }

    /**
     * 获取站点类型
     */
    public String getZdType() {
        return zdType;
    }

    /**
     * 设置站点类型
     */
    public void setZdType(String zdType) {
        this.zdType = zdType == null ? null : zdType.trim();
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
