package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 传入数据ID
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月5日
 * @version 1.0
 */
@ApiModel("设备ID和档案ID Po")
public class EquIdAndArchIdPo {
    @ApiModelProperty("设备ID")
    @Check(test = "required")
    private Long equId;
    @ApiModelProperty("档案ID")
    @Check(test = "required")
    private Long archId;

    public Long getEquId() {
        return equId;
    }

    public void setEquId(Long equId) {
        this.equId = equId;
    }

    public Long getArchId() {
        return archId;
    }

    public void setArchId(Long archId) {
        this.archId = archId;
    }
}
