package com.wisea.cultivar.common.po.tp.lta;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className LtaUpdateExpensePo
 * @date 2019/8/22 15:04
 * @Description 长期协议修改订单费用po
 */
public class LtaUpdateExpensePo {
    @Check(test = "required")
    @ApiModelProperty("订单ID")
    private Long ordId;
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]{0,2})$|^[1-9]\\d*(\\.[0-9]{1,2})?$", regexMsg = "订单运费小数保留两位")
    @ApiModelProperty("订单运费")
    private Double commTotalFreight;
    @ApiModelProperty("商品总金额")
    @Check(test = { "regex" }, regex = "^(0\\.[0-9]{0,2})$|^[1-9]\\d*(\\.[0-9]{1,2})?$", regexMsg = "商品总金额需要大于0，小数保留两位")
    private Double commTotalPrice;
    @ApiModelProperty("是否保存标记，0 计算，1 保存")
    @Check(test = "liveable", liveable = {"0", "1"}, liveableMsg = "是否保存标记有效值：0、1")
    private String saveFlag;

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

    public Double getCommTotalPrice() {
        return commTotalPrice;
    }

    public void setCommTotalPrice(Double commTotalPrice) {
        this.commTotalPrice = commTotalPrice;
    }

    public String getSaveFlag() {
        return saveFlag;
    }

    public void setSaveFlag(String saveFlag) {
        this.saveFlag = saveFlag;
    }
}
