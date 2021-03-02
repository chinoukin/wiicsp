package com.wisea.cultivar.supply.po;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * @author chengq
 * @date 2020/8/14 16:02
 */
public class CommAttriPo {

    @ApiModelProperty("属性id")
    @NotNull(message = "属性id不能为空")
    private Long attriId;

    @ApiModelProperty("属性名称")
    private String commAttriName;

    @ApiModelProperty("属性值")
    private String attriVal;

    public Long getAttriId() {
        return attriId;
    }

    public void setAttriId(Long attriId) {
        this.attriId = attriId;
    }

    public String getAttriVal() {
        return attriVal;
    }

    public void setAttriVal(String attriVal) {
        this.attriVal = attriVal;
    }

    public String getCommAttriName() {
        return commAttriName;
    }

    public void setCommAttriName(String commAttriName) {
        this.commAttriName = commAttriName;
    }
}
