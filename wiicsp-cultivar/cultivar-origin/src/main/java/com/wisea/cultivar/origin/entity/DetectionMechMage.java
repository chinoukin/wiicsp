package com.wisea.cultivar.origin.entity;

import java.time.OffsetDateTime;

import com.wisea.cloud.common.entity.DataLongEntity;
/**
 * 检测机构管理Entity
 *
 * @author wangh(wisea)
 *
 * @date 2018年8月30日
 * @version 1.0
 */
public class DetectionMechMage extends DataLongEntity<DetectionMechMage> {

    /**
	 *
	 */
	private static final long serialVersionUID = -7792277465944963729L;

	private String orgNum;

    private String orgName;

    private String operator;

    private  OffsetDateTime operatDate;

    public String getOrgNum() {
        return orgNum;
    }

    public void setOrgNum(String orgNum) {
        this.orgNum = orgNum;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

	public OffsetDateTime getOperatDate() {
		return operatDate;
	}

	public void setOperatDate(OffsetDateTime operatDate) {
		this.operatDate = operatDate;
	}


}
