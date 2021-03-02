package com.wisea.transac.common.po.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 传入数据ID
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月5日
 * @version 1.0
 */
@ApiModel("数据ID Po")
public class FocusPo {
    @ApiModelProperty(value = "数据ID",hidden = true)
    private Long id;

    @ApiModelProperty(value = "标示",hidden = true)
    private String flag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
