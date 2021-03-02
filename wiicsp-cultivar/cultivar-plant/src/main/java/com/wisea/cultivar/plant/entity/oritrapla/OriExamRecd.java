package com.wisea.cultivar.plant.entity.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import java.time.OffsetDateTime;

/**
 * 检测记录
 */
public class OriExamRecd extends DataLongEntity<OriExamRecd> {
    private Long examRecdRelaId; //检测记录关系id
    private Long mineArchId; //我的档案id
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime examDate; //检测日期
    private String examPrjet; //检测项目
    private String examResultType; //检测结果类型（合格，不合格）
    private String examModeType; //检测方式（送检，自检）
    private String examOrg; //检测机构
    private String examConc; //检测结论
    private Long recdBelongMembId; //记录所属会员id

    public Long getExamRecdRelaId() {
        return examRecdRelaId;
    }

    public void setExamRecdRelaId(Long examRecdRelaId) {
        this.examRecdRelaId = examRecdRelaId;
    }

    public Long getMineArchId() {
        return mineArchId;
    }

    public void setMineArchId(Long mineArchId) {
        this.mineArchId = mineArchId;
    }

    public OffsetDateTime getExamDate() {
        return examDate;
    }

    public void setExamDate(OffsetDateTime examDate) {
        this.examDate = examDate;
    }

    public String getExamPrjet() {
        return examPrjet;
    }

    public void setExamPrjet(String examPrjet) {
        this.examPrjet = examPrjet;
    }

    public String getExamResultType() {
        return examResultType;
    }

    public void setExamResultType(String examResultType) {
        this.examResultType = examResultType;
    }

    public String getExamModeType() {
        return examModeType;
    }

    public void setExamModeType(String examModeType) {
        this.examModeType = examModeType;
    }

    public String getExamOrg() {
        return examOrg;
    }

    public void setExamOrg(String examOrg) {
        this.examOrg = examOrg;
    }

    public String getExamConc() {
        return examConc;
    }

    public void setExamConc(String examConc) {
        this.examConc = examConc;
    }

    public Long getRecdBelongMembId() {
        return recdBelongMembId;
    }

    public void setRecdBelongMembId(Long recdBelongMembId) {
        this.recdBelongMembId = recdBelongMembId;
    }
}
