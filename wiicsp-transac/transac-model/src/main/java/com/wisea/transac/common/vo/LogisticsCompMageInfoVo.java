package com.wisea.transac.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("物流公司详细信息Vo")
public class LogisticsCompMageInfoVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="物流公司名称")
    private String logisticsCompName;

    @ApiModelProperty(value="代码")
    private String logisticsCompCode;

    @ApiModelProperty(value="联系电话")
    private String tel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogisticsCompName() {
        return logisticsCompName;
    }

    public void setLogisticsCompName(String logisticsCompName) {
        this.logisticsCompName = logisticsCompName;
    }

    public String getLogisticsCompCode() {
        return logisticsCompCode;
    }

    public void setLogisticsCompCode(String logisticsCompCode) {
        this.logisticsCompCode = logisticsCompCode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
