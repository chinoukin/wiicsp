package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * divide_event 表实体
 * 分账事件(用于定时任务实现延迟分账)
 * 2019/01/23 10:21:32
 */
public class DivideEvent extends DataLongEntity<DivideEvent> {
    private static final long serialVersionUID = 1L;

    /**
     * 订单id
     */
    private String ordId;

    /**
     * 分账详情
     */
    private String divideDetail;

    /**
     * 分账开始时间
     */
    private OffsetDateTime divStartTime;

    /**
     * 执行状态,0-未执行,1-执行成功,2-执行失败
     */
    private String exeState;

    /**
     * 是否首付款标识,1-首款,2-尾款
     */
    private String sfsfkFlag;

    /**
     * 获取订单id
     */
    public String getOrdId() {
        return ordId;
    }

    /**
     * 设置订单id
     */
    public void setOrdId(String ordId) {
        this.ordId = ordId == null ? null : ordId.trim();
    }

    public String getSfsfkFlag() {
		return sfsfkFlag;
	}

	public void setSfsfkFlag(String sfsfkFlag) {
		this.sfsfkFlag = sfsfkFlag;
	}

	/**
     * 获取分账详情
     */
    public String getDivideDetail() {
        return divideDetail;
    }

    /**
     * 设置分账详情
     */
    public void setDivideDetail(String divideDetail) {
        this.divideDetail = divideDetail == null ? null : divideDetail.trim();
    }

    /**
     * 获取分账开始时间
     */
    public OffsetDateTime getDivStartTime() {
        return divStartTime;
    }

    /**
     * 设置分账开始时间
     */
    public void setDivStartTime(OffsetDateTime divStartTime) {
        this.divStartTime = divStartTime;
    }

    /**
     * 获取执行状态,0-未执行,1-执行成功,2-执行失败
     */
    public String getExeState() {
        return exeState;
    }

    /**
     * 设置执行状态,0-未执行,1-执行成功,2-执行失败
     */
    public void setExeState(String exeState) {
        this.exeState = exeState == null ? null : exeState.trim();
    }
}
