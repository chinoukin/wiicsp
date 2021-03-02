package com.wisea.cultivar.plant.po;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.vo.CommGyPubPicturePageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询CommGyPubPicturePo")
public class CommGyPubPicturePageListPo extends PagePo<CommGyPubPicturePageListVo> {
    @ApiModelProperty(value="商品供应发布id")
    private Long commGyPubId;

    @ApiModelProperty(value="图片url")
    private String url;

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
