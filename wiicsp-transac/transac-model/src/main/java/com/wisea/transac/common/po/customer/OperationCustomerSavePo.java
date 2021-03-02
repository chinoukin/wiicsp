package com.wisea.transac.common.po.customer;

import java.util.List;

import com.google.common.collect.Lists;
import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModelProperty;

public class OperationCustomerSavePo {
    /**
     * 接待服务最大数量
     */
    @Check(test = { "required" })
    @ApiModelProperty(value = "接待服务最大数量")
    private Integer serMaxCount;

    /**
     * 类型 0:轮询 1:指定
     */
    @ApiModelProperty(value = "类型 0:轮询 1:指定")
    @Check(test = { "required" })
    private String type;

    /**
     * 用户ID列表
     */
    @Check(test = { "required" })
    @ApiModelProperty(value = "用户ID列表", notes = "会对用户进行同步操作，不在列表中的会被删除")
    private List<Long> userIdList = Lists.newArrayList();

    public Integer getSerMaxCount() {
        return serMaxCount;
    }

    public void setSerMaxCount(Integer serMaxCount) {
        this.serMaxCount = serMaxCount;
    }

    public List<Long> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<Long> userIdList) {
        this.userIdList = userIdList;
    }

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
