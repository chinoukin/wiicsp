package com.wisea.transac.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("项目配置分页查询Vo")
public class ItemConfigurePageListVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="公司名称")
    private String entpName;

    @ApiModelProperty(value="联系电话")
    private String tel;

    @ApiModelProperty(value="联系邮箱")
    private String email;

    @ApiModelProperty(value="联系地址")
    private String address;

    @ApiModelProperty(value="版权所有")
    private String copyright;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
}
