package com.wisea.cultivar.supply.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * 店铺业绩
 * @author chengq
 * @date 2020/8/12 10:04
 */
public class ShopPerformanceVo {

    @ApiModelProperty(value = "服务单金额", example = "56.2万")
    private String serListPrice;

    @ApiModelProperty(value = "服务单总数", example = "326笔")
    private String serListCount;

    @ApiModelProperty(value = "客户数", example = "300人")
    private String clientCount;

    @ApiModelProperty(value = "关注数", example = "500人")
    private String focusCount;

    public String getSerListPrice() {
        return serListPrice;
    }

    public void setSerListPrice(String serListPrice) {
        this.serListPrice = serListPrice;
    }

    public String getSerListCount() {
        return serListCount;
    }

    public void setSerListCount(String serListCount) {
        this.serListCount = serListCount;
    }

    public String getClientCount() {
        return clientCount;
    }

    public void setClientCount(String clientCount) {
        this.clientCount = clientCount;
    }

    public String getFocusCount() {
        return focusCount;
    }

    public void setFocusCount(String focusCount) {
        this.focusCount = focusCount;
    }
}
