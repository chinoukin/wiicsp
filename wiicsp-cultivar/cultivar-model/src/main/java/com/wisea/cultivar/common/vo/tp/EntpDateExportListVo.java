package com.wisea.cultivar.common.vo.tp;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;

/**
 * 会员认证导出VO
 *
 * @author wangh(wisea)
 *
 * @date 2018年10月17日
 * @version 1.0
 */
@ApiModel("会员认证导出VO")
public class EntpDateExportListVo {
    private Long id;
    private String userName;// 用户名
    private String registTel;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private OffsetDateTime createDate;
    private String compName;
    private String authExamState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRegistTel() {
        return registTel;
    }

    public void setRegistTel(String registTel) {
        this.registTel = registTel;
    }

    public OffsetDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(OffsetDateTime createDate) {
        this.createDate = createDate;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getAuthExamState() {
        return authExamState;
    }

    public void setAuthExamState(String authExamState) {
        this.authExamState = authExamState;
    }
}
