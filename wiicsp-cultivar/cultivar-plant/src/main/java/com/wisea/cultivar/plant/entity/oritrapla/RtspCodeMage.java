package com.wisea.cultivar.plant.entity.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;

import java.time.OffsetDateTime;

/**
 * 追溯码管理
 */
public class RtspCodeMage extends DataLongEntity<RtspCodeMage> {
    private Long membId; //会员id
    private Long mineArchId; //我的档案id
    private String archNum; //档案编号
    private String batchNum; //批次编号
    private Integer rtspCodeCount; //追溯码数量
    private String printMethType; //打印方式类型（自行打印，平台打印）
    private String recipients; //收件人
    private String contInform; //联系方式
    private String contAddress; //联系地址
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime applyDate; //申请时间

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public Long getMineArchId() {
        return mineArchId;
    }

    public void setMineArchId(Long mineArchId) {
        this.mineArchId = mineArchId;
    }

    public String getArchNum() {
        return archNum;
    }

    public void setArchNum(String archNum) {
        this.archNum = archNum;
    }

    public String getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum;
    }

    public Integer getRtspCodeCount() {
        return rtspCodeCount;
    }

    public void setRtspCodeCount(Integer rtspCodeCount) {
        this.rtspCodeCount = rtspCodeCount;
    }

    public String getPrintMethType() {
        return printMethType;
    }

    public void setPrintMethType(String printMethType) {
        this.printMethType = printMethType;
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    public String getContInform() {
        return contInform;
    }

    public void setContInform(String contInform) {
        this.contInform = contInform;
    }

    public String getContAddress() {
        return contAddress;
    }

    public void setContAddress(String contAddress) {
        this.contAddress = contAddress;
    }

    public OffsetDateTime getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(OffsetDateTime applyDate) {
        this.applyDate = applyDate;
    }
}
