package com.wisea.cultivar.common.po;


import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.FeedBackMagePageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("反馈分页查询Po")
public class FeedBackMagePageListPo extends PagePo<FeedBackMagePageListVo> {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="用户名")
    private String loginName;

    @ApiModelProperty(value="姓名")
    private String name;

    @ApiModelProperty(value="手机号")
    private String tel;

    @ApiModelProperty(value="企业名称")
    private String entpName;

    @ApiModelProperty(value="问题类型")
    private String problemType;

    @ApiModelProperty(value="反馈内容")
    private String feedbackContent;

    @ApiModelProperty(value="来源类型")
    private String sourceType;

    @ApiModelProperty(value="处理状态类型")
    private String procesStatusType;

    @ApiModelProperty(value="处理者")
    private String operator;

    @ApiModelProperty(value="处理时间")
    private OffsetDateTime opreatDate;

    @ApiModelProperty(value="处理结果")
    private String opreatContent;

    @ApiModelProperty(value="处理时间_前缀")
    private OffsetDateTime oprdateFront;

    @ApiModelProperty(value="处理时间_后缀")
    private OffsetDateTime oprdateBack;


    @ApiModelProperty(value="用户名或姓名或手机号条查")
    private String loginNameAndnameAndtel;

    @ApiModelProperty(value="创建时间开始条查")
    private OffsetDateTime startCreateDate;

    @ApiModelProperty(value="创建时间结束条查")
    private OffsetDateTime endCreateDate;

    public OffsetDateTime getOprdateFront() {
        return oprdateFront;
    }

    public String getLoginNameAndnameAndtel() {
        return loginNameAndnameAndtel;
    }

    public void setLoginNameAndnameAndtel(String loginNameAndnameAndtel) {
        this.loginNameAndnameAndtel = loginNameAndnameAndtel;
    }

    public OffsetDateTime getStartCreateDate() {
        return startCreateDate;
    }

    public void setStartCreateDate(OffsetDateTime startCreateDate) {
        this.startCreateDate = startCreateDate;
    }

    public OffsetDateTime getEndCreateDate() {
        return endCreateDate;
    }

    public void setEndCreateDate(OffsetDateTime endCreateDate) {
        this.endCreateDate = endCreateDate;
    }

    public void setOprdateFront(OffsetDateTime oprdateFront) {
        this.oprdateFront = oprdateFront;
    }

    public OffsetDateTime getOprdateBack() {
        return oprdateBack;
    }

    public void setOprdateBack(OffsetDateTime oprdateBack) {
        this.oprdateBack = oprdateBack;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public String getProblemType() {
        return problemType;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    public String getFeedbackContent() {
        return feedbackContent;
    }

    public void setFeedbackContent(String feedbackContent) {
        this.feedbackContent = feedbackContent;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getProcesStatusType() {
        return procesStatusType;
    }

    public void setProcesStatusType(String procesStatusType) {
        this.procesStatusType = procesStatusType;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public OffsetDateTime getOpreatDate() {
        return opreatDate;
    }

    public void setOpreatDate(OffsetDateTime opreatDate) {
        this.opreatDate = opreatDate;
    }

    public String getOpreatContent() {
        return opreatContent;
    }

    public void setOpreatContent(String opreatContent) {
        this.opreatContent = opreatContent;
    }
}