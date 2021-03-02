package com.wisea.transac.common.vo.product;

import com.wisea.transac.common.vo.CommSaleSetInfoVo;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @Description:
 * @author: wangs
 * @date :2020/6/10
 */
public class DistincCommSaleVo {

    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="分类名称")
    private String catgName;

    @ApiModelProperty(value="显示顺序")
    private Integer sort;

    @ApiModelProperty("销售分类设置信息")
    private List<CommSaleSetInfoVo> commSalesSetVoList;

    public List<CommSaleSetInfoVo> getCommSalesSetVoList() {
        return commSalesSetVoList;
    }

    public void setCommSalesSetVoList(List<CommSaleSetInfoVo> commSalesSetVoList) {
        this.commSalesSetVoList = commSalesSetVoList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCatgName() {
        return catgName;
    }

    public void setCatgName(String catgName) {
        this.catgName = catgName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
