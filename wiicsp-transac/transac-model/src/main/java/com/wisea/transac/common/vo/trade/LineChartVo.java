package com.wisea.transac.common.vo.trade;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className LineChartVo
 * @date 2020/5/25 16:01
 * @Description
 */
public class LineChartVo {
    @ApiModelProperty("横坐标")
    private String abscissa;
    @ApiModelProperty("纵坐标")
    private Double ordinate;

    public String getAbscissa() {
        return abscissa;
    }

    public void setAbscissa(String abscissa) {
        this.abscissa = abscissa;
    }

    public Double getOrdinate() {
        return ordinate;
    }

    public void setOrdinate(Double ordinate) {
        this.ordinate = ordinate;
    }
}
