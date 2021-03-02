package com.wisea.cultivar.common.vo.tp.product;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @author: wangs
 * @date :2019/5/21
 */
public class YhSerChargeMageVo {

    /**
     * 优惠服务费记录id
     */
    @ApiModelProperty("优惠服务费记录id 修改时传递")
    @JsonSerialize(using = IdSerializer.class)
    private Long id;

    /**
     * 指定会员id
     */
    @ApiModelProperty("指定会员id,多个以逗号分隔")
    private String appointMembId;

    /**
     * 交易模式
     */
    @ApiModelProperty("交易模式,字典值;0:大宗交易;1,中小零批;2,长期合同;多个以逗号分隔")
    private String transModeType;

    /**
     * 商品id
     */
    @ApiModelProperty("商品id")
    private Long commId;

    /**
     * 优惠类型
     */
    @ApiModelProperty("优惠的类型,字典值;0:总体折扣;1:重新指定")
    private String discountType;

    /**
     * 收取方式
     */
    @ApiModelProperty("收取方式,字典值;0:按次;1:按比例")
    private String colleMethType;

    /**
     * 收取数值
     */
    @ApiModelProperty("收取数值或总体折扣的折扣数")
    private Double sqVal;

    /**
     * 单笔最小数值
     */
    @ApiModelProperty("单笔最小数值")
    private Double oneceMin;

    /**
     * 单笔最大数值
     */
    @ApiModelProperty("单笔最大数值")
    private Double oneceMax;

    @ApiModelProperty("用于存储商品分类标记字段")
    private String remarks;

    @ApiModelProperty("处理后的会员名称")
    private String membInfoName;

    public String getMembInfoName() {
        return membInfoName;
    }

    public void setMembInfoName(String membInfoName) {
        this.membInfoName = membInfoName;
    }

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
}
