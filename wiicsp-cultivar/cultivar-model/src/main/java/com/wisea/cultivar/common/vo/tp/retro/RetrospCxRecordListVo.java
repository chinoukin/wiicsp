package com.wisea.cultivar.common.vo.tp.retro;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import java.time.OffsetDateTime;

/**
 * @author jirg
 * @version 1.0
 * @className RetrospCxRecordListVo
 * @date 2019/12/21 12:42
 * @Description
 */
public class RetrospCxRecordListVo {
    @ApiModelProperty("批次号")
    private String retrospPcNum;
    @ApiModelProperty("追溯码编号")
    private String retrospNumBh;
    @ApiModelProperty("查询方式类型")
    private String cxModeType;
    @ApiModelProperty("查询ip")
    private String cxIp;
    @ApiModelProperty("查询时间")
    private OffsetDateTime cxDate;
    @ApiModelProperty("查询位置")
    private String cxAddress;

    public String getRetrospPcNum() {
        return retrospPcNum;
    }

    public void setRetrospPcNum(String retrospPcNum) {
        this.retrospPcNum = retrospPcNum;
    }

    public String getRetrospNumBh() {
        return retrospNumBh;
    }

    public void setRetrospNumBh(String retrospNumBh) {
        this.retrospNumBh = retrospNumBh;
    }

    public String getCxModeType() {
        return cxModeType;
    }

    public void setCxModeType(String cxModeType) {
        this.cxModeType = cxModeType;
    }

    public String getCxIp() {
        return cxIp;
    }

    public void setCxIp(String cxIp) {
        this.cxIp = cxIp;
    }

    public OffsetDateTime getCxDate() {
        return cxDate;
    }

    public void setCxDate(OffsetDateTime cxDate) {
        this.cxDate = cxDate;
    }

    public String getCxAddress() {
        return cxAddress;
    }

    public void setCxAddress(String cxAddress) {
        this.cxAddress = cxAddress;
    }
}
