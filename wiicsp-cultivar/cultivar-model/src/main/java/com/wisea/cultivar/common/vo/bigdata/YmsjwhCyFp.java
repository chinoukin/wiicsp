package com.wisea.cultivar.common.vo.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;
import io.swagger.annotations.ApiModelProperty;

/**
 * ymsjwh_cy_fp 表实体
 * 页面数据产业及扶贫
 * 2019/08/29 17:45:19
 */
public class YmsjwhCyFp extends DataLongEntity<YmsjwhCyFp> {
    private static final long serialVersionUID = 1L;

    /**
     * 现有糯米蕉林面积
     */
    @ApiModelProperty("现有糯米蕉林面积")
    private Double xynmjlmj;

    /**
     * 总种植糯米蕉株数
     */
    @ApiModelProperty("总种植糯米蕉株数")
    private Integer zzznmjzs;

    /**
     * 年产量
     */
    @ApiModelProperty("年产量")
    private Double ncl;

    /**
     * 糯米蕉种植专业合作社
     */
    @ApiModelProperty("糯米蕉种植专业合作社")
    private Integer nmjzzzyhzs;

    /**
     * 糯米蕉标准化种植基地
     */
    @ApiModelProperty("糯米蕉标准化种植基地")
    private Integer nmjbzhzzjd;

    /**
     * 拥有冷库
     */
    @ApiModelProperty("拥有冷库")
    private Double yylks;

    /**
     * 糯米蕉深加工处理能力
     */
    @ApiModelProperty("糯米蕉深加工处理能力")
    private Double nmjsjgclnl;

    /**
     * 受益农户
     */
    @ApiModelProperty("受益农户")
    private Integer synh;

    /**
     * 受益贫困户
     */
    @ApiModelProperty("受益贫困户")
    private Integer sypkh;

    /**
     * 2018年脱贫人数
     */
    @ApiModelProperty("2018年脱贫人数")
    private Integer tprs2018;

    /**
     * 2019年脱贫人数
     */
    @ApiModelProperty("2019年脱贫人数")
    private Integer tprs2019;

    /**
     * 户均增收
     */
    @ApiModelProperty("户均增收")
    private Double hjzs;

    /**
     * 楼层副标题
     */
    @ApiModelProperty("楼层副标题")
    private String sambFloorTitle;

    /**
     * 获取现有糯米蕉林面积
     */
    public Double getXynmjlmj() {
        return xynmjlmj;
    }

    /**
     * 设置现有糯米蕉林面积
     */
    public void setXynmjlmj(Double xynmjlmj) {
        this.xynmjlmj = xynmjlmj;
    }

    /**
     * 获取总种植糯米蕉株数
     */
    public Integer getZzznmjzs() {
        return zzznmjzs;
    }

    /**
     * 设置总种植糯米蕉株数
     */
    public void setZzznmjzs(Integer zzznmjzs) {
        this.zzznmjzs = zzznmjzs;
    }

    /**
     * 获取年产量
     */
    public Double getNcl() {
        return ncl;
    }

    /**
     * 设置年产量
     */
    public void setNcl(Double ncl) {
        this.ncl = ncl;
    }

    /**
     * 获取糯米蕉种植专业合作社
     */
    public Integer getNmjzzzyhzs() {
        return nmjzzzyhzs;
    }

    /**
     * 设置糯米蕉种植专业合作社
     */
    public void setNmjzzzyhzs(Integer nmjzzzyhzs) {
        this.nmjzzzyhzs = nmjzzzyhzs;
    }

    /**
     * 获取糯米蕉标准化种植基地
     */
    public Integer getNmjbzhzzjd() {
        return nmjbzhzzjd;
    }

    /**
     * 设置糯米蕉标准化种植基地
     */
    public void setNmjbzhzzjd(Integer nmjbzhzzjd) {
        this.nmjbzhzzjd = nmjbzhzzjd;
    }

    /**
     * 获取拥有冷库
     */
    public Double getYylks() {
        return yylks;
    }

    /**
     * 设置拥有冷库
     */
    public void setYylks(Double yylks) {
        this.yylks = yylks;
    }

    /**
     * 获取糯米蕉深加工处理能力
     */
    public Double getNmjsjgclnl() {
        return nmjsjgclnl;
    }

    /**
     * 设置糯米蕉深加工处理能力
     */
    public void setNmjsjgclnl(Double nmjsjgclnl) {
        this.nmjsjgclnl = nmjsjgclnl;
    }

    /**
     * 获取受益农户
     */
    public Integer getSynh() {
        return synh;
    }

    /**
     * 设置受益农户
     */
    public void setSynh(Integer synh) {
        this.synh = synh;
    }

    /**
     * 获取受益贫困户
     */
    public Integer getSypkh() {
        return sypkh;
    }

    /**
     * 设置受益贫困户
     */
    public void setSypkh(Integer sypkh) {
        this.sypkh = sypkh;
    }

    /**
     * 获取2018年脱贫人数
     */
    public Integer getTprs2018() {
        return tprs2018;
    }

    /**
     * 设置2018年脱贫人数
     */
    public void setTprs2018(Integer tprs2018) {
        this.tprs2018 = tprs2018;
    }

    /**
     * 获取2019年脱贫人数
     */
    public Integer getTprs2019() {
        return tprs2019;
    }

    /**
     * 设置2019年脱贫人数
     */
    public void setTprs2019(Integer tprs2019) {
        this.tprs2019 = tprs2019;
    }

    /**
     * 获取户均增收
     */
    public Double getHjzs() {
        return hjzs;
    }

    /**
     * 设置户均增收
     */
    public void setHjzs(Double hjzs) {
        this.hjzs = hjzs;
    }

    /**
     * 获取楼层副标题
     */
    public String getSambFloorTitle() {
        return sambFloorTitle;
    }

    /**
     * 设置楼层副标题
     */
    public void setSambFloorTitle(String sambFloorTitle) {
        this.sambFloorTitle = sambFloorTitle == null ? null : sambFloorTitle.trim();
    }
}
