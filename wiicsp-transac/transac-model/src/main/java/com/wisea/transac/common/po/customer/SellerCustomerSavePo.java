package com.wisea.transac.common.po.customer;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModelProperty;

public class SellerCustomerSavePo {
    /**
     * 类型 0:轮询 1:指定
     */
    @Check(test = { "liveable" }, liveable = { "0", "1" })
    @ApiModelProperty(value = "类型 0:平均接待 1:余量接待")
    private String type = "0";

    /**
     * 接待服务最大数量
     */
    @Check(test = { "required" })
    @ApiModelProperty(value = "接待服务最大数量")
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Integer getSerMaxCount() {
        return serMaxCount;
    }

    public void setSerMaxCount(Integer serMaxCount) {
        this.serMaxCount = serMaxCount;
    }

}
