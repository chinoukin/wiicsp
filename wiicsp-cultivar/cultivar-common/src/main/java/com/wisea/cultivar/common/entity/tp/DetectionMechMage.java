package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * detection_mech_mage 表实体
 * 检测机构管理
 * 2018/09/18 14:36:47
 */
public class DetectionMechMage extends DataLongEntity<DetectionMechMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 机构编号
     */
    private String orgNum;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 操作时间
     */
    private OffsetDateTime operatDate;

    /**
     * 获取机构编号
     */
    public String getOrgNum() {
        return orgNum;
    }

    /**
     * 设置机构编号
     */
    public void setOrgNum(String orgNum) {
        this.orgNum = orgNum == null ? null : orgNum.trim();
    }

    /**
     * 获取机构名称
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 设置机构名称
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    /**
     * 获取操作人
     */
    public String getOperator() {
        return operator;
    }

    /**
     * 设置操作人
     */
    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    /**
     * 获取操作时间
     */
    public OffsetDateTime getOperatDate() {
        return operatDate;
    }

    /**
     * 设置操作时间
     */
    public void setOperatDate(OffsetDateTime operatDate) {
        this.operatDate = operatDate;
    }
}
