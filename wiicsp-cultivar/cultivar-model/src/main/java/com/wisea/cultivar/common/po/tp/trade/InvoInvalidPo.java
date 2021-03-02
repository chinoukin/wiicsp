package com.wisea.cultivar.common.po.tp.trade;

import com.wisea.cultivar.common.po.tp.LongIdPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className InvoInvalidPo
 * @date 2019/4/27 13:01
 * @Description 发票作废Po
 */
@ApiModel("发票作废PO")
public class InvoInvalidPo extends LongIdPo {
    @ApiModelProperty("作废备注")
    private String cancelRemarks;

    public String getCancelRemarks() {
        return cancelRemarks;
    }

    public void setCancelRemarks(String cancelRemarks) {
        this.cancelRemarks = cancelRemarks;
    }
}
