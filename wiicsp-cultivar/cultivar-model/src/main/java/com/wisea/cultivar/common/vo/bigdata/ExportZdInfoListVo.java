package com.wisea.cultivar.common.vo.bigdata;

import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import io.swagger.annotations.ApiModelProperty;

/**
 * PlaceOriginMageListVo
 * 2019/12/02 11:02:15
 */
public class ExportZdInfoListVo {

    @ExcelField(title = "站点名称", sort = 0, width = 20)
    @ApiModelProperty(value = "站点名称")
    private String zdName;
    @ExcelField(title = "站点地址", sort = 1, width = 20)
    @ApiModelProperty(value = "站点地址")
    private String zdAddress;
    @ExcelField(title = "站点类型", sort = 2, width = 20)
    @ApiModelProperty(value = "站点类型")
    private String zdType;
    @ExcelField(title = "坐标点", sort = 3, width = 20)
    @ApiModelProperty(value = "经纬度拼接")
    private String jdwd;

    public String getZdName() {
        return zdName;
    }
    public void setZdName(String zdName) {
        this.zdName = zdName;
    }
    public String getZdAddress() {
        return zdAddress;
    }
    public void setZdAddress(String zdAddress) {
        this.zdAddress = zdAddress;
    }
    public String getZdType() {
        return zdType;
    }
    public void setZdType(String zdType) {
        this.zdType = zdType;
    }
    public String getJdwd() {
        return jdwd;
    }
    public void setJdwd(String jdwd) {
        this.jdwd = jdwd;
    }
}
