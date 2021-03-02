package com.wisea.cultivar.common.po.tp.trade;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 修改订单运费PO
 */
@ApiModel("修改订单运费PO")
public class UpdateExpensePo {
    @Check(test = "required")
    @ApiModelProperty("订单ID")
    private Long ordId;
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]{0,2})$|^[1-9]\\d*(\\.[0-9]{1,2})?$", regexMsg = "订单运费小数保留两位")
    @ApiModelProperty("订单运费")
    private Double commTotalFreight;
    /*@ApiModelProperty("商品总金额")
    @Check(test = { "regex" }, regex = "^(0\\.[0-9]{0,2})$|^[1-9]\\d*(\\.[0-9]{1,2})?$", regexMsg = "商品总金额需要大于0，小数保留两位")
    private Double commTotalPrice;
    @ApiModelProperty("是否保存标记，0 计算，1 保存")
    @Check(test = "liveable", liveable = {"0", "1"}, liveableMsg = "是否保存标记有效值：0、1")
    private String saveFlag;*/

    @ApiModelProperty("订单商品列表")
    private List<UpdateOrdCommRelaPo> ordCommRelas;
    @ApiModelProperty("是否保存，true 保存、 false 计算价格")
    private Boolean saveFlag;

    public Long getOrdId() {
        return ordId;
    }

    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }

    public Double getCommTotalFreight() {
        return commTotalFreight;
    }

    public void setCommTotalFreight(Double commTotalFreight) {
        this.commTotalFreight = commTotalFreight;
    }

    public List<UpdateOrdCommRelaPo> getOrdCommRelas() {
        return ordCommRelas;
    }

    public void setOrdCommRelas(List<UpdateOrdCommRelaPo> ordCommRelas) {
        this.ordCommRelas = ordCommRelas;
    }

    public Boolean getSaveFlag() {
        return saveFlag;
    }

    public void setSaveFlag(Boolean saveFlag) {
        this.saveFlag = saveFlag;
    }
}
