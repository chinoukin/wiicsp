package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class RetrospCxRecord extends DataLongEntity<RetrospCxRecord> {
    /**
     * 会员id
     */
    private Long membId;

    /**
     * 批次号
     */
    private String retrospPcNum;

    /**
     * 追溯码编号
     */
    private String retrospNumBh;

    /**
     * 查询方式类型
     */
    private String cxModeType;

    /**
     * 查询ip
     */
    private String cxIp;

    /**
     * 查询时间
     */
    private OffsetDateTime cxDate;

    /**
     * 查询位置
     */
    private String cxAddress;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getRetrospPcNum() {
        return retrospPcNum;
    }

    public void setRetrospPcNum(String retrospPcNum) {
        this.retrospPcNum = retrospPcNum;
    }

    public String getRetrospNumBh() {
        return retrospNumBh;
    }

    public void setRetrospNumBh(String retrospNumBh) {
        this.retrospNumBh = retrospNumBh;
    }

    public String getCxModeType() {
        return cxModeType;
    }

    public void setCxModeType(String cxModeType) {
        this.cxModeType = cxModeType;
    }

    public String getCxIp() {
        return cxIp;
    }

    public void setCxIp(String cxIp) {
        this.cxIp = cxIp;
    }

    public OffsetDateTime getCxDate() {
        return cxDate;
    }

    public void setCxDate(OffsetDateTime cxDate) {
        this.cxDate = cxDate;
    }

    public String getCxAddress() {
        return cxAddress;
    }

    public void setCxAddress(String cxAddress) {
        this.cxAddress = cxAddress;
    }
}
