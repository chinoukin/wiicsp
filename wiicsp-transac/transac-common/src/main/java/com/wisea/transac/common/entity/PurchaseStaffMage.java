package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class PurchaseStaffMage extends DataLongEntity<PurchaseStaffMage> {
    /**
     * 会员id
     */
    private Long membId;

    /**
     * 采购员工id（会员id）
     */
    private Long purchaseStaffId;

    /**
     * 是否发送短信邀请
     */
    private String sffsdxyqFlag;

    /**
     * 关联状态
     */
    private String purchaseTeamState;

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
