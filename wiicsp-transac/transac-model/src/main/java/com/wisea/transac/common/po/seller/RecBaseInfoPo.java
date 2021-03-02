package com.wisea.transac.common.po.seller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("基地查询查询PO")
public class RecBaseInfoPo  {
    @ApiModelProperty("基地ID")
    private Long id;
    @ApiModelProperty("经度")
    private String jd;
    @ApiModelProperty("纬度")
    private String wd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJd() {
        return jd;
    }

    public void setJd(String jd) {
        this.jd = jd;
    }

    public String getWd() {
        return wd;
    }

    public void setWd(String wd) {
        this.wd = wd;
    }
}
