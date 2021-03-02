package com.wisea.cultivar.common.po.customer;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModelProperty;

/**
 * SysImCustomerConfigUpdatePo 2018/09/29 13:46:47
 */
public class SysImCustomerConfigUpdatePo {
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 类型 0:轮询 1:指定
     */
    @Check(test = { "liveable" }, liveable = { "0", "1" })
    @ApiModelProperty(value = "类型 0:轮询 1:指定")
    private String type;

    /**
     * 接待服务最大数量
     */
    @Check(test = { "maxLength", "logic" }, length = 10, logic = "'0'.equals(#type)?#isNotEmpty(#serMaxCount):true", logicMsg = "使用轮询方式时，接待服务最大数量必填")
    @ApiModelProperty(value = "接待服务最大数量(使用  0:轮询 方式时，接待服务最大数量必填)")
    private Integer serMaxCount;

    /**
     * 最近联系人优先 0:否 1:是
     */
    @Check(test = { "liveable" }, liveable = { "0", "1" })
    @ApiModelProperty(value = "最近联系人优先 0:否 1:是")
    private String retContact = "0";

    /**
     * 管理员不参与自动分配 0:否 1:是
     */
    @Check(test = { "liveable" }, liveable = { "0", "1" })
    @ApiModelProperty(value = "管理员不参与自动分配 0:否 1:是")
    private String depNoAdmin = "1";

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
