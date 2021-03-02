package com.wisea.cultivar.common.po.tp.retro;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className RetroInfoPo
 * @date 2019/12/21 10:41
 * @Description 查询追溯详细信息PO
 */
@ApiModel("查询追溯详细信息PO")
public class RetroInfoPo {
    @ApiModelProperty("追溯码")
    @Check(test = "required")
    private String retroCode;
    @ApiModelProperty("手机端当前地址信息")
    private String position;

    public String getRetroCode() {
        return retroCode;
    }

    public void setRetroCode(String retroCode) {
        this.retroCode = retroCode;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
