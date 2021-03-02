package com.wisea.cultivar.common.entity.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.entity.DataLongEntity;
import com.wisea.cloud.model.annotation.IdSerializer;

import java.time.OffsetDateTime;

public class QuarantineReport extends DataLongEntity<QuarantineReport> {
    private Long membId; //会员id
    private String quarantineNum; //检疫证编号
    private String productName; //产品名称/动物种类
    private String slDw; //数量及单位
    private String originPlace; //产地
    private String shipper; //货主
    private OffsetDateTime issueDate; //签发日期
    private String tel; //联系电话

    /**
     * 证书id
     * @return
     */
    @JsonSerialize(using = IdSerializer.class)
    private Long labelLitInfoId;

    /**
     * 检疫合格证type
     * @return
     */
    private String labelRelaType;

    public String getLabelRelaType() {
        return labelRelaType;
    }

    public void setLabelRelaType(String labelRelaType) {
        this.labelRelaType = labelRelaType;
    }

    public Long getLabelLitInfoId() {
        return labelLitInfoId;
    }

    public void setLabelLitInfoId(Long labelLitInfoId) {
        this.labelLitInfoId = labelLitInfoId;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getQuarantineNum() {
        return quarantineNum;
    }

    public void setQuarantineNum(String quarantineNum) {
        this.quarantineNum = quarantineNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSlDw() {
        return slDw;
    }

    public void setSlDw(String slDw) {
        this.slDw = slDw;
    }

    public String getOriginPlace() {
        return originPlace;
    }

    public void setOriginPlace(String originPlace) {
        this.originPlace = originPlace;
    }

    public String getShipper() {
        return shipper;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
    }

    public OffsetDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(OffsetDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
