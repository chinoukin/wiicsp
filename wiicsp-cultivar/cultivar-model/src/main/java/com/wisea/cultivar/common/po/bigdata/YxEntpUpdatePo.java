package com.wisea.cultivar.common.po.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * YxEntpUpdatePo
 * 2019/12/02 11:02:15
 */
public class YxEntpUpdatePo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id", required = true)
    private Long id;

    /**
     * 产地id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "产地id", allowableValues = "length:(,19]")
    private Long placeOriginId;

    /**
     * 企业名称
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "企业名称", allowableValues = "mixLength:(,255]")
    private String entpName;

    /**
     * 所在国家
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "所在国家", allowableValues = "mixLength:(,255]")
    private String szgj;

    /**
     * 地块数量
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "地块数量", allowableValues = "length:(,10]")
    private Integer dkSl;

    /**
     * 环境监测设备数量
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "环境监测设备数量", allowableValues = "length:(,10]")
    private Integer hjjcsbSl;

    /**
     * 视频摄像头数量
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "视频摄像头数量", allowableValues = "length:(,10]")
    private Integer spsxtSl;

    /**
     * 档案数量
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "档案数量", allowableValues = "length:(,10]")
    private Integer daSl;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 删除标记
     */
    @Check(test = { "maxLength" }, mixLength = 1)
    @ApiModelProperty(value = "删除标记", allowableValues = "mixLength:(,1]")
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
     * 获取产地id
     */
    public Long getPlaceOriginId() {
        return placeOriginId;
    }

    /**
     * 设置产地id
     */
    public void setPlaceOriginId(Long placeOriginId) {
        this.placeOriginId = placeOriginId;
    }

    /**
     * 获取企业名称
     */
    public String getEntpName() {
        return entpName;
    }

    /**
     * 设置企业名称
     */
    public void setEntpName(String entpName) {
        this.entpName = entpName == null ? null : entpName.trim();
    }

    /**
     * 获取所在国家
     */
    public String getSzgj() {
        return szgj;
    }

    /**
     * 设置所在国家
     */
    public void setSzgj(String szgj) {
        this.szgj = szgj == null ? null : szgj.trim();
    }

    /**
     * 获取地块数量
     */
    public Integer getDkSl() {
        return dkSl;
    }

    /**
     * 设置地块数量
     */
    public void setDkSl(Integer dkSl) {
        this.dkSl = dkSl;
    }

    /**
     * 获取环境监测设备数量
     */
    public Integer getHjjcsbSl() {
        return hjjcsbSl;
    }

    /**
     * 设置环境监测设备数量
     */
    public void setHjjcsbSl(Integer hjjcsbSl) {
        this.hjjcsbSl = hjjcsbSl;
    }

    /**
     * 获取视频摄像头数量
     */
    public Integer getSpsxtSl() {
        return spsxtSl;
    }

    /**
     * 设置视频摄像头数量
     */
    public void setSpsxtSl(Integer spsxtSl) {
        this.spsxtSl = spsxtSl;
    }

    /**
     * 获取档案数量
     */
    public Integer getDaSl() {
        return daSl;
    }

    /**
     * 设置档案数量
     */
    public void setDaSl(Integer daSl) {
        this.daSl = daSl;
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
