package com.wisea.cultivar.common.po.tp.memb;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 传入数据ID（可不传值）
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月5日
 * @version 1.0
 */
@ApiModel("传入数据ID（可不传值）Po")
public class NotReqLongIdPo {
    @ApiModelProperty("数据ID")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
