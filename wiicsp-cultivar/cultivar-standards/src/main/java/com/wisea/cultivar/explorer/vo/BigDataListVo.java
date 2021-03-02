package com.wisea.cultivar.explorer.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
import java.util.Map;

/**
 * @author jirg
 * @version 1.0
 * @className BigDataBaseListVo
 * @date 2020/9/2 14:22
 * @Description 大数据 - 种植大数据 - 基地列表VO
 */
@ApiModel("基地列表VO")
public class BigDataListVo {
    @ApiModelProperty("不同数据类型数量")
    private Map<String, Long> dataTypeCountMap;
    @ApiModelProperty("数据列表")
    private List<BigDataMapPointListVo> mapPoints;

    public Map<String, Long> getDataTypeCountMap() {
        return dataTypeCountMap;
    }

    public void setDataTypeCountMap(Map<String, Long> dataTypeCountMap) {
        this.dataTypeCountMap = dataTypeCountMap;
    }

    public List<BigDataMapPointListVo> getMapPoints() {
        return mapPoints;
    }

    public void setMapPoints(List<BigDataMapPointListVo> mapPoints) {
        this.mapPoints = mapPoints;
    }
}
