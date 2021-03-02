package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className UpdateStatusPo
 * @date 2019/3/25 16:07
 * @Description 批量修改状态PO
 */
@ApiModel("批量修改状态PO")
public class UpdateStatusPo extends LongIdPo {
    @ApiModelProperty("状态值")
    @Check(test = "required")
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
