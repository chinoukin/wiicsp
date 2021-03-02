package com.wisea.cultivar.common.vo.tp.retro;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("追溯模板VO")
public class RetroTemplateVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "会员ID")
    @JsonSerialize(using = IdSerializer.class)
    private Long membId;

    @ApiModelProperty(value = "追溯信息模板")
    private String currencyRetrospTemplate;

    @ApiModelProperty(value = "备注")
    private String remarks;

    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getCurrencyRetrospTemplate() {
        return currencyRetrospTemplate;
    }

    public void setCurrencyRetrospTemplate(String currencyRetrospTemplate) {
        this.currencyRetrospTemplate = currencyRetrospTemplate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
