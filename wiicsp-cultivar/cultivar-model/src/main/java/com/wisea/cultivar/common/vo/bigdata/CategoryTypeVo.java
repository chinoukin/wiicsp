package com.wisea.cultivar.common.vo.bigdata;

import com.wisea.cultivar.common.vo.tp.statistics.ChartVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Map;

@ApiModel("采购类别占比和采购类型走势分析Vo")
public class CategoryTypeVo {
    @ApiModelProperty(value = "采购类型走势")
    Map<String,List<TypeTrendVo>> typeTrendVos;

    @ApiModelProperty(value = "采购类别占比")
    List<ChartVo> chartVos;

    public Map<String, List<TypeTrendVo>> getTypeTrendVos() {
        return typeTrendVos;
    }

    public void setTypeTrendVos(Map<String, List<TypeTrendVo>> typeTrendVos) {
        this.typeTrendVos = typeTrendVos;
    }

    public List<ChartVo> getChartVos() {
        return chartVos;
    }

    public void setChartVos(List<ChartVo> chartVos) {
        this.chartVos = chartVos;
    }
}
