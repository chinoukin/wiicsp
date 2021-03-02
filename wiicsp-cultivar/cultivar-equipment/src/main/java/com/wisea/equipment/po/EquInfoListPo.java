package com.wisea.equipment.po;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.equipment.vo.EquInfoListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className EquInfoListPo
 * @date 2020/7/7 10:15
 * @Description 设备列表PO
 */
@ApiModel("设备列表PO")
public class EquInfoListPo extends PagePo<EquInfoListVo> {
    @ApiModelProperty("设备名称")
    private String equName;
    @ApiModelProperty("设备厂商")
    private String equEntpName;
    @ApiModelProperty("设备型号")
    private String equModel;
    @ApiModelProperty("设备编号")
    private String equNum;

    public String getEquName() {
        return equName;
    }

    public void setEquName(String equName) {
        this.equName = equName;
    }

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

    public String getEquNum() {
        return equNum;
    }

    public void setEquNum(String equNum) {
        this.equNum = equNum;
    }
}
