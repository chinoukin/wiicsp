package com.wisea.cultivar.common.po;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.CommSaleCatgPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分页查询Po")
public class CommSaleCatgPageListPo extends PagePo<CommSaleCatgPageListVo> {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="父分类名称")
    private String pCatgName;

    @ApiModelProperty(value="分类名称")
    private String catgName;

    @ApiModelProperty(value="名称首字母")
    private String szmsx;

    @ApiModelProperty(value="显示顺序")
    private Integer sort;

    @ApiModelProperty(value="分类图标")
    private String catgUrl;

    @ApiModelProperty(value="停启用状态")
    private String effeInvalState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getpCatgName() {
        return pCatgName;
    }

    public void setpCatgName(String pCatgName) {
        this.pCatgName = pCatgName;
    }

    public String getCatgName() {
        return catgName;
    }

    public void setCatgName(String catgName) {
        this.catgName = catgName;
    }

    public String getSzmsx() {
        return szmsx;
    }

    public void setSzmsx(String szmsx) {
        this.szmsx = szmsx;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCatgUrl() {
        return catgUrl;
    }

    public void setCatgUrl(String catgUrl) {
        this.catgUrl = catgUrl;
    }

    public String getEffeInvalState() {
        return effeInvalState;
    }

    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState;
    }
}
