package com.wisea.cultivar.common.vo.tp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 返回运费信息
 * @author: wangs
 * @date :2018/9/30
 */
@ApiModel("返回运费信息")
public class FreightFormworkMageVo {

    /**
     * 运费价格
     */
    @ApiModelProperty("运费价格")
    private Double freightFormworkMage;

    @ApiModelProperty("运费信息string")
    private String freightFormMage;
    /**
     * 返回消息码
     */
    @ApiModelProperty("返回code码")
    private String code;

    /**
     * 返回消息
     */
    @ApiModelProperty("返回消息")
    private String msg;

    public String getFreightFormMage() {
        return freightFormMage;
    }

    public void setFreightFormMage(String freightFormMage) {
        this.freightFormMage = freightFormMage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Double getFreightFormworkMage() {
        return freightFormworkMage;
    }

    public void setFreightFormworkMage(Double freightFormworkMage) {
        this.freightFormworkMage = freightFormworkMage;
    }
}
