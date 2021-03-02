package com.wisea.transac.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询Vo")
public class PurchaseStaffMagePageListVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="会员id")
    private Long membId;

    @ApiModelProperty(value="采购员工id（会员id）")
    private Long purchaseStaffId;

    @ApiModelProperty(value="是否发送短信邀请")
    private String sffsdxyqFlag;

    @ApiModelProperty(value="关联状态")
    private String purchaseTeamState;

    @ApiModelProperty(value="是否设置成为管理员")
    private String sfAdminFlag;

    @ApiModelProperty(value="员工姓名")
    private String staffName;

    @ApiModelProperty(value="职位")
    private String position;

    @ApiModelProperty(value="性别类型")
    private String sexType;

    @ApiModelProperty(value="备注：电话号")
    private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public Long getPurchaseStaffId() {
        return purchaseStaffId;
    }

    public void setPurchaseStaffId(Long purchaseStaffId) {
        this.purchaseStaffId = purchaseStaffId;
    }

    public String getSffsdxyqFlag() {
        return sffsdxyqFlag;
    }

    public void setSffsdxyqFlag(String sffsdxyqFlag) {
        this.sffsdxyqFlag = sffsdxyqFlag;
    }

    public String getPurchaseTeamState() {
        return purchaseTeamState;
    }

    public void setPurchaseTeamState(String purchaseTeamState) {
        this.purchaseTeamState = purchaseTeamState;
    }

    public String getSfAdminFlag() {
        return sfAdminFlag;
    }

    public void setSfAdminFlag(String sfAdminFlag) {
        this.sfAdminFlag = sfAdminFlag;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSexType() {
        return sexType;
    }

    public void setSexType(String sexType) {
        this.sexType = sexType;
    }
}
