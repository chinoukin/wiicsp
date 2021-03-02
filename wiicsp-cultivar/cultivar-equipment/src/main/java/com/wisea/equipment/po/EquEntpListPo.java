package com.wisea.equipment.po;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.equipment.vo.EquEntpListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className EquEntpListPo
 * @date 2020/7/6 14:56
 * @Description
 */
@ApiModel("查询设备厂商列表PO")
public class EquEntpListPo extends PagePo<EquEntpListVo> {
    @ApiModelProperty("设备厂商名称")
    private String equEntpName;

    public String getEquEntpName() {
        return equEntpName;
    }

    public void setEquEntpName(String equEntpName) {
        this.equEntpName = equEntpName;
    }
}
