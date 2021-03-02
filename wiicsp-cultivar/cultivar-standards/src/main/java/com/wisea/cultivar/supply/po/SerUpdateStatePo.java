package com.wisea.cultivar.supply.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * 修改价格
 * @author chengq
 * @date 2020/8/15 18:45
 */
public class SerUpdateStatePo {

    @ApiModelProperty("服务单id")
    @Check(test = {"required" }, requiredMsg = "服务单id不能为空")
    private Long id;

    @ApiModelProperty(value = "状态 1-待服务 2-服务中 3-已取消")
    @Check(test = { "required", "liveable" }, liveable = {"1", "2", "3"}, logicMsg = "商品发布状态只能为1、2、3")
    private String serListStateType;

    @ApiModelProperty(value = "取消原因")
    private String serListCancelReason;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerListStateType() {
        return serListStateType;
    }

    public void setSerListStateType(String serListStateType) {
        this.serListStateType = serListStateType;
    }

    public String getSerListCancelReason() {
        return serListCancelReason;
    }

    public void setSerListCancelReason(String serListCancelReason) {
        this.serListCancelReason = serListCancelReason;
    }
}
