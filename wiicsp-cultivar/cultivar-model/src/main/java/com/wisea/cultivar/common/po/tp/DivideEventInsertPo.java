package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * DivideEventInsertPo
 * 2019/01/23 10:21:32
 */
public class DivideEventInsertPo {
    /**
     * 订单id
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "订单id")
    private String ordId;

    /**
     * 分账详情
     */
    @Check(test = { "maxLength" }, mixLength = 200)
    @ApiModelProperty(value = "分账详情")
    private String divideDetail;

    /**
     * 分账开始时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "分账开始时间")
    private OffsetDateTime divStartTime;

    /**
     * 执行状态,0-未执行,1-执行成功,2-执行失败
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "执行状态,0-未执行,1-执行成功,2-执行失败")
    private String exeState;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

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
}
