package com.wisea.cultivar.common.vo;

import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import io.swagger.annotations.ApiModel;

/**
 * @Description: 反馈导出VO
 * @Author:Liangzy(Feeling)
 * @Date:Create in 2020/5/7 4:58 下午
 */
@ApiModel("反馈详细信息导出Vo")
public class FeedBackMageExportVo {

    @ExcelField(title = "用户名", sort = 1)
    private String loginName;

    @ExcelField(title = "姓名", sort = 2)
    private String name;

    @ExcelField(title = "手机号", sort = 3)
    private String tel;

    @ExcelField(title = "企业名称", sort = 4)
    private String entpName;

    @ExcelField(title = "问题类型", sort = 5)
    private String problemType;

    @ExcelField(title = "反馈内容", sort = 6)
    private String feedbackContent;

   /* @ExcelField(title = "来源类型", sort = 7)
    private String sourceType;*/

    @ExcelField(title = "处理状态类型", sort = 8)
    private String procesStatusType;

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

  /*  public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }*/

    public String getProcesStatusType() {
        return procesStatusType;
    }

    public void setProcesStatusType(String procesStatusType) {
        this.procesStatusType = procesStatusType;
    }
}
