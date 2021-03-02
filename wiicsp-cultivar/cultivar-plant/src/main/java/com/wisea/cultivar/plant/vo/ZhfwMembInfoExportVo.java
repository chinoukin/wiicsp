package com.wisea.cultivar.plant.vo;

import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("会员列表导出Vo")
public class ZhfwMembInfoExportVo {

    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="认证类型")
    private String authType;

    @ApiModelProperty(value="用户名")
    @ExcelField(sort=1,title = "用户名")
    private String loginName;

    @ApiModelProperty(value="企业名称")
    @ExcelField(sort=2,title = "企业名称")
    private String entpName;

    @ApiModelProperty(value="注册手机号")
    @ExcelField(sort=3,title = "注册手机号")
    private String registTel;

    @ApiModelProperty(value="注册时间")
    @ExcelField(sort=4,title = "注册时间")
    private OffsetDateTime registerDate;

    @ApiModelProperty(value="认证状态")
    @ExcelField(sort=5,title = "认证状态")
    private String entpAuthStateType;

    @ApiModelProperty(value="账户状态")
    @ExcelField(sort=6,title = "账户状态")
    private String acctState;

    @ApiModelProperty(value="审核状态")
    private String authStateType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
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

    public OffsetDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(OffsetDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public String getEntpAuthStateType() {
        if ("0".equals(entpAuthStateType)) {
            return "已认证";
        } else if ("1".equals(entpAuthStateType)) {
            return "未认证";
        }
        return "";
    }

    public void setEntpAuthStateType(String entpAuthStateType) {
        this.entpAuthStateType = entpAuthStateType;
    }

    public String getAcctState() {
        if ("0".equals(acctState)) {
            return "正常";
        } else if ("1".equals(acctState)) {
            return "冻结";
        }
        return "";
    }

    public void setAcctState(String acctState) {
        this.acctState = acctState;
    }

    public String getAuthStateType() {
        return authStateType;
    }

    public void setAuthStateType(String authStateType) {
        this.authStateType = authStateType;
    }
}
