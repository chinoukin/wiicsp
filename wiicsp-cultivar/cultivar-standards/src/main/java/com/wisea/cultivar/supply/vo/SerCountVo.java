package com.wisea.cultivar.supply.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author chengq
 * @date 2020/8/16 8:21
 */
public class SerCountVo {

    /**
     * 销售中
     */
    @ApiModelProperty(value = "待确认", example = "99+")
    private String confirmCount;


    /**
     * 草稿
     */
    @ApiModelProperty("待服务")
    private String serviceCount;


    /**
     * 待审核
     */
    @ApiModelProperty("服务中")
    private String checkCount;

    public String getConfirmCount() {
        return confirmCount;
    }

    public void setConfirmCount(String confirmCount) {
        this.confirmCount = confirmCount;
    }

    public String getServiceCount() {
        return serviceCount;
    }

    public void setServiceCount(String serviceCount) {
        this.serviceCount = serviceCount;
    }

    public String getCheckCount() {
        return checkCount;
    }

    public void setCheckCount(String checkCount) {
        this.checkCount = checkCount;
    }
}
