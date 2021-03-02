package com.wisea.transac.common.po.customer;

import java.util.List;

import com.google.common.collect.Lists;

import io.swagger.annotations.ApiModelProperty;

public class SellerStallCustomerListVo {
    @ApiModelProperty(value = "分组id")
    private String groupId;
    @ApiModelProperty(value = "分组名称")
    private String groupName;
    @ApiModelProperty(value = "员工列表")
    private List<SaleStaffInfoMageCustomerInfoVo> customerList = Lists.newArrayList();

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<SaleStaffInfoMageCustomerInfoVo> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<SaleStaffInfoMageCustomerInfoVo> customerList) {
        this.customerList = customerList;
    }

}
