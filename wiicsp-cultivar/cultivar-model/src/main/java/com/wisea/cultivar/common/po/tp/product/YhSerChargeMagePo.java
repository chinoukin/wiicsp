package com.wisea.cultivar.common.po.tp.product;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 优惠服务费传入参数
 * @author: wangs
 * @date :2019/5/16
 */
@ApiModel("优惠服务费传入参数")
public class YhSerChargeMagePo {

    /**
     * 优惠服务费记录id
     */
    @ApiModelProperty("优惠服务费记录id 修改时传递")
    @JsonSerialize(using = IdSerializer.class)
    private Long id;

    /**
     * 指定会员id
     */
    @ApiModelProperty("指定会员id,多个以逗号分隔,业务变更为只能选一个指定的id了")
    @Check(test = {"required"}, requiredMsg = "指定会员id不能为空")
    @JsonSerialize(using = IdSerializer.class)
    private String appointMembId;

    /**
     * 交易模式
     */
    @ApiModelProperty("交易模式,字典值;0:大宗交易;1,中小零批;2,长期合同;多个以逗号分隔,产品变更为只能选一种交易模式")
    @Check(test = {"required"}, requiredMsg = "交易模式不能为空")
    private String transModeType;

    /**
     * 商品id
     */
    @ApiModelProperty("商品id")
    @Check(test = {"required"}, requiredMsg = "商品不能为空")
    @JsonSerialize(using = IdSerializer.class)
    private Long commId;

    /**
     * 优惠类型
     */
    @ApiModelProperty("优惠的类型,字典值;0:总体折扣;1:重新指定")
    @Check(test = {"required"}, requiredMsg = "指定会员id不能为空")
    private String discountType;

    /**
     * 收取方式
     */
    @ApiModelProperty("收取方式,字典值;0:按次;1:按比例")
    @Check(test = {"required"}, requiredMsg = "收取方式不能为空")
    private String colleMethType;

    /**
     * 收取数值
     */
    @ApiModelProperty("收取数值或总体折扣的折扣数")
    @Check(test = {"required"}, requiredMsg = "收取数值或总体折扣数不能为空")
    private Double sqVal;

    /**
     * 单笔最小数值
     */
    @ApiModelProperty("单笔最小数值")
    @Check(test = "logic", logic = "'1'.equals(#discountType)?#isNotEmpty(#oneceMin):true")
    private Double oneceMin;

    /**
     * 单笔最大数值
     */
    @ApiModelProperty("单笔最大数值")
    @Check(test = "logic", logic = "'1'.equals(#discountType)?#isNotEmpty(#oneceMax):true")
    private Double oneceMax;

    /**
     * 标记字段
     */
    @ApiModelProperty("标记字段,为了方便存储优惠手续费的商家名称用逗号分隔")
    private String remarks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppointMembId() {
        return appointMembId;
    }

    public void setAppointMembId(String appointMembId) {
        this.appointMembId = appointMembId;
    }

    public String getTransModeType() {
        return transModeType;
    }

    public void setTransModeType(String transModeType) {
        this.transModeType = transModeType;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public String getColleMethType() {
        return colleMethType;
    }

    public void setColleMethType(String colleMethType) {
        this.colleMethType = colleMethType;
    }

    public Double getSqVal() {
        return sqVal;
    }

    public void setSqVal(Double sqVal) {
        this.sqVal = sqVal;
    }

    public Double getOneceMin() {
        return oneceMin;
    }

    public void setOneceMin(Double oneceMin) {
        this.oneceMin = oneceMin;
    }

    public Double getOneceMax() {
        return oneceMax;
    }

    public void setOneceMax(Double oneceMax) {
        this.oneceMax = oneceMax;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
