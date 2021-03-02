package com.wisea.transac.common.po;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.po.LongIdPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className EnableFreezePo
 * @date 2020/5/12 15:56
 * @Description 启用/停用PO
 */
@ApiModel("启用/停用PO")
public class EnableDisablePo extends LongIdPo {
    @ApiModelProperty("启用/停用类型 0 启用 、1 停用")
    @Check(test = "required", requiredMsg = "启用/停用类型不能为空", liveable = {"0", "1"}, liveableMsg = "启用/停用类型有效值为0或1")
    private String enableDisableType;

    public String getEnableDisableType() {
        return enableDisableType;
    }

    public void setEnableDisableType(String enableDisableType) {
        this.enableDisableType = enableDisableType;
    }
}
