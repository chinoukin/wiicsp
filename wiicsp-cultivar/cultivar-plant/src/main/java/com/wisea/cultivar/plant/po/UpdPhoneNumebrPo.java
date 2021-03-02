package com.wisea.cultivar.plant.po;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @ClassNameUpdPhoneNumebrPo
 * @Description
 * @Author zhangbo
 * @Date2020/8/7 14:46
 **/
public class UpdPhoneNumebrPo {

    @NotNull(message = "原手机号码不能为空")
    @ApiModelProperty(value = "原手机号码")
    private String oldMobile;

    @NotNull(message = "新手机号码不能为空")
    @ApiModelProperty(value = "新手机号码")
    private String newMobile;

    @NotNull(message = "验证码不能为空")
    @ApiModelProperty(value = "验证码")
    private String valCode;

    @ApiModelProperty(value="会员id")
    @NotNull(message = "会员id不能为空")
    private Long id;

    public String getNewMobile() {
        return newMobile;
    }

    public void setNewMobile(String newMobile) {
        this.newMobile = newMobile;
    }

    public String getValCode() {
        return valCode;
    }

    public void setValCode(String valCode) {
        this.valCode = valCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOldMobile() {
        return oldMobile;
    }

    public void setOldMobile(String oldMobile) {
        this.oldMobile = oldMobile;
    }
}
