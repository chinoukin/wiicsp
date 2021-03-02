package com.wisea.transac.operation.customer.po;

import java.util.List;

import com.google.common.collect.Lists;
import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModelProperty;

/**
 * 分配客服PO
 *
 * @author XuDL(Wisea)
 *
 *         2018年10月10日 下午5:02:07
 */
public class SysImCustomerDispatchPo {

    @Check(test = { "required" })
    @ApiModelProperty(value = "分组id 1(系统客服id)", notes = "分发数组，从数组中分发遍历查找接待客服，有一个有返回即为结果  例：从档口进入['档口id','店铺id']  从店铺进入['店铺id'] 联系平台['1']")
    private List<String> groupIds = Lists.newArrayList();

    public List<String> getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(List<String> groupIds) {
        this.groupIds = groupIds;
    }

}
