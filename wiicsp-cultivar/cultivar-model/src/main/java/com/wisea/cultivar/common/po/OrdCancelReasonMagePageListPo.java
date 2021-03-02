package com.wisea.cultivar.common.po;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.OrdCancelReasonMagePageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("取消原因分页查询Po")
public class OrdCancelReasonMagePageListPo extends PagePo<OrdCancelReasonMagePageListVo> {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="编号")
    private String num;

    @ApiModelProperty(value="订单取消原因")
    private String ordCancelReason;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getOrdCancelReason() {
        return ordCancelReason;
    }

    public void setOrdCancelReason(String ordCancelReason) {
        this.ordCancelReason = ordCancelReason;
    }
}
