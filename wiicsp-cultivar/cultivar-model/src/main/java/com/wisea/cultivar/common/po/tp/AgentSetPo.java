package com.wisea.cultivar.common.po.tp;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author:Liangzy(Wisea)
 * @Date:Create in 2018/9/28 上午9:37
 * @Description:用来处理结算价以及代理价表达式的PO
 */
public class AgentSetPo {

    /*
    * 数量
    * */
    @ApiModelProperty(value = "数量")
    private String num;

    /**
     * 结算价
     */
    @ApiModelProperty(value = "结算价")
    private String price;

    /**
     * 代理结算价指定方式
     */
    @ApiModelProperty(value = "代理结算价指定方式")
    private String agentSettType;

    /**
     * 代理结算值（可为：固定值/小数）
     */
    @ApiModelProperty(value = "代理结算固定值")
    private String agentPrice;

    public String getAgentSettType() {
        return agentSettType;
    }

    public void setAgentSettType(String agentSettType) {
        this.agentSettType = agentSettType;
    }

    public String getAgentPrice() {
        return agentPrice;
    }

    public void setAgentPrice(String agentPrice) {
        this.agentPrice = agentPrice;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
