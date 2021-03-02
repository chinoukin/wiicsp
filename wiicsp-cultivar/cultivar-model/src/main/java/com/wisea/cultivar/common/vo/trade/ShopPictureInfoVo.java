package com.wisea.cultivar.common.vo.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author wangs
 */
@ApiModel("Image picture Vo")
public class ShopPictureInfoVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="图片url")
    private String url;

    @ApiModelProperty(value="图片类型（主图、细节图）")
    private String certName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }
}
