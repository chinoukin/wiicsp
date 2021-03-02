package com.wisea.cultivar.common.vo.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * 检测报告图片
 */
public class ExamReportPicture extends DataLongEntity<ExamReportPicture> {
    private Long examRecdId; //检测记录id
    private String url; //附件url

    public Long getExamRecdId() {
        return examRecdId;
    }

    public void setExamRecdId(Long examRecdId) {
        this.examRecdId = examRecdId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
