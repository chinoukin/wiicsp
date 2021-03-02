package com.wisea.transac.common.po.trade;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.po.LongIdPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className OrderHandleDisputesPo
 * @date 2020/5/26 17:08
 * @Description 处理争议订单Po
 */
@ApiModel("处理争议订单Po")
public class OrderHandleDisputesPo extends LongIdPo {
    @ApiModelProperty("处理备注")
    @Check(test="required")
    private String handleRemarks;

    public String getHandleRemarks() {
        return handleRemarks;
    }

    public void setHandleRemarks(String handleRemarks) {
        this.handleRemarks = handleRemarks;
    }
}
