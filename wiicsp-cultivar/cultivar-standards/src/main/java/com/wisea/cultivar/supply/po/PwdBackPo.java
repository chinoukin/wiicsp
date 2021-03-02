package com.wisea.cultivar.supply.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * 找回用户密码Po
 *
 * @author XuDL(Wisea)
 *
 *         2018年1月12日 下午3:34:03
 */
public class PwdBackPo {
    @ApiModelProperty(value = "手机号", required = true)
    @Check(test = "required")
    private String mobile;

    @ApiModelProperty(value = "验证码", required = true)
    @Check(test = "required")
    private String valCode;

    @ApiModelProperty(value = "新密码,需要进行md5", required = true)
    @Check(test = "required")
    private String newPassword;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getValCode() {
        return valCode;
    }

    public void setValCode(String valCode) {
        this.valCode = valCode;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
