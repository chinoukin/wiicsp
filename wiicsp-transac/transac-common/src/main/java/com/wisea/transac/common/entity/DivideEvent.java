package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;
import java.time.OffsetDateTime;

public class DivideEvent extends DataLongEntity<DivideEvent> {
    /**
     * 订单id
     */
    private String ordId;

    /**
     * 订单分账id
     */
    private String ordDateId;

    /**
     * 分账详情
     */
    private String divideDetail;

    /**
     * 分账开始时间
     */
    private OffsetDateTime divStartTime;

    /**
     * 执行状态
     */
    private String exeState;

    /**
     * 是否首付款标识
     */
    private String sfsfkFlag;

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public String getDivideDetail() {
        return divideDetail;
    }

    public void setDivideDetail(String divideDetail) {
        this.divideDetail = divideDetail;
    }

    public OffsetDateTime getDivStartTime() {
        return divStartTime;
    }

    public void setDivStartTime(OffsetDateTime divStartTime) {
        this.divStartTime = divStartTime;
    }

    public String getOrdDateId() {
        return ordDateId;
    }

    public void setOrdDateId(String ordDateId) {
        this.ordDateId = ordDateId;
    }

    public String getExeState() {
        return exeState;
    }

    public void setExeState(String exeState) {
        this.exeState = exeState;
    }

    public String getSfsfkFlag() {
        return sfsfkFlag;
    }

    public void setSfsfkFlag(String sfsfkFlag) {
        this.sfsfkFlag = sfsfkFlag;
    }
}
