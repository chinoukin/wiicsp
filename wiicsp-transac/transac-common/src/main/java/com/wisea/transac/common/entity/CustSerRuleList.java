package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class CustSerRuleList extends DataLongEntity<CustSerRuleList> {
    /**
     * 账号
     */
    private String acctNum;

    /**
     * 姓名
     */
    private String name;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 最大接待数量
     */
    private Integer maxJdsl;

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
