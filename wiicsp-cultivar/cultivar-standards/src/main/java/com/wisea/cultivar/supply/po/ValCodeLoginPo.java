package com.wisea.cultivar.supply.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * 手机验证码登录
 * @author chengq
 * @date 2020/8/20 18:08
 */
public class ValCodeLoginPo {

    @ApiModelProperty("手机号")
    @Check(test = "required")
    private String mobile;

    @ApiModelProperty("验证码")
    @Check(test = "required")
    private String valCode;

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
}
