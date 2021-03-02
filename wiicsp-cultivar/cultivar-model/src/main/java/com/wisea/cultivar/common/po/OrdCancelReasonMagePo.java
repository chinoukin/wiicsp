package com.wisea.cultivar.common.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("取消原因新增或修改Po")
public class OrdCancelReasonMagePo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="编号")
    private String num;

    @ApiModelProperty(value="订单取消原因")
    private String ordCancelReason;
    @ApiModelProperty(value="排序")
    private Integer sort;

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
    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
