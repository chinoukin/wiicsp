package com.wisea.cultivar.explorer.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className PalntBigDataInfoPo
 * @date 2020/9/2 16:07
 * @Description 查询基地/地块 详细信息Po
 */
public class PalntBigDataInfoPo {
    @ApiModelProperty("数据ID")
    @Check(test = "required")
    private Long id;
    @ApiModelProperty("数据类型：0 种植主体 、1 示范基地 、2 种植主体地块 、3 示范基地地块")
    @Check(test = "liveable", liveable = {"0", "1", "2", "3"}, liveableMsg = "数据类型错误")
    private String dataType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
