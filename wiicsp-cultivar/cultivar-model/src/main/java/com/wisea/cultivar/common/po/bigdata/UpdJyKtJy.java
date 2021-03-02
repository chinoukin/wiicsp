package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * PlaceOriginMageBatDeletePo
 * 2019/12/02 11:02:15
 */
public class UpdJyKtJy {

    @Check(test = "required")
    @ApiModelProperty(value = "ID")
    private Long id;
    @Check(test = "required")
    @ApiModelProperty(value = "0：开通；1：禁用；2：删除")
    private String ktflag;

    public String getKtflag() {
        return ktflag;
    }
    public void setKtflag(String ktflag) {
        this.ktflag = ktflag;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
