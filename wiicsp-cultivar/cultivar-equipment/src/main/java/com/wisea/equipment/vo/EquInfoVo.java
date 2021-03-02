package com.wisea.equipment.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className EquInfoVo
 * @date 2020/7/7 10:50
 * @Description 设备详细信息VO
 */
@ApiModel("设备详细信息VO")
public class EquInfoVo {
    @ApiModelProperty("设备ID")
    private Long id;
    @ApiModelProperty("设备名称")
    private String equName;
    @ApiModelProperty("设备编号")
    private String equNum;
    @ApiModelProperty("设备厂商ID")
    private Long equEntpId;
    @ApiModelProperty("设备厂商")
    private String equEntpName;
    @ApiModelProperty("设备型号ID")
    private Long equModelId;
    @ApiModelProperty("设备型号")
    private String equModel;
    @ApiModelProperty("生产序列号")
    private String psn;
    @ApiModelProperty("扩展字段1")
    private String extFirst;
    @ApiModelProperty("扩展字段2")
    private String extSecond;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getEquEntpName() {
        return equEntpName;
    }

    public void setEquEntpName(String equEntpName) {
        this.equEntpName = equEntpName;
    }

    public Long getEquModelId() {
        return equModelId;
    }

    public void setEquModelId(Long equModelId) {
        this.equModelId = equModelId;
    }

    public String getEquModel() {
        return equModel;
    }

    public void setEquModel(String equModel) {
        this.equModel = equModel;
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
