package com.wisea.transac.common.po.customer;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.Lists;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.transac.common.vo.MarketAcctNumMageInfoVo;

import io.swagger.annotations.ApiModelProperty;

/**
 * SysImCustomerConfigGetVo 2018/09/29 13:46:47
 */
public class OperationCustomerConfigGetVo {
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 分组id sys(系统客服)或用户id
     */
    @ApiModelProperty(value = "分组id sys(系统客服)或用户id")
    private String groupId;

    /**
     * 类型 0:轮询 1:指定
     */
    @ApiModelProperty(value = "类型 0:轮询 1:指定")
    private String type;

    /**
     * 接待服务最大数量
     */
    @ApiModelProperty(value = "接待服务最大数量")
    private Integer serMaxCount;
    /**
     * 最近联系人优先 0:否 1:是
     */
    @ApiModelProperty(value = "最近联系人优先 0:否 1:是")
    private String retContact = "0";

    /**
     * 管理员不参与自动分配 0:否 1:是
     */
    @ApiModelProperty(value = "管理员不参与自动分配 0:否 1:是")
    private String depNoAdmin = "1";

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    @ApiModelProperty(value = "客服列表")
    private List<MarketAcctNumMageInfoVo> customerList = Lists.newArrayList();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取分组id sys(系统客服)或用户id
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * 设置分组id sys(系统客服)或用户id
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    /**
     * 获取类型 0:轮询 1:指定
     */
    public String getType() {
        return type;
    }

    /**
     * 设置类型 0:轮询 1:指定
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取接待服务最大数量
     */
    public Integer getSerMaxCount() {
        return serMaxCount;
    }

    /**
     * 设置接待服务最大数量
     */
    public void setSerMaxCount(Integer serMaxCount) {
        this.serMaxCount = serMaxCount;
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

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getRetContact() {
        return retContact;
    }

    public void setRetContact(String retContact) {
        this.retContact = retContact;
    }

    public String getDepNoAdmin() {
        return depNoAdmin;
    }

    public void setDepNoAdmin(String depNoAdmin) {
        this.depNoAdmin = depNoAdmin;
    }

    public List<MarketAcctNumMageInfoVo> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<MarketAcctNumMageInfoVo> customerList) {
        this.customerList = customerList;
    }

}
