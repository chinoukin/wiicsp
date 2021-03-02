package com.wisea.transac.common.vo.system;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 默认服务费返回值
 * @author: wangs
 * @date :2019/5/15
 */
@ApiModel("默认服务费详情返回信息")
public class MrSerChargeMageGetVo {

    @ApiModelProperty("默认手续费id;只在修改时传递")
    @JsonSerialize(using = IdSerializer.class)
    private Long id;

    /**
     * 商品id
     */
    @ApiModelProperty("商品树信息id")
    @JsonSerialize(using = IdSerializer.class)
    private Long commId;

    /**
     * 收取方式
     */
    @ApiModelProperty("收取方式,字典值,本次只设计按比例:0,按次;1,按比例;")
    private String colleMethType;

    /**
     * 收取数值
     */
    @ApiModelProperty("收取数值")
    private Double sqVal;

    /**
     * 单笔最小数值
     */
    @ApiModelProperty("单笔最小值")
    private Double oneceMin;

    /**
     * 单笔最大数值
     */
    @ApiModelProperty("单笔最大值")
    private Double oneceMax;

    @ApiModelProperty("用于返回商品分类id")
    private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取商品id
     */
    public Long getCommId() {
        return commId;
    }

    /**
     * 设置商品id
     */
    public void setCommId(Long commId) {
        this.commId = commId;
    }

    /**
     * 获取收取方式
     */
    public String getColleMethType() {
        return colleMethType;
    }

    /**
     * 设置收取方式
     */
    public void setColleMethType(String colleMethType) {
        this.colleMethType = colleMethType == null ? null : colleMethType.trim();
    }

    /**
     * 获取收取数值
     */
    public Double getSqVal() {
        return sqVal;
    }

    /**
     * 设置收取数值
     */
    public void setSqVal(Double sqVal) {
        this.sqVal = sqVal;
    }

    /**
     * 获取单笔最小数值
     */
    public Double getOneceMin() {
        return oneceMin;
    }

    /**
     * 设置单笔最小数值
     */
    public void setOneceMin(Double oneceMin) {
        this.oneceMin = oneceMin;
    }

    /**
     * 获取单笔最大数值
     */
    public Double getOneceMax() {
        return oneceMax;
    }

    /**
     * 设置单笔最大数值
     */
    public void setOneceMax(Double oneceMax) {
        this.oneceMax = oneceMax;
    }
}
