package com.wisea.cultivar.common.po.product;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author wangs
 * CommVarietMageInsertPo
 * 2019/04/15 09:49:09
 */
public class CommVarietMageInsertPo {

    private Long id;
    /**
     * 商品id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19,requiredMsg = "品类id不能为空")
    @ApiModelProperty(value = "商品id")
    private Long commId;

    /**
     * 品种名称
     */
    @Check(test = { "maxLength" }, mixLength = 100,requiredMsg = "品种名称不能为空")
    @ApiModelProperty(value = "品种名称")
    private String commVarietName;

    /**
     * 显示顺序
     */
    @ApiModelProperty(value = "显示顺序")
    private Integer sort;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取品种名称
     */
    public String getCommVarietName() {
        return commVarietName;
    }

    /**
     * 设置品种名称
     */
    public void setCommVarietName(String commVarietName) {
        this.commVarietName = commVarietName == null ? null : commVarietName.trim();
    }

    /**
     * 获取显示顺序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置显示顺序
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
}
