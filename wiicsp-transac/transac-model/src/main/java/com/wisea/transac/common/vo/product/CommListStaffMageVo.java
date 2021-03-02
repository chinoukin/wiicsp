package com.wisea.transac.common.vo.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 根据档口id 查询销售分类和分类设置
 * @author: wangs
 * @date :2020/6/10
 */
@ApiModel("根据档口id 查询销售分类和分类设置")
public class CommListStaffMageVo {

    /**
     * 销售分类配置id
     */
    private Long id;
    /**
     * 商品销售分类id
     */
    @ApiModelProperty("商品销售分类id")
    private Long commSaleCatgId;

    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    private String commName;

    /**
     * 显示顺序
     */
    @ApiModelProperty("显示顺序")
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
