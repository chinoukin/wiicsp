package com.wisea.cultivar.common.vo.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * LogisticsBasicDataListVo
 * 2020/09/03 10:24:52
 */
public class LogisticsBasicDataListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 物流基础数据类型
     */
    @ApiModelProperty(value = "物流基础数据类型，0物流流通单数，1分拣工厂数量，2分拣工厂面积，3物流企业，4从业人数，5物流覆盖省份")
    @Check(test = "required")
    private String logisticsBasicDataType;

    /**
     * 数量
     */
    @ApiModelProperty(value = "数量")
    @Check(test = "required")
    private Double num;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取物流基础数据类型
     */
    public String getLogisticsBasicDataType() {
        return logisticsBasicDataType;
    }

    /**
     * 设置物流基础数据类型
     */
    public void setLogisticsBasicDataType(String logisticsBasicDataType) {
        this.logisticsBasicDataType = logisticsBasicDataType == null ? null : logisticsBasicDataType.trim();
    }

    /**
     * 获取数量
     */
    public Double getNum() {
        return num;
    }

    /**
     * 设置数量
     */
    public void setNum(Double num) {
        this.num = num;
    }

    /**
     * 获取排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}
