package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * DetectionMechMageInsertPo
 * 2018/09/18 14:36:47
 */
public class DetectionMechMageInsertPo {
    /**
     * 机构编号
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "机构编号")
    private String orgNum;

    /**
     * 机构名称
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "机构名称")
    private String orgName;

    /**
     * 操作人
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "操作人")
    private String operator;

    /**
     * 操作时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "操作时间")
    private OffsetDateTime operatDate;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

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

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}
