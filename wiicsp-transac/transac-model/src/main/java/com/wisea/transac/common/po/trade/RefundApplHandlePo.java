package com.wisea.transac.common.po.trade;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.po.LongIdPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className RefundApplHandlePo
 * @date 2020/5/11 9:43
 * @Description
 */
@ApiModel("卖家退款处理Po")
public class RefundApplHandlePo extends LongIdPo {
    @ApiModelProperty("处理结果类型")
    @Check(test = "required", requiredMsg = "处理结果类型不能为空")
    private String sellerOperatType;
    @ApiModelProperty("处理备注")
    @Check(test = "logic", logic = "'1'.equals(#sellerOperatType) ? #isNotEmpty(#operatRemarks) : true", logicMsg = "处理备注不能为空")
    private String operatRemarks;

    public String getSellerOperatType() {
        return sellerOperatType;
    }

    public void setSellerOperatType(String sellerOperatType) {
        this.sellerOperatType = sellerOperatType;
    }

    public String getOperatRemarks() {
        return operatRemarks;
    }

    public void setOperatRemarks(String operatRemarks) {
        this.operatRemarks = operatRemarks;
    }
}
