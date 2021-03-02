package com.wisea.cultivar.common.vo.memb;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import com.wisea.cloud.model.annotation.IdSerializer;

import java.time.OffsetDateTime;

/**
 * 会员相关导出数据VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年6月19日
 * @version 1.0
 */
public class MembInfoExportListExcelVo {

    @JsonSerialize(using = IdSerializer.class)
    private Long id;


    @ExcelField(title = "用户名", sort = 20)
    private String loginName;// 用户名

    @ExcelField(title = "企业名称", sort = 60)
    private String entpName;


    @ExcelField(title = "注册手机号", sort = 30)
    private String registTel;

    @ExcelField(title = "注册时间", sort = 40)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private OffsetDateTime registDate;

    @ExcelField(title = "认证状态", sort = 50)
    private String entpAuthStateTypeValue;

    @ExcelField(title = "账户状态", sort = 70)
    private String acctStateValue;

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

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
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

    public String getEntpAuthStateTypeValue() {
        return entpAuthStateTypeValue;
    }

    public void setEntpAuthStateTypeValue(String entpAuthStateTypeValue) {
        this.entpAuthStateTypeValue = entpAuthStateTypeValue;
    }

    public String getAcctStateValue() {
        return acctStateValue;
    }

    public void setAcctStateValue(String acctStateValue) {
        this.acctStateValue = acctStateValue;
    }
}

