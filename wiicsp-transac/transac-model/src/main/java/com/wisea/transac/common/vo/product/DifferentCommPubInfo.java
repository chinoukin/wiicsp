package com.wisea.transac.common.vo.product;

import io.swagger.annotations.ApiModel;

/**
 * @Description: 比较商品信息是否发生变化
 * @author: wangs
 * @date :2020/5/9
 */
@ApiModel("比较商品信息是否发生变化")
public class DifferentCommPubInfo {

    private String resultMsg;

    private Boolean flag;

    private String Code;

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
