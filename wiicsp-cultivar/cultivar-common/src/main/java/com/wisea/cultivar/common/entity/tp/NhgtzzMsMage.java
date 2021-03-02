package com.wisea.cultivar.common.entity.tp;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

/**
 * nhgtzz_ms_mage 表实体
 * 农户个体种植亩数管理
 * 2019/08/29 17:45:19
 */
public class NhgtzzMsMage extends DataLongEntity<NhgtzzMsMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 种植户姓名
     */
    private String zzhName;

    /**
     * 实测面积
     */
    private Double scMj;

    /**
     * 香蕉园地点
     */
    private String jyAddress;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 维护时间
     */
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime whTime;

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
