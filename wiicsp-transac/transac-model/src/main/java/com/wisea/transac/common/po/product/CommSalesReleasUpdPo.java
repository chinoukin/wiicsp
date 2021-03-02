package com.wisea.transac.common.po.product;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description:
 * @author: wangs
 * @date :2020/5/6
 */
@ApiModel("修改销售配置排序信息")
public class CommSalesReleasUpdPo {

    @Check(test = "required", requiredMsg = "分类配置id 不能为空")
    @ApiModelProperty("分类配置id")
    private Long id;
    /**
     * 显示顺序
     */
    @ApiModelProperty("分类配置排序")
    @Check(test = "required", requiredMsg = "分类配置排序不能为空")
    private Integer sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}


