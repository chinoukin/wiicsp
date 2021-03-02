package com.wisea.cultivar.common.po.bigdata;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel("大数据查询企业PO")
public class QiyeAllInfoPo {

    @ApiModelProperty("企业名称")
    private String name;
    @ApiModelProperty("地区")
    private String prov;
    @ApiModelProperty("国内国外标识 0国内 1国外")
    private String gnwFlag;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getProv() {
        return prov;
    }
    public void setProv(String prov) {
        this.prov = prov;
    }
    public String getGnwFlag() {
        return gnwFlag;
    }
    public void setGnwFlag(String gnwFlag) {
        this.gnwFlag = gnwFlag;
    }
}
