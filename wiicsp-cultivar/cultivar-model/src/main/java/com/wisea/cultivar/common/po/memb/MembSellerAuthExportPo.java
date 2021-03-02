package com.wisea.cultivar.common.po.memb;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;
import java.util.List;

/**
 * 采购商会员管理导出处理PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年6月19日
 * @version 1.0
 */
@ApiModel("采购商会员管理导出处理PO")
public class MembSellerAuthExportPo {


	@ApiModelProperty(value = "用户名/注册手机号/企业名称")
	private String key;

	@ApiModelProperty(value="认证类型(0:企业1:个人)")
	private String authType;

	@ApiModelProperty(value="会员id列表(如果为空则按照条件,如果不是空则按照id列表查询)")
	private List<String> idList;

    @ApiModelProperty(value="审核状态(auth_state_type 0:待审核1:审核通过2:审核未通过)")
    private String authStateType;
    @ApiModelProperty(value = "注册时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private OffsetDateTime registDate;

    @ApiModelProperty(value = "认证类型")
    private String authTypeValue;

    @ApiModelProperty(value = "审核状态")
    private String authStateTypeValue;
    public String getKey() {
        return key;
    }

    public OffsetDateTime getRegistDate() {
        return registDate;
    }

    public void setRegistDate(OffsetDateTime registDate) {
        this.registDate = registDate;
    }

    public String getAuthTypeValue() {
        return authTypeValue;
    }

    public void setAuthTypeValue(String authTypeValue) {
        this.authTypeValue = authTypeValue;
    }

    public String getAuthStateTypeValue() {
        return authStateTypeValue;
    }

    public void setAuthStateTypeValue(String authStateTypeValue) {
        this.authStateTypeValue = authStateTypeValue;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public List<String> getIdList() {
        return idList;
    }

    public void setIdList(List<String> idList) {
        this.idList = idList;
    }

    public String getAuthStateType() {
        return authStateType;
    }

    public void setAuthStateType(String authStateType) {
        this.authStateType = authStateType;
    }
}
