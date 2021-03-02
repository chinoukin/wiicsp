package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * @Author jirg
 * @Date 2019/3/22 15:40
 * @Description 操作日志图片
 **/
public class OriOperateLogPic extends DataLongEntity<OriOperateLogPic> {
    /**
     * 养殖日志id
     */
    private Long breedLogId;

    /**
     * 操作图片
     */
    private String operateUrl;

    public Long getBreedLogId() {
        return breedLogId;
    }

    public void setBreedLogId(Long breedLogId) {
        this.breedLogId = breedLogId;
    }

    public String getOperateUrl() {
        return operateUrl;
    }

    public void setOperateUrl(String operateUrl) {
        this.operateUrl = operateUrl;
    }
}
