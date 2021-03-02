package com.wisea.transac.common.po;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.CustSerRuleListPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询Po")
public class CustSerRuleListPageListPo extends PagePo<CustSerRuleListPageListVo> {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="账号")
    private String acctNum;

    @ApiModelProperty(value="姓名")
    private String name;

    @ApiModelProperty(value="联系电话")
    private String tel;

    @ApiModelProperty(value="最大接待数量")
    private Integer maxJdsl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAcctNum() {
        return acctNum;
    }

    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
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

    public Integer getMaxJdsl() {
        return maxJdsl;
    }

    public void setMaxJdsl(Integer maxJdsl) {
        this.maxJdsl = maxJdsl;
    }
}
