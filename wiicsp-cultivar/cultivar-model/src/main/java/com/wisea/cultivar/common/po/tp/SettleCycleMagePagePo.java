package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.vo.tp.SettleCycleMageListVo;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;
import io.swagger.annotations.ApiModelProperty;

/**
 * SettleCycleMagePagePo
 * 2018/10/18 17:17:58
 */
public class SettleCycleMagePagePo extends PagePo<SettleCycleMageListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 结算周期类型
     */
    @ApiModelProperty(value = "结算周期类型")
    private String settleCycleType;

    /**
     * 最晚付款日期
     */
    @ApiModelProperty(value = "最晚付款日期")
    private Integer theLatestPayDate;

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
     * 获取结算周期类型
     */
    public String getSettleCycleType() {
        return settleCycleType;
    }

    /**
     * 设置结算周期类型
     */
    public void setSettleCycleType(String settleCycleType) {
        this.settleCycleType = settleCycleType == null ? null : settleCycleType.trim();
    }

    /**
     * 获取最晚付款日期
     */
    public Integer getTheLatestPayDate() {
        return theLatestPayDate;
    }

    /**
     * 设置最晚付款日期
     */
    public void setTheLatestPayDate(Integer theLatestPayDate) {
        this.theLatestPayDate = theLatestPayDate;
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
