package com.wisea.transac.common.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("新增或修改Po")
public class BrandMagePo {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="序号")
    private String serialNum;

    @ApiModelProperty(value="品牌logo")
    private String brandLogo;

    @ApiModelProperty(value="品牌名称")
    private String brandName;

    @ApiModelProperty(value="品牌故事")
    private String brandStory;

    @ApiModelProperty(value="排序")
    private Integer sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandStory() {
        return brandStory;
    }

    public void setBrandStory(String brandStory) {
        this.brandStory = brandStory;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
