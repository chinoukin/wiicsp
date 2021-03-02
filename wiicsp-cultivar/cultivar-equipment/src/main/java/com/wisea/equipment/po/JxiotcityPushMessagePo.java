package com.wisea.equipment.po;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author chengq
 * @date 2020/11/26 10:24
 */
public class JxiotcityPushMessagePo {

    @ApiModelProperty("执行命令")
    private String code;

    @ApiModelProperty("内容")
    private String content;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
