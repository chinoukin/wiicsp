package com.wisea.cultivar.common.po.product;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 销售分类
 * @author: wangs
 * @date :2020/4/30
 */
@ApiModel("销售分类PO")
public class CommSaleMageInsertPo {

    /**
     * 销售分类id
     */
    @ApiModelProperty("销售分类ID-修改时使用")
    private Long id;
    /**
     * 销售分类pid不能为空
     */
    @Check(test = "required", requiredMsg = "销售分类pid不能为空")
    @ApiModelProperty(value = "销售分类pid")
    private Long pid;

    /**
     * 分类名称
     */
    @Check(test = "required", requiredMsg = "销售分类名称不能为空")
    @ApiModelProperty(value = "销售分类名称")
    private String catgName;

    /**
     * 名称首字母
     */
    @Check(test = "required", requiredMsg = "销售分类名称首字母不能为空")
    @ApiModelProperty(value = "名称首字母")
    private String szmsx;

    /**
     * 显示顺序
     */
    @ApiModelProperty("分类排序")
    @Check(test = "required", requiredMsg = "销售分类排序不能为空")
    private Integer sort;

    /**
     * 分类图标
     */
    @ApiModelProperty(value = "分类图标")
    private String catgUrl;

    /**
     * 停启用状态
     */
    @ApiModelProperty(value = "商品状态（有效、无效）")
    private String effeInvalState;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
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
