package com.wisea.transac.common.vo.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className ApPayMageCountVo
 * @date 2020/5/12 14:46
 * @Description
 */
@ApiModel("账期支付设置角标Vo")
public class ApPayMageCountVo {
    @ApiModelProperty("已设置角标")
    private Integer hasBeenSetCount;
    @ApiModelProperty("冻结角标")
    private Integer freezeCount;
    @ApiModelProperty("未设置角标")
    private Integer notSetCount;

    public Integer getHasBeenSetCount() {
        return hasBeenSetCount;
    }

    public void setHasBeenSetCount(Integer hasBeenSetCount) {
        this.hasBeenSetCount = hasBeenSetCount;
    }

    public Integer getFreezeCount() {
        return freezeCount;
    }

    public void setFreezeCount(Integer freezeCount) {
        this.freezeCount = freezeCount;
    }

    public Integer getNotSetCount() {
        return notSetCount;
    }

    public void setNotSetCount(Integer notSetCount) {
        this.notSetCount = notSetCount;
    }
}
