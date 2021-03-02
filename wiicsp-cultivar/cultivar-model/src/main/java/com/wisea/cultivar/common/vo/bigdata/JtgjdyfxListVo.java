package com.wisea.cultivar.common.vo.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * JtgjdyfxListVo
 * 2019/12/02 11:02:14
 */
public class JtgjdyfxListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 交通工具名称
     */
    @ApiModelProperty(value = "交通工具名称")
    @Check(test = "required")
    private String jtgjmc;

    /**
     * 流通数量
     */
    @ApiModelProperty(value = "流通数量")
    @Check(test = "required")
    private Double ltsl;

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
     * 获取交通工具名称
     */
    public String getJtgjmc() {
        return jtgjmc;
    }

    /**
     * 设置交通工具名称
     */
    public void setJtgjmc(String jtgjmc) {
        this.jtgjmc = jtgjmc == null ? null : jtgjmc.trim();
    }

    /**
     * 获取流通数量
     */
    public Double getLtsl() {
        return ltsl;
    }

    /**
     * 设置流通数量
     */
    public void setLtsl(Double ltsl) {
        this.ltsl = ltsl;
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
