package com.wisea.cultivar.common.vo.tp;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

/**
 *
 * @author wangh(wisea)
 *
 * @date 2017年12月26日
 * @version 1.0
 */
public class MembInfoExportVo {
    @JsonSerialize(using = IdSerializer.class)
    private Long id;

    private String userName;// 用户名

    private String registTel;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private OffsetDateTime registDate;

    private String compName;

    private String entpAuthStateType;

    private String agentFlag;

    private String acctState;

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

    public OffsetDateTime getRegistDate() {
        return registDate;
    }

    public void setRegistDate(OffsetDateTime registDate) {
        this.registDate = registDate;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getEntpAuthStateType() {
        return entpAuthStateType;
    }

    public void setEntpAuthStateType(String entpAuthStateType) {
        this.entpAuthStateType = entpAuthStateType;
    }

    public String getAgentFlag() {
        return agentFlag;
    }

    public void setAgentFlag(String agentFlag) {
        this.agentFlag = agentFlag;
    }

    public String getAcctState() {
        return acctState;
    }

    public void setAcctState(String acctState) {
        this.acctState = acctState;
    }
}
