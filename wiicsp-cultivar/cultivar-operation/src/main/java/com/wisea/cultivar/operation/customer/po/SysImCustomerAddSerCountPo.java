package com.wisea.cultivar.operation.customer.po;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModelProperty;

/**
 * 增加接待人数客服PO
 *
 * @author XuDL(Wisea)
 *
 *         2018年10月10日 下午5:02:07
 */
public class SysImCustomerAddSerCountPo {
    @Check(test = { "required" })
    @ApiModelProperty(value = "分组id 1(系统客服id)或用户id")
    private String groupId;
    @Check(test = { "required" })
    @ApiModelProperty(value = "客服id")
    private Long customerId;

    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "用户.id")
    private Long userId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
