package com.wisea.cultivar.common.po.bigdata;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * GwldbtListPo
 * 2019/12/02 11:02:14
 */
public class GwldbtListPo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 物流名称
     */
    @ApiModelProperty(value = "物流名称")
    private String wlname;

    /**
     * 物流流通件数
     */
    @ApiModelProperty(value = "物流流通件数")
    private Double wlltjs;

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
     * 获取物流名称
     */
    public String getWlname() {
        return wlname;
    }

    /**
     * 设置物流名称
     */
    public void setWlname(String wlname) {
        this.wlname = wlname == null ? null : wlname.trim();
    }

    /**
     * 获取物流流通件数
     */
    public Double getWlltjs() {
        return wlltjs;
    }

    /**
     * 设置物流流通件数
     */
    public void setWlltjs(Double wlltjs) {
        this.wlltjs = wlltjs;
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
