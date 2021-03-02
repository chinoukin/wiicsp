package com.wisea.cultivar.common.po.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

/**
 * 品类传入参数
 */
@ApiModel("查询品类树PO")
public class CommMageTreePo {
    @ApiModelProperty("查询框内容")
    private String query;
    @ApiModelProperty("有效状态")
    private String effeInvalState;
    @ApiModelProperty("pid")
    private long pid;
    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getEffeInvalState() {
        return effeInvalState;
    }

    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState;
    }

    public long getPid() {
        return pid;
    }


    public void setPid(long pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "CommMageTreePo{" +
                "query='" + query + '\'' +
                ", effeInvalState='" + effeInvalState + '\'' +
                ", pid=" + pid +
                '}';
    }
}
