package com.wisea.cultivar.plant.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("新增或修改CommGyPubPicturePo")
public class CommGyPubPicturePo {
    @ApiModelProperty(value="数据ID，修改时该字段必填")
    private Long id;

    @ApiModelProperty(value="商品供应发布id")
    private Long commGyPubId;

    @ApiModelProperty(value="图片url")
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommGyPubId() {
        return commGyPubId;
    }

    public void setCommGyPubId(Long commGyPubId) {
        this.commGyPubId = commGyPubId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
