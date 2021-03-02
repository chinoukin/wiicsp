package com.wisea.cultivar.common.vo.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("档口销售员工分页查询Vo")
public class SaleStaffInfoMagePageListVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="会员id")
    private Long membId;

    @ApiModelProperty(value="销售员工id（会员id）")
    private Long saleStaffId;

    @ApiModelProperty(value="停启用状态")
    private String effeInvalState;

    @ApiModelProperty(value="关联状态")
    private String purchaseTeamState;

    @ApiModelProperty(value="个人介绍")
    private String signature;

    @ApiModelProperty(value="是否设置成为管理员/角色")
    private String sfAdminFlag;

    @ApiModelProperty(value="员工姓名")
    private String staffName;

    @ApiModelProperty(value="职位")
    private String position;

    @ApiModelProperty(value="性别类型")
    private String sexType;

    @ApiModelProperty(value="档口关系启用")
    private String stallsEffeInvalState;
    @ApiModelProperty(value="关系类型")
    private String relaStateType;
    @ApiModelProperty(value="手机号")
    private String registTel;

    public String getStallsEffeInvalState() {
        return stallsEffeInvalState;
    }

    public void setStallsEffeInvalState(String stallsEffeInvalState) {
        this.stallsEffeInvalState = stallsEffeInvalState;
    }

    public String getRelaStateType() {
        return relaStateType;
    }

    public void setRelaStateType(String relaStateType) {
        this.relaStateType = relaStateType;
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

    public Long getSaleStaffId() {
        return saleStaffId;
    }

    public void setSaleStaffId(Long saleStaffId) {
        this.saleStaffId = saleStaffId;
    }

    public String getEffeInvalState() {
        return effeInvalState;
    }

    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState;
    }

    public String getPurchaseTeamState() {
        return purchaseTeamState;
    }

    public void setPurchaseTeamState(String purchaseTeamState) {
        this.purchaseTeamState = purchaseTeamState;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
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

    public String getRegistTel() {
        return registTel;
    }

    public void setRegistTel(String registTel) {
        this.registTel = registTel;
    }
}
