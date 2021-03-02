package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * LogisticsCompMageInsertPo
 * 2018/09/18 14:36:47
 */
public class LogisticsCompMageInsertPo {
    /**
     * 物流公司名称
     */
    @Check(test = { "maxLength","required" }, mixLength = 255)
    @ApiModelProperty(value = "物流公司名称")
    private String logisticsCompName;

    /**
     * 代码
     */
    @Check(test = { "maxLength","required" }, mixLength = 30)
    @ApiModelProperty(value = "代码")
    private String logisticsCompCode;

    @ApiModelProperty(value = "联系方式")
    @Check(test = { "maxLength","required" }, mixLength = 30)
    private String tel;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取物流公司名称
     */
    public String getLogisticsCompName() {
        return logisticsCompName;
    }

    /**
     * 设置物流公司名称
     */
    public void setLogisticsCompName(String logisticsCompName) {
        this.logisticsCompName = logisticsCompName == null ? null : logisticsCompName.trim();
    }

    /**
     * 获取代码
     */
    public String getLogisticsCompCode() {
        return logisticsCompCode;
    }

    /**
     * 设置代码
     */
    public void setLogisticsCompCode(String logisticsCompCode) {
        this.logisticsCompCode = logisticsCompCode == null ? null : logisticsCompCode.trim();
    }

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}
