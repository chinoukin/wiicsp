package com.wisea.cultivar.common.po.tp.product;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 评价指标传入参数
 * @author: wangs
 * @date :2019/6/6
 */
@ApiModel("评价指标传入参数")
public class PjZbList {

    /**
     * 评价结果id
     */
    private Long pjJgId;

    /**
     * 评价参数id
     */
    @ApiModelProperty("评价参数id")
    private Long pjCsId;

    /**
     * 评价指标
     */
    @ApiModelProperty("评价指标字段")
    @Check(test = "required",requiredMsg = "评价指标不能为空")
    private String pjZb;

    /**
     * 指标值
     */
    @ApiModelProperty("指标值")
    @Check(test = "required",requiredMsg = "指标值不能为空")
    private String pjVal;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    @Check(test = "required",requiredMsg = "排序不能为空")
    private Integer sort;

    public Long getPjJgId() {
        return pjJgId;
    }

    public void setPjJgId(Long pjJgId) {
        this.pjJgId = pjJgId;
    }

    public Long getPjCsId() {
        return pjCsId;
    }

    public void setPjCsId(Long pjCsId) {
        this.pjCsId = pjCsId;
    }

    public String getPjZb() {
        return pjZb;
    }

    public void setPjZb(String pjZb) {
        this.pjZb = pjZb;
    }

    public String getPjVal() {
        return pjVal;
    }

    public void setPjVal(String pjVal) {
        this.pjVal = pjVal;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
