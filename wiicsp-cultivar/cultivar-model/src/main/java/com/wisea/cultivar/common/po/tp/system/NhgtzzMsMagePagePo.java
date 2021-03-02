package com.wisea.cultivar.common.po.tp.system;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.vo.tp.system.NhgtzzMsMageListVo;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * nhgtzz_ms_mage 表实体
 * 农户个体种植亩数管理
 * 2019/08/29 17:45:19
 */
public class NhgtzzMsMagePagePo extends PagePo<NhgtzzMsMageListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * 种植户姓名
     */
    @ApiModelProperty("种植户姓名")
    private String zzhName;

    /**
     * 实测面积
     */
    @ApiModelProperty("实测面积")
    private Double scMj;

    /**
     * 香蕉园地点
     */
    @ApiModelProperty("香蕉园地点")
    private String jyAddress;

    /**
     * 联系电话
     */
    @ApiModelProperty("联系电话")
    private String tel;

    /**
     * 维护时间
     */
    @ApiModelProperty("维护时间")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime whTime;

    @ApiModelProperty("查询字段")
    private String search;
    @ApiModelProperty(value = "排序字段",hidden = true)
    private String sort;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    /**
     * 获取种植户姓名
     */
    public String getZzhName() {
        return zzhName;
    }

    /**
     * 设置种植户姓名
     */
    public void setZzhName(String zzhName) {
        this.zzhName = zzhName == null ? null : zzhName.trim();
    }

    /**
     * 获取实测面积
     */
    public Double getScMj() {
        return scMj;
    }

    /**
     * 设置实测面积
     */
    public void setScMj(Double scMj) {
        this.scMj = scMj;
    }

    /**
     * 获取香蕉园地点
     */
    public String getJyAddress() {
        return jyAddress;
    }

    /**
     * 设置香蕉园地点
     */
    public void setJyAddress(String jyAddress) {
        this.jyAddress = jyAddress == null ? null : jyAddress.trim();
    }

    /**
     * 获取联系电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置联系电话
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * 获取维护时间
     */
    public OffsetDateTime getWhTime() {
        return whTime;
    }

    /**
     * 设置维护时间
     */
    public void setWhTime(OffsetDateTime whTime) {
        this.whTime = whTime;
    }
}
