package com.wisea.cultivar.supply.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author chengq
 * @date 2020/8/16 18:22
 */
public class SerOpreateListVo {

    @ApiModelProperty("操作者")
    private String operator;

    @ApiModelProperty("操作时间")
    private String opreatDate;

    @ApiModelProperty("操作内容")
    private String opreatContent;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getOpreatDate() {
        return opreatDate;
    }

    public void setOpreatDate(String opreatDate) {
        this.opreatDate = opreatDate;
    }

    public String getOpreatContent() {
        return opreatContent;
    }

    public void setOpreatContent(String opreatContent) {
        this.opreatContent = opreatContent;
    }
}
