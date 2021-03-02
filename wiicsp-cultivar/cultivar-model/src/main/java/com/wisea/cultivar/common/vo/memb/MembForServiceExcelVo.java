package com.wisea.cultivar.common.vo.memb;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;

import java.time.OffsetDateTime;

/**
 * 运营平台/市场运营 会员列表VO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月20日
 * @version 1.0
 */
@ApiModel("运营平台/市场运营 会员列表VO")
public class MembForServiceExcelVo {


    @ExcelField(title = "认证类型", sort = 50)
    private String authTypeValue;

    @ExcelField(title = "用户名", sort = 30)
    private String loginName;

    @ExcelField(title = "企业名称", sort = 30)
    private String entpName;

    @ExcelField(title = "注册手机号", sort = 30)
    private String registTel;

    @ExcelField(title = "注册时间", sort = 30)
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime registDate;

    @ExcelField(title = "审核状态", sort = 70)
    private String authStateTypeValue;

    public String getAuthTypeValue() {
        return authTypeValue;
    }

    public void setAuthTypeValue(String authTypeValue) {
        this.authTypeValue = authTypeValue;
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

    public String getAuthStateTypeValue() {
        return authStateTypeValue;
    }

    public void setAuthStateTypeValue(String authStateTypeValue) {
        this.authStateTypeValue = authStateTypeValue;
    }
}
