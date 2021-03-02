package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

/**
 * judge_meet_info 表实体
 * 品鉴会信息
 * 2018/09/18 14:36:47
 */
public class JudgeMeetInfo extends DataLongEntity<JudgeMeetInfo> {
    private static final long serialVersionUID = 1L;

    /**
     * 品鉴会名称
     */
    private String judgeMeetName;

    /**
     * 主办单位
     */
    private String hostUnit;

    /**
     * 开始日期
     */
    private OffsetDateTime startDate;

    /**
     * 结束日期
     */
    private OffsetDateTime endDate;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;

    /**
     * 地址
     */
    private String address;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 操作时间
     */
    private OffsetDateTime operatDate;

    /**
     * 品鉴会介绍
     */
    private String judgeMeetIntroduce;

    /**
     * 获取品鉴会名称
     */
    public String getJudgeMeetName() {
        return judgeMeetName;
    }

    /**
     * 设置品鉴会名称
     */
    public void setJudgeMeetName(String judgeMeetName) {
        this.judgeMeetName = judgeMeetName == null ? null : judgeMeetName.trim();
    }

    /**
     * 获取主办单位
     */
    public String getHostUnit() {
        return hostUnit;
    }

    /**
     * 设置主办单位
     */
    public void setHostUnit(String hostUnit) {
        this.hostUnit = hostUnit == null ? null : hostUnit.trim();
    }

    /**
     * 获取开始日期
     */
    public OffsetDateTime getStartDate() {
        return startDate;
    }

    /**
     * 设置开始日期
     */
    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取结束日期
     */
    public OffsetDateTime getEndDate() {
        return endDate;
    }

    /**
     * 设置结束日期
     */
    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取开始时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    /**
     * 获取结束时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置结束时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    /**
     * 获取地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取联系人
     */
    public String getContacts() {
        return contacts;
    }

    /**
     * 设置联系人
     */
    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    /**
     * 获取联系电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置联系电话
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
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

    /**
     * 获取品鉴会介绍
     */
    public String getJudgeMeetIntroduce() {
        return judgeMeetIntroduce;
    }

    /**
     * 设置品鉴会介绍
     */
    public void setJudgeMeetIntroduce(String judgeMeetIntroduce) {
        this.judgeMeetIntroduce = judgeMeetIntroduce == null ? null : judgeMeetIntroduce.trim();
    }
}
