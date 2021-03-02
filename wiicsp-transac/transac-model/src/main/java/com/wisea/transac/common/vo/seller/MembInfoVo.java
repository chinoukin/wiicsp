package com.wisea.transac.common.vo.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("账号信息")
public class MembInfoVo {

    @ApiModelProperty(value = "用户ID")
    private Long id;

    @ApiModelProperty("姓名/用户名/手机号")
    private String name;

    @ApiModelProperty(value="会员昵称")
    private String petName;

    @ApiModelProperty("姓名")
    private String contName;

    @ApiModelProperty(value = "LOGO")
    private String logoUrl;

    @ApiModelProperty(value = "公司名称")
    private String entpName;

    @ApiModelProperty(value = "用户名")
    private String loginName;

    @ApiModelProperty(value = "注册手机号")
    private String registTel;

    @ApiModelProperty(value = "职位")
    private String position;

    @ApiModelProperty(value = "性别类型")
    private String sexType;

    @ApiModelProperty(value="是否设置用户名(0:是(已经设置过)1：否)")
    private String loginNameSetFlag;

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getRegistTel() {
        return registTel;
    }

    public void setRegistTel(String registTel) {
        this.registTel = registTel;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSexType() {
        return sexType;
    }

    public void setSexType(String sexType) {
        this.sexType = sexType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginNameSetFlag() {
        return loginNameSetFlag;
    }

    public void setLoginNameSetFlag(String loginNameSetFlag) {
        this.loginNameSetFlag = loginNameSetFlag;
    }
}
