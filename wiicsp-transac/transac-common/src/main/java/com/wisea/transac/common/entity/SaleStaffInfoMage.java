package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class SaleStaffInfoMage extends DataLongEntity<SaleStaffInfoMage> {
    /**
     * 会员id
     */
    private Long membId;

    /**
     * 销售员工id（会员id）
     */
    private Long saleStaffId;

    /**
     * 停启用状态
     */
    private String effeInvalState;

    /**
     * 关联状态
     */
    private String purchaseTeamState;

    /**
     * 个人介绍
     */
    private String signature;

    /**
     * 是否设置成为管理员
     */
    private String sfAdminFlag;

    /**
     * 员工姓名
     */
    private String staffName;

    /**
     * 职位
     */
    private String position;

    /**
     * 性别类型
     */
    private String sexType;

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
}
