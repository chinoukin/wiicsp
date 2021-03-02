package com.wisea.transac.operation.customer.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * SysImCustomerConfigListVo
 * 2018/09/29 13:46:47
 */
public class SysImCustomerConfigListVo {
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
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

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
}
