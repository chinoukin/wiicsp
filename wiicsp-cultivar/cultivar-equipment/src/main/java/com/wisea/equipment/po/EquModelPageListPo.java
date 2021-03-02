package com.wisea.equipment.po;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.equipment.vo.EquModelPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className EquModelListPo
 * @date 2020/7/6 16:19
 * @Description 查询设备型号列表PO
 */
@ApiModel("查询设备型号列表PO")
public class EquModelPageListPo extends PagePo<EquModelPageListVo> {
    @ApiModelProperty("设备厂商名称")
    private String equEntpName;
    @ApiModelProperty("设备型号名称")
    private String equModel;
    @ApiModelProperty("设备类型")
    private String equType;

    public String getEquEntpName() {
        return equEntpName;
    }

    public void setEquEntpName(String equEntpName) {
        this.equEntpName = equEntpName;
    }

    public String getEquModel() {
        return equModel;
    }

    public void setEquModel(String equModel) {
        this.equModel = equModel;
    }

    public String getEquType() {
        return equType;
    }

    public void setEquType(String equType) {
        this.equType = equType;
    }
}
