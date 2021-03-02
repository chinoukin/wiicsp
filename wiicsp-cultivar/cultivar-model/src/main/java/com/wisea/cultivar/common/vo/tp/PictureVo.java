package com.wisea.cultivar.common.vo.tp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 图片VO
 */
@ApiModel("图片VO")
public class PictureVo {
    @ApiModelProperty("图片URL")
    private String url;
    @ApiModelProperty("买卖方标志（0 买方 、1 卖方）")
    private String buySellFlag;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBuySellFlag() {
        return buySellFlag;
    }

    public void setBuySellFlag(String buySellFlag) {
        this.buySellFlag = buySellFlag;
    }
}
