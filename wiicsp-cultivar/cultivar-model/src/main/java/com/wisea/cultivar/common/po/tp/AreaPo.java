package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author:Liangzy(Wisea)
 * @Date:Create in 2018/9/27 下午1:25
 * @Description:地区CodePO
 */
public class AreaPo {

    /*
    * 地区的Code
    * */
    @ApiModelProperty(value="id")
    @Check(test = "required")
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
