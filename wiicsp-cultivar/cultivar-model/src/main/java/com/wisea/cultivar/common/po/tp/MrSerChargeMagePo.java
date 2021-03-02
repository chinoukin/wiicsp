package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 默认服务费,传入信息
 * @author: wangs
 * @date :2019/5/15
 */
@ApiModel("默认手续费新增和修改传递参数")
public class MrSerChargeMagePo {

    @ApiModelProperty("默认手续费id;只在修改时传递")
    private Long id;

    /**
     * 交易模式
     */
    @ApiModelProperty("交易模式,字典值:0,大宗交易;1,中小零批;2,长期合同;")
    @Check(test = "required", requiredMsg = "交易模式不能为空")
    private String transModeType;

    /**
     * 商品id
     */
    @ApiModelProperty("商品树信息id")
    @Check(test = "required", requiredMsg = "商品id不能为空")
    private Long commId;

    /**
     * 收取方式
     */
    @ApiModelProperty("收取方式,字典值,本次只设计按比例:0,按次;1,按比例;")
    @Check(test = "required", requiredMsg = "收取方式不能为空")
    private String colleMethType;

    /**
     * 收取数值
     */
    @ApiModelProperty("收取数值")
    @Check(test = "required", requiredMsg = "收取数值不能为空")
    private Double sqVal;

    /**
     * 单笔最小数值
     */
    @ApiModelProperty("单笔最小值")
    @Check(test = "required", requiredMsg = "单笔最小值不能为空")
    private Double oneceMin;

    /**
     * 单笔最大数值
     */
    @ApiModelProperty("单笔最大值")
    @Check(test = "required", requiredMsg = "单笔最大值不能为空")
    private Double oneceMax;

    @ApiModelProperty("存储标记")
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
     * 获取交易模式
     */
    public String getTransModeType() {
        return transModeType;
    }

    /**
     * 设置交易模式
     */
    public void setTransModeType(String transModeType) {
        this.transModeType = transModeType == null ? null : transModeType.trim();
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
