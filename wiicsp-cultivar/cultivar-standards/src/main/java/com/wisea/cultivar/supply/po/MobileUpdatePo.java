package com.wisea.cultivar.supply.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * 修改手机号
 * @author chengq
 * @date 2020/8/20 18:08
 */
public class MobileUpdatePo {

    /**
     * 注册手机号
     */
    @ApiModelProperty("注册手机号")
    @Check(test = "required", requiredMsg = "注册手机号不能为空")
    private String registeredMobile;

    /**
     * 验证码
     */
    @ApiModelProperty("验证码")
    @Check(test = "required", requiredMsg = "验证码不能为空")
    private String valCode;

    /**
     * 新手机号
     */
    @ApiModelProperty("新手机号")
    @Check(test = "required", requiredMsg = "新手机号不能为空")
    private String newMobile;

    public String getRegisteredMobile() {
        return registeredMobile;
    }

    public void setRegisteredMobile(String registeredMobile) {
        this.registeredMobile = registeredMobile;
    }

    public String getValCode() {
        return valCode;
    }

    public void setValCode(String valCode) {
        this.valCode = valCode;
    }

    public String getNewMobile() {
        return newMobile;
    }

    public void setNewMobile(String newMobile) {
        this.newMobile = newMobile;
    }
}
