package com.wisea.cultivar.origin.entity;

import java.time.OffsetDateTime;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * 品鉴会信息Entity
 *
 * @author wangh(wisea)
 *
 * @date 2018年8月30日
 * @version 1.0
 */
public class JudgeMeetInfo extends DataLongEntity<JudgeMeetInfo> {
	/**
	 *
	 */
	private static final long serialVersionUID = 8708195100348442096L;

	private String judgeMeetName;

	private String hostUnit;

	private OffsetDateTime startDate;

	private OffsetDateTime endDate;

	private String startTime;

	private String endTime;

	private String address;

	private String operator;

	private OffsetDateTime operatDate;

	private String contacts;

	private String tel;

	private String judgeMeetIntroduce;

	public String getJudgeMeetName() {
		return judgeMeetName;
	}

	public void setJudgeMeetName(String judgeMeetName) {
		this.judgeMeetName = judgeMeetName;
	}

	public String getHostUnit() {
		return hostUnit;
	}

	public void setHostUnit(String hostUnit) {
		this.hostUnit = hostUnit;
	}

	public OffsetDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(OffsetDateTime startDate) {
		this.startDate = startDate;
	}

	public OffsetDateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(OffsetDateTime endDate) {
		this.endDate = endDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getJudgeMeetIntroduce() {
		return judgeMeetIntroduce;
	}

	public void setJudgeMeetIntroduce(String judgeMeetIntroduce) {
		this.judgeMeetIntroduce = judgeMeetIntroduce;
	}

}
