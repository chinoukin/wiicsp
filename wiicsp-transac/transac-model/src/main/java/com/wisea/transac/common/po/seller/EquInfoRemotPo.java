package com.wisea.transac.common.po.seller;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className EquInfoRemotPo
 * @date 2020/7/7 14:07
 * @Description 远程调用设备服务，保存设备PO"
 */
@ApiModel("远程调用设备服务，保存设备PO")
public class EquInfoRemotPo {
    @ApiModelProperty("设备名称")
    @Check(test = { "required" })
    private String equName;
    @ApiModelProperty("设备编号")
    @Check(test = { "required" })
    private String equNum;
    @ApiModelProperty("设备厂商")
    @Check(test = { "required" })
    private Long equEntpId;
    @ApiModelProperty("设备型号")
    @Check(test = { "required" })
    private Long equModelId;
    @ApiModelProperty("生产序列号")
    private String psn;
    @ApiModelProperty("扩展字段1")
    private String extFirst;
    @ApiModelProperty("扩展字段2")
    private String extSecond;

    public String getEquName() {
        return equName;
    }

    public void setEquName(String equName) {
        this.equName = equName;
    }

    public String getEquNum() {
        return equNum;
    }

    public void setEquNum(String equNum) {
        this.equNum = equNum;
    }

    public Long getEquEntpId() {
        return equEntpId;
    }

    public void setEquEntpId(Long equEntpId) {
        this.equEntpId = equEntpId;
    }

    public Long getEquModelId() {
        return equModelId;
    }

    public void setEquModelId(Long equModelId) {
        this.equModelId = equModelId;
    }

    public String getPsn() {
        return psn;
    }

    public void setPsn(String psn) {
        this.psn = psn;
    }

    public String getExtFirst() {
        return extFirst;
    }

    public void setExtFirst(String extFirst) {
        this.extFirst = extFirst;
    }

    public String getExtSecond() {
        return extSecond;
    }

    public void setExtSecond(String extSecond) {
        this.extSecond = extSecond;
    }
}
