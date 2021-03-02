package com.wisea.transac.common.po.trade;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author jirg
 * @Date 2020/12/2 16:34
 * @Description
 **/
public class OrderDelivePo {
    @ApiModelProperty("订单ID")
    @Check(test = {"required"})
    private Long ordId;
    @ApiModelProperty("物流公司ID")
    @Check(test = {"required"})
    private Long logisticsCompId;
    @ApiModelProperty("物流公司ID")
    @Check(test = {"required"})
    private String logisticsNum;

    public Long getOrdId() {
        return ordId;
    }

    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }

    public Long getLogisticsCompId() {
        return logisticsCompId;
    }

    public void setLogisticsCompId(Long logisticsCompId) {
        this.logisticsCompId = logisticsCompId;
    }

    public String getLogisticsNum() {
        return logisticsNum;
    }

    public void setLogisticsNum(String logisticsNum) {
        this.logisticsNum = logisticsNum;
    }
}
