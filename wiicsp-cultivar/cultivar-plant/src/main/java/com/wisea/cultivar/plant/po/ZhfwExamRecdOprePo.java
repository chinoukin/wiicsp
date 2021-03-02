package com.wisea.cultivar.plant.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("服务商审核操作po")
public class ZhfwExamRecdOprePo {

    @ApiModelProperty(value="会员名id")
    @Check(test = "required")
    private Long membId;

    @ApiModelProperty(value="审核结果,0-审核通过,1-审核未通过")
    @Check(test = "required")
    private String authStateType;

    @ApiModelProperty(value="审核意见")
    private String examFailReason;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getAuthStateType() {
        return authStateType;
    }

    public void setAuthStateType(String authStateType) {
        this.authStateType = authStateType;
    }

    public String getExamFailReason() {
        return examFailReason;
    }

    public void setExamFailReason(String examFailReason) {
        this.examFailReason = examFailReason;
    }
}
