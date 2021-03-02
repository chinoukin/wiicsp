package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

public class LtaContFile extends DataLongEntity<LtaContFile> {
    /**
     * 合同id
     */
    private Long ltaContId;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 合同附件url
     */
    private String url;

    public Long getLtaContId() {
        return ltaContId;
    }

    public void setLtaContId(Long ltaContId) {
        this.ltaContId = ltaContId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
