package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Auth： jirg
 * CreateDate:  2018/6/7
 * projectName:  oritrapla
 * remark:  导出追溯码PO
 */
@ApiModel("导出追溯码PO")
public class ExportRtspCodePo {
    @ApiModelProperty("追溯码申请ID")
    @Check(test = "required", requiredMsg = "追溯码申请ID不能为空")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
