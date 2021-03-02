package com.wisea.transac.common.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author chengq
 * @date 2020/9/29 15:16
 */
public class VersionResultVo {
    /** 返回码 */
    @ApiModelProperty(value = "返回码，默认000，为正常。其他参见返回码表。")
    private String code;

    /** 返回消息 */
    @ApiModelProperty(value = "返回消息，默认为null。一般会返回错误消息提示。")
    private String msg;

    /** 返回结果 */
    @ApiModelProperty(value = "返回结果，默认为null。")
    private VersionMageVo data;

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

    public VersionMageVo getData() {
        return data;
    }

    public void setData(VersionMageVo data) {
        this.data = data;
    }

    public VersionResultVo(String code, VersionMageVo data) {
        this.code = code;
        this.data = data;
    }

    public VersionResultVo() {
    }
}
