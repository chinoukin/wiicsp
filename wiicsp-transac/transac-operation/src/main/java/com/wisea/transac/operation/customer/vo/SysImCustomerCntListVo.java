package com.wisea.transac.operation.customer.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * SysImCustomerCntListVo
 * 2018/09/29 13:46:47
 */
public class SysImCustomerCntListVo {
    /**
     * 客服id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "客服id")
    private Long customerId;

    /**
     * 被接待的用户id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "被接待的用户id")
    private Long userId;

    /**
     * 获取客服id
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * 设置客服id
     */
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    /**
     * 获取被接待的用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置被接待的用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
