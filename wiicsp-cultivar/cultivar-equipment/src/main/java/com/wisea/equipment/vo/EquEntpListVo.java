package com.wisea.equipment.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className EquEntpListVo
 * @date 2020/7/6 14:56
 * @Description 设备厂商列表VO
 */
@ApiModel("设备厂商列表VO")
public class EquEntpListVo {
    @ApiModelProperty("设备厂商ID")
    private Long id;
    @ApiModelProperty("厂商名称")
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
