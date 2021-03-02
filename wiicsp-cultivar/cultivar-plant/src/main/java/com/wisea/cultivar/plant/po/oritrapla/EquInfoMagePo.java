package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.vo.oritrapla.EquInfoMageVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className EquInfoMagePo
 * @date 2019/2/25 9:57
 * @Description
 */
@ApiModel("设备信息Po")
public class EquInfoMagePo extends PagePo<EquInfoMageVo> {
    @ApiModelProperty(value = "用户ID", hidden = true)
    private Long userId;
    @ApiModelProperty(value = "设备类型0传感设备，1视频设备")
    @Check(test="required")
    private String equType;
    @ApiModelProperty("地块ID（App端 - 档案列表 - 环境监测传入改值）")
    private Long massifId;
    @ApiModelProperty("后台查询输入框")
    private String query;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEquType() {
        return equType;
    }

    public void setEquType(String equType) {
        this.equType = equType;
    }

    public Long getMassifId() {
        return massifId;
    }

    public void setMassifId(Long massifId) {
        this.massifId = massifId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
