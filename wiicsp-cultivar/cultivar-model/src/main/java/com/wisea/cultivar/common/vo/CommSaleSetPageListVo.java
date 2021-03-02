package com.wisea.cultivar.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询Vo")
public class CommSaleSetPageListVo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="商品销售分类id")
    private Long commSaleCatgId;

    @ApiModelProperty(value="商品id")
    private Long commId;

    @ApiModelProperty(value="商品名称")
    private String commName;

    @ApiModelProperty(value="显示顺序")
    private Integer sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCommSaleCatgId() {
        return commSaleCatgId;
    }

    public void setCommSaleCatgId(Long commSaleCatgId) {
        this.commSaleCatgId = commSaleCatgId;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
