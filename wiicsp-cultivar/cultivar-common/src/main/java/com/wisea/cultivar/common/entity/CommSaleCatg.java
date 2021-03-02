package com.wisea.cultivar.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("商品销售分类返回值")
public class CommSaleCatg extends DataLongEntity<CommSaleCatg> {
    /**
     * 父分类名称
     */
    @ApiModelProperty("父分类名称")
    private String pCatgName;

    @ApiModelProperty("父id")
    private Long pid;

    /**
     * 分类名称
     */
    @ApiModelProperty("分类名称")
    private String catgName;

    /**
     * 名称首字母
     */
    @ApiModelProperty("名称首字母")
    private String szmsx;

    /**
     * 显示顺序
     */
    @ApiModelProperty("顺序")
    private Integer sort;

    /**
     * 分类图标
     */
    @ApiModelProperty("分类图标")
    private String catgUrl;

    /**
     * 停启用状态
     */
    @ApiModelProperty("停启用状态")
    private String effeInvalState;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
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
