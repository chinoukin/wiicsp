package com.wisea.cultivar.operation.customer.po;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModelProperty;

/**
 * 减少接待人数客服PO
 *
 * @author XuDL(Wisea)
 *
 *         2018年10月10日 下午5:02:07
 */
public class SysImCustomerSubSerCountPo {
    @Check(test = { "required" })
    @ApiModelProperty(value = "分组id 1(系统客服id)或用户id")
    private String groupId;
    @Check(test = { "required" })
    @ApiModelProperty(value = "客服id")
    private Long customerId;

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

}
