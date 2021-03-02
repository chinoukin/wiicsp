package com.wisea.cultivar.common.vo.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * YxEntpListVo
 * 2019/12/02 11:02:15
 */
public class YxEntpListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 产地id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "产地id")
    private Long placeOriginId;

    /**
     * 企业名称
     */
    @ApiModelProperty(value = "企业名称")
    private String entpName;

    /**
     * 所在国家
     */
    @ApiModelProperty(value = "所在国家")
    private String szgj;

    /**
     * 地块数量
     */
    @ApiModelProperty(value = "地块数量")
    private Integer dkSl;

    /**
     * 环境监测设备数量
     */
    @ApiModelProperty(value = "环境监测设备数量")
    private Integer hjjcsbSl;

    /**
     * 视频摄像头数量
     */
    @ApiModelProperty(value = "视频摄像头数量")
    private Integer spsxtSl;

    /**
     * 档案数量
     */
    @ApiModelProperty(value = "档案数量")
    private Integer daSl;

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

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "会员ID")
    private Long membId;

    @ApiModelProperty(value = "精度")
    private Double jd;

    @ApiModelProperty(value = "维度")
    private Double wd;

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

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public Double getJd() {
        return jd;
    }

    public void setJd(Double jd) {
        this.jd = jd;
    }

    public Double getWd() {
        return wd;
    }

    public void setWd(Double wd) {
        this.wd = wd;
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
