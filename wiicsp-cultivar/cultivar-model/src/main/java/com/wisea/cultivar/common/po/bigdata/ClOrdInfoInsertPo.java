package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * ClOrdInfoInsertPo
 * 2019/12/02 11:02:14
 */
public class ClOrdInfoInsertPo {
    /**
     * 待处理
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "待处理", allowableValues = "length:(,10]")
    private Integer dcl;

    /**
     * 打包中
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "打包中", allowableValues = "length:(,10]")
    private Integer dbz;

    /**
     * 在途中
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "在途中", allowableValues = "length:(,10]")
    private Integer ztz;

    /**
     * 已完成
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "已完成", allowableValues = "length:(,10]")
    private Integer ywc;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注", allowableValues = "mixLength:(,255]")
    private String remarks;

    /**
     * 获取待处理
     */
    public Integer getDcl() {
        return dcl;
    }

    /**
     * 设置待处理
     */
    public void setDcl(Integer dcl) {
        this.dcl = dcl;
    }

    /**
     * 获取打包中
     */
    public Integer getDbz() {
        return dbz;
    }

    /**
     * 设置打包中
     */
    public void setDbz(Integer dbz) {
        this.dbz = dbz;
    }

    /**
     * 获取在途中
     */
    public Integer getZtz() {
        return ztz;
    }

    /**
     * 设置在途中
     */
    public void setZtz(Integer ztz) {
        this.ztz = ztz;
    }

    /**
     * 获取已完成
     */
    public Integer getYwc() {
        return ywc;
    }

    /**
     * 设置已完成
     */
    public void setYwc(Integer ywc) {
        this.ywc = ywc;
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
