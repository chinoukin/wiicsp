package com.wisea.transac.common.po.trade;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("结算单验票异议申请Vo")
public class ExamInvoDissPo {

    @ApiModelProperty(value = "结算单id")
    @Check(test = "required")
    private Long id;
    @ApiModelProperty(value = "验票异议备注")
    private String examInvoDissRemarks;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getExamInvoDissRemarks() {
        return examInvoDissRemarks;
    }
    public void setExamInvoDissRemarks(String examInvoDissRemarks) {
        this.examInvoDissRemarks = examInvoDissRemarks;
    }
}
