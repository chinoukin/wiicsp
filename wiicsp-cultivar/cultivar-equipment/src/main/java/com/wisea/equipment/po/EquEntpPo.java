package com.wisea.equipment.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className EquEntpPo
 * @date 2020/7/6 15:43
 * @Description 保存或修改设备厂商PO
 */
@ApiModel("保存或修改设备厂商PO")
public class EquEntpPo {
    @ApiModelProperty("数据ID，修改时非空")
    private Long id;
    @ApiModelProperty("厂商名称")
    @Check(test = { "required" })
    private String equEntpName;
    @ApiModelProperty("联系人")
    private String contact;
    @ApiModelProperty("联系电话")
    private String contactTel;
    @ApiModelProperty("厂商地址")
    private String equEntpAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquEntpName() {
        return equEntpName;
    }

    public void setEquEntpName(String equEntpName) {
        this.equEntpName = equEntpName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getEquEntpAddress() {
        return equEntpAddress;
    }

    public void setEquEntpAddress(String equEntpAddress) {
        this.equEntpAddress = equEntpAddress;
    }
}
