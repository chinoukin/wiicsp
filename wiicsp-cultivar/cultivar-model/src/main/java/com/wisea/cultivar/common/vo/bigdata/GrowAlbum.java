package com.wisea.cultivar.common.vo.bigdata;

import com.wisea.cloud.common.entity.DataLongEntity;
import io.swagger.annotations.ApiModelProperty;

public class GrowAlbum extends DataLongEntity<GrowAlbum> {
    @ApiModelProperty("设备id")
    private Long equId;
    @ApiModelProperty("图片url")
    private String url;

    public Long getEquId() {
        return equId;
    }

    public void setEquId(Long equId) {
        this.equId = equId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
