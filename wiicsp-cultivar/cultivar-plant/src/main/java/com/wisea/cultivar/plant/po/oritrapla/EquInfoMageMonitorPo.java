package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.vo.oritrapla.EquInfoMageMonitorVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className EquInfoMageMonitorPo
 * @date 2019/2/25 17:42
 * @Description
 */
@ApiModel("设备监控详情Po")
public class EquInfoMageMonitorPo extends PagePo<EquInfoMageMonitorVo> {
    @ApiModelProperty(value = "用户ID", hidden = true)
    private Long userId;

    @ApiModelProperty(value = "设备类型")
    private String equType;

    public String getEquType() {
        return equType;
    }

    public void setEquType(String equType) {
        this.equType = equType;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
