package com.wisea.cultivar.common.vo.bigdata;

import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import io.swagger.annotations.ApiModelProperty;

/**
 * PlaceOriginMageListVo
 * 2019/12/02 11:02:15
 */
public class ExportCgsNameListVo {

    @ExcelField(title = "采购商名称", sort = 0, width = 20)
    @ApiModelProperty(value = "采购商名称")
    private String cgsName;
    @ExcelField(title = "采购商简称", sort = 1, width = 20)
    @ApiModelProperty(value = "采购商简称")
    private String cgsJc;
    @ExcelField(title = "采购商地址", sort = 2, width = 20)
    @ApiModelProperty(value = "采购商地址")
    private String cgsAddress;
    @ExcelField(title = "成交金额", sort = 3, width = 20)
    @ApiModelProperty(value = "成交金额")
    private Double cjje;
    @ExcelField(title = "坐标点", sort = 4, width = 20)
    @ApiModelProperty(value = "经纬度拼接")
    private String jdwd;

    public String getCgsName() {
        return cgsName;
    }
    public void setCgsName(String cgsName) {
        this.cgsName = cgsName;
    }
    public String getCgsJc() {
        return cgsJc;
    }
    public void setCgsJc(String cgsJc) {
        this.cgsJc = cgsJc;
    }
    public String getCgsAddress() {
        return cgsAddress;
    }
    public void setCgsAddress(String cgsAddress) {
        this.cgsAddress = cgsAddress;
    }
    public Double getCjje() {
        return cjje;
    }
    public void setCjje(Double cjje) {
        this.cjje = cjje;
    }
    public String getJdwd() {
        return jdwd;
    }
    public void setJdwd(String jdwd) {
        this.jdwd = jdwd;
    }
}
