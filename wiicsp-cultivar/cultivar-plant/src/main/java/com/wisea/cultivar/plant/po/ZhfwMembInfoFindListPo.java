package com.wisea.cultivar.plant.po;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.vo.ZhfwMembInfoFindListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("种植会员管理列表/服务商列表查询用po")
public class ZhfwMembInfoFindListPo extends PagePo<ZhfwMembInfoFindListVo> {

    @ApiModelProperty("查询类型,0-查询会员列表 1-查询服务商列表")
    @Check(test = "required")
    private String queryType;

    @ApiModelProperty("输入查询[用户名/企业名称/注册手机号]")
    private String searchText;

    @ApiModelProperty("认证状态")
    private String entpAuthStateType;

    @ApiModelProperty("账户状态")
    private String acctState;

    @ApiModelProperty("认证类型")
    private String authType;

    @ApiModelProperty("审核状态")
    private String authStateType;

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
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

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getAuthStateType() {
        return authStateType;
    }

    public void setAuthStateType(String authStateType) {
        this.authStateType = authStateType;
    }
}
