package com.wisea.transac.common.vo.memb;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import com.wisea.cloud.model.annotation.IdSerializer;

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

    @ExcelField(title = "会员类型", sort = 10)
    private String membType;

    @ExcelField(title = "用户名", sort = 20)
    private String loginName;// 用户名

    @ExcelField(title = "注册手机号", sort = 30)
    private String registTel;

    @ExcelField(title = "注册日期", sort = 40)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private OffsetDateTime registDate;

    @ExcelField(title = "认证状态", sort = 50)
    private String entpAuthStateType;

    @ExcelField(title = "企业名称", sort = 60)
    private String entpName;

    @ExcelField(title = "账户状态", sort = 70)
    private String acctState;

    @ExcelField(title = "审核状态", sort = 80)
    private String authStateType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegistTel() {
        return registTel;
    }

    public void setRegistTel(String registTel) {
        this.registTel = registTel;
    }

	public String getMembType() {
		return membType;
	}

	public void setMembType(String membType) {
		this.membType = membType;
	}

	public OffsetDateTime getRegistDate() {
		return registDate;
	}

	public void setRegistDate(OffsetDateTime registDate) {
		this.registDate = registDate;
	}

	public String getEntpAuthStateType() {
		return entpAuthStateType;
	}

	public void setEntpAuthStateType(String entpAuthStateType) {
		this.entpAuthStateType = entpAuthStateType;
	}

	public String getAcctState() {
		return acctState;
	}

	public void setAcctState(String acctState) {
		this.acctState = acctState;
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

	public String getAuthStateType() {
		return authStateType;
	}

	public void setAuthStateType(String authStateType) {
		this.authStateType = authStateType;
	}
}
