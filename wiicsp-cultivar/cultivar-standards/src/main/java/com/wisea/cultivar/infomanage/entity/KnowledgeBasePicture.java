package com.wisea.cultivar.infomanage.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

import java.time.OffsetDateTime;

public class KnowledgeBasePicture extends DataLongEntity<KnowledgeBasePicture> {
    private static final long serialVersionUID = 1L;
     //知识库管理id
    private Long knowledgeBaseMageId;
    //图片url
    private String url;
    //创建者
    private String createBy;
    //创建时间
    private OffsetDateTime createDate;
    //更新者
    private String updateBy;
    //更新时间
    private OffsetDateTime updateDate;
    //备注
    private String remarks;
   //删除标记
    private String delFlag;

    public Long getKnowledgeBaseMageId() {
        return knowledgeBaseMageId;
    }

    public void setKnowledgeBaseMageId(Long knowledgeBaseMageId) {
        this.knowledgeBaseMageId = knowledgeBaseMageId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getCreateBy() {
        return createBy;
    }

    @Override
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    @Override
    public void setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public String getUpdateBy() {
        return updateBy;
    }

    @Override
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public OffsetDateTime getUpdateDate() {
        return updateDate;
    }

    @Override
    public void setUpdateDate(OffsetDateTime updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String getRemarks() {
        return remarks;
    }

    @Override
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String getDelFlag() {
        return delFlag;
    }

    @Override
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
